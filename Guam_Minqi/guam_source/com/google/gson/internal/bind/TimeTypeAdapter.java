package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        /* class com.google.gson.internal.bind.TimeTypeAdapter.AnonymousClass1 */

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.rawType == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };
    public final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.gson.TypeAdapter
    public Time read(JsonReader jsonReader) throws IOException {
        synchronized (this) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new Time(this.format.parse(jsonReader.nextString()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.gson.stream.JsonWriter, java.lang.Object] */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Time time) throws IOException {
        String str;
        Time time2 = time;
        synchronized (this) {
            if (time2 == null) {
                str = null;
            } else {
                str = this.format.format(time2);
            }
            jsonWriter.value(str);
        }
    }
}
