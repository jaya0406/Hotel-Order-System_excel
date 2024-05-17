package Besant_Corejava.Food_application;

import java.io.IOException;

public class Get_order_map extends Hotel_map {
	
public void get_order() throws IOException, InterruptedException
{
		get_hotel();
		if(isthere==true)
		{
	           System.out.print("\nEnter Item: ");
	           user_item = s.nextLine().trim().toUpperCase();
	                              
	           Food_menu.put(foodItem,price);
	           if(Food_menu.containsKey(user_item))
	           {
	        	   isitem=true;
	        	   System.out.print("Enter quantity: ");
	        	   user_quantity = s.nextInt();
	        	   System.out.println("Your order "+ user_item+" - "+user_quantity);
	        	   amount =Food_menu.get(user_item)*user_quantity;
	                            	
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
