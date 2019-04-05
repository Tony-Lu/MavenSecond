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

public class ExcelDataDriven {	//No.161 --- 166
	
	// identify testcase column by scanning the 1st row 
	// once column is identified then scan entire testcase column to identify targetData row
	// after you grab targetData testcase row,  then pull the data from that row to parse into test

	public ArrayList<String> getData(String testCaseName) throws IOException {
		
		ArrayList<String> arr = new ArrayList<String>();
		FileInputStream fls = new FileInputStream("F:\\Java\\MavenSecond\\testData\\excelData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fls);
		
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("MD01")){
				XSSFSheet sheet = workbook.getSheetAt(i);
				// identify testcase column by scanning the 1st row
				Iterator<Row> rows = sheet.iterator();//sheet is collection of rows
				Row firstrow = rows.next();  
				Iterator<Cell> cells = firstrow.cellIterator();//row is collection of cells
				int k=0;
				int col = 0;
				while(cells.hasNext()) {
					Cell cellVar = cells.next();
					if(cellVar.getStringCellValue().equalsIgnoreCase(testCaseName)) {
						col=k;  // got actual column of the target data
					}
					k++;
//					System.out.println("TestCase's column is: "+col);
				}
				
				System.out.println("TestCase's column is: "+col);
				
				// once column is identified then scan entire testcase column to identify targetData row
				
				while(rows.hasNext()) {
					Row rowVar=rows.next();
					if(rowVar.getCell(col).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						// after you grab targetData testcase row,  then pull the data from that row to parse into test
						Iterator<Cell> ce=rowVar.cellIterator();
						while(ce.hasNext()) {
							Cell c  = ce.next();							
							if(c.getCellTypeEnum()==CellType.STRING){
								arr.add(c.getStringCellValue());// adding all String data into arr 								
							}
							else {
								arr.add(NumberToTextConverter.toText(c.getNumericCellValue()));// convert data type to string	
//								arr.add(String.valueOf(c.getNumericCellValue()));// this method return: 1.51544848E8 , which is wrong
							}
							
						}
						
					}					
					
				}				
				
			}
		
		}
		return arr;		

	}
	
}


