package dataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelExercise {

	public ArrayList<String> getData(String testCaseName) throws IOException {

		ArrayList<String> arr=new ArrayList<String>();
		FileInputStream fls = new FileInputStream("F:\\Java\\MavenSecond\\testData\\excelData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fls);
		int sheetCount = wb.getNumberOfSheets();
		for(int i=0;i<sheetCount;i++) {
			if(wb.getSheetName(i).equalsIgnoreCase("MD01")) {
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> rows =sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				int j=0;
				int col=0;				
				while(ce.hasNext()) {
					Cell cellVar = ce.next();
					if(cellVar.getStringCellValue().equalsIgnoreCase(testCaseName)) {
						col=j;
					}
					j++;
				}
				System.out.println("target data column is: "+col);
				
				while(rows.hasNext()) {
					Row rowVar = rows.next();
					if(rowVar.getCell(col).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell>rowData=rowVar.cellIterator();
						while(rowData.hasNext()) {
							Cell c = rowData.next();
							if(c.getCellTypeEnum()==CellType.STRING){
								arr.add(c.getStringCellValue());
							}
							else {
								arr.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
								
						}
					}
				}
				
			}
		}
		
		return arr;		

	}

}
