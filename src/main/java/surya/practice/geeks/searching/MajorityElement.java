package surya.practice.geeks.searching;//Initial Template for Java

import java.util.HashMap;
import java.util.Scanner;


class MajorityElement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(new MajorityBruteForce().majorityElement(arr, n));
        }
    }

}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class MajorityBruteForce {
    static int majorityElement(int a[], int size) {
        int res = -1;
        for (int num : a) {
            int count = 0;
            for (int num1 : a) {
                if (num == num1)
                    count++;
            }
            if (count > size / 2) {
                res = num;
            }
        }
        return res;

    }
}

class MajorityHMAuxSpace {
    static int majorityElement(int a[], int size)
    {
        HashMap<Integer, Integer> cMap = new HashMap();
        int res = -1;
        for (int num : a) {
            int nCount = cMap.getOrDefault(num, 0);
            //Caution: Do not use nCount++ here
            cMap.put(num, nCount+1);
            if (cMap.getOrDefault(num, 0) > (size / 2) ) {
                res = num;
                break;
            }
        }
        return res;
    }
}
//@formatter:off
/**
 Majority Element
 Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.

 Input:
 The first line of the input contains T denoting the number of testcases. The first line of the test case will be the size of array and second line will be the elements of the array.

 Output:
 For each test case the output will be the majority element of the array. Output "-1" if no majority element is there in the array.

 User Task:
 The task is to complete the function findMajority() which finds the majority element in the array. If no majority exists, return -1.

 Constraints:
 1 <= T<= 100
 1 <= N <= 107
 0 <= Ai <= 106

 Example:
 Input:
 2
 5
 3 1 3 3 2
 3
 1 2 3

 Output:
 3
 -1

 Explanation:
 Testcase 1: Since, 3 is present more than N/2 times, so it is the majority element.
 **/
