package com.intuit.cg.backendtechassessment;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intuit.cg.backendtechassessment.controller.BackendTechAssessmentController;
import com.intuit.cg.backendtechassessment.exception.BadRequestException;
import com.intuit.cg.backendtechassessment.request.AddProjectRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendTechAssessmentApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testAddProject_NoBidClosingDate() {
		try {
			new BackendTechAssessmentController().addProject(new AddProjectRequest(1L, "someDescription", 123.0, null));
			fail("An exception should be thrown");
		} catch (BadRequestException exception) {

		}
	}
//
//	@Test
//	public void testAddProject_NoSellerId() {
//		try {
//			Call the service with a AddProjectRequest which does not have a valid seller id 
//		} catch (BadRequestException exception) {
//			the service should throw a bad request exception
//		}
//	}
	
//
//	@Test
//	public void testAddBid_NoBuyerId() {
//		try {
//			Call the service with a AddBidRequest which does not have a valid buyer id 
//		} catch (BadRequestException exception) {
//			the service should throw a bad request exception since the buyer id does not exist 
//		}
//	}
}
