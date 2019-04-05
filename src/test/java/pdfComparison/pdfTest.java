package pdfComparison;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import de.redsix.pdfcompare.PdfComparator;
import test.TestSample;

public class pdfTest {	
	
	private static final Logger logger = LogManager.getLogger(TestSample.class.getName());
		@Test
		public void pdfDemoTest() throws IOException {
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
