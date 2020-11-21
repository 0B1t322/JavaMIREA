package ru.demin.pract17;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MoscowSubwayConvertor implements
        JsonDeserializer<MoscowSubway>,
        JsonSerializer<MoscowSubway> {

    private final MoscowSubwayDeserilizator deserilizator   =    new MoscowSubwayDeserilizator();
    private final  MoscowSubwaySerilizator serilizator      =    new MoscowSubwaySerilizator();

    @Override
    public MoscowSubway deserialize(
            JsonElement jsonElement,
            Type type,
            JsonDeserializationContext jsonDeserializationContext
    ) throws JsonParseException {

        return deserilizator.deserialize(
            jsonElement,
            type,
            jsonDeserializationContext
        );
    }

    @Override
    public JsonElement serialize(
            MoscowSubway moscowSubway,
            Type type,
            JsonSerializationContext jsonSerializationContext
    ) {

        return serilizator.serialize(
            moscowSubway,
            type,
            jsonSerializationContext
        );
    }
}
