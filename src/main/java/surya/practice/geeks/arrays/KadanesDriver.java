package surya.practice.geeks.arrays;

import java.io.*;
class KadanesDriver {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");
			for(int i=0; i<n; i++){
				arr[i] = Integer.parseInt(inputLine[i]);
			}

			Kadane obj = new Kadane();

			System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
class Kadane{

	// Function to find subarray with maximum sum
	// arr: input array
	// n: size of array
	int maxSubarraySum(int arr[], int n){

		int max_cur=arr[0];
		int max_global= arr[0];

		for(int i=1; i<n; i++){

			max_cur = Math.max(max_cur+arr[i], arr[i]);
			if(max_cur>max_global) max_global=max_cur;

		}

		return max_global;

	}

}
