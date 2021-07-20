package com.rbs.repoattestation.csv.util;

import com.rbs.repoattestation.csv.entity.Admin;
import com.rbs.repoattestation.csv.entity.Attestation;
import com.rbs.repoattestation.csv.entity.Project;
import com.rbs.repoattestation.exception.FileNotRecognizedException;

public class CsvUtil {
	
	public static final char DEFAULT_SEPARATOR = ',';

	/**
	 * Get file location as per the class given
	 * @param csvEntity : CSV class
	 * @return String : csvFilePath
	 */
	public static String getFileName(Class<?> csvEntity) {
		if (csvEntity.isAssignableFrom(Admin.class)) {
			return "C:\\Test\\admin.csv";
		} else if (csvEntity.isAssignableFrom(Project.class)) {
			return "C:\\Test\\project.csv";
		} else if (csvEntity.isAssignableFrom(Attestation.class)) {
			return "C:\\Test\\attestation.csv";
		} else {
			throw new FileNotRecognizedException("File Type not recognized");
		}
	}
}
