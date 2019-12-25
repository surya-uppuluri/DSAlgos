package surya.practice.leet;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LC942_DI_String_Match {
    public int[] diStringMatch(String S) {
        
        
        int[] arr = new int[S.length()+1];
        
        int [] gen = new int[S.length()+1];
        
        for(int i=0 ; i<gen.length; i++)
            gen[i]=i;
        
        int low = 0, high = S.length();
        int pos = 0;
        for(char ch: S.toCharArray())
        {
            if(ch=='D'){
                arr[pos++] = gen[high--];
                }
            else
                arr[pos++] = gen[low++];
        }
        arr[S.length()]=gen[low];
        
        return arr;
    }
}

public class DI_String_Match {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += number + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String S = stringToString(line);
            
            int[] ret = new LC942_DI_String_Match().diStringMatch(S);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
}