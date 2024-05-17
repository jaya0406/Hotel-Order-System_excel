package Besant_Corejava.Food_application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Hotel_map {

	    protected Scanner s = new Scanner(System.in);
	    protected String filepath = System.getProperty("user.dir") + "\\Input_1\\Java_Hotel_assingment.xlsx";
	    protected boolean isthere=false;
	    protected boolean isitem=false;
	    protected String user_hotel = new String();
	    protected String user_item=new String();
		protected int user_quantity;
		protected double amount;
		protected double total_amount;
		protected double Discount_rate;
	    
	   // List<String> get_food = new ArrayList<String>();
	    Map<String,Integer> Food_menu = new TreeMap<>();
	    //List<Integer> get_price = new ArrayList<Integer>();
public void get_hotel() throws IOException, InterruptedException 
{
	 System.out.println("ORDER YOUR FOOD HERE\n");
	 System.out.println("Available Hotels: \n1.Thalapakatti\n2.Buddha hut\n3.Taj\n4.Copper Kitchen\n5.A2B");
	
	 System.out.println("Enter Hotel name: ");
	 user_hotel = s.nextLine();
	        
	 File f = new File(filepath);
	 FileInputStream fis = new FileInputStream(f);
	 XSSFWorkbook wbk = new XSSFWorkbook(fis);
	        
	 for (int sheet_count = 0; sheet_count < wbk.getNumberOfSheets(); sheet_count++)
	 {
	   Sheet sheet = wbk.getSheetAt(sheet_count);
	   if (user_hotel.equalsIgnoreCase(sheet.getSheetName()))
	      {
	          isthere=true;
	           for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) 
	              	{ // first row is the header
	                   Row row = sheet.getRow(rowIndex);
	                   if (row != null) 
	                    {
	                       Cell foodcell = row.getCell(0);
	                       Cell pricecell = row.getCell(1);
	                        
	                        if (foodcell != null && foodcell.getCellType() == CellType.STRING) 
	                        {
	                        	if(pricecell!=null && pricecell.getCellType()==CellType.NUMERIC)
	                        	{
	                        		String foodItem = foodcell.getStringCellValue();
	                                int price = (int) pricecell.getNumericCellValue();
	                                Food_menu.put(foodItem,price);
	                        	}
	                        }
	                    }
	               }
	           
               break;
	        }
       }
	 
	 if(isthere)
	 {
		 System.out.println("Welcome to "+user_hotel.toUpperCase()+" hotel.\n");
	     System.out.println("Menu:\n-----");
	     for (Map.Entry<String, Integer> entry : Food_menu.entrySet())
	     {
	         System.out.println(entry.getKey() + ": " + entry.getValue());
	         Thread.sleep(1000);
	     } 
	 }
	
	       // Iterator<String>it = get_food.iterator();
	        //Iterator<Integer>it1 = get_price.iterator();
	        
	        wbk.close();
	       

	        
	        if(!isthere)
	        {
	        	System.out.println("Error: Hotel not found.");
	        	return;
	        }
	    }

public static void main(String[] args) throws IOException, InterruptedException 
		{
	    	Hotel_map hm = new Hotel_map();
	        hm.get_hotel();
	    }
	}