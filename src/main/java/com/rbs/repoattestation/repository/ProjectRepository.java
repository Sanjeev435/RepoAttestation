package com.rbs.repoattestation.repository;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.rbs.repoattestation.entity.Project;


@Repository
public interface ProjectRepository extends AbstractCommonRepository<Project, Integer>, Serializable {
}
