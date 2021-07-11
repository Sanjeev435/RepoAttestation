package com.rbs.repoattestation.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbs.repoattestation.csv.CsvReader;
import com.rbs.repoattestation.csv.CsvWriter;
import com.rbs.repoattestation.csv.entity.Attestation;
import com.rbs.repoattestation.csv.entity.Project;
import com.rbs.repoattestation.dto.AttestationDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AttestationService {

	@Autowired
	private ProjectService projectService;

	public List<Attestation> getAttestations() {
		List<Attestation> attestations = new ArrayList<>();

		CsvReader<Attestation> reader = new CsvReader<>(Attestation.class);
		attestations.addAll(reader.read());

		Collections.sort(attestations, Comparator.comparing(Attestation::getAttestationId));

		return attestations;
	}

	public void save(AttestationDto attestation) {

		log.info("Attestation save initialized for employee id : " + attestation.getEmpId());

		boolean isSaveRequired = false;
		Attestation newAttestation = null;
		List<Attestation> assetations = getAttestations();
		List<Attestation> assetationTemp = getUserAttestationDetails(attestation.getEmpId());

		Project tempProject = projectService.getProjectById(attestation.getProjectId());
		Integer newAttestationId = assetations.size() == 0 ? 1
				: assetations.get(assetations.size() - 1).getAttestationId() + 1;

		if (CollectionUtils.isEmpty(assetationTemp)
				|| !assetationTemp.stream().anyMatch(data -> data.getEmpID().equals(attestation.getEmpId())
						&& data.getProjectName().equals(tempProject.getProjectName()))) {

			newAttestation = Attestation.builder().attestationId(newAttestationId).empID(attestation.getEmpId())
					.email(attestation.getEmail()).projectName(tempProject.getProjectName())
					.repositoryUrl(tempProject.getRepositoryUrl()).attestationTime(LocalDateTime.now()).build();
			isSaveRequired = true;
		}

		if (isSaveRequired) {
			CsvWriter<Attestation> writer = new CsvWriter<>(Attestation.class);
			writer.write(newAttestation);
			log.info("Attestation save successful for employee id : " + attestation.getEmpId());
		} else {
			log.info("Duplicate data found for attestation for employee id : " + attestation.getEmpId());
		}
	}

	public List<Attestation> getUserAttestationDetails(String empId) {
		log.info("Getting attestation details for user : " + empId);
		return getAttestations().stream().filter(data -> data.getEmpID().equals(empId)).collect(Collectors.toList());
	}

}
