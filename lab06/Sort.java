package lab06;

public class Sort {

	public static void main(String[] args) {
		int[] arr = {7, 4, 5, 1, 3};
		
		printArr(arr);
		bubbleSort(arr, arr.length);
		printArr(arr);

	}
	
	public static void bubbleSort(int arr[], int n) {
		int tmp;
		
		for(int j = 1; j < n; j++) {
			for(int i = 0; i < n - j; i++) {
				if(arr[i] > arr[i+1]) {
					tmp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = tmp;
				}	
			}		
		}
	}
	
	public static void printArr(int arr[]) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
