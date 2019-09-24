public final class SortingLabClient {


   /*
    * Class constructor 
   */
   SortingLabClient() {
    
   }
   
   public static void main(String[] args){
   
     // Creates SotrtingLab class 
     int key = 903974769;
      SortingLab<String> sls = new SortingLab<String>(key);
      
      // Runs each sort a few times before collecting time data 
      // To make sure data collected doesn't have any anomalys
      String [] warmupSort =  {"D","B","E","C","A"};
      for (int i = 0; i < 10; i++) {
         sls.sort1(warmupSort);
         sls.sort2(warmupSort);
         sls.sort3(warmupSort);
         sls.sort4(warmupSort);
         sls.sort5(warmupSort);
      }
    
      // Generates timing data for sort methods using doubling strategy
      int Max = 330000; // max capactity for array
      int N = 5000; //Inital size of array
      
      //Testing First sort method with randomly sorted array
       System.out.println("Randomly Sorted Array Test, Sort 1");
      for (; N <= Max; N *= 2) {
         Integer[] randomIntArray = getIntegerArray(N, Integer.MAX_VALUE);
         //timeTesting1(randomIntArray, N);
      }
      
      //Testing First sort method with Asc sorted array
      System.out.println("\nAlready sorted (in Ascending order) Array, Sort 1");
      N = 5000; //Resetting N = 5000 so that loops can run
      for (; N < Max; N *= 2) {
         Integer[] ascIntArray = getAscIntegerArray(N);
         timeTesting1(ascIntArray, N);
      }
      
      N = 5000; //Resetting N = 5000 so that loop can run
      //Testing Second sort method with randomly sorted array
       System.out.println("Randomly Sorted Array Test, Sort 2");
      for (; N < Max; N *= 2) {
         Integer[] randomIntArray = getIntegerArray(N, Integer.MAX_VALUE);
         timeTesting2(randomIntArray, N);
      }
      
      //Testing Second sort method with Asc sorted array
      System.out.println("\nAlready sorted (in Ascending order) Array, Sort 2");
      N = 5000; //Resetting N = 5000 so that loops can run
      for (; N < Max; N *= 2) {
         Integer[] ascIntArray = getAscIntegerArray(N);
         timeTesting2(ascIntArray, N);
      }
      
      N = 5000; //Resetting N = 5000 so that loop can run
      //Testing Third sort method with randomly sorted array
       System.out.println("Randomly Sorted Array Test, Sort 3");
      for (; N < Max; N *= 2) {
         Integer[] randomIntArray = getIntegerArray(N, Integer.MAX_VALUE);
         timeTesting3(randomIntArray, N);
      }
      
      //Testing Third sort method with Asc sorted array
      System.out.println("\nAlready sorted (in Ascending order) Array, Sort 3");
      N = 5000; //Resetting N = 5000 so that loops can run
      for (; N < Max; N *= 2) {
         Integer[] ascIntArray = getAscIntegerArray(N);
         timeTesting3(ascIntArray, N);
      }
      
      N = 5000; //Resetting N = 5000 so that loop can run
      //Testing Fourth sort method with randomly sorted array
       System.out.println("Randomly Sorted Array Test, Sort 4");
      for (; N < Max; N *= 2) {
         Integer[] randomIntArray = getIntegerArray(N, Integer.MAX_VALUE);
         timeTesting4(randomIntArray, N);
      }
      
      //Testing Fourth sort method with Asc sorted array
      System.out.println("\nAlready sorted (in Ascending order) Array, Sort 4");
      N = 5000; //Resetting N = 5000 so that loops can run
      for (; N < Max; N *= 2) {
         Integer[] ascIntArray = getAscIntegerArray(N);
         timeTesting4(ascIntArray, N);
      }
      
      N = 5000; //Resetting N = 5000 so that loop can run
      //Testing Fifth sort method with randomly sorted array
       System.out.println("Randomly Sorted Array Test, Sort 5");
      for (; N < Max; N *= 2) {
         Integer[] randomIntArray = getIntegerArray(N, Integer.MAX_VALUE);
         timeTesting5(randomIntArray, N);
      }
      
      //Testing Fifth sort method with Asc sorted array
      System.out.println("\nAlready sorted (in Ascending order) Array, Sort 5");
      N = 5000; //Resetting N = 5000 so that loops can run
      for (; N < Max; N *= 2) {
         Integer[] ascIntArray = getAscIntegerArray(N);
         timeTesting5(ascIntArray, N);
      }
   } 
   
   //End Of Main

   /** return an array of random integer values. */
   private static Integer[] getIntegerArray(int N, int max) {
         Integer[] a = new Integer[N];
         java.util.Random rng = new java.util.Random();
         for (int i = 0; i < N; i++) {
            a[i] = rng.nextInt(max);
         }
         
         return a;
         }
           
         
      /** return an array of descending integer values */
   private static Integer[] getDesIntegerArray(int N) {
         Integer[] a = new Integer[N];
         for (int i = 0; i < N; i++) {
            a[i] = N-i;
         }
         
         return a;
         }         
         
      /** return an array of ascending integer values */
   private static Integer[] getAscIntegerArray(int N) {
         Integer[] a = new Integer[N];
         for (int i = 0; i < N; i++) {
            a[i] = i;
         }
         
         return a;
         }

      /** Calculates and prints elapsed time for sort1*/   
      public static void timeTesting1( Integer[] orderedArray, int N) {
            //Creating Sorting Object
            int key = 903974769;
         SortingLab<Integer> sortList = new SortingLab<Integer>(key);
         //Setting Variables for time calculation
            double start;
         double elapsedTime;
         //Caluclating elapsed time
            start = System.nanoTime();
         sortList.sort1(orderedArray);
         elapsedTime = (System.nanoTime() - start) / 1_000_000_000d;
         //Printing out the size of N correspondent to time elapsed
         System.out.print(N + "\t");
         System.out.printf("%4.3f\n", elapsedTime);
      }
      
     /** Calculates and prints elapsed time for sort2 */   
      public static void timeTesting2( Integer[] orderedArray, int N) {
            //Creating Sorting Object
            int key = 903974769;
         SortingLab<Integer> sortList = new SortingLab<Integer>(key);
         //Setting Variables for time calculation
            double start;
         double elapsedTime;
         //Caluclating elapsed time
            start = System.nanoTime();
         sortList.sort2(orderedArray);
         elapsedTime = (System.nanoTime() - start) / 1_000_000_000d;
         //Printing out the size of N correspondent to time elapsed
         System.out.print(N + "\t");
         System.out.printf("%4.3f\n", elapsedTime);
      }
      
      /** Calculates and prints elapsed time for sort 3*/   
      public static void timeTesting3( Integer[] orderedArray, int N) {
            //Creating Sorting Object
            int key = 903974769;
         SortingLab<Integer> sortList = new SortingLab<Integer>(key);
         //Setting Variables for time calculation
            double start;
         double elapsedTime;
         //Caluclating elapsed time
            start = System.nanoTime();
         sortList.sort3(orderedArray);
         elapsedTime = (System.nanoTime() - start) / 1_000_000_000d;
         //Printing out the size of N correspondent to time elapsed
         System.out.print(N + "\t");
         System.out.printf("%4.3f\n", elapsedTime);
      }
      
      /** Calculates and prints elapsed time for sort 4*/   
      public static void timeTesting4( Integer[] orderedArray, int N) {
            //Creating Sorting Object
            int key = 903974769;
         SortingLab<Integer> sortList = new SortingLab<Integer>(key);
         //Setting Variables for time calculation
            double start;
         double elapsedTime;
         //Caluclating elapsed time
            start = System.nanoTime();
         sortList.sort4(orderedArray);
         elapsedTime = (System.nanoTime() - start) / 1_000_000_000d;
         //Printing out the size of N correspondent to time elapsed
         System.out.print(N + "\t");
         System.out.printf("%4.3f\n", elapsedTime);
      }
      
      /** Calculates and prints elapsed time for sort 5*/   
      public static void timeTesting5( Integer[] orderedArray, int N) {
            //Creating Sorting Object
            int key = 903974769;
         SortingLab<Integer> sortList = new SortingLab<Integer>(key);
         //Setting Variables for time calculation
            double start;
         double elapsedTime;
         //Caluclating elapsed time
            start = System.nanoTime();
         sortList.sort5(orderedArray);
         elapsedTime = (System.nanoTime() - start) / 1_000_000_000d;
         //Printing out the size of N correspondent to time elapsed
         System.out.print(N + "\t");
         System.out.printf("%4.3f\n", elapsedTime);
      }      
}