package Besant_Corejava.Food_application;

import java.io.IOException;

public class Invoice extends Discount_rate {

	public void invoice() throws IOException
	{
		discount_calculation();
		if(super.user_hotel!=null && super.isthere==true && super.isitem)
		{
			//discount_calculation();
	        System.out.println("\nInvoice\n" + "Hotel: " + user_hotel.toUpperCase());
	        System.out.println("Food Item\t\tPrice");
	        System.out.println("-------------------------------");
	        System.out.println(Food + "\t\t₹" + Price);
	        System.out.println("\nAmount:\t\t\t" + amount);
	        System.out.println("Discount rate:(" + ((discount_rate / amount) * 100) + "%)\t" + discount_rate);
	        System.out.println("-------------------------------");
	        System.out.println("Total amount \t\t" + Total_price);
	        System.out.println("   Thank you & visit again!!!");
		}
		   
		
	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		Invoice i = new Invoice();
		i.invoice();
	
	}

}
