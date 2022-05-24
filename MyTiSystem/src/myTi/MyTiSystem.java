package myTi;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/* MyTi system is travel management system  which allow a user or multiple users 
 * making a journey or multiple journeys on the same day or over a number of days.
 * @author M.M.
 */
public class MyTiSystem {

//	protected double purchase;
	private  double credit;
	private static String zone;
	private static double tCost;
	private static String tPass; 
	
	// global initialization of variable credit
	final static double CREDIT_LIMIT = 100.0;  // maximum allowed credit
	final static int ALLOWED_MULTIPLE = 5;// Recharges allowed only by multiples of this.
	// static Scanner input;  // the Scanner that will be used for reading options
	int index ;
	// ArrayList to track all successful purchases made for future retrieval.
	ArrayList<String> purchaseList = new ArrayList<String>(); 
	 Map<String, List> printList = new HashMap<String, List>();
	 HashMap<String, UserData> hm = new HashMap<String, UserData>();
	// New Scanner object scan  was created to get input from keyboard
	Scanner scan = new Scanner(System.in);
	
	private UserData user = new UserData(null, null, null, null, null, 0.0); 
	
	public double getTCost(){
		
		   return tCost;
		   }

	
	public String getZone(){
		
		   return zone ();
		   }

	public String getTPass(){
		
		   return tPass();
		   }


	// simply display the options of selection 
	public int getOption() {
		
		boolean nonInteger = true;
		int option = 0; 

		// Display menu selection options
		System.out.println("************** Options Menu    *************************");
		System.out.println("--------------------------------------------------------");
		System.out.println("***** 1.Buy a Journey for a User          **************");
		System.out.println("***** 2.Charge a MyTi card for a User     **************");
		System.out.println("***** 3.Show Remaining Credit  for a User **************");
		System.out.println("***** 4.Print User Report                 **************");
		System.out.println("***** 5.Update Pricing                    **************");
		System.out.println("***** 6.Show Station Statistics           **************");
		System.out.println("***** 7.Add a new User                    **************");
		System.out.println("***** 8.Quit                              **************");	
		System.out.println("**************      End        *************************");

		// Get input from console numbers 1 to 8 and if nonInteger input 
		// was entered throw exception error message continue till an integer entered.  
		
		do {
				System.out.print("Please make a selection :     ");

				try {

					option = Integer.parseInt(scan.next());
				nonInteger = false; 
				} catch (Exception e){ System.out.println("Invalid Input, please enter a number between 1 and 7 or 8 to quit");}
				
			} while(nonInteger); 
		
			return option; 
	}
	
	// control of the menu display option. 
	public void chooseOption() {

		int choice;
		
			/// Display menu options i.e getOption() and select the appropriate number for the desired menu option.
			// and invalid selection message if any other number passed and start over again to choose the correct number. 
		
		
			choice = getOption(); 
			if (choice == 1) {
				 user.computeCost();
				 chooseOption();
			}
			else if (choice == 2) {
				user.topUp();
				chooseOption();
			}
			else if (choice == 3) {
				 user.showCredit();
				 chooseOption();
			}
			else if (choice == 4) {
				user.orderedPrintList(purchaseList);
				chooseOption();
			}
			else if (choice == 5) {
				//updatePricing();
				chooseOption();
			}
			else if (choice == 6) {
				//showStationStatistics();
				chooseOption();
			}
			else if (choice == 7) {
				 user.addUsers(); 
				 chooseOption();
			}
			else if (choice == 8)
				System.exit(0);
			else 
			{
				System.out.println("\n Invalid selection. Please select option: 1, 2 or 3 and 0 to exit \n\n");
				 chooseOption();		
			}	
	}
	
	
	public String tPass() {

 		// display available time zone options
 		System.out.println("#############{__travel Pass Menu options_}####################");
 		System.out.println("#############|                           |####################");
 		System.out.println("#############|  a) 2 hour                |####################");
		System.out.println("#############|  b) 24 hour               |####################");
		System.out.println("#############|  c) Cancel                |####################");
		System.out.println("#############|                           |####################");
		System.out.println("#############{_____       End       _____}####################");
	
		//	What travel period? :
		boolean  legal = true;
		String selection = null; 
		do {
			System.out.println("please choose approperiate travel period (a, b or c):  ");
			// input an appropriate letter to select the time period 

			try {

				 selection = scan.next();
				//String tPass = choice.valueOf(choice);
				if ((!selection.equals("a"))||(!selection.equals("b"))||(!selection.equals("c"))) {
					//	System.out.println("You have selected an illegal option. Please try again.");
				
						legal = false; 
				}
			} catch (Exception e){ System.out.println("Invalid Input, please enter a,b, or c and 0 to quit");}
			
		} while(legal); 
		
		// this line is to limit the selection to the lower case characters only. 
		//char tPass = choice.toLowerCase().charAt(0);
			
		// to select a, b, or c only and exclude any other option. 
			switch(selection) {
				case "a" :
					tPass = "a"; 
					break; 
				case "b":
					tPass = "b";
					break; 
				case "c":
					tPass ="c";
					System.out.println("enter 0 to exit");
					
					break ; 
				default: 
					System.out.println("invalid choice please select a, b or c");
					tPass(); 
			}
			// String tPassValue = tPass.valueOf(tPass);
	 return tPass; 
	}

	
 	public String zone() {

 		// display available time zone options
 		System.out.println("#############{_____Zone Menu options_____}####################");
 		System.out.println("#############|                           |####################");
 		System.out.println("#############|  a) Zone 1                |####################");
 		System.out.println("#############|  b) Zone 1 & 2            |####################");
		System.out.println("#############|  c) Cancel                |####################");
		System.out.println("#############|                           |####################");
		System.out.println("#############{_____       End       _____}####################");
	
		//	What time zone :
		boolean  legal = true;
		String choice = null; 
		do {
			System.out.println("please choose approperiate TIME ZONE (a, b or c):  ");
			// input an appropriate letter to select the time period 

			try {

				 choice = scan.next();
				//String tPass = choice.valueOf(choice);
				if ((!choice.equals("a")) || (!choice.equals("b"))||(!choice.equals("c"))) 
					//System.out.println("You have selected an illegal option. Please try again.");
					legal = false; 
				
			} catch (Exception e){ System.out.println("Invalid Input, please enter a,b, or c and 0 to quit");}
			//String tPass = choice.valueOf(choice);
		} while(legal); 

	// to select a, b, or c only and exclude any other option. 
		switch(choice) {
			case "a" :
				zone = "a"; 
				break; 
			case "b":
				zone = "b";
				break;
			case "c":
					zone ="c";
					System.out.println("enter 0 to exit");						
					break ; 
			default: 
					System.out.println("invalid choice please select a, b or c");
					zone(); 
			}	
		 
	 return zone; 
	}
 	

	public static void main(String[] args) {
		
		UserData usr = new UserData(null, null, null, null, null, 0.0); 
		TravelPass tp = new Journey(0, 0, null);
		
		
		 
				 
	MyTiSystem MyTi = new MyTiSystem(); 
		MyTi.chooseOption();
		
	}
	
}

