package com.javarush.task.jdk13.task53.task5307;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private String pathEnterFile;
    private String pathOutFile;
    private int key;
    private Validator validator = new Validator();
    Alphabet alphabet = new Alphabet();
    private FileManager fileManager = new FileManager();
    private Cipher cipher = new Cipher(alphabet.getALPHABET());


    public void switchMainMenu(int menuPoint) throws IOException {
        while (menuPoint < 0 || menuPoint > 5) {
            menuPoint = scanner.nextInt();
        }

        switch (menuPoint) {
            case 1 -> encryptMenuItem();
            case 2 -> decryptMenuItem();
            case 3 -> bruteForceItem();
            case 4 -> {
                PrintMenu.printGoodBye();
                System.exit(0);
            }
        }
    }

    private void oneTwoItemMenu() {
        PrintMenu.printProcessedFilePath();
        pathEnterFile = scanner.nextLine();

        PrintMenu.printEnterKey();
        key = scanner.nextInt();

        if (!validator.isKeyValid(key)) {
            while (key > 0 && key < 127) {
                key = scanner.nextInt();
            }
        }

        PrintMenu.printResultFilePath();
        pathOutFile = scanner.next();
    }

    private void encryptMenuItem() {
        oneTwoItemMenu();
        fileManager.wrightFile(pathOutFile, cipher.encrypt(fileManager.readFile(pathEnterFile), key));
    }

    private void decryptMenuItem() {
        oneTwoItemMenu();
        fileManager.wrightFile(pathOutFile, cipher.decrypt(fileManager.readFile(pathEnterFile), key));
    }

    private void bruteForceItem() throws IOException {
        PrintMenu.printProcessedFilePath();
        pathEnterFile = scanner.nextLine();

        PrintMenu.printResultFilePath();
        pathOutFile = scanner.nextLine();

        PrintMenu.printBruteForce();
        fileManager.wrightFile(pathOutFile, cipher.bruteForce(fileManager.readFile(pathEnterFile)));
    }

}



