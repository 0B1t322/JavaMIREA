package ru.demin.pract17;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;

public class MoscowSubwayDeserilizator implements JsonDeserializer<MoscowSubway> {

    @Override
    public MoscowSubway deserialize(
            JsonElement jsonElement,
            Type type,
            JsonDeserializationContext jsonDeserializationContext
    ) throws JsonParseException {
        Gson gson = new Gson();

        MoscowSubway moscowSubway = new MoscowSubway();
        var stations = jsonElement.getAsJsonObject().get("stations");

        moscowSubway.setStations(
                new Stations(
                        gson.fromJson(
                                stations,
                                moscowSubway.getStations().getStations().getClass()
                        )
                )
        );

        var lines = jsonElement.getAsJsonObject().get("lines");
        moscowSubway.setLines(
                gson.fromJson(
                        lines,
                        moscowSubway.getLines().getClass()
                )
        );

        return moscowSubway;
    }
}
