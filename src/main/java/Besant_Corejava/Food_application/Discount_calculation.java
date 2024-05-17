package Besant_Corejava.Food_application;

import java.io.IOException;

public class Discount_calculation extends Get_order_map{
	
	public void discount_rate() throws IOException, InterruptedException
	{
		get_order();
		if(super.isitem==true)
		{
			if(super.amount==300 && super.amount<=500)
			{
				Discount_rate = amount * 0.05;
				total_amount =amount - Discount_rate;
				System.out.println(total_amount);
			}
			
			if(super.amount>500 && super.amount<=1000)
			{
				Discount_rate = amount * 0.08;
				total_amount =amount - Discount_rate;
				//System.out.println(Discount_rate);
			}
			
			if(super.amount>1000 && super.amount<=1500)
			{
				Discount_rate = amount * 0.11;
				total_amount =amount - Discount_rate;
				//System.out.println(Discount_rate);
			}
			
			if(super.amount>1500)
			{
				Discount_rate = amount * 0.15;
				total_amount =amount - Discount_rate;
			}

			else
			{
				System.out.print("Discount not applied");
			}
			
		}
		
	}
	

	public static void main(String[] args) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		Discount_calculation dc = new Discount_calculation();
		dc.discount_rate();

	}

}
