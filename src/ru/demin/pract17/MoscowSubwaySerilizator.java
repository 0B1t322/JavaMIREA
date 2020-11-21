package ru.demin.pract17;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MoscowSubwaySerilizator implements JsonSerializer<MoscowSubway> {
    @Override
    public JsonElement serialize(
            MoscowSubway moscowSubway,
            Type type,
            JsonSerializationContext jsonSerializationContext
    ) {
        JsonObject jsonObject = new JsonObject();
        Gson gson = new Gson();
        jsonObject.add(
                "stations",
                JsonParser.parseString(
                        gson.toJson(
                                moscowSubway
                                        .getStations()
                                        .getStations()
                        )
                )
        );

        jsonObject.add(
                "lines",
                JsonParser.parseString(
                        gson.toJson(
                                moscowSubway.getLines()
                        )
                )
        );

        return jsonObject;
    }
}
