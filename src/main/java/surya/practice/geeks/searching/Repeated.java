package surya.practice.geeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RepeatedElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String l = br.readLine();
            String[] sarr = l.split(" ");
            int[] arr = new int[sarr.length];
            for (int i1 = 0; i1 < arr.length; i1++) {
                arr[i1] = Integer.parseInt(sarr[i1]);
            }

            Repeated obj = new Repeated();

            obj.twoRepeated(arr, n);
            System.out.println();


        }
    }
}

class Repeated {

    static void twoRepeated(int arr[], int n) {

        // iterating over the array elements
        for (int p = 0; p < n + 2; p++) {

            // check if the element is visited or not
            // if not, then make it negative
            if (arr[Math.abs(arr[p])] > 0) {
                arr[Math.abs(arr[p])] = -arr[Math.abs(arr[p])];
            }
            // else, if it is already visited, then print the element
            // it means it is repeated
            else {
                System.out.print(Math.abs(arr[p]) + " ");
            }
        }


    }

}