package Besant_Corejava.Food_application;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Get_order extends Hotel{
	protected boolean isitem=false;
	public void get_item() throws IOException
	{
		search_hotel();
		if(super.isthere==true)
		{
			File f = new File(filepath);
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wbk = new XSSFWorkbook(fis);
			
			for(int sheetcount = 0 ;sheetcount<wbk.getNumberOfSheets();sheetcount++)
			{
				 sheet = wbk.getSheetAt(sheetcount);
				 
				 if (user_hotel.equalsIgnoreCase(sheet.getSheetName())) 
				 {
					 System.out.print("\nEnter Item: ");
			            user_item = s.nextLine();
			            
	                    for (Row row : sheet)
	                    {
	                    	Foodcell = row.getCell(0);
	                        Pricecell = row.getCell(1);
	                        
	                        if (Foodcell != null && Foodcell.getCellType() == CellType.STRING)
	                        {
	                            String Food = Foodcell.getStringCellValue();
	                            
	                            if (user_item.equalsIgnoreCase(Food))
	                            {
	                                isitem = true;
	                                System.out.println("Enter Quantity: ");
	                                user_quantity = s.nextInt();
	                                if (Pricecell != null && Pricecell.getCellType() == CellType.NUMERIC)
	                                {
	                                    Price = Pricecell.getNumericCellValue();
	                                    this.Food = Food; // Set the correct Food value
	                                    System.out.println("Your Order - " + user_item.toUpperCase() + " " + Price + " - " + user_quantity);
	                                    break; // Exit the loop once item is found
	                                }
	                            }
	                        }
	                    }
	                    break; // Exit the loop once hotel is found
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

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
		Get_order go= new Get_order();
		go.get_item();

	}

}
