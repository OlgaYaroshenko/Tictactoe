import java.util.*;

public class Reader {

    /**
    * Class fields
    */
	private Scanner scan;

    /**
    * Class constructor with no params
    * creates new Scanner object and assignes it to scan
    */
	private Reader() {
		scan = new Scanner(System.in);
	}

    /**
    * Static factory with no params
    * @return new Reader object
    */
	public static Reader init() {return new Reader();}


    /**
    * Method reads user input and checks if it is Y or N, case insensitive
    * @return input to lowercase
    * @throws InputException with specified text
    */
	public String readStart () throws InputException {
		String s = scan.nextLine().trim();
		if (s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("N")) {
			return s.toLowerCase();
		}
		throw new InputException("Y or N expected.");
	}

    /**
    * Method reads user input, trims whitespace, split symbols by space.
    * Checks if it consists of 2 symbols
    * @throws InputException with specified text
    * Parses integers and checks their range from 1-3
    * @throws InputException with specified text
    * Catches NumberFormatException
    * @throws InputException with specified text
    * @return q board
    */
	public int[] readMove () throws InputException {
		String s = scan.nextLine().trim();
		String[] split = s.split(" ");
		if (split.length != 2) {
			throw new InputException ("Two integers expected.");
		}
		int[] q = {-1, -1};
		for (int i = 0; i < 2; i++) {
			try {
				q[i] = Integer.parseInt(split[i]);
				if (q[i] < 1 || q[i] > 3) {
					throw new InputException ("Integers must be from 1 to 3.");
				}
			}
			catch (NumberFormatException e) {
				throw new InputException ("Integers expected.");
			}
		}
		return q;
	}
} 