package com.javarush.task.jdk13.task53.task5307;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    Validator validator = new Validator();

    public String readFile(String filePath) {

        String resultString = "";

        try {
            if (validator.isExistFile(filePath)) {
                Path path = Path.of(filePath).toAbsolutePath().normalize();
                byte[] bytes = Files.readAllBytes(path);
                resultString = new String(bytes, StandardCharsets.UTF_8);
            } else {
                throw new FileNotFoundException("Файл не найден");
            }
        } catch (InvalidPathException e) {
            System.out.println("Ошибка в пути: " + e);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла! " + e);
        }

        return resultString;
    }

    public void wrightFile(String filePath, String content) {
        try {
            Path path = Path.of(filePath).toAbsolutePath().normalize();
            Files.writeString(path, content, StandardOpenOption.CREATE);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка в пути: " + e);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла! " + e);
        }

    }

    public ArrayList<String> readWordsInList() throws IOException {
        List<String> listWords = Files.readAllLines(Path.of("src/com/javarush/task/jdk13/task53/task5307/Files/Words.txt"));
        return (ArrayList<String>) listWords;
    }
}
