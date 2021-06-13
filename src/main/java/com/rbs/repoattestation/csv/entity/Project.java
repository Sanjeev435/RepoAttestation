package com.rbs.repoattestation.csv.entity;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Project(Integer projectId) {
		this.projectId = projectId;
	}

	@CsvBindByPosition(position = 0)
	private Integer projectId; // Primary ID

	@CsvBindByPosition(position = 1)
	private String projectName;

	@CsvBindByPosition(position = 2)
	private String repositoryUrl;

}