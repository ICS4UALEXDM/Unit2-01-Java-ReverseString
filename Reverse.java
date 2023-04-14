import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
* This program calculates amount of mean median and mode.
*
* @author  Alex De Meo
* @version 1.0
* @since   2023/02/08
*/

public final class Reverse {
    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility Class
     */
    private Reverse() {
        throw new IllegalStateException("Utility Class");
    }
    /**
    * This is the main method.
    *
    * @param args Unused
    * @throws Exception if something goes wrong
    */

    public static void main(String[] args) throws Exception {
        // Initializing variables
        String line;
        final String err = "Error";
        try {
            // new file object
            final File input = new File("input.txt");

            // Creating the writer
            final FileWriter writer = new FileWriter("output.txt");

            try {
                // Creating the scanner.
                final Scanner scanner = new Scanner(input);

                // ArrayList to hold the lines
                final ArrayList<String> lines = new ArrayList<>();
                // Getting the input from the first file
                while (scanner.hasNextLine()) {
                    // getting next line and putting it in the interim list
                    line = scanner.nextLine();
                    lines.add(line);
                }
                // set a counter
                int counter = 0;
                // creating a new array to hold this data
                final String[] linesArr = new String[lines.size()];
                // taking the data from the interim list and inputting it into
                // newly made array
                for (String line2 : lines) {
                    linesArr[counter] = line2;
                    counter++;
                }
                for (String line3 : linesArr) {
                    final String sentence = reverseRec(line3);
                    writer.write(sentence + "\n");
                }
            } catch (IOException error) {
                System.out.println(err + error.getMessage());
            }
            // closes the writer
            writer.close();
        } catch (IOException error) {
            System.out.println(err + error.getMessage());
        }
    }
    /**
    * This is the method reverseRecs the string.
    *
    * @param aString This is the string
    * @return the marks 2dArray
    */

    public static String reverseRec(String aString) {
        if (aString.isEmpty()) {
            return aString;
        } else {
            return reverseRec(aString.substring(1)) + aString.charAt(0);
        }
    }
}
