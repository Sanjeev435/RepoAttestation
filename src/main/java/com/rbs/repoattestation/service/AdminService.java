package com.rbs.repoattestation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.rbs.repoattestation.dto.AdminDto;
import com.rbs.repoattestation.entity.Admin;
import com.rbs.repoattestation.repository.AdminRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AttestationService attestationService;

	public Admin getAdminUser(String user) {
		log.info("Getting admin details for user : " +user);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("loginId",
				GenericPropertyMatchers.exact());

		Example<Admin> admin = Example.of((new Admin(user)), matcher);
		return adminRepository.findOne(admin).orElse(new Admin());
	}

	public List<AdminDto> getAllAttestations() {
		log.info("Getting All Attestation Data");
		
		List<AdminDto> adminData = new ArrayList<>();
		attestationService.getAttestations().forEach(data -> {
			data.getAssociatedProjects().forEach(prj -> adminData.add(
					AdminDto.builder()
									.empId(data.getEmpID())
									.email(data.getEmail())
									.project(prj.getProject().getProjectName())
									.repositoryUrl(prj.getProject().getRepositoryUrl())
									.attestedOn(prj.getAttestationTime())
									.build()));
		});
		
		log.info("Retrived All Attestation Data of size : " + adminData.size());
		
		return adminData;
	}

}
