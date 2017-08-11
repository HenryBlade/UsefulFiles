import java.io.*;

/**
* A set of methods that can be use to manipulate arrys.
* (Sorting, Merging, etc.)
*
* @author Henry Larson
*/
public class arrayUtils {

  /**
  * Sorts an array in increading order.
  * Sorting method used is Insertion Sort.
  * @param arr The array to sort.
  */
  public static void sortArray(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int val = arr[i];
      int j = i - 1;
      while (j >= 0 && val < arr[j]) {
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = val;
    }
  }

  /**
  * Merges two arrays in the style of arr1[0], arr2[0], arr1[1], arr2[1]...
  * @param arr1 The first array.
  * @param arr2 The second array.
  * @return The merged array.
  */
  public static int[] zipperMerge(int[] arr1, int[] arr2) {
    int[] merged = new int[arr1.length+arr2.length];
    if (arr1.length == arr2.length) {
      int arrIndex = 0;
      for (int i = 0; i < arr1.length; i++) {
        int val1 = arr1[i];
        int val2 = arr2[i];
        merged[arrIndex] = val1;
        arrIndex++;
        merged[arrIndex] = val2;
        arrIndex++;
      }
    }
    return merged;
  }

}
