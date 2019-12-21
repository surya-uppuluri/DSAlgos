package surya.practice.geeks.arrays;

import java.io.*;

class TrappingRainWaterBrute {
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

class Trap{
    
    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    static int trappingWater(int arr[], int n) { 
        int res = 0;

      //min(leftmax,rightmax)-currht

       for(int i=1; i<n-1; i++)
      {
          
      int lmax = arr[i];
       
      //findleft max
      for(int j=0; j<i; j++)
         lmax = Math.max(lmax,arr[j]);
      
      
      int rmax=arr[i];
           //find right max
      for(int j=i+1; j<n; j++)
      rmax = Math.max(rmax, arr[j]);
      
    //   System.out.println("Adding "+ String.valueOf(
    //       Math.min(lmax,rmax)-arr[i])
    //   + " to tesult");
      res+=Math.min(lmax,rmax)-arr[i];
      
       }
       
       return res;
    } 
}
