package surya.practice.geeks.arrays;

import java.util.*;
//Position this line where user code will be pasted.
class SmallestMissingPositiveNumber
{   
    public static void main (String[] args) 
    {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Missing obj = new Missing();
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}

/*This is a function problem.You only need to complete the function given below*/
class Missing{
    
    // function to find first positive missing number
    static int missingNumber(int arr[], int size)
    {
     HashMap<Integer, Integer> pos = new HashMap<>();
     int currmax =0;
     for(int num: arr)
     {
         if(num>=0){
         pos.put(num,1);
         if(num>currmax) currmax=num;
             
         }
     }
     
     
     for(int i=0; i<currmax;i++)
     {
         if(pos.getOrDefault(i,0)==0)
         return i;
     }
     return -1;
    }
    
}
