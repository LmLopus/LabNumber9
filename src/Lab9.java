import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lab9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
boolean flag = true;
		Scanner scnr = new Scanner(System.in);

		Map<String, Double> grocery = new HashMap<>();
		grocery.put("apple",  0.99);
		grocery.put("banana",  0.59);
		grocery.put("cauliflower",  1.59);
		grocery.put("dragonfruit",  2.19);
		grocery.put("elderberry",  1.79);
		grocery.put("figs",  2.09);
		grocery.put("grapefruit",  1.99);
		grocery.put("honeydew", 3.49);
		
		List<Double> prices = new ArrayList<>();
		List<String> items = new ArrayList<>();
		
		do {	
		System.out.println("Welcome to Guenther's Market!\r\n");
		System.out.println("====================");
		
		

		for (Map.Entry<String, Double> entry : grocery.entrySet()) {
			System.out.printf("%-13s $%-1s\n", entry.getKey(), entry.getValue());
		}
//		System.out.printf("%-12s %-12s\n", "Apple", "$0.99");
//		System.out.printf("%-12s %-12s\n", "Banana", "$0.59");
//		System.out.printf("%-12s %-12s\n", "Cauliflower", "$1.59");
//		System.out.printf("%-12s %-12s\n", "Dragonfruit", "$2.19");
//		System.out.printf("%-12s %-12s\n", "Elderberry", "$1.79");
//		System.out.printf("%-12s %-12s\n", "Figs", "$2.09");
//		System.out.printf("%-12s %-12s\n", "Grapefruit", "$1.99");
//		System.out.printf("%-12s %-12s\n", "Honeydew", "$3.49");
		
		System.out.println("\r\nWhat item would you like to order?");
		try {
			String itemOrder = scnr.next();
			String itemOrderLC = itemOrder.toLowerCase();
				if (grocery.containsKey(itemOrderLC)) {
					for (Double itemPrice : grocery.values()) {
						if (grocery.get(itemOrderLC) == itemPrice) {
						System.out.println("Adding " + itemOrder + " to cart at " + itemPrice);
						prices.add(itemPrice);
						items.add(itemOrderLC);
						break;
					}
					else {
					}
				}
			}
				else {
					throw new InputMismatchException();
				}
			
			
	}	catch (InputMismatchException e){
			System.out.println("You did not enter a valid option.");
	}
		System.out.println("Would you like to order anything else? yes or no");
		String yesOrNo = scnr.next();
		yesOrNo = yesOrNo.toLowerCase();
			if(yesOrNo.contentEquals("yes")) {
				
	
	}
			else if (yesOrNo.equals("no")){
				System.out.println("Thanks for the order!");
				System.out.println("Heres what you got:");
				for (int i = 0; i < prices.size(); i++) {
					System.out.printf("%-13s $%-1s\n", items.get(i), prices.get(i));

					
				}
				flag = false;
				double average = getTotal(prices) / items.size();
				
				System.out.printf("Average price per item in order was %.2f", average);
			}
			else {
				System.out.println("That was not a valid answer.");
				System.out.println("Would you like to order anything else? yes or no");
				String yesOrNo2 = scnr.next();
				yesOrNo2 = yesOrNo.toLowerCase();
					if(yesOrNo2.contentEquals("yes")) {
						
			
			}
					else if (yesOrNo2.equals("no")){
						break;
					}
			}
	
	
	}while (flag); {
		
		
		}
	}
	
	public static double getTotal(List <Double> itemPrice) {
		double total = 0; 
		for (double price: itemPrice) {
			total += price;
		}
		return total;
	}
}
