package InputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputParser {
    public static String getPrefix(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input prefix: ");
        String prefix = sc.nextLine();

        return prefix;
    }
    public static ArrayList<String> getInput() {
        File textFile = new File("text.txt");
        ArrayList<String> lines = new ArrayList<String>();

        try {
            BufferedReader fileOut = new BufferedReader(new InputStreamReader(new FileInputStream(textFile), "UTF-8"));

            try {
                for (String line; (line = fileOut.readLine()) != null; ) {
                    lines.add(line);
                }
            } finally {
                fileOut.close();
            }
        }

        catch (IOException ex) {
            ex.printStackTrace();
        }

        return lines;
    }

    public static String[] parseText(ArrayList<String> lines){
        ArrayList<String> words = new ArrayList<String>();
        String pepega = "пепега";
        for(String line: lines){
            ArrayList<String> splittedLine = new ArrayList<String>(Arrays.asList(line.split("[^'\\wа-яА-Я]+")));
            splittedLine.removeIf(word -> word.length() <= 3);
            splittedLine = new ArrayList<>(splittedLine.stream().filter(word -> word.length() >= 3)
                                                       .map(word -> word.toLowerCase())
                                                       .collect(Collectors.toList()));
            words.addAll(splittedLine);
        }

        return words.toArray(String[]::new);
    }
}
