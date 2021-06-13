package com.rbs.repoattestation.csv.entity;



import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin{
	
	public Admin(String loginId) {
		this.loginId = loginId;
	}
	
	public boolean isPresent() {
		return this.loginId != null ;
	}
	
	@CsvBindByPosition(position = 0)
	private Integer adminId; // Primary ID
	
	@CsvBindByPosition(position = 1)
	private String loginId;
}
