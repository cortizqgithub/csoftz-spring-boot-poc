package com.acme.leetcode;

// 819. Most Common Word
/*
Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:

Input: paragraph = "a.", banned = []
Output: "a"

Constraints:

1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.
 */
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostCommonWord {

    public static final String TEXT_PARAGRAPH = "Bob hit a ball, the hit BALL flew far after it was hit.";
    public static final String TEXT_PARAGRAPH2 = "Bob. hIt, baLl";

    public String mostCommonWordMyNotes(String paragraph, String[] banned) {

        var listBanned = List.of(banned);
        var wordMap =
            Stream
                .of(paragraph.split("\\W"))
                .filter(s -> !"".equals(s))
                .filter(s -> !listBanned.contains(s))
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));

        var pp = wordMap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        var pp1 = wordMap.entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get()
            .getKey();

        System.out.println(pp1);


        System.out.println(wordMap);
        System.out.println(pp);

        return pp1;
    }

    public String mostCommonWord(String paragraph, String[] banned) {

        var listBanned = List.of(banned);

        return Stream.of(paragraph.split("\\W"))
            .filter(s -> !"".equals(s))
            .filter(s -> !listBanned.contains(s))
            .map(String::trim)
            .map(String::toLowerCase)
            .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting())).entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get()
            .getKey();
    }

    public static void main(String[] args) {
        var s = new MostCommonWord();

        System.out.println("Most Common Word -> [" + s.mostCommonWord(TEXT_PARAGRAPH2, new String[]{"bob", "hit"}) + "]");
    }
}
