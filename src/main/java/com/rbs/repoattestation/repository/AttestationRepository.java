package com.rbs.repoattestation.repository;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.rbs.repoattestation.entity.Attestation;


@Repository
public interface AttestationRepository extends AbstractCommonRepository<Attestation, Integer>, Serializable {
}
