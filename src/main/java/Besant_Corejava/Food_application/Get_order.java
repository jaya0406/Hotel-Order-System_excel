package Besant_Corejava.Food_application;


import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;


public class Get_order extends Hotel{
	protected boolean isitem=false;
	public void get_item() throws IOException
	{
		search_hotel();
		if(super.isthere==true)
		{
		
			System.out.print("\nEnter Item: ");
			user_item = s.nextLine().trim();
							
			Food=Foodcell.getStringCellValue();
			if(user_item.equalsIgnoreCase(Food))
			{
				isitem=true;
				System.out.println("Enter Qantity: ");
				user_quantity = s.nextInt();
				if(Pricecell!=null && Pricecell.getCellType()==CellType.NUMERIC)
				{
					Price=Pricecell.getNumericCellValue();
					System.out.println("Your Order - "+user_item.toUpperCase()+" "+Price+" - "+user_quantity);

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
