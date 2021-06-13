package com.rbs.repoattestation.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.rbs.repoattestation.csv.util.CsvUtil;
import com.rbs.repoattestation.exception.CsvWriterException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvWriter<T> {
	
	private Class<T> csvEntity;
	private String fileName;
	
	public CsvWriter(Class<T> csvEntity) {
		this.csvEntity = csvEntity;
		this.fileName = CsvUtil.getFileName(this.csvEntity);
	}
	
	public void write(T data) {
		//BufferedWriter writer give better performance
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName, true))) {

            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(data);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException |
                IOException ex) {
            log.error(ex.getMessage(), ex);
            throw new CsvWriterException(
					"Error while writing data to file for " + this.csvEntity.getName() + " | " + ex.getMessage());
        }
    }

}
