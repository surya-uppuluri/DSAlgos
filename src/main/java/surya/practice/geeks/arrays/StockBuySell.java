package surya.practice.geeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class StockBuySell {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Stock obj = new Stock();

            obj.stockBuySell(arr, n);
            System.out.println();
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/

class Interval {
    int buy;
    int sell;
}

class Stock {
    // Function to find the buy and sell days and print them
    static void stockBuySell(int price[], int n) {

        int i = 0;
        int count = 0;
        ArrayList<Interval> list = new ArrayList<>();
        while (i < n - 1) {
            Interval interval = new Interval();
            //find local maxima and mark it as buy
            //n-1 is last element. I need atleast one other element
            //Going to n-1 is meaningless
            //I'll go only till n-2
            while (i < n - 1 && price[i + 1] <= price[i]) {
                i++;

            }
            if (i == n - 1)
                break;
            interval.buy = i++;

            //find local maxima now

            {
                while (i < n && price[i] >= price[i - 1])
                    i++;
            }
            interval.sell = i - 1;
            list.add(interval);
            count++;

        }


        if (count > 0) {
            for (Interval inte : list) {
                System.out.print("(" + inte.buy + " " + inte.sell + ") ");

            }
        } else
            System.out.print("No Profit");

    }


}