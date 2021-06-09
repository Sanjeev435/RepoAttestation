package com.rbs.repoattestation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectDto {
	
	private Integer projectId;
	private String projectName;
	private String repositoryUrl;

}
