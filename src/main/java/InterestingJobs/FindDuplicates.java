package InterestingJobs;


import java.util.HashMap;
import java.util.Map;

public class FindDuplicates {

    public static void main(String[] args) {
        printDuplicateCharacters("Programming");
    }

    public static void printDuplicateCharacters(String word) {
        char[] characters = word.toCharArray();

        Map<Character, Integer> charMap = new HashMap();

        for (Character ch : characters)
        {
            if (charMap.containsKey(ch))
            {
                charMap.put(ch, charMap.get(ch) + 1);
            }
            else
            {
                charMap.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            System.out.print(entry.getKey() + "-" + entry.getValue() + " ");
        }
    }

}
