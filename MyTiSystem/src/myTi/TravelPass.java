package myTi;

import java.util.Scanner;

/*
 * Some ideas were adapted from TravelPass class implements data and operations required for a basic Travel Pass,
 * by  
 * @author lcavedon
 *
 */

enum Zone {
	  a, // zone 1to1
	  b, // zone 1to2/2to1
	  c 
}

enum TPass {
	a,
	b,
	c
}



public abstract class TravelPass {
		
	 double credit = 0.0;
      static Zone zone;
    static TPass tPass; 
	double tCost = 0; 
	final double TWO_HOUR_ZONE1 = 2.50;
	final double TWO_HOUR_ZONES12 = 3.50;
    final double ALL_DAY_ZONE1 = 4.90;
	final double ALL_DAY_ZONES12 = 6.80;
	private String length;
	private int sZone; 
	private int eZone; 
    
    // constructor
    public TravelPass(int sZone, int eZone,  TPass tPass)
    {
    	this.eZone = eZone; 
    	this.sZone = sZone; 
        this.tPass = tPass;
   
    }

	public double travelCost(int sZone, int eZone,  TPass tPass) {
		
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
		else if (sZone == 1 && eZone == 2 && tPass == TPass.b ) {
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
			else 
			{
				System.out.println("illegal travel Pass value");
				tCost = 0;
			}
			return tCost;
	}



 }


