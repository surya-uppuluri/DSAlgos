package surya.practice.geeks.sorting;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class SortTheLogs {
    //LC937
    public void reorderLogFiles(String[] logs) {
        AtomicInteger totalComparisons = new AtomicInteger();
        Arrays.sort(logs, (log1, log2) -> {
            log.info("Comparing { {} } WITH { {} }", log1, log2);
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            totalComparisons.getAndIncrement();
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                log.info("Internally both are non digits, comparing { {} } with { {} } and result: {}", split1[1], split2[1], cmp);
                if (cmp != 0) return cmp;
                int result = split1[0].compareTo(split2[0]);
                log.info("Both are not digits. Comparison result: {}", result);
                return result;

            }
            int res = isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            log.info("One of them is a digit. isDigit1: {} isDigit2: {}. Result: {}", isDigit1, isDigit2, res);
            return res;
        });
    }


    public static void main(String[] args) {
        SortTheLogs sortTheLogs = new SortTheLogs();
        //String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        log.info("input: {}", Arrays.toString(logs));
        sortTheLogs.reorderLogFiles(logs);
        System.out.println(Arrays.toString(logs));
    }
}
