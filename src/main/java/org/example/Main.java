package org.example;
import Separator.Separator;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        FileReader source = new FileReader("Yjateubsolawmdda_data.txt");
        Scanner scan = new Scanner(source);
        Separator sp;

        while (scan.hasNextLine()) {
            sp = new Separator(scan.nextLine(), 61);
            Thread thread = new Thread(sp);
            thread.start();
        }
        source.close();

        //Data data = (new Gson()).fromJson("{\"name\": \"Лев\", \"id\": 53, \"number\": 121212121212}", Data.class);
        //System.out.println(data.toString());
    }
}