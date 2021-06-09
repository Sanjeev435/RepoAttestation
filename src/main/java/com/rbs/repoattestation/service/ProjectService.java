package com.rbs.repoattestation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbs.repoattestation.dto.ProjectDto;
import com.rbs.repoattestation.entity.Project;
import com.rbs.repoattestation.repository.ProjectRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	public List<ProjectDto> getProjects(){
		List<ProjectDto> projects = new ArrayList<>();
		projectRepository.findAll().forEach(data -> {
			projects.add(ProjectDto.builder().projectId(data.getProjectId())
					.projectName(data.getProjectName()).repositoryUrl(data.getRepositoryUrl()).build());
		});
		log.info("Retrived projects Size : " + projects.size());
		return projects;
	}
	
	public Project getProjectById(Integer projectId) {
		return projectRepository.findById(projectId).orElse(new Project());
	}
}
