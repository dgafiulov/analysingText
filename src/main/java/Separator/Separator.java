package Separator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Separator {
    private final int id;
    private final Scanner scan;
    private double sum = 0;
    private int amountOfNumbers = 0;

    public Separator(String origFilePath, int requestedId) {
        this.id = requestedId;
        this.scan = new Scanner(Objects.requireNonNull(fileReaderInit(origFilePath)));
    }

    private FileReader fileReaderInit(String origFilePath) {
        try {
            return new FileReader(origFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found. " + e);
        }
        return null;
    }

    public void startWork() throws ExecutionException, InterruptedException {
        while (scan.hasNext()) {
            FutureTask<Double> future = new FutureTask<>(new Reader(scan.nextLine().substring(12), id));
            new Thread(future).start();
            double temp = future.get();
            if (temp != 0.0) {
                sum += temp;
                amountOfNumbers++;
            }
        }
        System.out.println("final res " + sum / amountOfNumbers);
    }

}
