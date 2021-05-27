package ro.siit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class FileLoader {

    public static void duplicateFile(final String filePath, final String destinationPath) {
        try (InputStream is = new FileInputStream(filePath);
             OutputStream os = new FileOutputStream(destinationPath)) {
            byte[] bytes = new byte[1024];
            int number = -1;
            while ((number = is.read(bytes)) != -1) {
                os.write(bytes);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void duplicateTextFile(final File file, final File destination) {
        try (Reader reader = new FileReader(file, StandardCharsets.UTF_8);
             Writer writer = new FileWriter(destination)) {
            char[] chars = new char[128];
            int num = -1;
            while ((num = reader.read(chars)) != -1) {
                for (int i = 0; i < num; i++) {
                    System.out.print(chars[i]);
                    // write to destination file
                    writer.write(chars[i]);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
