import java.io.*;
import java.util.*;

public class SolveMatrix {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Ask the user to specify the # of rows
    public int getRows() throws IOException {
        System.out.println("How many rows?");
        int rows = Integer.parseInt(reader.readLine());
        return rows;
    }

    // Ask the user to specify the # of columns
    public int getcolumns() throws IOException {
        System.out.println("How many columns?");
        int columns = Integer.parseInt(reader.readLine());
        return columns;
    }

    // Ask the user to specify the data for a row

    public List<String> getARow(int columns) throws IOException {
        List<String> row = new ArrayList<>(); 

        for (int i=1; i <= columns; i++) {
            System.out.print(" x"+i+": ");;
            row.add(reader.readLine());

        }

        return row;
    }


    // ELEMENTARY ROW OPPERATIONS START HERE

    // Scale a row to make the first nonzero digit 1
    public List<String> scaleToOne(List<String> unscaledList) {
        
        List<String> scaledRow = new ArrayList<>();

        // Divide each entry by the value of the first non-zero entry in the row
        Long nonZeroVal = Long.valueOf(0);

        for (int i = 0; i<unscaledList.size(); i++) {

            // Get the numerical value of the entry.
            Long entry = Long.valueOf(unscaledList.get(i).toString());
            System.err.println(entry);
            if (entry == 0) {
                continue;
            }
            else if (entry == 1) {
                nonZeroVal = Long.valueOf(1);
                break;
            }
            else {
                nonZeroVal = Long.valueOf(entry);
            }
        }
        
        // If the entry happens to already be a 1 just return the row, else, do the division of each entry.
        if (nonZeroVal == 1 || nonZeroVal == 0) {
            return unscaledList;
        }
        else {
            for (int i = 0; i<unscaledList.size(); i++) {

                // We already have the first non-zero entry so we can just divide by that.
                unscaledList.set(i, ""+(Long.parseLong(unscaledList.get(i))/nonZeroVal));

            }


        }

        
        return scaledRow;
    }


    // Subtract a row from another row

    // Swap two rows in the order


    // Print the matrix to the terminal




    public void main(String[] args) throws IOException{

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

            for (int i = 0; i < matrix.size(); i++) {
                
            }

            // Find which row we need to work on by finding the first column where two or more rows have a non-zero value. Remember the column for later

            int currentColumn;

            // Working in the current column, find the last row that has a non-zero and mark it as the subtrahand.

            int subtrahand;

            // Subtract the subtrahand row from each row above it.

            // 


        }


    }
}
