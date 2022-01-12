package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    public final TypeAdapter<T> adapter;
    public final Gson gson;

    public GsonResponseBodyConverter(Gson gson2, TypeAdapter<T> typeAdapter) {
        this.gson = gson2;
        this.adapter = typeAdapter;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // retrofit2.Converter
    public Object convert(ResponseBody responseBody) throws IOException {
        ResponseBody responseBody2 = responseBody;
        Gson gson2 = this.gson;
        Reader charStream = responseBody2.charStream();
        if (gson2 != null) {
            JsonReader jsonReader = new JsonReader(charStream);
            jsonReader.lenient = gson2.lenient;
            try {
                T read = this.adapter.read(jsonReader);
                if (jsonReader.peek() == JsonToken.END_DOCUMENT) {
                    return read;
                }
                throw new JsonIOException("JSON document was not fully consumed.");
            } finally {
                responseBody2.close();
            }
        } else {
            throw null;
        }
    }
}
