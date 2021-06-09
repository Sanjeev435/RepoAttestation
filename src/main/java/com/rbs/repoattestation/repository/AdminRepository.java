package com.rbs.repoattestation.repository;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.rbs.repoattestation.entity.Admin;

@Repository
public interface AdminRepository extends AbstractCommonRepository<Admin, Integer>, Serializable {
}
