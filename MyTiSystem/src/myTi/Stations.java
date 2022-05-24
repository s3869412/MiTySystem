package myTi;


import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Stations {
	

	private ArrayList <Stations> station = new ArrayList<Stations>();
	private String sName = "";
	private String sSName; 
	private String eSName; 
	private int sSZone; 
	private int eSZone; 
	private Zone zone;
	Scanner input = new Scanner(System.in);
	private Period periods;
	
	public Stations(String sName, Zone zone  )
	{  this.sName = sName;
		this.sSName = sSName;
		this.eSName = eSName;
	}
	public   String getSName() { 
		
		return sName; }
	public   String getSSName() { 
		
		return sSName; }
	public   String getESName() { 
		
		return eSName; }
	
	public Zone getZone() { 
		
		return zone; }
	public int getSSZone() { 
		
		return sSZone; }
	public int getESZone() { 
		
		return eSZone; }

		
	public String toString()
	{  return new String("start station name = "+sSName + "start station name = " + eSName +" start Station zone = " + getSSZone() + "\n"  ); 
	   
	}

	public String startStation(String name) {
		   
	   boolean valid = true;
		   Scanner input = new Scanner(System.in);
		   do {
				System.out.print("from which sation? :     ");
	
		try {
	
			 name = input.next();
			 valid = false; 
		} catch (Exception e){ System.out.println("please enter proper station name");}
			
		} while(valid); 
		 
	   if (name.contains("Central")||name.contains("Flagstaff")||name.contains("Richmond")) { 
			   sName = name; 
			   sSName= sName; 
			   zone =  this.zone.a;   //  "1";  
			   sSZone = 1; 
			  
		}
		else if (name.contains("Lilydale")||name.contains("Epping")) {
			    sName = name;
			    sSName= sName; 
			    zone =  this.zone.b; // "2"
			    sSZone = 2; 
			  
		}
		else 
		{
			   System.out.println("Unknown station! please enter correct station name?");
			   endStation(name);
		}
	   	
			return sSName ; 
			
	}
	
	public String endStation(String name) {
	   
	   boolean valid = true;
		   Scanner input = new Scanner(System.in);
		   do {
				System.out.print("to which sation? :     ");

		try {

			 name = input.next();
			 valid = false; 
		} catch (Exception e){ System.out.println("please enter proper station name");}
			
		} while(valid); 
		if(name.equals(sName)) {
		  System.out.println("you should choose different destination station");
			endStation(name); 
		}
		else
		{
		 
		   if (name.contains("Central")||name.contains("Flagstaff")||name.contains("Richmond")) { 
				   sName = name;
				   eSName= sName; 
				   zone = this.zone.a; // "1"; 
				   eSZone = 1;
				  
				}
				else if (name.contains("Lilydale")||name.contains("Epping")) {
				    sName = name;
				    eSName= sName;
					zone =   this.zone.b; //"2"; 
					eSZone = 2; 
	 
			   }
			   else 
			   {
				   System.out.println("Unknown station! please enter correct station name?");
				   endStation(name);
			   }
		}

	  
			return eSName  ; 
			
	   }
	
	public Zone sSZone(String name) {
		  Zone sSZone = null; 
		   
				 name = getSSName();
		
		   if (name.contains("Central")||name.contains("Flagstaff")||name.contains("Richmond")) {  
			   	zone =  this.zone.a;   //  "1";  
				  sSZone = zone; 
			}
			else if (name.contains("Lilydale")||name.contains("Epping")) {
				zone =  this.zone.b;
				sSZone = zone; 
			}
			else 
			{
				   System.out.println("Unknown station! please enter correct station name?");
				   endStation(name);
			}
		
			   
		 //  System.out.println( "zone of " + sSName + " is   " + sSZone);
				return sSZone  ; 
				
		}
		
		public Zone eSZone(String name) {
			
		   Zone eSZone = null; 
			 name = eSName;
		 
		   if (name.contains("Central")||name.contains("Flagstaff")||name.contains("Richmond")) { 
				   zone = this.zone.a; // "1"; 
				  eSZone = zone; 
				}
				else if (name.contains("Lilydale")||name.contains("Epping")) {
					zone =   this.zone.b; //"2"; 
				  eSZone = zone; 
			   }
			   else 
			   {
				   System.out.println("Unknown station! please enter correct station name?");
				   endStation(name);
			   }
	
		   System.out.println( "zone of " + eSName + " is   " + eSZone);
				return eSZone ; 
				
		   }
		
		
		public int starTime() {
			 Scanner in = new Scanner(System.in);
			 int starTime = 0;
			 int endTime = 0; 
			 int Minutes;
			 int Hours; 
			 String period = null;
			 //Date dt; 
		
			 try {
				 	System.out.println("Please enter the journey start time: ");

			         String s = input.next();
					 starTime = Integer.parseInt(s);
			   }
			   catch(Exception e) {
				   System.out.println("illegal - ");
			   }
				if(starTime <0 || starTime > 2359) {
					System.out.println("illegal time digit. please enter integer between 0 and 2359");
					period();
					
				}
				else { System.out.println("start time is : " + starTime);
						
				}
			return starTime; 
		}
		
		public int endTime() {
			 int endTime = 0; 
			 int Minutes;
			 int Hours; 
			 String period = null;
			

				try {
					 	System.out.println("Please enter the journey end time: ");

				         String s = input.next();
						 endTime = Integer.parseInt(s);
				}
				catch(Exception e) {
					   System.out.println("illegal - ");
				}
				if(endTime <0 || endTime > 2359) {
					System.out.println("illegal number. please enter integer between 0 and 2359");
					period();
						
				}
				else { System.out.println("end time is : " + endTime);
				
							
				}
				
				return endTime;
		}

		public int period () {

			int starTime = starTime();
			 int endTime = endTime();
			 final int FACTOR = 60; 
			 int Minutes;
			 int Hours; 
			 int period = 0;
			 
				if( (endTime - starTime) < 0) {

						System.out.println("please enter proper end time. endTime should be before 2359 midnight");
						period();
				}
				else {
						period = (endTime - starTime);
						Minutes = period % FACTOR;
						Hours = period / FACTOR;
						System.out.println("your ticket is valid for:    " + Hours + " hours, "  + Minutes + "   minutes  period");	

								 System.out.println("travel period duration is:  " + period);
							}
				return period;
		}
					

	   public List addStation() {
		 
		   station.add(0, new Stations(sName = "Central  ", zone =  this.zone.a));
		   station.add(1,new Stations(sName = "Flagstaff  ",zone =  this.zone.a));
		   station.add(2, new Stations(sName ="Richmond  ",zone =  this.zone.a));
		   station.add(3, new Stations(sName ="Lilydale  ",zone =  this.zone.b));
		   station.add(4, new Stations(sName ="Epping  ", zone = this.zone.b));
			
		return station;
		                    
	   }

}
