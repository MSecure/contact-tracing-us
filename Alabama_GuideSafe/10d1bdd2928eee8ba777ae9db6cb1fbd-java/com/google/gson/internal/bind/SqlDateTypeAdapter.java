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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        /* class com.google.gson.internal.bind.SqlDateTypeAdapter.AnonymousClass1 */

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.rawType == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };
    public final DateFormat format = new SimpleDateFormat("MMM d, yyyy");

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        Date date;
        synchronized (this) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                date = null;
            } else {
                try {
                    date = new Date(this.format.parse(jsonReader.nextString()).getTime());
                } catch (ParseException e) {
                    throw new JsonSyntaxException(e);
                }
            }
        }
        return date;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.gson.stream.JsonWriter, java.lang.Object] */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        String str;
        Date date2 = date;
        synchronized (this) {
            if (date2 == null) {
                str = null;
            } else {
                str = this.format.format(date2);
            }
            jsonWriter.value(str);
        }
    }
}
