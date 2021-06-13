package com.rbs.repoattestation.csv.util;

import com.rbs.repoattestation.csv.entity.Admin;
import com.rbs.repoattestation.csv.entity.Attestation;
import com.rbs.repoattestation.csv.entity.Project;
import com.rbs.repoattestation.exception.FileNotRecognizedException;

public class CsvUtil {
	
	public static final char DEFAULT_SEPARATOR = ',';

	public static String getFileName(Class<?> csvEntity) {
		if (csvEntity.isAssignableFrom(Admin.class)) {
			return "D:\\Test\\admin.csv";
		} else if (csvEntity.isAssignableFrom(Project.class)) {
			return "D:\\Test\\project.csv";
		} else if (csvEntity.isAssignableFrom(Attestation.class)) {
			return "D:\\Test\\attestation.csv";
		} else {
			throw new FileNotRecognizedException("File Type not recognized");
		}
	}
}
