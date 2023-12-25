package testcasedataofapplication;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProvForLoginApplication
{
	
	public FileInputStream FS;
	
	
	
	@DataProvider(name="Amrutham")
	
	
	public  Object[][] readApplicationDataFromExcel() throws Exception
	{
		
		FS = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\testcasedataofapplication\\ExcelData.xlsx");
		
		
		XSSFWorkbook book = new XSSFWorkbook(FS);
		
		
		XSSFSheet sheet = book.getSheet("LoginSauce");
				
		
		int rows= sheet.getLastRowNum();    // index numner of last row with data in zero based indexing

		
		int cols= sheet.getRow(0).getLastCellNum();    // index number of last coloumn in that row with data +1coloumn index value in zero based indexing 
		
		
		// All the above 5 statements are initialization of extracting data from excel and storing it in similar table format(r*c) in 2-d array.
		
		
		Object[][] excelData = new Object[rows][cols];
		
		
		// extracting data from excel
		
	      
		for(int i=0; i<rows; i++)     // row data extracting from excel to array
		 {
			
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0; j<cols; j++) // coloumn data extracting from excel to array
				{
				
				if(row!=null)
				{
				XSSFCell cell= row.getCell(j);
				 
				if(cell !=null)
				{
				
				CellType type = cell.getCellType();
				
				switch(type)           // condition statements 
				{
				case STRING : excelData[i][j] = cell.getStringCellValue();
				break;                 // jump statements
				
				case NUMERIC : excelData[i][j] = Integer.toString((int)cell.getNumericCellValue());
				break;
				
				case BOOLEAN : excelData[i][j]= cell.getBooleanCellValue();
				break;
       
				
				default:
				break;
				
				}
				}
				}
					
			}
		}
		
		book.close();
		return excelData;
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


