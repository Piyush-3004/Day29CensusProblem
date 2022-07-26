package com.blzassign;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {
	
	
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {

    	try {
            Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\cheti\\eclipse-workspace\\CensusProblem\\src\\test\\resources\\IndiaStateCensusData.csv"));
            CsvToBeanBuilder<IndianCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndianCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndianCensusCSV> stateCSVIterator = csvToBean.iterator();;
            int namOfEateries = 0;
            while (stateCSVIterator.hasNext()) {
                namOfEateries++;
                IndianCensusCSV censusData = stateCSVIterator.next();
            }
            return namOfEateries;
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

	public int loadIndianStateCode(String csvFilePath) throws CensusAnalyserException {
		// TODO Auto-generated method stub
        CsvToBean<IndiaStateCodeCSV> csvToBean = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\cheti\\eclipse-workspace\\CensusProblem\\src\\test\\resources\\IndiaStateCode.csv"));
            CsvToBeanBuilder<IndiaStateCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaStateCodeCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaStateCodeCSV> stateCSVIterator = csvToBean.iterator();;
            int namOfEateries = 0;
            while (stateCSVIterator.hasNext()) {
                namOfEateries++;
                IndiaStateCodeCSV stateData = stateCSVIterator.next();
            }
            return namOfEateries;
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
		
	}
}
