package com.javarush.task.jdk13.task53.task5307;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    private final List<Character> ALPHABET = new ArrayList<>() {
        {
            for (char ch = 'А'; ch <= 'я'; ++ch) {
                add(ch);
            }
            for (char ch = 'A'; ch <= 'Z'; ++ch) {
                add(ch);
            }
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                add(ch);
            }
            add('.');
            add(',');
            add('"');
            add('«');
            add('»');
            add('\'');
            add(':');
            add('-');
            add('!');
            add('?');
            add(' ');
        }
    };

    public List<Character> getALPHABET() {
        return ALPHABET;
    }
}
