package Separator;

import com.google.gson.Gson;
import java.util.concurrent.Callable;

public class Reader implements Callable<Double> {

    private final int id;
    long sum;
    private final Data[] data;

    public Reader(String orig, int id) {
        this.id = id;
        Gson gson = new Gson();
        data = gson.fromJson(orig, Data[].class);
    }

    private double workWithData() {
        for (Data datum : data) {
            if (datum.getId() == id) {
                sum += datum.getNumber();
            }
        }
        return sum / (data.length * 1.0);
    }

    @Override
    public Double call() {
        return workWithData();
    }
}
