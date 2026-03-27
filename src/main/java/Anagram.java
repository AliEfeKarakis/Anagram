import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public boolean isAnagramTwoStrings(String a, String b) {
        //If the length of two string doesn't match then they do not form an anagram
        if (a.length() != b.length()) {
            return false;
        }

        //In order to count frequency of each character we use HashMap
        Map<Character, Integer> counter = new HashMap<>();

        //Simply counting the frequency of character in a string with a for-loop
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            //If a character already exists, the existing value is incremented. Otherwise, as default, the count is given a zero
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            //Since we are comparing two words for possible anagram, if a character is missing or used more times than available, the strings are not anagrams
            if (!counter.containsKey(c) || counter.get(c) == 0) {
                return false;
            }

            //We increase counts using String a, then decrease using String b. If both strings are anagrams, all counts will cancel out to zero
            counter.put(c, counter.get(c) - 1);
        }

        return true;
    }
}
