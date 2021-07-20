package com.rbs.repoattestation.csv;

import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import com.rbs.repoattestation.csv.util.CsvUtil;
import com.rbs.repoattestation.exception.CsvReaderException;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Generic class to read data from CSV file
 *
 * @param <T>
 */
@Slf4j
public class CsvReader<T> {

	private Class<T> csvEntity;
	private String fileName;

	public CsvReader(Class<T> csvEntity) {
		this.csvEntity = csvEntity;
		this.fileName = CsvUtil.getFileName(this.csvEntity);
	}

	/**
	 * Read data from CSV file
	 */
	public List<T> read() {
		try (FileReader fr = new FileReader(this.fileName)) {
			List<T> data = new CsvToBeanBuilder<T>(fr).withSeparator(CsvUtil.DEFAULT_SEPARATOR)
					.withType(this.csvEntity).build().parse();
			return data;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new CsvReaderException(
					"Error while reading file for " + this.csvEntity.getName() + " | " + ex.getMessage());
		}
	}

}
