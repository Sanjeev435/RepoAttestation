package com.rbs.repoattestation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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

	/**
	 * Read all projects from csv
	 * @return List<ProjectDto>
	 */
	public List<ProjectDto> getProjects() {
		List<ProjectDto> projects = new ArrayList<>();
		ProjectService.projects.forEach(data -> {
			projects.add(ProjectDto.builder().projectId(data.getProjectId()).projectName(data.getProjectName())
					.repositoryUrl(data.getRepositoryUrl()).build());
		});
		log.info("Retrived projects Size : " + projects.size());
		return projects;
	}

	/**
	 * Get project details of project associated with the projectId
	 * @param projectId
	 * @return Project
	 */
	public Project getProjectById(Integer projectId) {
		return ProjectService.projects.stream().filter(data -> data.getProjectId().equals(projectId)).findFirst()
				.orElse(new Project());
	}

	/**
	 * Get all project contains the queried string in project name
	 * @param query
	 * @return List<String>
	 */
	public List<String> getProjects(String query) {
		List<String> projects = new ArrayList<>();
		ProjectService.projects.forEach(data -> {
			if(data.getProjectName().toUpperCase().contains(query)) {
				projects.add(data.getProjectName());
			}
		});
		log.info("Retrived projects Size for query " + "'" +query +"'" + " : " + projects.size());
		return projects;
	}

	/**
	 * Get Project details for the provided project name
	 * @param projectName
	 * @return ProjectDto
	 */
	public ProjectDto getProject(String projectName) {
		List<Project> projectTemp = ProjectService.projects.stream()
				.filter(data -> data.getProjectName().equalsIgnoreCase(projectName)).collect(Collectors.toList());

		if (CollectionUtils.isEmpty(projectTemp) || projectTemp.size() > 1) {
			return ProjectDto.builder().projectId(0).projectName(StringUtils.EMPTY).repositoryUrl(StringUtils.EMPTY)
					.build();
		} else {
			return ProjectDto.builder()
					.projectId(projectTemp.get(0).getProjectId())
					.projectName(projectTemp.get(0).getProjectName())
					.repositoryUrl(projectTemp.get(0).getRepositoryUrl())
					.build();
		}
	}
}
