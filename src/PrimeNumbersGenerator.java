import java.util.LinkedList;
import java.util.List;

public class PrimeNumbersGenerator implements NumberGenerator {

    
    /*Ordmax seems to refer to the ORDMAX algorithm of Ford-Zassenhaus, the name is kept as is*/
    final int ORDMAX = 30;
    
    public int[] generateNumbers (int amountOfPrimes) {

        int square = 9;
        int ordinal = 2;
        
        int[] listOfPrimes = new int[amountOfPrimes + 1];
        listOfPrimes[1] = 2;

        int[] mult = new int[ORDMAX+1];

        int currentNumber = 1;
        int nextFoundPrime = 1;
        boolean isAPrime = false;

        int n = 0;

        while (currentNumber < amountOfPrimes) {
            do {
                nextFoundPrime += 2;
                
                if( nextFoundPrime == square) {
                    ordinal++;
                    square = listOfPrimes[ordinal] * listOfPrimes[ordinal];
                    mult[ordinal-1] = nextFoundPrime;
                }
                n = 2;
                isAPrime = true;
                while (n < ordinal && isAPrime) {
                    while (mult[n] < nextFoundPrime)
                        mult[n] += listOfPrimes[n] + listOfPrimes[n];
                    if (mult[n] == nextFoundPrime)
                        isAPrime = false;
                    n++;
                }
            } while (!isAPrime);
            
            currentNumber++;
            listOfPrimes[currentNumber] = nextFoundPrime;
        }

        return listOfPrimes;
        
    }

    public static void main (String[] args) {
        PrimeNumbersGenerator generator = new PrimeNumbersGenerator();
        int[] primes = generator.generateNumbers(10);

        for (int i = 0; i < primes.length; i++) {
            System.out.println(primes[i]);
        }
    }
    
    
    
    
}



