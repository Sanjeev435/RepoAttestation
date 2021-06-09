package com.rbs.repoattestation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@PostMapping("/save")
	public ResponseEntity<String> submitAttestaion(AttestationDto attestationData) {
		attestationService.save(attestationData);
		return ResponseEntity.ok("success");
	}
	
	@ResponseBody
	@GetMapping("/projects")
	public List<ProjectDto> getProjects() {
		return projectService.getProjects();
	}

}
