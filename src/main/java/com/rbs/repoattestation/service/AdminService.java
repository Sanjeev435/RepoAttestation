package com.rbs.repoattestation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbs.repoattestation.csv.CsvReader;
import com.rbs.repoattestation.csv.entity.Admin;
import com.rbs.repoattestation.dto.AdminDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminService {

	@Autowired
	private AttestationService attestationService;

	public Admin getAdminUser(String user) {
		log.info("Getting admin details for user : " + user);

		CsvReader<Admin> adminReader = new CsvReader<>(Admin.class);
		return adminReader.read().stream().filter(data -> data.getLoginId().equals(user)).findFirst()
				.orElse(new Admin());
	}

	public List<AdminDto> getAllAttestations() {
		log.info("Getting All Attestation Data");

		List<AdminDto> adminData = new ArrayList<>();
		attestationService.getAttestations().forEach(data -> {
			adminData
					.add(AdminDto.builder().empId(data.getEmpID()).email(data.getEmail()).project(data.getProjectName())
							.repositoryUrl(data.getRepositoryUrl()).attestedOn(data.getAttestationTime()).build());

		});

		log.info("Retrived All Attestation Data of size : " + adminData.size());

		return adminData;
	}

}
