package Besant_Corejava.Food_application;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Get_order_map extends Hotel_map {
	
public void get_order() throws IOException, InterruptedException
{
		get_hotel();
		if(isthere==true)
		{
			File f = new File(filepath);
			FileInputStream fis = new FileInputStream(f);
			try (XSSFWorkbook wbk = new XSSFWorkbook(fis)) {
				for(int sheetcount = 0 ;sheetcount<wbk.getNumberOfSheets();sheetcount++)
				{
					sheet = wbk.getSheetAt(sheetcount);
						 
				if (user_hotel.equalsIgnoreCase(sheet.getSheetName())) 
				 {
							
					 System.out.print("\nEnter Item: ");
					 user_item = s.nextLine().trim().toUpperCase();
				                          
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) 
				{ // first row is the header
					row = sheet.getRow(rowIndex);
					if (row != null) 
					 {
						foodcell = row.getCell(0);
					        pricecell = row.getCell(1);
					                    
					 if (foodcell != null && foodcell.getCellType() == CellType.STRING) 
					  {
					 if(pricecell!=null && pricecell.getCellType()==CellType.NUMERIC)
					  {
					        String foodItem = foodcell.getStringCellValue().toUpperCase();
					        int price = (int) pricecell.getNumericCellValue();
									
					        Food_menu.put(foodItem,price);
					        if(Food_menu.containsKey(user_item))
					        {
					             isitem=true;
					             System.out.print("Enter quantity: ");
					             user_quantity = s.nextInt();
					             System.out.println("Your order "+ user_item+" - "+user_quantity);
					             amount =Food_menu.get(user_item)*user_quantity;
					            break;
					        }
					} 	
					}
					}
				}
				}
				}
			} 
		}
		else
		{
			return;
		}
		
		if(!isitem)
		{
			System.out.println("Error: Item not found.");
			return;
		}
}	


	public static void main(String[]args) throws IOException, InterruptedException
	{
		Get_order_map gom= new Get_order_map();
		gom.get_order();
	}
	
}