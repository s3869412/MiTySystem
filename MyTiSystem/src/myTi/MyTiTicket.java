package myTi;



/*
 * A User may be an Adult, a Junior or Senior. A MyTi ticket is a
 *  FullMyTi  /  Adult, a JuniorMyTi if its User is a Junior, and a SeniorMyTi if its User is a Senior.
 * JuniorMyTi and SeniorMyTi tickets are also ConcessionTickets with an associated
 * discountRate--- you mst use a Java interface to implement this requirement. SeniorMyTi
 * ticket holders travel free on Sundays---they do not have to pay for any journeys.
 * discountRate is set at 0.5 (i.e. half-price) and is always the same for ALL Concession users,
 * but this must be (theoretically) able to be changed.
 */

public interface MyTiTicket {
	public static final double FullMyTi = 0;
	public static final double JuniorMyTi = 0;
	public static final double SeniorMyTi = 0;
	public static final double SeniorWeekEndRate = 0.0; 
	public static final double ConcessionTickets = 0.50;
	public static final double discountRate = 0.50;

	double MyTiTicket(double FullMyTi, double JuniorMyTi, double SenioMyTi);
 	 		
 	

}

