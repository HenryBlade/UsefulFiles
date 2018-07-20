import java.io.*;
import java.util.*;

/**
* A set of methods that can be use to manipulate arrys.
* (Sorting, Merging, etc.)
*
* @author Henry Larson
*/
public class arrayUtils {

  /**
  * Sorts an array in increasing order.
  * Sorting method used is Insertion Sort.
  * @param arr The array to sort.
  */
  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int temp = arr[i];
      int j = i - 1;
      while (j >= 0 && temp < arr[j]) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = temp;
    }
  }

  /**
  * Sorts an array in increasing order.
  * Sorting method used is Selection Sort.
  * @param arr The array to sort.
  */
  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int mIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[mIndex]) {
          mIndex = j;
        }
      }
      swap(arr, mIndex, i);
    }
  }

  /**
  * Sorts an array in increasing order.
  * Sorting method used is Merge Sort.
  * @param arr The array to sort.
  */
  public static void mergeSort(int[] arr) {
    if (arr.length == 1) {
			return;
		} else if (arr.length == 2) {
			if (arr[1] < arr[0]) {
        swap(arr, 0, 1);
			}
		} else {
      int[] L = Arrays.copyOfRange(arr, 0, arr.length/2);
      int[] R = Arrays.copyOfRange(arr, arr.length/2, arr.length);

      mergeSort(L);
      mergeSort(R);

      int i = 0, j = 0, index = 0;
      while (i < L.length && j < R.length) {
        if (L[i] < R[j]) {
          arr[index] = L[i];
          i++;
        } else {
          arr[index] = R[j];
          j++;
        }
        index++;
      }
      while (i < L.length) {
        arr[index] = L[i];
        i++;
        index++;
      }
      while (j < R.length) {
        arr[index] = R[j];
        j++;
        index++;
      }
    }
  }

  /**
  * Sorts an array in increasing order.
  * Sorting method used is Quick Sort.
  * @param arr The array to sort.
  */
  public static void quickSort(int[] arr) {
    if (arr.length <= 1) {
      return;
    } else {
      int pivot = arr[arr.length-1];
      int index = 0;
      for (int i = 0; i < arr.length-1; i++) {
        if (arr[i] <= pivot) {
          swap(arr, index, i);
          index++;
        }
      }
      swap(arr, index, arr.length-1);

      int[] low = Arrays.copyOfRange(arr, 0, index);
      int[] high = Arrays.copyOfRange(arr, index+1, arr.length);

      quickSort(low);
      quickSort(high);

      for (int i = 0; i < low.length; i++) {
        arr[i] = low[i];
      } for (int i = 0; i < high.length; i++) {
        arr[i+index+1] = high[i];
      }
    }
  }

  /**
  * Sorts an array in increasing order.
  * Sorting method used is Bubble Sort.
  * @param arr The array to sort.
  */
  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      boolean swapped = false;
      for (int j = 0; j < arr.length-1-i; j++) {
        if (arr[j] > arr[j+1]) {
          swap(arr, j, j+1);
          swapped = true;
        }
      }
      if (!swapped)
        break;
    }
  }

  /**
  * Swaps two array indicies
  * @param arr The array to use
  * @param i The first index to swap
  * @param j The second index to swap
  */
  public static void swap(int[] arr, int i, int j){
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }

  /**
  * Prints an array in a readable way.
  * @param arr The array to print.
  */
  public static void printArray(int[] arr) {
    System.out.print("{");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      if (i < arr.length-1)
        System.out.print(", ");
    }
    System.out.println("}");
  }

}
