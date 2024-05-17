package Besant_Corejava.Food_application;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Hotel extends Thread {
	
	Scanner s = new Scanner(System.in);
	String filepath=System.getProperty("user.dir")+"\\input\\Java_Hotel_assingment.xlsx";
	protected String user_hotel= new String();
	protected boolean isthere = false;
	protected String Food;
	protected double Price;
	protected String user_item=new String();
	protected int user_quantity;
	
	public void search_hotel() throws IOException
	{
		System.out.println("ORDER YOUR FOOD HERE");
		System.out.println("Available Hotels: \n1.Thalapakatti\n2.Buddha hut\n3.Taj\n4.Copper Kitchen\n5.A2B");
		//Available hotels Thalapakatti,Buddha hut,Taj,Copper Kitchen,A2B
		System.out.println("Enter Hotel name: ");
		user_hotel = s.nextLine();//getting user input
		
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wbk = new XSSFWorkbook(fis);
		
		for(int sheetcount = 0 ;sheetcount<wbk.getNumberOfSheets();sheetcount++)
		{
			Sheet sheet = wbk.getSheetAt(sheetcount);
			if(user_hotel.equalsIgnoreCase(sheet.getSheetName()))
			{
				isthere = true;
				System.out.println("Welcome to Hotel "+ user_hotel.toUpperCase()+" !!");
				System.out.println("Menu:\n-----");
				
				for(Row row : sheet)
				{
					Cell Foodcell = row.getCell(0);
					Cell Pricecell = row.getCell(1);
					
					if(Foodcell!= null && Foodcell.getCellType()==CellType.STRING)
					{
						if(Pricecell!=null && Pricecell.getCellType()==CellType.NUMERIC)
						{
							String Food=Foodcell.getStringCellValue();
							double Price=Pricecell.getNumericCellValue();
							
							System.out.println(Food+" - ₹"+Price);
						}
					}
				}
				
				break;
			}
			wbk.close();
		}
		
		if(!isthere)
		{
			System.out.println("Error: Hotel name not found.");
			return;
		}
		
	}
	
	public void run()
	{
		// TODO Auto-generated method stub
		try {
			search_hotel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Hotel t = new Hotel();
		//Thread t1 = new Thread(t);-- if thread not extends
		//System.out.println(t.getState());
		t.start();
		//Hotel h = new Hotel();
		//h.search_hotel();

	}
}
