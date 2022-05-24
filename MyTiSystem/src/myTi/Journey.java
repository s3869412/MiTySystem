package myTi;

import java.io.PrintStream;
import java.time.Period;
import java.util.Scanner;


/*
 *If a User tries to purchase a Journey that requires a new Travel Pass, or an upgrade from 2Hour 
 *to All Day, and there is not enough credit left on their MyTi card, then the purchase of
 *that Journey must fail (with an Exception), and the user told they need to recharge their card. 
 */

public class Journey extends TravelPass 
{	   
	
		private int sZone;
		private int eZone;
	public Journey(int sZone, int eZone, TPass tPass) {
		super(sZone, eZone, tPass);
		this.sZone = sZone; 
		this.eZone = eZone;
		
	}
	public Zone getSZone() {
		return zone;
	}
	public Zone getEZone() {
		return zone;
	}
	
	public Zone getTPass() {
		return zone;
	}
	@Override
	public double travelCost(int sZone, int eZone,  TPass tPass) {
		 final int FACTOR = 60; 
		 final int TWO_HOUR = 2;
		 final int TWENTY_FOUR_H = 24; 
		Stations st = new Stations(null, null); 
		st.startStation(null);
		sZone = st.getSSZone();
		System.out.println("start station zone " + sZone);
		st.endStation(null);
		eZone = st.getESZone();
		System.out.println("end station zone " + eZone);

		int period = st.period();
		int minutes = period % FACTOR;
		int hours = period / FACTOR;
	
		if ((hours>=0 && hours <= 2)&& (minutes>=0 && minutes <= 59)) {
			tPass = tPass.a; 
		System.out.println("tPass value is : " + tPass);
		}
		else if((hours>=TWO_HOUR && hours <= TWENTY_FOUR_H)) { 
			tPass = tPass.b;
			System.out.println("all day tPass value is:  " + tPass);
		}
		else
				System.out.println("Your travel period have to be within 24 hours");
		if (sZone == 1 && eZone == 1 && tPass == TPass.a ) {
			   this.zone = Zone.a; 
		   	   this.tPass = tPass;
			   tCost = TWO_HOUR_ZONE1 ;
		   }
		  else if (sZone == 2 && eZone == 2 && tPass == TPass.a) {
			   this.zone = Zone.a; 
		   	   this.tPass = tPass;
		   	   tCost = TWO_HOUR_ZONE1; 
		   } 
		if (sZone == 1 && eZone == 1 && tPass == TPass.b ) {
			   this.zone = Zone.a; 
		   	   this.tPass = tPass;
			   tCost =ALL_DAY_ZONE1 ;
		   }
		if (sZone == 2 && eZone == 2 && tPass == TPass.b ) {
			   this.zone = Zone.a; 
		   	   this.tPass = tPass;
			   tCost =ALL_DAY_ZONE1 ;
		   }
		else if (sZone == 1 && eZone == 2 && tPass == TPass.a ) {
			 this.zone = zone.b; 
	   	   	 this.tPass = tPass ;
			 tCost = TWO_HOUR_ZONES12; 
			}
		  else if (sZone == 2 && eZone == 1 && tPass == TPass.a) {
			   this.zone = Zone.b; 
		   	   this.tPass = tPass ;
		   	   tCost = TWO_HOUR_ZONES12; 
			}
			if (sZone == 1 && eZone == 2 && tPass == TPass.b ) {
				this.zone = Zone.b; 
		   	    this.tPass = tPass ;
			    tCost = ALL_DAY_ZONES12;
			}
			else if (sZone == 2 && eZone == 1 && tPass == TPass.b ) {
				 this.zone = zone.b; 
		   	   	 this.tPass = tPass ;
				 tCost = ALL_DAY_ZONES12; 
			}
		
	
		return tCost;
	
	}
	public String toString(){
        return "[" + this.getSZone() +" ,  " + this.getEZone() +  "  ,  " + this.getTPass() + "]";
        }
	
	
	
public static void main(String[] args) {
	TravelPass jny = new Journey(0, 0, null); 
	
		
		UserData user = new UserData(null, null, null, null, null, 0.0); 
		user.topUp();
		//user.users().put(id, user).getUserCredit();
		//user.users();
		user.showCredit();
	
	//	user.users();
		//user.displayMap(user.users());
		//user.checkUserData().toString(); 
	
		//user.displayMap(user.users);
		//user.MyTiTicket(0, 0, 0);
		
	}
		
		
	}

