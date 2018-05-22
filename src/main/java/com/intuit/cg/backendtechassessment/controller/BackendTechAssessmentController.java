package com.intuit.cg.backendtechassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.intuit.cg.backendtechassessment.autobidder.AutoBidder;
import com.intuit.cg.backendtechassessment.autobidder.AutoBidderImpl;
import com.intuit.cg.backendtechassessment.autobidder.AutoBidderListener;
import com.intuit.cg.backendtechassessment.bid.operation.AddBidOperation;
import com.intuit.cg.backendtechassessment.bid.srv.entity.Bid;
import com.intuit.cg.backendtechassessment.bid.srv.repository.BidJdbcRepository;
import com.intuit.cg.backendtechassessment.buyer.operation.AddBuyerOperation;
import com.intuit.cg.backendtechassessment.buyer.srv.repository.BuyerJdbcRepository;
import com.intuit.cg.backendtechassessment.controller.requestmappings.RequestMappings;
import com.intuit.cg.backendtechassessment.exception.BadRequestException;
import com.intuit.cg.backendtechassessment.project.operation.AddProjectOperation;
import com.intuit.cg.backendtechassessment.project.operation.GetProjectOperation;
import com.intuit.cg.backendtechassessment.project.srv.entity.Project;
import com.intuit.cg.backendtechassessment.project.srv.repository.ProjectJdbcRepository;
import com.intuit.cg.backendtechassessment.request.AddActorRequest;
import com.intuit.cg.backendtechassessment.request.AddBidRequest;
import com.intuit.cg.backendtechassessment.request.AddProjectRequest;
import com.intuit.cg.backendtechassessment.request.CreateAutoBidderRequest;
import com.intuit.cg.backendtechassessment.response.AddActorResponse;
import com.intuit.cg.backendtechassessment.response.AddProjectResponse;
import com.intuit.cg.backendtechassessment.response.ProjectSearchResponse;
import com.intuit.cg.backendtechassessment.seller.operation.AddSellerOpertion;
import com.intuit.cg.backendtechassessment.seller.srv.repository.SellerJdbcRepository;

/**
 * The controller for the service. This controller only contains the end points
 * and some validation logic for the requests, the actual working of the end
 * points is delegated to their respective operation classes. This makes the
 * controller much more scalable and modular as we can easily swap out
 * operations without affecting the working of the controller. This way we also
 * don't need to have all logic in a single class. I decided to go with an in
 * memory auto bidder and don't write the auto bidders to a database as it is
 * just a prototype. The AutoBidderListener is an observer which notifies the
 * auto bidders that a new bid has been added or that a new auto bidder has been
 * added, the listener is a singleton since all classes in the future will need
 * to share the same autobidder as instantiating a new listener will cause a new
 * instance of the project auto bidder map to be created which will lead to sync
 * issues. The technology used in this assessment is the same that was provided,
 * Spring boot mvc for the web service implementation and H2 in-memory database
 * for data persistence.
 * 
 * @author Advait Moghe
 *
 */
@Controller
public class BackendTechAssessmentController {

	private AutoBidderListener listener = AutoBidderListener.getInstance();

	@Autowired
	ProjectJdbcRepository projectRepository;

	@Autowired
	BidJdbcRepository bidJdbcRepository;

	@Autowired
	BuyerJdbcRepository buyerRepository;

	@Autowired
	SellerJdbcRepository sellerRepository;

	/**
	 * Adds a new seller.
	 * 
	 * @param addSellerRequest
	 *            the request containing the data to be added for the seller. Cannot
	 *            be <code>null</code>.
	 * @return the {@link AddSellerResponse} containing the newly added seller's id.
	 */
	@PostMapping(RequestMappings.SELLERS)
	@ResponseBody
	public AddActorResponse addSeller(@RequestBody(required = true) AddActorRequest addSellerRequest) {
		if (addSellerRequest == null) {
			throw new BadRequestException("The seller json cannot be null");
		}

		return new AddSellerOpertion(sellerRepository).addSeller(addSellerRequest);
	}

