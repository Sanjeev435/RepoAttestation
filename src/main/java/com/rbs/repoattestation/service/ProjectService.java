package com.rbs.repoattestation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rbs.repoattestation.csv.CsvReader;
import com.rbs.repoattestation.csv.entity.Project;
import com.rbs.repoattestation.dto.ProjectDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectService {

	private static List<Project> projects = new ArrayList<>();

	static {
		CsvReader<Project> reader = new CsvReader<>(Project.class);
		projects = reader.read();
	}

	public List<ProjectDto> getProjects() {
		List<ProjectDto> projects = new ArrayList<>();
		ProjectService.projects.forEach(data -> {
			projects.add(ProjectDto.builder().projectId(data.getProjectId()).projectName(data.getProjectName())
					.repositoryUrl(data.getRepositoryUrl()).build());
		});
		log.info("Retrived projects Size : " + projects.size());
		return projects;
	}

	public Project getProjectById(Integer projectId) {
		return ProjectService.projects.stream().filter(data -> data.getProjectId().equals(projectId)).findFirst()
				.orElse(new Project());
	}
}
