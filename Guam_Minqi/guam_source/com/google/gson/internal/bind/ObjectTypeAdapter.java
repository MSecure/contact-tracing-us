package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        /* class com.google.gson.internal.bind.ObjectTypeAdapter.AnonymousClass1 */

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.rawType == Object.class) {
                return new ObjectTypeAdapter(gson);
            }
            return null;
        }
    };
    public final Gson gson;

    public ObjectTypeAdapter(Gson gson2) {
        this.gson = gson2;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        int ordinal = jsonReader.peek().ordinal();
        if (ordinal == 0) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(read(jsonReader));
            }
            jsonReader.endArray();
            return arrayList;
        } else if (ordinal == 2) {
            LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                linkedTreeMap.put(jsonReader.nextName(), read(jsonReader));
            }
            jsonReader.endObject();
            return linkedTreeMap;
        } else if (ordinal == 5) {
            return jsonReader.nextString();
        } else {
            if (ordinal == 6) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            if (ordinal == 7) {
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
            if (ordinal == 8) {
                jsonReader.nextNull();
                return null;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Gson gson2 = this.gson;
        Class<?> cls = obj.getClass();
        if (gson2 != null) {
            TypeAdapter adapter = gson2.getAdapter(new TypeToken(cls));
            if (adapter instanceof ObjectTypeAdapter) {
                jsonWriter.beginObject();
                jsonWriter.endObject();
                return;
            }
            adapter.write(jsonWriter, obj);
            return;
        }
        throw null;
    }
}
