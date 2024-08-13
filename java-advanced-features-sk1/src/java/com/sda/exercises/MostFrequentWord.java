package com.sda.exercises;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentWord {
    public static void main(String[] args) {
        //Write a function that receives a sentence (string) as a parameter and returns the most frequent word of that sentence.
        // If there is more than one such word return any one of them.
        String testedPhrase = "But then they were married (she felt awful about being pregnant before but\n" +
                "Harry had been talking about marriage for a while and anyway laughed when\n" +
                "she told him in early February about missing her period and said Great she\n" +
                "was terribly frightened and he said Great and lifted her put his arms around\n" +
                "under her bottom and lifted her like you would a child he could be so\n" +
                "wonderful when you didn’t expect it in a way it seemed important that you\n" +
                "didn’t expect it there was so much nice in him she couldn’t explain to\n" +
                "anybody she had been so frightened about being pregnant and he made her\n" +
                "be proud) they were married after her missing her second period in March\n" +
                "and she was still little clumsy dark-complected Janice Springer and her\n" +
                "husband was a conceited lunk who wasn’t good for anything in the world Daddy\n" +
                "said and the feeling of being alone would melt a little with a little drink.";
        System.out.println(getMostFrequentPhrase(testedPhrase));
    }

    public static String getMostFrequentPhrase(String input) {
        input = input.replaceAll("[^ A-Za-z]", "").toLowerCase();
        String[] words = input.split(" ");

        Map<String, Integer> frequency = new HashMap<>();

        for (String s : words) {
            frequency.put(s, frequency.getOrDefault(s, 0) + 1);
        }

        String output = "";
        int maxValue = 0;
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                output = entry.getKey();
            }
        }
        return output;
    }
}