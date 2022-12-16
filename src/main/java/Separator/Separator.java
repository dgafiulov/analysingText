package Separator;

import com.google.gson.Gson;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Separator implements Runnable {

    private int id;
    private String string;
    private ArrayList<Data> queueOfData = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();

    public Separator(String string, int id) {
        this.string = string;
        this.id = id;
    }

    public void run() {
        read();
        separateToParts();
        toData();
        //System.out.println(getAverageNumberOfThisLine());
    }

    private void read() {
        int stringLen = string.length();
        string = string.substring(13, stringLen - 1);
        System.out.println(string);
    }

    private void separateToParts() {
        while(!string.isEmpty()) {
            int i = string.indexOf("}") + 1;
            System.out.println(string);
            list.add(string.substring(0, i));
            string = string.substring(i+1 == string.length()? i: i+1);
        }
    }

    private void toData() {
        for (int i = 0; i < list.size(); i++) {
            queueOfData.add((new Gson()).fromJson(list.get(i), Data.class));
        }
    }

    private double getAverageNumberOfThisLine() {
        long sum = 0;
        int amount = 0;
        for (int i = 0; i < queueOfData.size(); i++) {
            if (queueOfData.get(i).getId() == id) {
                amount++;
                sum += queueOfData.get(i).getNumber();
            }
        }
        return (double) amount / sum;
    }
}