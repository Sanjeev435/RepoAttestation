package com.rbs.repoattestation.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_ATTESTATION_DETAIL")
public class Attestation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Attestation(String empID) {
		this.empID = empID;
	}
	
	public boolean isPresent() {
		return this.attestationId != null ;
	}

	@Id
	@SequenceGenerator(sequenceName = "S_ATTESTATION_DETAIL", allocationSize = 1, name = "S_ATTESTATION_DETAIL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ATTESTATION_DETAIL")
	@Column(name = "ATTESTATION_ID", precision = 9)
	private Integer attestationId; // Primary ID

	@Column(name = "EMP_ID", length = 10)
	private String empID;

	@Column(name = "EMAIL", length = 100)
	private String email;

	@OneToMany(targetEntity = AttestationAudit.class,  mappedBy = "attestation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AttestationAudit> associatedProjects = new ArrayList<>();

}