	/**
	 * Adds a new buyer.
	 * 
	 * @param addBuyerRequest
	 *            the request containing the data to be added for the buyer. Cannot
	 *            be <code>null</code>.
	 * @return the {@link AddActorResponse} containing the newly added buyer's id.
	 */
	@PostMapping(RequestMappings.BUYERS)
	@ResponseBody
	public AddActorResponse addBuyer(@RequestBody(required = true) AddActorRequest addBuyerRequest) {
		if (addBuyerRequest == null) {
			throw new BadRequestException("The buyer json cannot be null");
		}
		return new AddBuyerOperation(buyerRepository).addBuyer(addBuyerRequest);
	}

	/**
	 * Retrieves a project with the given project id.
	 * 
	 * @param projectId
	 *            the id of the project to retrieve. Cannot be zero or negative.
	 * @return the {@link ProjectSearchResponse} which contains the project with the
	 *         lowest bid. Will never be <code>null</code>.
	 */
	@GetMapping(RequestMappings.PROJECTS)
	@ResponseBody
	public ProjectSearchResponse getProjectById(@RequestParam(name = "projectId", required = true) long projectId) {
		if (projectId <= 0) {
			throw new BadRequestException("The project id cannot be zero or negative.");
		}

		Project retrievedProject = new GetProjectOperation(projectRepository).getProjectById(projectId);
		List<Bid> bidsByProject = bidJdbcRepository.getLowestBidsByProjectId(projectId,
				retrievedProject.getBidClosingDateTime());

		Bid lowestBid = bidsByProject.isEmpty() ? null : bidsByProject.get(0);

		return new ProjectSearchResponse(projectId, lowestBid == null ? 0 : lowestBid.getBuyerId(),
				lowestBid == null ? 0.0 : lowestBid.getBidAmount());
	}

	/**
	 * Adds a new project.
	 * 
	 * @param addProjectRequest
	 *            the request containing the data to be added for the project.
	 *            Cannot be <code>null</code>.
	 * @return the {@link AddProjectResponse} containing the newly added project's
	 *         id.
	 */
	@PostMapping(RequestMappings.PROJECTS)
	@ResponseBody
	public AddProjectResponse addProject(@RequestBody(required = true) AddProjectRequest addProjectRequest) {
		if (addProjectRequest == null) {
			throw new IllegalArgumentException("The project json cannot be null");
		}
		addProjectRequest.validate();
		return new AddProjectOperation(projectRepository).addProject(addProjectRequest);
	}

	/**
	 * Adds a new bid.
	 * 
	 * @param addProjectRequest
	 *            the request containing the data to be added for the bid. Cannot be
	 *            <code>null</code>.
	 * @return the {@link AddBidResponse} containing the newly added bid's id.
	 */
	@PostMapping(RequestMappings.BIDS)
	@ResponseStatus(value = HttpStatus.OK)
	public void addBid(@RequestParam(name = "projectId", required = true) long projectId,
			@RequestBody(required = true) AddBidRequest addBidRequest) {
		if (addBidRequest == null) {
			throw new BadRequestException("The bida json cannot be null");
		}
		Project project = new GetProjectOperation(projectRepository).getProjectById(projectId);
		new AddBidOperation(bidJdbcRepository).addBid(addBidRequest, project);
		listener.notifyAutoBidders(bidJdbcRepository, project);
	}

	/**
	 * Creates a new auto bidder. Each new autobidder is stored in-memory inside a
	 * map keyed by their respective project ids. Whenever a new bid is added the
	 * {@link AutoBidderListener} notifies each auto bidder to check the latest bid
	 * and add a new bid if required.
	 * 
	 * @param projectId
	 *            the id of the project for which the bidder is needed. Cannot be
	 *            zero or negative.
	 * @param createAutoBiddderRequest
	 *            the {@link CreateAutoBidderRequest}. Cannot be <code>null</code>.
	 */
	@PostMapping(RequestMappings.AUTOBIDDER)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createAutobidder(@RequestParam(name = "projectId", required = true) long projectId,
			@RequestBody(required = true) CreateAutoBidderRequest createAutoBiddderRequest) {
		if (createAutoBiddderRequest == null) {
			throw new BadRequestException("The project json cannot be null");
		}

		createAutoBiddderRequest.validate(buyerRepository);

		AutoBidder autoBidder = new AutoBidderImpl(createAutoBiddderRequest.getBuyerId(),
				createAutoBiddderRequest.getBidFactor(), createAutoBiddderRequest.getMinimumBidLimit());
		listener.addAutoBidder(autoBidder, projectId);
		listener.notifyAutoBidders(bidJdbcRepository, projectRepository.getProjectById(projectId));
	}
}
