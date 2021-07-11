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
	
	@GetMapping
	public String getIndexPage() {
		return "attestation.html";
	}
	
	@GetMapping("/user/validation")
	public String login() {
		return "/userValidation.html";
	}
	
	@ResponseBody
	@PostMapping("/save")
	public ResponseEntity<String> submitAttestaion(AttestationDto attestationData) {
		attestationService.save(attestationData);
		return ResponseEntity.ok("success");
	}
	
	@ResponseBody
	@GetMapping("/projects")
	public List<String> getProjects(@RequestParam String query) {
		return projectService.getProjects(query);
	}
	
	@ResponseBody
	@GetMapping("/project")
	public ProjectDto getProject(@RequestParam String projectName) {
		return projectService.getProject(projectName);
	}
	
	@ResponseBody
	@GetMapping("/view")
	public List<Attestation> getUserAttestations(@RequestParam String racfId) {
		return attestationService.getUserAttestationDetails(racfId);
	}

}
