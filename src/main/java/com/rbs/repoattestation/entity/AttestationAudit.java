package com.rbs.repoattestation.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "T_ATTESTATION_AUDIT_REF")
public class AttestationAudit {

	public AttestationAudit(Attestation attestation, Project project) {
		this.attestation = attestation;
		this.project = project;
	}

	@Id
	@SequenceGenerator(sequenceName = "S_ATTESTATION_AUD_REF", allocationSize = 1, name = "S_ATTESTATION_AUD_REF")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ATTESTATION_AUD_REF")
	@Column(name = "ATTESTATION_AUD_REF_ID", precision = 9)
	private Integer attestationAuditRefId; // Primary ID
	
	@Column(name = "ATTESTATION_TIME", columnDefinition = "TIMESTAMP")
	private LocalDateTime attestationTime;

	@JoinColumn(name = "ATTESTATION_ID")
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Attestation.class, fetch = FetchType.EAGER)
	private Attestation attestation;

	@JoinColumn(name = "PROJECT_ID")
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Project.class, fetch = FetchType.EAGER)
	private Project project;

}
