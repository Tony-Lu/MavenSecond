package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {

	@Test(dataProvider="getData")
	public void loginPageTest(String username, String password, String text) {
		
//		driver.findelement.sendkeys(username);
//		driver.findelement.sendkeys(password);
//		driver.findelement.click		
//		System.out.println(text);
		
		
	}
	
	
	@DataProvider
	public Object[][] getData() {

		Object[][] data= new Object[2][3];
		// 0th row
		data[0][0]="akdkdkk@xxx.com";
		data[0][1]="akdkdkk@xxx.com";
		data[0][2]="akdkdkk@xxx.com";

		// 1tst row
		data[1][0]="akdkdkk@xxx.com";
		data[1][1]="akdkdkk@xxx.com";
		data[1][2]="akdkdkk@xxx.com";
		
		return data;
		

	}




}
