package myTi;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class UserData  implements MyTiTicket{
	private  String ID;
	private  String type;
	private String firstName;
	private String lastName; 
	private String email; 
	Double userCredit;
	int index ;
	double concession;
	//	private static double tCost;
	final static double CREDIT_LIMIT = 100.0;  // maximum allowed credit
	final static int ALLOWED_MULTIPLE = 5;// Recharges allowed only by multiples of this.
	private HashMap<String, UserData> users = new HashMap<String, UserData>(); 
	// ArrayList to track all successful purchases made for future retrieval.
	ArrayList<String> purchaseList = new ArrayList<String>(); 
	 Map<String, List> printList = new HashMap<String, List>();
	 
	public UserData (String ID, String type, String first , String last , String email, Double userCredit) {
		this.ID = ID; 
		this.type = type;
		firstName = first; 
		lastName = last;
		this.email = email; 
		this.userCredit = userCredit;
	
	}
	Scanner input = new Scanner(System.in);
	public String getID() {
		return ID; 
	}
	public  String getType() {
		
		return type;
	}
	public  String getFirst() {
		
		return firstName;
	}
		
	public String getLast() {
		
		return lastName ;
	}
	public  String getEmail() {
		
		return email;
	}
	public  double getUserCredit() {
		
		return userCredit;
	}	
	
	public Double getTopUp() {
		
		return userCredit; 
	} 
	// method just to display ordered list of the users
	public static void displayMap(Map m)
		{
		   Set keySet = m.keySet();
		   Iterator iterator = keySet.iterator();
		   while (iterator.hasNext()) {
		         String key = (String) iterator.next();
		         System.out.println(key + ":" + m.get(key) ); 
		   }   
		   
		}
	@Override
	 public String toString(){
	        return "[" + this.ID + " ,  " + this.type+ " ,  "  + this.firstName + "  ,  " + this.lastName + "  ,  " + this.email + "  ,  " + this.userCredit + "]";
	    }
	 // to add new users to users list
	  public HashMap<String, UserData> addUsers () {
		  
			users = users(); 
			boolean illegal = true; 
			Scanner input = new Scanner(System.in);
			do {
					System.out.println("Please enter user data as the follows (id, type, first name , last name , email & account credit :     ");
	
				 try {
				 	System.out.println("please enter the ID#:  ");
					ID = input.next(); 
					 if (users.containsKey(input)) {
						 System.out.println("this ID already exist");
						 users();
					 }
					 else
					 { 	System.out.println("please enter the type:  ");					
						type = input.next(); 
						System.out.println("please enter the first name:  ");
						firstName = input.next(); 
						System.out.println("please enter the last name:  ");
						lastName = input.next(); 
						System.out.println("please enter the email:  ");
						email = input.next();  
						System.out.println("please enter the account credit:  ");
						userCredit = Double.parseDouble(input.next());
					 }
					 illegal = false; 
				 } catch (Exception e){ System.out.println("Invalid Input, please enter String value");}
				
			  users.put(ID, new UserData(ID, type, firstName, lastName, email,userCredit)); 
				
			} while(illegal); 
	
			displayMap(users); 
		  
			return users;  
	
	  }
		// to recharge the card whenever it goes low in balance         
	public Double topUp() {
		
		int index = -1;
		UserData user = new UserData(null, null, null, null, null, 0.0);
		System.out.println("to recharge, please enter user Id");
		String id = user.checkUserData();
		users = new HashMap<String, UserData>(); 	
		double credit = userCredit; 
		System.out.println("how much do you want to add:   ");
		
		do 
		{
			double amount = 0.0;
			boolean nonChar = true ;
			do {
				System.out.print("Please make a selection :     ");
		
			try { 
					//throw an error message if a letter is entered instead of positive integer for amount
					amount = Double.parseDouble(input.next());
					nonChar = false; 
			 } catch (Exception e){ System.out.println("Invalid Input, please enter the amount in positive integer value between 0 and 100  ");}
					
		} while(nonChar); 
	
	if (amount <0.0 || amount > CREDIT_LIMIT)
			System.out.println("Sorry, the maximum allowed amount of credit is $100.00");
	else if (amount > 0.0 && amount % ALLOWED_MULTIPLE == 0 || amount<CREDIT_LIMIT && amount % ALLOWED_MULTIPLE == 0) {
			credit = credit + amount;
			user.userCredit = credit; 
			userCredit = credit;  
		    UserData y =  users.put(id, user); 
		    //user.users.put(id, user);
		    users.put(id, y);
		    System.out.println("\n your credited amount is:   " + amount + " and your new total credit is :   " + userCredit+ "\n\n");	
	
		    break;
	}
	else 
			System.out.println("Sorry, you can only add multiples of 5 \n ");
		} while (index ==-1);
			// add the new user to the users list 
				user.users().put(id, user).getUserCredit();
	
		return userCredit; 	
	
	}
	// shoe the remaining balance whenever required by the end of each transaction
	public double showCredit() {
		
		System.out.println("\n your remaining credit is:    " + userCredit + "\n\n");
		
		
		return userCredit; 		
	}
	// list of users saved in hashMap in order to allow the key to be user ID
	public HashMap<String, UserData> users () {
		  
		   HashMap<String, UserData> users = new HashMap<String, UserData>(); 
		   users.put(("001").toLowerCase(), new UserData(ID= "001",type = "Adult", firstName= "Omar", lastName= "Mohamed", email= "0433304444#xyz.com" , 0d));
		   users.put(("lc").toLowerCase(), new UserData( ID = "lc", type = "Senior", firstName ="Lawrence", lastName = "Cavedon", email ="lawrence.cavedon@rmit.edu.au",0d)); 
		   users.put(("vm").toLowerCase(),new UserData(ID = "vm", type = "Adult", firstName = "Xiang", lastName= "Li", email ="vuhuy.mai@rmit.edu.au",0d));
	
			return users;  
	
	  }
	// this method is similar to setUserID(). It can be used to check user data.
	public String checkUserData() {
		 	boolean t= true; 
		 	 Map h = users(); 		
		 	 Scanner scan = new Scanner(System.in);
		 	 System.out.println("which user?  : ");
	   // get input and compare it with the users list if it matchs the id then its existing user.
	   String input = scan.next(); 
	   if (h.containsKey(input)) {
		   ID = input;
		    System.out.println("record exist! user ID is :  " + this.ID +  " and type is: " + ((UserData) h.get(ID)).getType() );
			type = (String) ((UserData) h.get(ID)).getType();
			userCredit = ((UserData) h.get(ID)).getUserCredit();
			System.out.println("usercredit" + userCredit);
			return ID ;
	}
	else //if the user doesn't exist prompt for adding new user .
	    	System.err.println("no such user ID? ");
	   // Y or y for yes to add new user and any other character to say no. 
	   	System.out.print("Do you want to Add new user?  (Y/N): ");
	   	char userSelection = scan.next().charAt(0);
	if (userSelection == 'Y' || userSelection == 'y') // continue the loop if the user selects Y
		 addUsers(); 
	else // this message if y or Y are not selected
		System.out.println("please enter proper user ID");
			  
		return type;
	 }
	public String setUserID() {
	 	
	 	Map h = users(); 		
		Scanner scan = new Scanner(System.in);
	
		System.out.println("which user?  : ");
   
		String input = scan.next(); 
		if (h.containsKey(input)) {
			ID = input;
	        System.out.println("record exist! user ID is :  " + this.ID +  " and type is: " + ((UserData) h.get(ID)).getType() );
			type = (String) ((UserData) h.get(ID)).getType();
			userCredit = ((UserData) h.get(ID)).getUserCredit();
			if(userCredit == 0.0) {
					topUp();
			 }else
				 	System.out.println("usercredit" + userCredit);
			    	return ID ;
		}
		else
		    System.err.println("no such user ID? ");
	   
	   	System.out.print("Do you want to Add new user?  (Y/N): ");
		char userSelection = scan.next().charAt(0);
		if (userSelection == 'Y' || userSelection == 'y') // continue the loop if the user selects Y
				 addUsers(); 
		else
			System.out.println("please enter proper user ID");
		
			return type;
	}
	// this method return the travel day. its useful to check if the travel day is weekend
	// specially when user is Senior .
	public DayOfWeek travelDay () {
		 DayOfWeek dayOfWeek = null  ;		
		  try {
			  System.out.println("please enter the Travel Day order in the week starting 1 for Monday till 7 Sunday");

			   String s = input.next(); 
			   int day = Integer.parseInt(s);
		       dayOfWeek = DayOfWeek.of(day);	 
		  }
		  catch(Exception e) {
		   System.out.println("illegal - ");
			   }
	
				return dayOfWeek;		 
	}
	
	
	@Override    // MyTiTicket overrides MyTiTicket interface
	public double MyTiTicket(double FullMyTi, double JuniorMyTi, double SeniorMyTi) {
		// take get user ID from setUserID()
		setUserID();
		// get zone, travel pass details from travel Pass through Journey class.
		TravelPass tp = new Journey(0, 0, null); 
		// initial value of travel cost
		double tCost = tp.travelCost(0, 0, null);
		String type = getType();
		double yourDiscountedRate = 0; 
	
		if (type =="Adult") {
	 
			FullMyTi = tCost;
			  yourDiscountedRate = FullMyTi; 
			  System.out.println("Your ticket will cost you : " + yourDiscountedRate );
				  tCost = yourDiscountedRate;
				  return tCost;
				  
		}
		else if ((type == "Junior"))  {
			
				 JuniorMyTi = tCost * discountRate;
				 yourDiscountedRate= JuniorMyTi;
				 concession = yourDiscountedRate;
				  return concession ; 
		}
		else if ((type == "Senior"))  {
			//check travel date if weekend drop the travel cost to zero otherwise concession rate apply 
				DayOfWeek tDate = travelDay(); 
			if ((tDate == DayOfWeek.of(6))||(tDate == DayOfWeek.of(7))){
				
				SeniorMyTi = SeniorWeekEndRate;
				concession= SeniorWeekEndRate ;
				tCost = SeniorWeekEndRate; 
				System.out.println("Your discounted ticket is: " + concession );
				  return concession; 
		}
		else
		{  // weekdays concession rate apply
				SeniorMyTi = tCost * discountRate;
				yourDiscountedRate = SeniorMyTi;
				concession = yourDiscountedRate;
				tCost = yourDiscountedRate;
				System.out.println("Your discounted ticket is: " + yourDiscountedRate );
				  return concession; 
		}
	}
	
	else
		System.out.println("incorrect type" );
	
		System.out.println("Your discounted ticket is: " + yourDiscountedRate );
		return tCost; 
	}
	
	
	public double computeCost() {
		UserData usr = new UserData(null, null, null, null, null, null);
		Stations st = new Stations(null, null); 
		double tCost = 0.0;
		// enter user ID 
		String id = setUserID(); 
		Map h = users(); 
		double credit =  userCredit; 
		// check user id against user list and check credit topUP credit 
		if ( users().containsKey(id) &&  getUserCredit()== 0.0) 
		{
			System.out.println("ID is " + id);
			credit = topUp();
		
		}
		else
		{
			System.out.println("the id is : " + id);
		
			 tCost = MyTiTicket(0,0,0);
			 credit = userCredit;
			 // check there's enough credit to pay for the new pass
		if (credit < tCost) {
			// not enough credit to pay for the travel pass!!
			System.out.println("You don't have enough credit. please charge your card");
			topUp();
			
		} else {      // else == there is enough credit
		
			// pay for the pass
			userCredit -= tCost;
			
			// add the transaction details to the print report Array list purchase list
			purchaseList.add( " you journey  started at     " + st.startStation(null) + "    and ended at " + st.endStation(null) + "    for pass "  + TravelPass.tPass + " and Zone  " + TravelPass.zone + " for user  :   "+ id 
			+ "   concession is " + concession+ " and  all cost :" + tCost+"$"  
			+ "  and your balance credit is: " + showCredit());	
			++index;
			// update the user details after deduction.
			users.put(id, usr); 
			System.out.println(" \n" + " you journey " + st.startStation(null) +  " and ended at " + st.endStation(null) +"for pass "  + TravelPass.tPass + "   and Zone  " + TravelPass.zone + "    for user :   " +  id + " your concession rate is " + concession +  "   and all cost is  :    "+ tCost+"$   "  
						+ "   and your balance credit is: " + showCredit()+ "\n\n");
			// update the ordered hashMap list to get your report ordered. 				
			orderedPrintList(purchaseList);
		
				}
		
		}
		return tCost;
	}
	
	public List printPurchase() {
		
		// print array list of all successful purchases
		if( purchaseList.size()!=0) 
		{
			do {
				for (String str : purchaseList) {
		  
				System.out.println("  "  + str);
				--index;
				}
	
			}while(index>=1);  
		}
		else
			System.out.println("There is nothing to print. No purchase yet \n\n " );
	
		return purchaseList;
	  } 
		// a Map list of all successful journey purchases to be retrieved later in print report	 
	 public Map<String, List>  orderedPrintList(List prints ) {
	
		 prints  = printPurchase(); 
		 String id = getID();
	
		  printList.put(id, prints);
			for (String en : printList.keySet() )
			      System.out.println(printList.get(en));
			return printList ;
	 }	
}