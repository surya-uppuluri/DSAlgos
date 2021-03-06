package surya.practice.geeks.arrays;

import java.io.*;

class TrappingRainWaterTimeOptimized {
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
		    
		    TrapTimeOptimized obj = new TrapTimeOptimized();
		    
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


/*This is a function problem.You only need to complete the function given below*/

class TrapTimeOptimized {
    
    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    static int trappingWater(int arr[], int n) { 
       int res = 0;
       
         //time optimized solution
   //precompute left and right arr
   
   int[] left = new int[n];
   int[] right = new int[n];
   
   //populate left
   left[0] = arr[0];
   
   for(int i=1; i<n; i++)
    left[i] = Math.max(left[i-1], arr[i]);
    
     //populate right
   right[n-1] = arr[n-1];
   
   for(int i=n-2; i>=0; i--)
    right[i] = Math.max(right[i+1], arr[i]);
    
    
    for(int i=0; i<n; i++)
        res+= Math.min(left[i], right[i]) - arr[i];

    
    
       return res;
    } 
}
