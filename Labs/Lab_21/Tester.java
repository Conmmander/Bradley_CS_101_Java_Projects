import java.util.ArrayList;

public class Tester
{
	public static void main( String[] args )
	{
		ArrayList<HasLegs> thoseThatHaveLegs = new ArrayList<>() ;
		ArrayList<HasWings> thoseThatHaveWings = new ArrayList<>() ;
		ArrayList<BreathesUnderwater> thoseThatBreatheUnderwater = new ArrayList<>() ;
		
		//TODO: crate at least two different objects, each of a different class,
		//       for each of the three interfaces and add the objects to the
		//       corresponding ArrayList.
		Fish f = new Fish();
		Clam c = new Clam();
		Kaboom k = new Kaboom();
		Bee b = new Bee();
		Dog d = new Dog();
		Desk de = new Desk();
		
		thoseThatHaveLegs.add(d);
		thoseThatHaveLegs.add(de);
		thoseThatHaveWings.add(k);
		thoseThatHaveWings.add(b);
		thoseThatBreatheUnderwater.add(f);
		thoseThatBreatheUnderwater.add(c);
		for( HasLegs hl : thoseThatHaveLegs )
		{
			System.out.print( hl.toString() ) ;
			System.out.println( " I have " + hl.getNumberOfLegs() + " legs." ) ;
		}

		for( HasWings hw : thoseThatHaveWings )
		{
			System.out.print( hw.toString() ) ;
			System.out.println( " I have " + hw.getNumberOfWings() + " wings." ) ;
		}
		
		for( BreathesUnderwater buw : thoseThatBreatheUnderwater )
		{
			System.out.print( buw.toString() ) ;
			System.out.println( " I am breathing underwater." ) ;
			buw.breatheUnderwater() ;
		}
	}
}
