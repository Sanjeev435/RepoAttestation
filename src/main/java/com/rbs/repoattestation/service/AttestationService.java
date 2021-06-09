package com.rbs.repoattestation.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.rbs.repoattestation.dto.AttestationDto;
import com.rbs.repoattestation.entity.Attestation;
import com.rbs.repoattestation.entity.AttestationAudit;
import com.rbs.repoattestation.repository.AttestationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AttestationService {
	
	@Autowired
	private AttestationRepository attestationRepository;
	
	@Autowired
	private ProjectService projectService;
	
	public Iterable<Attestation> getAttestations() {
		return attestationRepository.findAll();
	}
	
	@Transactional
	public void save(AttestationDto attestation) {
		
		log.info("Attestation save initialized for employee id : " +attestation.getEmpId());
		
		boolean isSaveRequired = false;
		Attestation assetationTemp = getAttestationUserDetails(attestation.getEmpId());
		AttestationAudit auditTemp = new AttestationAudit(assetationTemp, projectService.getProjectById(attestation.getProjectId()));
		auditTemp.setAttestationTime(LocalDateTime.now());
		
		if(assetationTemp.isPresent() 
				&& !assetationTemp.getAssociatedProjects().stream()
				.anyMatch(prj -> prj.getProject().getProjectId().equals(attestation.getProjectId()))) {
			isSaveRequired = true;
			assetationTemp.getAssociatedProjects().add(auditTemp);
		}else if(!assetationTemp.isPresent()) {
			isSaveRequired = true;
			assetationTemp.setEmpID(attestation.getEmpId());
			assetationTemp.setEmail(attestation.getEmail());
			assetationTemp.setAssociatedProjects(Lists.newArrayList(auditTemp));
		}
		
		if(isSaveRequired) {
			attestationRepository.save(assetationTemp);	
			log.info("Attestation save successful for employee id : " +attestation.getEmpId());
		}else {
			log.info("Duplicate data found for attestation for employee id : " + attestation.getEmpId());
		}
	}
	
	public Attestation getAttestationUserDetails(String empId) {
		log.info("Getting attestation details for user : " +empId);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("empID",
				GenericPropertyMatchers.exact());

		Example<Attestation> employeeDetail = Example.of((new Attestation(empId)), matcher);
		return attestationRepository.findOne(employeeDetail).orElse(new Attestation());
	}

}
