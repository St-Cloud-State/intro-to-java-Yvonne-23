import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Merge {
    public static void main(String[] args) {
        try (Scanner keyScanner = new Scanner(System.in)) {

            System.out.print("Please enter the first file name: ");
            String fileName1 = keyScanner.nextLine().trim();

            System.out.print("Please enter the second file name: ");
            String fileName2 = keyScanner.nextLine().trim();

            System.out.print("Please enter the output file name: ");
            String outFileName = keyScanner.nextLine().trim();

            File dataFile1 = new File(fileName1);
            File dataFile2 = new File(fileName2);
            File outFile   = new File(outFileName);

            try (Scanner fileScanner1 = new Scanner(dataFile1);
                 Scanner fileScanner2 = new Scanner(dataFile2);
                 PrintWriter printer  = new PrintWriter(outFile)) {

                boolean hasNext1 = fileScanner1.hasNextInt();
                boolean hasNext2 = fileScanner2.hasNextInt();
                int item1 = 0, item2 = 0;

                if (hasNext1) item1 = fileScanner1.nextInt();
                if (hasNext2) item2 = fileScanner2.nextInt();

                // Merge while both have data
                while (hasNext1 && hasNext2) {
                    if (item1 <= item2) {
                        printer.print(item1);
                        printer.print(' ');
                        hasNext1 = fileScanner1.hasNextInt();
                        if (hasNext1) item1 = fileScanner1.nextInt();
                    } else {
                        printer.print(item2);
                        printer.print(' ');
                        hasNext2 = fileScanner2.hasNextInt();
                        if (hasNext2) item2 = fileScanner2.nextInt();
                    }
                }

                // Drain the remainder
                while (hasNext1) {
                    printer.print(item1);
                    printer.print(' ');
                    hasNext1 = fileScanner1.hasNextInt();
                    if (hasNext1) item1 = fileScanner1.nextInt();
                }
                while (hasNext2) {
                    printer.print(item2);
                    printer.print(' ');
                    hasNext2 = fileScanner2.hasNextInt();
                    if (hasNext2) item2 = fileScanner2.nextInt();
                }

                printer.println(); // optional: end with newline
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
