package com.javarush.task.jdk13.task53.task5307;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public boolean isKeyValid(int key) {
        if (key > 0 && key < 127) {
            return true;
        } else {
            System.out.println("Введено неправильное значение.");
            return false;
        }
    }

    public boolean isExistFile(String filePath) throws FileNotFoundException {
        if (Files.exists(Path.of(filePath))) {
            return true;
        } else {
            System.out.println("Файл не найден.");
            throw new FileNotFoundException();
        }
    }
}
