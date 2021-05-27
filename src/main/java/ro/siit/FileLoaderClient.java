package ro.siit;

import java.io.File;

public class FileLoaderClient {

    public static void main(String[] args) {
        FileLoader.duplicateFile("pisi.jpg", "duplicated_pisi.jpg");
        FileLoader.duplicateTextFile(new File("test.txt"), new File("duplicated_test.txt"));

    }
}
