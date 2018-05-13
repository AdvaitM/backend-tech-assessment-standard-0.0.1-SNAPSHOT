package com.intuit.cg.backendtechassessment.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuit.cg.backendtechassessment.controller.requestmappings.RequestMappings;
import com.intuit.cg.backendtechassessment.json.AddProjectRequestJSON;
import com.intuit.cg.backendtechassessment.json.AddProjectResponseJSON;
import com.intuit.cg.backendtechassessment.json.ProjectSearchResponseJSON;

@Controller
public class BackendTechAssessmentController {

	@GetMapping(RequestMappings.PROJECTS)
	@ResponseBody
	public ProjectSearchResponseJSON getProjectById(@RequestParam(name = "projectId", required = true) long projectId) {
		return new ProjectSearchResponseJSON(projectId, "description", 123);
	}

	@PostMapping(RequestMappings.PROJECTS)
	@ResponseBody
	public AddProjectResponseJSON addProject(@RequestBody(required = true) AddProjectRequestJSON addProjectJSON) {

		String desc = addProjectJSON.getProjectDescription();
		Date date = addProjectJSON.getBidClosingDateTime();
		long projectId = new Random().nextLong();
		return new AddProjectResponseJSON(date.getTime());
	}
}
