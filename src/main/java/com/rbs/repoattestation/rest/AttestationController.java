package com.rbs.repoattestation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rbs.repoattestation.csv.entity.Attestation;
import com.rbs.repoattestation.dto.AttestationDto;
import com.rbs.repoattestation.dto.ProjectDto;
import com.rbs.repoattestation.service.AttestationService;
import com.rbs.repoattestation.service.ProjectService;

@Controller
@RequestMapping(path = "/attestation")
public class AttestationController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private AttestationService attestationService;
	
	/**
	 * Get landing page for attestation
	 * @return attestation page
	 */
	@GetMapping
	public String getIndexPage() {
		return "attestation.html";
	}
	
	/**
	 * Get user validation page to search validation
	 * @return userValidation page
	 */
	@GetMapping("/user/validation")
	public String login() {
		return "/userValidation.html";
	}
	
	/**
	 * Save attestation data filled by user
	 * @param attestationData
	 * @return Status Code : 200
	 */
	@ResponseBody
	@PostMapping("/save")
	public ResponseEntity<String> submitAttestaion(AttestationDto attestationData) {
		attestationService.save(attestationData);
		return ResponseEntity.ok("success");
	}
	
	/**
	 * Get all the project name which contains the queried string
	 * @param query : query string to filter out project data
	 * @return List<String> : List of projects
	 */
	@ResponseBody
	@GetMapping("/projects")
	public List<String> getProjects(@RequestParam String query) {
		return projectService.getProjects(query);
	}
	
	/**
	 * Get project details for the specified project name
	 * @param projectName : Name of project
	 * @return ProjectDto : project details
	 */
	@ResponseBody
	@GetMapping("/project")
	public ProjectDto getProject(@RequestParam String projectName) {
		return projectService.getProject(projectName);
	}
	
	/**
	 * Get all the attestation details of projects which has been attested by the specified user
	 * @param racfId : User RBS Racf ID
	 * @return List<Attestation> : List of attestation data
	 */
	@ResponseBody
	@GetMapping("/view")
	public List<Attestation> getUserAttestations(@RequestParam String racfId) {
		return attestationService.getUserAttestationDetails(racfId);
	}

}
