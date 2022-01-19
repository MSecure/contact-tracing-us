package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;

public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    public final TreeTypeAdapter<T>.GsonContextImpl context = new GsonContextImpl(this, null);
    public TypeAdapter<T> delegate;
    public final JsonDeserializer<T> deserializer;
    public final Gson gson;
    public final JsonSerializer<T> serializer;
    public final TypeAdapterFactory skipPast;
    public final TypeToken<T> typeToken;

    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        public GsonContextImpl(TreeTypeAdapter treeTypeAdapter, AnonymousClass1 r2) {
        }
    }

    public static final class SingleTypeFactory implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> cls = typeToken.rawType;
            throw null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson2, TypeToken<T> typeToken2, TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson2;
        this.typeToken = typeToken2;
        this.skipPast = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        throw new com.google.gson.JsonSyntaxException(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        throw new com.google.gson.JsonIOException(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        throw new com.google.gson.JsonSyntaxException(r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029 A[ExcHandler: NumberFormatException (r4v8 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:7:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030 A[ExcHandler: IOException (r4v7 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:7:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[ExcHandler: MalformedJsonException (r4v6 'e' com.google.gson.stream.MalformedJsonException A[CUSTOM_DECLARE]), Splitter:B:7:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0059  */
    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        JsonElement jsonElement;
        EOFException e;
        boolean z;
        if (this.deserializer == null) {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                typeAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
                this.delegate = typeAdapter;
            }
            return typeAdapter.read(jsonReader);
        }
        try {
            jsonReader.peek();
            z = false;
            jsonElement = TypeAdapters.JSON_ELEMENT.read(jsonReader);
        } catch (EOFException e2) {
            e = e2;
            z = true;
        } catch (MalformedJsonException e3) {
        } catch (IOException e4) {
        } catch (NumberFormatException e5) {
        }
        if (jsonElement != null) {
            throw null;
        } else if (jsonElement instanceof JsonNull) {
            return null;
        } else {
            return this.deserializer.deserialize(jsonElement, this.typeToken.type, this.context);
        }
        if (z) {
            jsonElement = JsonNull.INSTANCE;
            if (jsonElement != null) {
            }
        } else {
            throw new JsonSyntaxException(e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        JsonSerializer<T> jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                typeAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
                this.delegate = typeAdapter;
            }
            typeAdapter.write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonSerializer.serialize(t, this.typeToken.type, this.context));
        }
    }
}
