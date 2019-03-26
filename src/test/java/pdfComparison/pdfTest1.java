package pdfComparison;

import java.io.IOException;

import de.redsix.pdfcompare.PdfComparator;

public class pdfTest1 {	
	
	public static void main(String[] args) throws Exception {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		String file1 = projectPath + "\\testData\\file1.pdf";
		String file2 = projectPath + "\\testData\\file2.pdf";
		String resultFile = projectPath + "\\results\\result";
		String ignoreFile = projectPath + "\\ignore.conf";
		
		new PdfComparator(file1, file2).withIgnore(ignoreFile).compare().writeTo(resultFile);
		//new PdfComparator("expected.pdf", "actual.pdf").compare().writeTo("diffOutput.pdf");
		
		boolean isEquals = new PdfComparator(file1, file2).withIgnore(ignoreFile).compare().writeTo(resultFile);
		System.out.println("Are pdf files similar: " + isEquals);
		
		System.out.println("Compare completed");
		
		
		
	}

}
