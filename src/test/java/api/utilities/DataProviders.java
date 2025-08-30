package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="AllData")
	public String [][]allDataProviders(){
		
		String fName = System.getProperty("user.dir")+"//Testdata//TestData.xlsx";
		
		int totalRowCount = ReadExcelFile.getRowCount(fName, "TestData");
		int totalColCount = ReadExcelFile.getColCount(fName, "TestData");
		
		String userData[][] = new String[totalRowCount-1][totalColCount];
		
		for(int rowNo =1; rowNo<totalRowCount;rowNo++) {
			
			for(int colNo =0; colNo<totalColCount;colNo++)
			{
				userData[rowNo-1][colNo] = ReadExcelFile.getCellValue(fName, "TestData", rowNo, colNo);
			}
		}
		
		return userData;
	}
	
	@DataProvider(name="userNameData")
	public String []userNameDataProvider(){
		
		String fName = System.getProperty("user.dir")+"//Testdata//TestData.xlsx";
		
		int totalRowCount = ReadExcelFile.getRowCount(fName, "TestData");
		//int totalColCount = ReadExcelFile.getColCount(fName, "TestData");
		
		String userNameData[] = new String[totalRowCount-1];
		
		for(int rowNo =1; rowNo<totalRowCount;rowNo++) {
		 
			userNameData[rowNo-1] = ReadExcelFile.getCellValue(fName, "TestData", rowNo, 1);
			
		}
		
		return userNameData;
	}
	
	
}
