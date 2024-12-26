package com.javarush.task.jdk13.task53.task5307;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintMenu.printMenu();
        Menu menu = new Menu();
        menu.switchMainMenu(scanner.nextInt());
    }
}
