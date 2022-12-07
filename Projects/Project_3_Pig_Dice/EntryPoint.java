/**
* @author Ryan Dodd
* <p> EntryPoint.java
* <p> Project3
* <p> This is the driver class that runs the game.
*/

/**
 * @author Ryan Dodd
 * The entry point, which serves as a driver class for the code.
 */
public class EntryPoint {
	/**
	 * Executes upon the program starting.
	 * @param args (String[]) takes command line input.
	 */
	public static void main(String[] args) {
		GameController gc = new GameController();
		gc.play();
	}

}
