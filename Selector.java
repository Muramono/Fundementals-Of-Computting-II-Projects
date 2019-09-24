import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Chase Dumbacher (cdd0035@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  TODAY
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int minVal = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] < minVal) {
            minVal = a[i];
         }
      }
      return minVal;
   }

   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int maxVal = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] > maxVal) {
            maxVal = a[i];
         }
      }
      return maxVal;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (k > a.length || k > numOfDistinct(a)) {
         throw new IllegalArgumentException();
      }
      int kthMin = min(a);
      int ceilingKey = min(a);
      for (int i = 0; i < k; i++) {
         kthMin = ceiling(a, ceilingKey);
         ceilingKey = kthMin + 1;
      }
      return kthMin;
   }
   
  /** 
    * returns a array in ascending order to make determing
    * the kth element of an arrary more simpely.
    */
   private static int numOfDistinct(int[] a) {
      int numOf = 0;
      for (int i = 0; i < a.length - 1; i++) {
         if (a[i] != a[i + 1]) {
            numOf++;
         }
      } 
      return numOf + 1;
   }

   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (k > a.length || k > numOfDistinct(a)) {
         throw new IllegalArgumentException();
      }
      int kthMax = max(a);
      int floorKey = max(a);
      for (int i = 0; i < k; i++) {
         kthMax = floor(a, floorKey);
         floorKey = kthMax - 1;
      }
      return kthMax;
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int [] fillerArray = new int [a.length]; 
      int fillerIndex = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            fillerArray[fillerIndex] = a[i];
            fillerIndex++;
         }
      }
      int [] arrayInRange = new int[fillerIndex];
      for (int i = 0; i < fillerIndex; i++) {
         arrayInRange[i] = fillerArray[i];
      }
      return arrayInRange;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (key > max(a)) {
         throw new IllegalArgumentException();
      } 
      int minVal = max(a);
      for (int i : a) {
         if (i < minVal && i >= key) {
            minVal = i;
         }
      }
      return minVal;
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (key < min(a)) {
         throw new IllegalArgumentException();
      } 
      int maxVal = min(a);
      for (int i : a) {
         if (i > maxVal && i <= key) {
            maxVal = i;
         }
      }
      return maxVal;
   }

}
