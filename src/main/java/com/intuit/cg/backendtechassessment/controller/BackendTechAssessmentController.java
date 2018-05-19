package com.intuit.cg.backendtechassessment.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuit.cg.backendtechassessment.controller.requestmappings.RequestMappings;
import com.intuit.cg.backendtechassessment.json.AddBidRequestJSON;
import com.intuit.cg.backendtechassessment.json.AddBidResponseJSON;
import com.intuit.cg.backendtechassessment.json.AddBuyerRequestJSON;
import com.intuit.cg.backendtechassessment.json.AddBuyerResponseJSON;
import com.intuit.cg.backendtechassessment.json.AddProjectRequestJSON;
import com.intuit.cg.backendtechassessment.json.AddProjectResponseJSON;
import com.intuit.cg.backendtechassessment.json.AddSellerRequestJSON;
import com.intuit.cg.backendtechassessment.json.AddSellerResponseJSON;
import com.intuit.cg.backendtechassessment.json.ProjectSearchResponseJSON;
import com.intuit.cg.backendtechassessment.srv.entity.Bid;
import com.intuit.cg.backendtechassessment.srv.entity.Buyer;
import com.intuit.cg.backendtechassessment.srv.entity.Project;
import com.intuit.cg.backendtechassessment.srv.entity.Seller;
import com.intuit.cg.backendtechassessment.srv.repository.BidJdbcRepository;
import com.intuit.cg.backendtechassessment.srv.repository.BuyerJdbcRepository;
import com.intuit.cg.backendtechassessment.srv.repository.ProjectJdbcRepository;
import com.intuit.cg.backendtechassessment.srv.repository.SellerJdbcRepository;

@Controller
public class BackendTechAssessmentController {

	@Autowired
	ProjectJdbcRepository projectJdbcRepository;

	@Autowired
	BidJdbcRepository bidJdbcRepository;

	@Autowired
	SellerJdbcRepository sellerRepository;

	@Autowired
	BuyerJdbcRepository buyerRepository;

	@PostMapping(RequestMappings.SELLERS)
	@ResponseBody
	public AddSellerResponseJSON addSeller(@RequestBody(required = true) AddSellerRequestJSON addSellerJSON) {
		if (addSellerJSON == null) {
			throw new IllegalArgumentException("The project json cannot be null");
		}

		Seller seller = new Seller(addSellerJSON.getDescription(), addSellerJSON.getEmailId());
		sellerRepository.insert(seller);
		return new AddSellerResponseJSON(sellerRepository.getLastInsertedRow());
	}

	@PostMapping(RequestMappings.BUYERS)
	@ResponseBody
	public AddBuyerResponseJSON addBuyer(@RequestBody(required = true) AddBuyerRequestJSON addBuyerJSON) {
		if (addBuyerJSON == null) {
			throw new IllegalArgumentException("The project json cannot be null");
		}

		Buyer buyer = new Buyer(addBuyerJSON.getDescription(), addBuyerJSON.getEmailId());
		buyerRepository.insertBuyer(buyer);
		return new AddBuyerResponseJSON(buyerRepository.getLastInsertedRow());
	}

	@GetMapping(RequestMappings.PROJECTS)
	@ResponseBody
	public ProjectSearchResponseJSON getProjectById(@RequestParam(name = "projectId", required = true) long projectId) {
		return new ProjectSearchResponseJSON(projectId, "description", 123);
	}

	@PostMapping(RequestMappings.PROJECTS)
	@ResponseBody
	public AddProjectResponseJSON addProject(@RequestBody(required = true) AddProjectRequestJSON addProjectJSON) {
		if (addProjectJSON == null) {
			throw new IllegalArgumentException("The project json cannot be null");
		}
		addProjectJSON.validate();

		Project project = new Project(addProjectJSON.getProjectDescription(), addProjectJSON.getMaximumBudget(),
				addProjectJSON.getBidClosingDateTime(), addProjectJSON.getSellerId());
		projectJdbcRepository.insertProject(project);

		return new AddProjectResponseJSON(projectJdbcRepository.getLastInsertedRow());
	}

	@PostMapping(RequestMappings.BIDS)
	@ResponseBody
	public AddBidResponseJSON addBid(@RequestParam(name = "projectId", required = true) long projectId,
			@RequestBody(required = true) AddBidRequestJSON addBidJSON) {
		if (addBidJSON == null) {
			throw new IllegalArgumentException("The project json cannot be null");
		}
		Bid bid = new Bid(addBidJSON.getBuyerId(), projectId, addBidJSON.getBidAmount(), new Date());
		bidJdbcRepository.insertBid(bid);

		return new AddBidResponseJSON(bidJdbcRepository.getLastInsertedRow());
	}

}
