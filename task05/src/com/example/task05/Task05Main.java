package com.example.task05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.out;

public class Task05Main {
    public static void main (String[]args)
    {
        String pathToFile = args[0]; // "/home/user/file.txt"
        try {
            String s = readFile(pathToFile);
            out.println(s);
        } catch (FileNotFoundException ex) {
            String message = String.format("файл \"%s\" не найден\n", pathToFile);
            out.print(message);
        } catch (IOException ex) {
            String message = String.format("произошла ошибка при чтении файла \"%s\"\n", pathToFile);
            out.print(message);
        }
    }

    public static String readFile (String pathToFile) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        FileReader fileReader = new FileReader(pathToFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String currentLine;

        while ((currentLine = bufferedReader.readLine()) != null)
        {
            stringBuilder.append(currentLine);
            stringBuilder.append("\n");
        }

        fileReader.close();

        return stringBuilder.toString();
    }
}
