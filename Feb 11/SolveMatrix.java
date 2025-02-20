import java.io.*;
import java.util.*;

public class SolveMatrix {

    public static int columns;
    public static int rows;
    public static int count;

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
    public static List<Double> getARow(int columns) throws IOException {
        List<Double> row = new ArrayList<>(); 
        System.out.println("\n");
        for (int i=1; i <= columns; i++) {
            System.out.print(" x"+i+": ");
            row.add(Double.valueOf(reader.readLine()));

        }
        System.out.println("\n");

        return row;
    }


    // TOOLS START HERE

    // Find the current column to work on (the one where there is more than one row with a non-zero entry)
    public static int findCurrentColumn(List<List<Double>> matrix) {

        System.out.println("\n\nFinding current column.");
        int currentColumn = 0;
        List<Double> row;

        for (int c  = 0; c < SolveMatrix.columns; c++) {

            // Count is a surprise tool that will help us later
            SolveMatrix.count = 0;

            for (int r = 0; r < SolveMatrix.rows; r++) {

                // Get the current Row;
                row = matrix.get(r);

                // The value in the given column and row. Check if it's nonzero, and, if it is, up the count.
                double entry = row.get(c);
                if (entry == 0) {
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
    public static boolean isRREF(List<List<Double>> matrix) {
        return true;
    }

    // Pull out the solution from a RREF matrix and print it to the terminal.
    public static void printSolution(List<List<Double>> matrix) {
        System.out.println(matrix);
    }



    // ELEMENTARY ROW OPPERATIONS START HERE

    // Scale a row to make the first nonzero digit 1
    public static List<Double> scaleToOne(List<Double> unscaledList) {
        
        System.out.println("Scaling " + unscaledList + " to 1");

        List<Double> scaledRow = new ArrayList<>(SolveMatrix.columns);

        // Divide each entry by the value of the first non-zero entry in the row
        Double nonZeroVal = Double.valueOf(0);

        for (int i = 0; i<unscaledList.size(); i++) {

            // Get the numerical value of the entry.
            Double entry = unscaledList.get(i);

            if (entry == 0) {
                continue;
            }
            else if (entry == 1) {
                nonZeroVal = Double.valueOf(1);
                break;
            }
            else {
                nonZeroVal = entry;
                break;
            }
        }
        
        // If the entry happens to already be a 1 just return the row, else, do the division of each entry.
        if (nonZeroVal == 1 || nonZeroVal == 0) {
            return unscaledList;
        }
        else {
            System.out.println("Dividing each entry by " + nonZeroVal);
            for (int i = 0; i<unscaledList.size(); i++) {
                
                // We already have the first non-zero entry so we can just divide by that.
                scaledRow.add(unscaledList.get(i)/nonZeroVal);

            }


        }

        
        return scaledRow;
    }


    // Subtract a row from another row

    // Reorder the rows according to RREF

    public static List<List<Double>> SortMatrix(List<List<Double>> unsortedMatrix, int currentColumn) {
        List<List<Double>> sortedMatrix = new ArrayList<>(SolveMatrix.rows);

        List<Double> kiddyPool;

        for (int r = 0; r < SolveMatrix.rows; r++) {
            if (sortedMatrix.get(r).get(currentColumn) != 0) {
                kiddyPool = sortedMatrix.get(0);
                sortedMatrix.set(0, sortedMatrix.get(r));
                sortedMatrix.set(r, kiddyPool);

            }

        }
        


        return sortedMatrix;
    }



    // Print the matrix to the terminal




    public static void main(String[] args) throws IOException{

        // Set up the matrix
        int rows = getRows();
        int columns = getcolumns();

        // Get the matrix data
        List<List<Double>> matrix = new ArrayList<>();

        while (matrix.size() < rows) {
            List<Double> row = getARow(columns);
            matrix.add(row);
        }

        // Solve the matrix starting here

        // The solving loop
        while (true) {
            // Find which row we need to work on by finding the first column where two or more rows have a non-zero value. Remember the column for later

            int currentColumn = findCurrentColumn(matrix);

            // Check the rows and reorder them if nessisary until rows with nonzero values for the current column of interest are on top of those with 0 values in that column.
            matrix = SortMatrix(matrix, currentColumn);

            // Scale each row until its leading value is 1
            List<Double> row;
            for (int i = 0; i < matrix.size(); i++) {

                // Select the row
                row = matrix.get(i);

                // Replace that entry with the scaled version
                matrix.set(i,scaleToOne(row));
            }

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
