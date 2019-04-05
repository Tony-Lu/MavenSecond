package test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dataDriven.ExcelDataDriven;

public class TestSample {

	private static final Logger logger = LogManager.getLogger(TestSample.class);
	public static void main(String[] args) throws IOException {


		ExcelDataDriven excelDriven = new ExcelDataDriven();
		
		ArrayList data = excelDriven.getData("Add Profile");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));

	}

}
