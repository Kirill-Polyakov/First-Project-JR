package com.javarush.task.jdk13.task53.task5307;

import java.io.IOException;
import java.util.List;

public class Cipher {
    private List<Character> alphabet;
    FileManager fileManager = new FileManager();

    public Cipher(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) {
        StringBuilder builderNewString = new StringBuilder();

        char[] chars = text.toCharArray();

        for (char ch : chars) {
            if (alphabet.contains(ch)) {
                int alphabetPosition = alphabet.indexOf(ch);
                char newChar = alphabet.get((alphabetPosition + shift) % alphabet.size());
                builderNewString.append(newChar);
            } else {
                builderNewString.append(ch);
            }
        }

        return builderNewString.toString();
    }

    public String decrypt(String text, int shift) {
        return encrypt(text, alphabet.size() - (shift % alphabet.size()));
    }

    public String bruteForce(String text) throws IOException {
        int probablyKey = 0;
        int maxCountMatchingWords = 0;
        int countMatchingWords = 0;

        for (int key = 1; key < alphabet.size(); key++) {

            String decodeString = decrypt(text, key);

            for (String words : fileManager.readWordsInList()) {
                if (decodeString.contains(words)) {
                    countMatchingWords++;
                }
            }

            if (countMatchingWords > maxCountMatchingWords) {

                maxCountMatchingWords = countMatchingWords;
                probablyKey = key;
            }

            countMatchingWords = 0;
        }

        return decrypt(text, probablyKey);
    }
}
