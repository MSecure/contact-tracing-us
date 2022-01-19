package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Date;

public final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        jsonReader.nextString();
        throw null;
    }

    public String toString() {
        throw null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.gson.stream.JsonWriter, java.lang.Object] */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        throw null;
    }
}
