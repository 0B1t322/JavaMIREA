package ru.demin.pract17;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Stations {
    private LinkedHashMap<String, List<String>> stations;

    public Stations() {
        stations = new LinkedHashMap<>();
    }

    public Stations(LinkedHashMap<String, List<String>> stations) {
        this.stations = stations;
    }

    public LinkedHashMap<String, List<String>> getStations() {
        return stations;
    }

    public void put(String lineNumber, String stationName) {
        if(!stations.containsKey(lineNumber)) {
            stations.put(lineNumber, new ArrayList<>());
        }

        var nameLists = stations.get(lineNumber);
        nameLists.add(stationName);
        stations.put(lineNumber, nameLists);
    }

    public List<String> get(String lineNumber) {
        return stations.get(lineNumber);
    }

    public void setStations(LinkedHashMap<String, List<String>> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "Stations{" +
                "stations=" + stations +
                '}';
    }
}
