package com.rsystems.test;
import org.testng.annotations.Test;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.Xls_Reader;

public class test {

	
	public static Xls_Reader excel = new Xls_Reader(ObjectRepository.excelFilePath);

	
	public String getKeyValue(String sheetname, String objectname, String keyname)
	{
		
		String sheetName = sheetname;
		String objectName = objectname;
		String keyName = keyname;
		String errorMessage = "Something wrong with your Key-Value Pair";
		
		int rows = excel.getRowCount(sheetName);
		
		for(int rowNum=2; rowNum<=rows; rowNum++)
		{
			
			if(excel.getCellData(sheetName, "objectID", rowNum).equalsIgnoreCase(objectName))
			{
				return excel.getCellData(sheetName, keyName, rowNum);
				
				
				
			}
					
			
			
		}
		
		System.out.println("NOT VALIDDDDDDDDDDDDD");
		return errorMessage;
		
		}


		
	
	
	

	@Test
	public void testingDP()
	{
		
		String data = getKeyValue("hub","Settings","focused_icon_textline");
		System.out.println(data);
		
		
		
		
		
	}
	
}
	
	