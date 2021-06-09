package com.rbs.repoattestation.entity;

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
@Table(name = "T_ADMIN_DETAIL")
public class Admin{
	
	public Admin(String loginId) {
		this.loginId = loginId;
	}
	
	public boolean isPresent() {
		return this.loginId != null ;
	}

	@Id
	@SequenceGenerator(sequenceName = "S_ADMIN_DETAIL", allocationSize = 1, name = "S_ADMIN_DETAIL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ADMIN_DETAIL")
	@Column(name = "ADMIN_ID", precision = 9)
	private Integer adminId; // Primary ID

	@Column(name = "LOGIN_ID", length = 50)
	private String loginId;
}
