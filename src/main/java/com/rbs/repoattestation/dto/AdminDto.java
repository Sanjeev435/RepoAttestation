package com.rbs.repoattestation.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDto {

	private String empId;
	private String email;
	private String project;
	private String repositoryUrl;
	private LocalDateTime attestedOn;
	
}
