import java.io.*;
import java.util.*;

public class SolveMatrix {

    public static int columns;
    public static int rows;
    public static int count;
    public static int currentColumn;

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

        System.out.println("\nFinding current column.");
        SolveMatrix.currentColumn = 0;
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
                    SolveMatrix.count ++;
                }

                
            }

            // We're looking for the first column where the count is greater than 1. When we find it we can stop searching immediately. The current value of int count will be very handy in the next step.

            if (SolveMatrix.count > 1) {
                SolveMatrix.currentColumn = c;
                break;
            }
            
        }

        return currentColumn;
    }

    public static int findSubtrahand(List<List<Double>> matrix) {
        int index = SolveMatrix.rows - 1;
        while (index >= 0) {

            if (matrix.get(index).get(currentColumn) != 0) {
                break;
            }

            index--;
        }

        return index;
    }

    // Determine if the matrix is in reduced row eschalon form
    public static boolean isRREF(List<List<Double>> matrix) {
        
        for (int r = 0; r < SolveMatrix.rows - 1; r++) {
            for (int c = 0; c < SolveMatrix.columns - 2; c++) {
                if (matrix.get(r).get(c) != 0) {

                    if (c != r || matrix.get(r).get(c) != 1){
                        return false;
                    }

                }
            }
        }

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

    public static List<List<Double>> subtractRow(List<List<Double>> originalMatrix, int subtrahand) {

        List<List<Double>> modifiedMatrix = originalMatrix;

        List<Double> subtraRow = originalMatrix.get(subtrahand);

        int row = subtrahand - 1;

        while (row >= 0)  {

            // Skip rows that are already empty in the current column
            if (originalMatrix.get(row).get(SolveMatrix.currentColumn) == 0) {
                continue;
            }
            else {

                // Subtract each element of the subtraRow from each element of the current row that we're working with.
                List<Double> difference = originalMatrix.get(row);
                double factor = originalMatrix.get(row).get(SolveMatrix.currentColumn);

                System.out.println("Subtracting row " + subtrahand + " (" + subtraRow + ")" + " from " + difference);
                for (int c = 0; c < difference.size(); c++) {

                    
                    difference.set(c, difference.get(c) - (subtraRow.get(c) * factor) );
                    
                }

                modifiedMatrix.set(row, difference);
            }


            row--;
        }
        

        return modifiedMatrix;
    }

    // Reorder the rows according to RREF

    public static List<List<Double>> sortMatrix(List<List<Double>> unsortedMatrix) {
        List<List<Double>> sortedMatrix = new ArrayList<>(SolveMatrix.rows);

        //List<Double> kiddyPool;

        for (int c = 0; c < SolveMatrix.columns; c++) {
            int r = 0;
            while (r < unsortedMatrix.size()) {
                if (unsortedMatrix.get(r).get(c) != 0) {
                    sortedMatrix.add(unsortedMatrix.get(r));
                    unsortedMatrix.remove(r);
    
                }
                else {
                    r++;
                }
    
            }
        }
        

        return sortedMatrix;
    }



    // Print the matrix to the terminal




    public static void main(String[] args) throws IOException, InterruptedException {

        // Set up the matrix
        int rows = getRows();
        int columns = getcolumns();

        // Get the matrix data
        List<List<Double>> matrix = new ArrayList<>();

        while (matrix.size() < rows) {
            List<Double> row = getARow(columns);
            matrix.add(row);
        }

        List<List<Double>> oldMatrix = new ArrayList<>();

        // Solve the matrix starting here

        // The solving loop

        while (true) {
            
            // Find which row we need to work on by finding the first column where two or more rows have a non-zero value. Remember the column for later

            int currentColumn = findCurrentColumn(matrix);

            // Check the rows and reorder them if nessisary until the matrix is sorted as close to RREF as possible.
            System.out.println("\nScaling matrix");
            matrix = sortMatrix(matrix);

            // Scale each row until its leading value is 1
            List<Double> row;
            for (int i = 0; i < matrix.size(); i++) {

                // Select the row
                row = matrix.get(i);

                // Replace that entry with the scaled version
                matrix.set(i,scaleToOne(row));
                
            }
            System.out.println("New scaled matrix: " + matrix);

            // Working in the current column, find the last row that has a non-zero and save its index as the subtrahand.

            int subtrahand = findSubtrahand(matrix);

            // Subtract the subtrahand row from each row above it.

            matrix = subtractRow(matrix, subtrahand);

            // Sort the matrix again before checking RREF

            matrix = sortMatrix(matrix);

            // Check if the matrix is in reduced row eschalon form. If so, run the printout.
            // if (isRREF(matrix)) {
            //     printSolution(matrix);
            //     break;
            // }

            printSolution(matrix);
            
            Thread.sleep(10000);


        }



    }
}
