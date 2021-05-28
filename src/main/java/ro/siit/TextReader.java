package ro.siit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {

    /**
     * Method that showcases the Decorator pattern.
     *
     * @param source
     * @return
     */
    public static String readFromFile(final String source) {
        var result = "";
        try (var br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(source))))) {
            var line = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return result;
    }

    public static String read(final InputStream is) {
        var result = "";
        try (var br = new BufferedReader(new InputStreamReader(is))) {
            var line = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return result;
    }

    public static String readLines(final InputStream is) {
        String result = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            final Stream<String> lines = br.lines();
            result = lines.reduce("", (str1, str2) -> str1 + str2);
        } catch (IOException e) {
            System.err.println(e);
        }
        return result;
    }

    public static List<Integer> countCharacters(final InputStream is) {
        List<Integer> result = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            final Stream<String> lines = br.lines();
            result = lines.map(str -> str.length()).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e);
        }
        return result;
    }

    public static Integer countWords(final InputStream is, final BinaryOperator<Integer> function) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            final Stream<String> lines = br.lines();
            return lines.map(str -> List.of(str.split(" ")).size()).reduce(0, function);
        } catch (IOException e) {
            System.err.println(e);
            return 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //final String text = readFromFile("test.txt");

        //final String text = read(new FileInputStream(new File("test.txt")));

        //final String text = read(System.in);

        //System.out.println(text);

        System.out.println(readLines(new FileInputStream("test.txt")));

        countCharacters(new FileInputStream("test.txt")).forEach(System.out::println);

        System.out.println(countWords(new FileInputStream("test.txt"), (acc, elem) -> acc + elem));
    }
}
