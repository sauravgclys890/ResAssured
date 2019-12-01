package com.apitesting.library;

import java.io.File;
import java.util.HashMap;

public class ExcelReaderPoi {
	
	String fileName=System.getProperty("user.dir")+File.separator+"Library"+File.separator+"TestData.xlsx";
	
	String sheetName="PositiveTestCaseData";
	
	public Object[][] readFileAndSheet(String fileName, String sheetName){
		Object[][] objArrays= new HashMap[500][1];
		Object[][] returnableArrays = null;
		int rowsCount = 0;
		
		
		return returnableArrays;
		
	}

}
