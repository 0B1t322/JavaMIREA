package ru.demin.pract17;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MoscowSubway {
    private Stations stations;
    private List<Line> lines;

    public MoscowSubway() {
        stations = new Stations();
        lines = new ArrayList<>();
    }

    public List<Line> getLines() {
        return lines;
    }

    public Stations getStations() {
        return stations;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public void setStations(Stations stations) {
        this.stations = stations;
    }
}
