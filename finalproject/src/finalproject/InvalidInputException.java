/**
 * Lead Author(s):
 * 
 * @author Nohemi Arquette
 * 
 *         Responsibilities: Custom exception class to handle invalid user input
 *         for Pokémon cards.
 */

// InvalidInputException IS-A Exception
public class InvalidInputException extends Exception {

	/**
	 * Constructs an InvalidInputException with a specific error message.
	 *
	 * @param message the error message
	 */
	public InvalidInputException(String message) {
		super(message);
	}
}
