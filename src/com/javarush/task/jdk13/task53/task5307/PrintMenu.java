package com.javarush.task.jdk13.task53.task5307;

public class PrintMenu {

    public static void printMenu() {
        System.out.println("Добро пожаловать в приложение Криптоанализатор");
        System.out.println();
        System.out.println("Выберете режим работы приложения:");
        System.out.println("(Необходимо ввести номер необходимого пункта)");
        System.out.println("""
                1. Зашифровать текст.
                2. Расшифровать текст.
                3. Взломать текст (Brute Force).
                4. Завершить работу приложения.""");
    }

    public static void printProcessedFilePath() {
        System.out.println("Введите адрес файла.");
    }

    public static void printResultFilePath() {
        System.out.println("Введите адрес, по которому хотите сохранить файл.");
    }

    public static void printEnterKey() {
        System.out.println("Ввести ключ (целое число в диопазоне от 1 до 126)");
    }

    public static void printBruteForce() {
        System.out.println("Взлом запущен. Расшифровка может занять некоторое время.");
    }

    public static void printGoodBye() {
        System.out.println("Всего хорошего.");
    }

}
