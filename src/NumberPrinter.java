

public class NumberPrinter {

    private String TEN_DIGIT_FORMATTER = "%10d";

    public void printListOfNumbers (String typeOfNumbers, int totalNumbers, NumberGenerator numberGenerator, int rowsPerPage, int columnsPerRow) {
        printListOfNumbers (typeOfNumbers, numberGenerator.generateNumbers(totalNumbers), rowsPerPage, columnsPerRow);
    }

    public void printListOfNumbers (String typeOfNumbers, int[] numbers, int rowsPerPage, int columnsPerRow) {

        int pageNumber = 1;
        int pageOffset = 1;
        int rowOffset = 0;
        int column = 0;
        
        int totalNumbers = numbers.length - 1;
        
        while (pageOffset <= totalNumbers) {
            
            System.out.print("The First " + totalNumbers);
            System.out.println(" " + typeOfNumbers + " === Page " + pageNumber);
           
            for (rowOffset = pageOffset; rowOffset <= pageOffset + rowsPerPage -1; rowOffset++) {
                for (column = 0; column <= columnsPerRow - 1; column++)
                    if (rowOffset + column * rowsPerPage <= totalNumbers)
                        System.out.printf(TEN_DIGIT_FORMATTER, numbers[rowOffset + column * rowsPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pageNumber++;
            pageOffset += rowsPerPage*columnsPerRow;
        }
    }

    public static void main (String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();
        numberPrinter.printListOfNumbers("Prime Numbers", 1000, new PrimeNumbersGenerator(), 50, 4);
    }

}
