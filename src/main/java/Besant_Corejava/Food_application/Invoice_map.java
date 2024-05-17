package Besant_Corejava.Food_application;

import java.io.IOException;

public class Invoice_map extends Discount_calculation{

	public void invoice() throws IOException, InterruptedException
	{
		discount_rate();
		if(super.user_hotel!=null && super.isthere==true && super.isitem)
		{
			//discount_calculation();
	        System.out.println("\nInvoice\n" + "Hotel: " + user_hotel.toUpperCase());
	        System.out.println("Food Item\t\tPrice");
	        System.out.println("-------------------------------");
	        System.out.println( user_item +"*"+user_quantity+ "\t\t₹" + Food_menu.get(user_item));
	        System.out.println("\nAmount:\t\t\t" + amount);
	        System.out.println("Discount rate:(" + (int)((Discount_rate / amount) * 100) + "%)\t" + Discount_rate);
	        System.out.println("-------------------------------");
	        System.out.println("Total amount \t\t" + total_amount);
	        System.out.println("\n   Thank you & visit again!!!");
		}
		   
		
	}
	public static void main(String[] args) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		Invoice_map i = new Invoice_map();
		i.invoice();
	}

}
