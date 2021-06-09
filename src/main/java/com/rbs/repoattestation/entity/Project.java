package com.rbs.repoattestation.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_PROJECT_DETAIL")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Project(Integer projectId) {
		this.projectId = projectId;
	}

	@Id
	@SequenceGenerator(sequenceName = "S_PROJECT_DETAIL", allocationSize = 1, name = "S_PROJECT_DETAIL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PROJECT_DETAIL")
	@Column(name = "PROJECT_ID", precision = 9)
	private Integer projectId; // Primary ID

	@Column(name = "PROJECT_NAME", length = 100)
	private String projectName;

	@Column(name = "REPO_URL", length = 200)
	private String repositoryUrl;

}