package ro.siit.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileScanner {

    static void printLines(final String path) {
        try (final Scanner scanner = new Scanner(new FileInputStream(path))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        printLines("test.txt");
    }
}
