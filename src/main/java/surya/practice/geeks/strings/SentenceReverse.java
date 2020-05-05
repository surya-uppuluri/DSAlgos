package surya.practice.geeks.strings;

public class SentenceReverse {

    public static void main(String[] args) {
        reverse(new char[]{'s', 'u', 'r', 'y', 'a', ' ', 'i', 's', ' ', 'e', 'n', 'g','i','n', 'e', 'e', 'r'});
    }

    private static void reverse(char[] arr) {
            swap(arr,0,arr.length-1);
           // System.out.print("after first swap "+ new String(arr)+ " ");
            int lp = 0; int  rp=0, i=0;
            while(i<arr.length)
            {if(arr[i]!=' ') i++;
            else{
                swap(arr,lp,i-1);
                lp=i+1;
                i=i+1;
            }
            }
            swap(arr,lp, arr.length-1);
            System.out.print("Returning "+ new String(arr)+ " ");


        }

        static void swap(char[] arr, int lp, int rp) {
            while(lp<rp){
                char temp = arr[lp];
                arr[lp] = arr[rp];
                arr[rp] = temp;
                lp++; rp--;
            }
        }


    }
