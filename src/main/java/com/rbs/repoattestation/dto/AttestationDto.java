package com.rbs.repoattestation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttestationDto {

	private String empId;
	private String email;
	private Integer projectId;
	private boolean confirmed;
	
}
