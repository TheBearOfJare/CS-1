import java.io.*;
import java.util.*;

public class SolveMatrix {

    public static int columns;
    public static int rows;

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Ask the user to specify the # of rows
    public static int getRows() throws IOException {
        System.out.println("How many rows?");
        SolveMatrix.rows = Integer.parseInt(reader.readLine());
        return rows;
    }

    // Ask the user to specify the # of columns
    public static int getcolumns() throws IOException {
        System.out.println("How many columns?\n");
        SolveMatrix.columns = Integer.parseInt(reader.readLine());
        return columns;
    }

    // Ask the user to specify the data for a row
    public static List<String> getARow(int columns) throws IOException {
        List<String> row = new ArrayList<>(); 
        System.out.println("\n");
        for (int i=1; i <= columns; i++) {
            System.out.print(" x"+i+": ");
            row.add(reader.readLine());

        }
        System.out.println("\n");

        return row;
    }


    // TOOLS START HERE

    // Find the current column to work on (the one where there is more than one row with a non-zero entry)
    public static int findCurrentColumn(List<String> matrix) {

        int currentColumn = 0;
        List<String> row;

        for (int c  = 0; c < SolveMatrix.columns; c++) {

            // Count is a surprise tool that will help us later
            int count = 0;

            for (int r = 0; r < SolveMatrix.rows; r++) {

                // Convert the current row's string to an actual list to read from.
                row = new ArrayList<>(Arrays.asList(matrix.get(r).toString().split(", ")));

                // The value in the given column and row. Check if it's nonzero, and, if it is, up the count.
                String entry = row.get(c).toString();
                if (entry.equals("0")) {
                    continue;
                }
                else {
                    count ++;
                }

                
            }

            // We're looking for the first column where the count is greater than 1. When we find it we can stop searching immediately. The current value of int count will be very handy in the next step.

            if (count > 1) {
                currentColumn = c;
                break;
            }
            
        }

        return currentColumn;
    }


    // Determine if the matrix is in reduced row eschalon form
    public static boolean isRREF(List<String> matrix) {
        return true;
    }

    // Pull out the solution from a RREF matrix and print it to the terminal.
    public static void printSolution(List<String> matrix) {
        System.out.println(matrix);
    }


    // ELEMENTARY ROW OPPERATIONS START HERE

    // Scale a row to make the first nonzero digit 1
    public static String scaleToOne(List<String> unscaledList) {
        
        System.out.println("Scaling " + unscaledList + " to 1");

        List<String> scaledRow = new ArrayList<>();

        // Divide each entry by the value of the first non-zero entry in the row
        Long nonZeroVal = Long.valueOf(0);

        for (int i = 0; i<unscaledList.size(); i++) {

            // Get the numerical value of the entry.
            Long entry = Long.valueOf(unscaledList.get(i).toString());

            if (entry == 0) {
                continue;
            }
            else if (entry == 1) {
                nonZeroVal = Long.valueOf(1);
                break;
            }
            else {
                nonZeroVal = Long.valueOf(entry);
                break;
            }
        }
        
        // If the entry happens to already be a 1 just return the row, else, do the division of each entry.
        if (nonZeroVal == 1 || nonZeroVal == 0) {
            return unscaledList.toString().substring(1,unscaledList.toString().length()-1);
        }
        else {
            System.out.println("Dividing each entry by " + nonZeroVal);
            for (int i = 0; i<unscaledList.size(); i++) {
                
                // We already have the first non-zero entry so we can just divide by that.
                scaledRow.add(""+(Long.parseLong(unscaledList.get(i))/nonZeroVal));

            }


        }

        
        return scaledRow.toString().substring(1,scaledRow.toString().length()-1);
    }


    // Subtract a row from another row

    // Swap two rows in the order




    // Print the matrix to the terminal




    public static void main(String[] args) throws IOException{

        // Set up the matrix
        int rows = getRows();
        int columns = getcolumns();

        // Get the matrix data
        List<String> matrix = new ArrayList<>();
        while (matrix.size() < rows) {
            String row = getARow(columns).toString();
            matrix.add(row.substring(1, row.length()-1));
        }

        // Solve the matrix starting here

        // The solving loop
        while (true) {

            // Check the rows and reorder them if nessisary until rows with nonzero values for x1 are on top and then values for x2 and so on.

            // Scale each row until its leading value is 1
            List<String> row;
            for (int i = 0; i < matrix.size(); i++) {

                // Make a list out of the data in the matrix.
                row = new ArrayList<>(Arrays.asList(matrix.get(i).toString().split(", ")));

                // Add it to the row.
                matrix.set(i,scaleToOne(row));
            }

            // Find which row we need to work on by finding the first column where two or more rows have a non-zero value. Remember the column for later

            int currentColumn = findCurrentColumn(matrix);

            // Working in the current column, find the last row that has a non-zero and mark it as the subtrahand.

            int subtrahand;

            // Subtract the subtrahand row from each row above it.

            // Check if the matrix is in reduced row eschalon form. If so, run the printout.
            if (isRREF(matrix)) {
                printSolution(matrix);
                break;
            }


        }


    }
}
