package org.example;

import Separator.Separator;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Separator separator = new Separator("Yjateubsolawmdda_data.txt", 61);
        separator.startWork();
    }
}