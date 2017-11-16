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
  * Sorts an array in increading order.
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
			int temp = arr[mIndex];
			arr[mIndex] = arr[i];
			arr[i] = temp;
		}
  }

  /**
  * Sorts an array in increading order.
  * Sorting method used is Merge Sort.
  * @param arr The array to sort.
  */
  public static void mergeSort(int[] arr) {
    if (arr.length == 1) {
			return;
		} else if (arr.length == 2) {
			if (arr[1] < arr[0]) {
				int temp = arr[0];
				arr[0] = arr[1];
				arr[1] = temp;
			}
		} else {
			int m = arr.length / 2;
			int[] L = new int[m];
			int[] R = new int[arr.length - m];

			for (int i = 0; i < L.length; i++)
				L[i] = arr[i];
			for (int i = 0; i < R.length; i++)
				R[i] = arr[i + m];

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
  * Sorts an array in increading order.
  * Sorting method used is Quick Sort.
  * DOES NOT WORK CURRENTLY
  * @param arr The array to sort.
  */
  public static void quickSort(int[] arr) {
    if (arr.length == 1) {
			return;
		} else if (arr.length == 2) {
			if (arr[1] < arr[0]) {
				int temp = arr[0];
				arr[0] = arr[1];
				arr[1] = temp;
			}
		} else {
			int pivot = arr[arr.length / 2];
			int low = 0, high = arr.length - 1;
			while (low < high) {
				while (arr[low] < pivot && low < arr.length) {
					low++;
				}
				while (arr[high] >= pivot && high > 0) {
					high--;
				}
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}

			int[] L = new int[low];
			int[] R = new int[arr.length - high];

			for (int i = 0; i < L.length; i++)
				L[i] = arr[i];
			for (int i = 0; i < R.length; i++)
				R[i] = arr[i + high];

			quickSort(L);
			quickSort(R);

			int i = 0;
			for (int j = 0; j < L.length; j++) {
				arr[i] = L[j];
				i++;
			}
			arr[i] = pivot;
			i++;
			for (int j = 0; j < R.length; j++) {
				arr[i] = R[j];
				i++;
			}
		}
  }

  /**
  * Prints an array in a readable way.
  * @param arr The array to print.
  */
  public static void printArray(int[] arr) {
		System.out.print("{");
		for (int x : arr) {
			System.out.print(x);
			if (x != arr[arr.length - 1])
				System.out.print(", ");
		}
		System.out.println("}");
	}

}
