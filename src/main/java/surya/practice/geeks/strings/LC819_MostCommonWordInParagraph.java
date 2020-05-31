package surya.practice.geeks.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
1, Plain Java and Core String Manipulation and StringBuilder
Runtime: 14 ms, faster than 42.25% of Java online submissions for Most Common Word.
Memory Usage: 41.8 MB, less than 5.05% of Java online submissions for Most Common Word.
*/

public class LC819_MostCommonWordInParagraph {

  public String mostCommonWord(String paragraph, String[] banned) {
    Set<String> bannedSet = new HashSet<>();
    for (String str : banned) {
      bannedSet.add(str.toLowerCase());
    }
    StringBuilder sb = new StringBuilder();
    List<String> words = new ArrayList<>();
    HashMap<String, Integer> wordMap = new HashMap<>();
    int ac = 0;
    for (char ch : paragraph.toCharArray()) {
      ac++;
      //all valid characters fall under A...Z ... a....z
      if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
        sb.append(ch);
      }

      //reset the string if a special char like , or a space is found
      //add the current word to words list
      else {
        if (sb.length() != 0) {
          words.add(sb.toString().toLowerCase());
          //System.out.println("adding "+sb.toString().toLowerCase());
        }
        sb = new StringBuilder("");
      }

      //case where there's only one word in the paragraph. There are no separators to trigger the add to sb. Also applies if it's last string in the paragraph
      if (ac == paragraph.length()) {
        if (sb.length() != 0) {
          words.add(sb.toString().toLowerCase());
        }

      }


    }

    //System.out.println("Sanitized words are "+words);

    String res = "";
    int max = 0;
    for (String word : words) {
      if (!bannedSet.contains(word)) {
        int count = wordMap.getOrDefault(word, 0);
        wordMap.put(word, count + 1);
        // System.out.println("Putting "+word+" with : "+ (count+1));
        if (count >= max) {
          max = count + 1;
          res = word;
        }
      }

    }
    return res;
  }

/*
2- Using inbuilt string separator
Runtime: 17 ms, faster than 28.86% of Java online submissions for Most Common Word.
Memory Usage: 40 MB, less than 5.05% of Java online submissions for Most Common Word.

*/

  public String mostCommonWordWithSeparator(String paragraph, String[] banned) {
    Set<String> bannedSet = new HashSet<>();
    for (String str : banned) {
      bannedSet.add(str.toLowerCase());
    }
    //sw means sanitized words
    StringBuilder sb = new StringBuilder();
    HashMap<String, Integer> wordMap = new HashMap<>();
    int max = 0;
    String res = "";
    String[] wordArr = paragraph.split("\\W");
    System.out.println("WordArr " + Arrays.toString(wordArr));
    for (String word : wordArr) {
      String currWord = word.toLowerCase();
      if (!bannedSet.contains(currWord) && !word.isEmpty()) {
        int count = wordMap.getOrDefault(currWord, 0);
        wordMap.put(currWord, count + 1);
        //System.out.println("Putting "+currWord+" with : "+ (count+1));
        if (count >= max) {
          max = count + 1;
          res = currWord;
        }
      }

    }
    return res;
  }

/*
Java8 Streams
Runtime: 31 ms, faster than 10.03% of Java online submissions for Most Common Word.
Memory Usage: 41.6 MB, less than 5.05% of Java online submissions for Most Common Word.
*/

  public String mostCommonWordWithSteams(String paragraph, String[] banned) {
    Set<String> bannedSet = new HashSet<>();
    for (String str : banned) {
      bannedSet.add(str.toLowerCase());
    }
    //sw means sanitized words
    StringBuilder sb = new StringBuilder();
    List<String> words = new ArrayList<>();
    HashMap<String, Integer> wordMap = new HashMap<>();

    String[] wordArr = paragraph.split("\\W");
    //System.out.println("WordArr "+ Arrays.toString(wordArr));
    for (String word : wordArr) {
      String currWord = word.toLowerCase();
      words.add(currWord);
      if (!bannedSet.contains(currWord) && !word.isEmpty()) {
        int count = wordMap.getOrDefault(currWord, 0);
        wordMap.put(currWord, count + 1);
      }
    }

    return wordMap.entrySet().stream().max(Entry.comparingByValue()).get().getKey();
  }

/*
The Efficient Way - Sanitize the paragraph first
Runtime: 9 ms, faster than 74.26% of Java online submissions for Most Common Word.
Memory Usage: 39.5 MB, less than 5.05% of Java online submissions for Most Common Word.
*/

  public String mostCommonWordEfficient(String paragraph, String[] banned) {
    Set<Character> punctuation = new HashSet<>(Arrays.asList('!', '?', ';', '.', ',', '\'', ' '));
    StringBuilder filtered = new StringBuilder();
    //sanitize the given paragraph in one go. Replace all special characters with a space and make it lowerCase
    for (char ch : paragraph.toCharArray()) {
      filtered.append(punctuation.contains(ch) ? ' ' : Character.toLowerCase(ch));
    }
    paragraph = filtered.toString();

    Map<String, Integer> map = new HashMap<>();

    Set<String> banSet = new HashSet<>();

    Collections.addAll(banSet, banned);

    for (String word : paragraph.split(" "))
    //Using java8 lambda, compute method let's update the values of hashMap
    {
      if (!word.trim().isEmpty() && !banSet.contains(word)) {
        map.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
      }
    }

    return map.entrySet().stream().max(Entry.comparingByValue()).get().getKey();

  }
}