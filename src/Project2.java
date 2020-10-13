import java.util.Random;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Project2 {
    public static int[] anArray;

    /*               ARRAY INITIALIZATIONS                          */
    //this fills the array with random numbers within range
    public static int randomFill(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt(max + 1 - min) + min;
        return randomNum;
    }

    //make an array of given size and fill with random numbers
    public static int[] list(int size){
        anArray = new int[size];
        for(int i = 0; i < anArray.length; i++){
            anArray[i] = randomFill(-100, 100);
        }
        return anArray;
    }

    /*                          ALGORITHM IMPLEMENTATIONS                         */

    //this is the brute-force solution to both the SORTED and UNSORTED array, time complexity O(n^2)
    public int[] twoSumBruteForce(int[] array, int target){
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                int complement = target - array[i];

                if(array[j] == complement){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no match found");
    }


    //this is a hash-map implementation for an UNSORTED array. time complexity O(n)
    public int[] twoSumHashMap(int[] array, int target){
        Map<Integer, Integer> num_map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            int complement = target - array[i];
            if(num_map.containsKey(complement)){
                return new int[] {num_map.get(complement), i};
            }
            num_map.put(array[i], i);
        }
        throw new IllegalArgumentException("no match found");
    }

    //main driver
    public static void main(String[] args){
        Project2 ts = new Project2();
        long start, end, duration;

        //initializations for arrays of size 100
        int unsortedArr100[] = list(100);             //get random array of size 100
        int sortedArr100[] = list(100);               //get random array of size 100
        Arrays.sort(sortedArr100);                         //use built in sorting function
        int target100 = randomFill(-200, 200);             //get a random number between the range -200, 200

        //initializations for arrays of size 1,000
        int unsortedArr1000[] = list(1000);
        int sortedArr1000[] = list(1000);
        Arrays.sort(sortedArr1000);
        int target1000 = randomFill(-200, 200);

        //initializations for arrays of size 100,000
        int unsortedArr100000[] = list(100000);
        int sortedArr100000[] = list(100000);
        Arrays.sort(sortedArr100000);
        int target100000 = randomFill(-200, 200);

        //initializations for arrays of size 1,000,000
        int unsortedArr1000000[] = list(1000000);
        int sortedArr1000000[] = list(1000000);
        Arrays.sort(sortedArr1000000);
        int target1000000 = randomFill(-200, 200);

        /*        SORTED ARRAY; shows brute-force and hashmap implementations       */
        System.out.println("Sorted Array");
        for(int i = 0; i < sortedArr100.length; i++){
            System.out.printf("at index %d the value is %d\n", i, sortedArr100[i]);
        }

        //Brute force

        //size 100
        start = System.nanoTime();
        int bfSortReturn100[] = ts.twoSumBruteForce(sortedArr100, target100);
        end = System.nanoTime();
        duration = end - start;
        String bf = Arrays.toString(bfSortReturn100);
        System.out.println("\n\nBrute-Force implementation for a sorted array:");
        System.out.printf("size: %d\ntarget: %d found at indexes %s \nTime taken: %d", sortedArr100.length,target100,bf, duration);

        //size 1000
        start = System.nanoTime();
        int bfSortReturn1000[] = ts.twoSumBruteForce(sortedArr1000, target1000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(bfSortReturn1000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", sortedArr1000.length,target1000,bf, duration);

        //size 100000
        start = System.nanoTime();
        int bfSortReturn100000[] = ts.twoSumBruteForce(sortedArr100000, target100000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(bfSortReturn100000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", sortedArr100000.length,target100000,bf, duration);

        //size 1000000
        start = System.nanoTime();
        int bfSortReturn1000000[] = ts.twoSumBruteForce(sortedArr1000000, target1000000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(bfSortReturn1000000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", sortedArr1000000.length,target1000000, bf, duration);

        //hash map
        //size 100
        start = System.nanoTime();
        int[] hmSortReturnArr100 = ts.twoSumHashMap(sortedArr100, target100);
        end = System.nanoTime();
        duration = end - start;

        bf = Arrays.toString(hmSortReturnArr100);
        System.out.println("\n\n\nHash-map implementation for a sorted array:");
        System.out.printf("size: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", sortedArr100.length,target100,bf, duration);

        //size 1000
        start = System.nanoTime();
        int hmSortReturnArr1000[] = ts.twoSumHashMap(sortedArr1000, target1000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(hmSortReturnArr1000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", sortedArr1000.length,target1000,bf, duration);

        //size 100000
        start = System.nanoTime();
        int hmSortReturnArr100000[] = ts.twoSumHashMap(sortedArr100000, target100000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(hmSortReturnArr100000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", sortedArr100000.length,target100000,bf, duration);

        //size 1000000
        start = System.nanoTime();
        int hmSortReturnArr1000000[] = ts.twoSumHashMap(sortedArr1000000, target1000000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(hmSortReturnArr1000000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", sortedArr1000000.length,target1000000, bf, duration);



        /*         UNSORTED ARRAY; shows brute-force and hashmap implementations        */
        System.out.println("\n\nUnsorted Array");
        for(int i = 0; i < unsortedArr100.length; i++){
            System.out.printf("at index %d the value is %d\n", i, unsortedArr100[i]);
        }

        //brute force

        //size 100
        start = System.nanoTime();
        int[] bfReturnArr100 = ts.twoSumBruteForce(unsortedArr100, target100);
        end = System.nanoTime();
        duration = end - start;
        //printing the indexes that give the vales
        bf = Arrays.toString(bfReturnArr100);
        System.out.println("\nBrute-Force implementation for an unsorted array:");
        System.out.printf("size: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", unsortedArr100.length,target100,bf, duration);

        //size 1000
        start = System.nanoTime();
        int bfUnsortReturn1000[] = ts.twoSumBruteForce(unsortedArr1000, target1000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(bfUnsortReturn1000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", unsortedArr1000.length,target1000,bf, duration);

        //size 100000
        start = System.nanoTime();
        int bfUnsortReturn100000[] = ts.twoSumBruteForce(unsortedArr100000, target100000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(bfUnsortReturn100000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", unsortedArr100000.length,target100000,bf, duration);

        //size 1000000
        start = System.nanoTime();
        int bfUnsortReturn1000000[] = ts.twoSumBruteForce(unsortedArr1000000, target1000000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(bfUnsortReturn1000000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", unsortedArr1000000.length,target1000000, bf, duration);


        //hashmap
        //size 100
        start = System.nanoTime();
        int[] hmReturnArr100 = ts.twoSumHashMap(unsortedArr100, target100);
        end = System.nanoTime();
        duration = end - start;

        bf = Arrays.toString(hmReturnArr100);
        System.out.println("\n\n\nHash-map implementation for an unsorted array:");
        System.out.printf("size: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", unsortedArr100.length,target100,bf, duration);

        //size 1000
        start = System.nanoTime();
        int hmReturnArr1000[] = ts.twoSumHashMap(unsortedArr1000, target1000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(hmReturnArr1000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", unsortedArr1000.length,target1000,bf, duration);

        //size 100000
        start = System.nanoTime();
        int hmReturnArr100000[] = ts.twoSumHashMap(unsortedArr100000, target100000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(hmReturnArr100000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", unsortedArr100000.length,target100000,bf, duration);

        //size 1000000
        start = System.nanoTime();
        int hmReturnArr1000000[] = ts.twoSumHashMap(unsortedArr1000000, target1000000);
        end = System.nanoTime();
        duration = end - start;
        bf = Arrays.toString(hmReturnArr1000000);
        System.out.printf("\n\nsize: %d\ntarget: %d found at indexes %s \nTime taken: %d nanoseconds", unsortedArr1000000.length,target1000000, bf, duration);
    }
}
