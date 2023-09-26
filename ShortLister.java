import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();


                InputStream in =
                        new BufferedInputStream(Files.newInputStream(target, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                ArrayList<String> shortWords = null;
                while (reader.ready()) {
                    line = reader.readLine();
                    shortWords = new ArrayList<>();
                    shortWords.add(Arrays.toString(line.split(",")));

                }

                String[] shortWord = (String[]) collectAll(shortWords.toArray(), new ShortWordFilter());
                System.out.println("Short Words");
                for (Object o : shortWord) {
                    System.out.println(o);
                }
                reader.close();

            } else {
                System.out.println("Sorry, you must select a file! Terminating!");
                System.exit(0);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error")
            ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static Object[] collectAll(Object[] objects, Filter f) {
        ArrayList<Object> result = new ArrayList<>();
        for (Object o : objects) {
            if (f.accept(o)) {
                result.add(o);
            }
        }
        return result.toArray();
    }

}

