package surya.practice.geeks.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("SuryaUppuluri", "yuri"));
    }

    public String minWindow(String wholeString, String toFind) {
        Map<Character, Integer> requiredCharacters = buildMappingOfCharactersToOccurrences(toFind);
        Map<Character, Integer> windowCharacterMapping = new HashMap<>();

        int left = 0;
        int right = 0;

        int totalCharFrequenciesToMatch = requiredCharacters.size();
        int charFrequenciesInWindowThatMatch = 0;

        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
        String minWindow = "";

        while (right < wholeString.length()) {
            char characterAtRightPointer = wholeString.charAt(right);
            addCharacterToHashtableMapping(windowCharacterMapping, characterAtRightPointer);

            boolean rightCharIsARequirement = requiredCharacters.containsKey(characterAtRightPointer);
            if (rightCharIsARequirement) {
                boolean requirementForCharacterMet =
                        requiredCharacters.get(characterAtRightPointer).intValue() ==
                                windowCharacterMapping.get(characterAtRightPointer).intValue();

                if (requirementForCharacterMet) {
                    charFrequenciesInWindowThatMatch++;
                }
            }

            while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {
                char characterAtLeftPointer = wholeString.charAt(left);
                int windowSize = right - left + 1;

                if (windowSize < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = windowSize;
                    minWindow = wholeString.substring(left, right + 1);
                }

                windowCharacterMapping.put(
                        characterAtLeftPointer,
                        windowCharacterMapping.get(characterAtLeftPointer) - 1
                );

                boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
                if (leftCharIsARequirement) {
                    boolean characterFailsRequirement =
                            windowCharacterMapping.get(characterAtLeftPointer) <
                                    requiredCharacters.get(characterAtLeftPointer);

                    if (characterFailsRequirement) {
                        charFrequenciesInWindowThatMatch--;
                    }
                }

                left++;
            }

            right++;
        }

        return minWindow;
    }

    private Map<Character, Integer> buildMappingOfCharactersToOccurrences(String toFind) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < toFind.length(); i++) {
            int occurrencesOfCharacter = map.getOrDefault(toFind.charAt(i), 0);
            map.put(toFind.charAt(i), occurrencesOfCharacter + 1);
        }

        return map;
    }

    private void addCharacterToHashtableMapping(
            Map<Character, Integer> map,
            Character c
    ) {
        int occurrences = map.getOrDefault(c, 0);
        map.put(c, occurrences + 1);
    }

}
