import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

public class SearchAlgo {


    private InteractiveCLI cli;

    public SearchAlgo() {
        cli = new InteractiveCLI();
    }



    public void run(){

        // User input
        cli.prompt("Enter the number of elements in the array: ");
        var size = cli.getKeyboardInteger();

        var array = new int[size];
        cli.display("Enter the elements in the array.");
        for(int i =0; i<size; i++){
            array[i] = cli.getKeyboardInteger();
        }

        cli.prompt("Enter the search key: ");
        var searchKey = cli.getKeyboardInteger();


        // Find key using linear search
        cli.display("\nUsing Linear Search:");
        long startTime = System.nanoTime();
        var keyIndex = linearSearch(array, searchKey);
        long endTime = System.nanoTime();

        displayIndexResult(keyIndex);

        NumberFormat formatter = new DecimalFormat("#0.00000");
        cli.display("Processing time for linear search was "+ ((endTime-startTime)/100)+" milliseconds.");

        // Find key using interpolation search
        Arrays.sort(array);
        cli.display("\nUsing Interpolation Search:");
        startTime = System.nanoTime();
        keyIndex = interpolationSearch(array, searchKey);
        endTime = System.nanoTime();

        displayIndexResult(keyIndex);

        cli.display("Processing time for linear search was "+ ((endTime-startTime)/100)+" milliseconds.");


        // Find key using revised linear search, using a sorted array
        cli.display("\nUsing Revised Linear Search:");
        startTime = System.nanoTime();
        keyIndex = revisedLinearSearch(array, searchKey);
        endTime = System.nanoTime();

        displayIndexResult(keyIndex);

        cli.display("Processing time for revised linear search was "+ ((endTime-startTime)/100)+" milliseconds.");




    }

    public int interpolationSearch(int[] arr, int x) {
        int lo = 0, hi = (arr.length - 1);

        while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            if (lo == hi) {
                if (arr[lo] == x) return lo;
                return -1;
            }

            // Probing the position with keeping uniform distribution in mind.
            int pos = lo + (((hi - lo) / (arr[hi] - arr[lo])) * (x - arr[lo]));

            // Condition of target found
            if (arr[pos] == x) {
                return pos;
            }

            // If x is larger, x is in the upper part
            if (arr[pos] < x) {
                lo = pos + 1;
            }

            // If x is smaller, x is in the lower part
            else {
                hi = pos - 1;
            }
        }
        return -1;
    }

    public void displayIndexResult(int keyIndex){
        if(keyIndex>0){
            cli.display("Search key FOUND at index " + keyIndex + ".");
        } else {
            cli.display("Search key NOT FOUND.");
        }
    }

    public int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;  // Element found, return its index
            }
        }
        return -1;  // Element not found, return -1
    }

    //Takes a sorted array,  so it knows that if there is a number higher than the key number, then it will return -1
    public int revisedLinearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;  // Element found, return its index
            }
            if(array[i] > target){
                return -1; // Since we are using a sorted list, there is no possibility that if a higher number is found it can be the key.
            }
        }
        return -1;  // Element not found, return -1
    }


    public static void main(String[] args) {
        var searchAlgo = new SearchAlgo();
        searchAlgo.run();
    }
}