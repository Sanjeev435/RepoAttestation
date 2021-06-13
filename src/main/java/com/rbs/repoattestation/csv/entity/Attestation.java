package com.rbs.repoattestation.csv.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.rbs.repoattestation.csv.util.LocalDateTimeConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attestation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Attestation(String empID) {
		this.empID = empID;
	}
	
	public boolean isPresent() {
		return this.attestationId != null ;
	}

	@CsvBindByPosition(position = 0)
	private Integer attestationId;

	@CsvBindByPosition(position = 1)
	private String empID;

	@CsvBindByPosition(position = 2)
	private String email;
	
	@CsvBindByPosition(position = 3)
	private String projectName;

	@CsvBindByPosition(position = 4)
	private String repositoryUrl;
	
	@CsvCustomBindByPosition(position = 5, converter = LocalDateTimeConverter.class)
	private LocalDateTime attestationTime;
	
	


}