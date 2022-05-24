package myTi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;


class JourneyTest {
	private Journey testJny;
     static Zone zone;
     static TPass tPass; 
     int sZone; 
     int eZone;
     private String sName = "";

	
	@BeforeClass // annotation to tell Junit about the purpose
	// of each method 
	public static void runBeforeAllTest() {
		// some code to be here
	}

	@AfterClass
	public static void runAfterAllTest() {
		// to be run only 1 time after all tests finish.	
	}

	@Before
	public void setUp()  throws Exception{
		// test for zone1 and zone2 and 2 hour pass.
		double tCost = 0; 
		 final int FACTOR = 60; 
		 final int TWO_HOUR = 2;
		 final int TWENTY_FOUR_H = 24; 

		final double TWO_HOUR_ZONE1 = 2.50;
		final double TWO_HOUR_ZONES12 = 3.50;
	    final double ALL_DAY_ZONE1 = 4.90;
		final double ALL_DAY_ZONES12 = 6.80;
		testJny = new Journey(1,2,tPass.a);
		Stations st = new Stations(sName, zone); 
		st.startStation("Central");
		sZone = st.getSSZone();
		st.endStation("Epping");
		eZone = st.getESZone();		
		
	}

	@After
	public void tearDown() {
		// some code to run after each test 
	}


	@Test
	public void testTravelCost()  {
		//
		//

		testJny.travelCost(1, 2, tPass.a);
		
		double expectedResult = 3.5;
		
	
		double actualResult = testJny.travelCost(1, 2, tPass.a);
		 


	}

}
