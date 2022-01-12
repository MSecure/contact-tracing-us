package com.facebook.react.bridge;

import android.util.JsonWriter;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonWriterHelper {

    /* renamed from: com.facebook.react.bridge.JsonWriterHelper$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002b */
        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                ReadableType readableType = ReadableType.Null;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$facebook$react$bridge$ReadableType;
                ReadableType readableType2 = ReadableType.Boolean;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$facebook$react$bridge$ReadableType;
                ReadableType readableType3 = ReadableType.Number;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$facebook$react$bridge$ReadableType;
                ReadableType readableType4 = ReadableType.String;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr5 = $SwitchMap$com$facebook$react$bridge$ReadableType;
            ReadableType readableType5 = ReadableType.Map;
            iArr5[4] = 5;
            try {
                int[] iArr6 = $SwitchMap$com$facebook$react$bridge$ReadableType;
                ReadableType readableType6 = ReadableType.Array;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void dynamicValue(JsonWriter jsonWriter, Dynamic dynamic) throws IOException {
        int ordinal = dynamic.getType().ordinal();
        if (ordinal == 0) {
            jsonWriter.nullValue();
        } else if (ordinal == 1) {
            jsonWriter.value(dynamic.asBoolean());
        } else if (ordinal == 2) {
            jsonWriter.value(dynamic.asDouble());
        } else if (ordinal == 3) {
            jsonWriter.value(dynamic.asString());
        } else if (ordinal == 4) {
            readableMapValue(jsonWriter, dynamic.asMap());
        } else if (ordinal == 5) {
            readableArrayValue(jsonWriter, dynamic.asArray());
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Unknown data type: ");
            outline17.append(dynamic.getType());
            throw new IllegalArgumentException(outline17.toString());
        }
    }

    public static void listValue(JsonWriter jsonWriter, List<?> list) throws IOException {
        jsonWriter.beginArray();
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            objectValue(jsonWriter, it.next());
        }
        jsonWriter.endArray();
    }

    public static void mapValue(JsonWriter jsonWriter, Map<?, ?> map) throws IOException {
        jsonWriter.beginObject();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            jsonWriter.name(entry.getKey().toString());
            value(jsonWriter, entry.getValue());
        }
        jsonWriter.endObject();
    }

    public static void objectValue(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
        } else if (obj instanceof String) {
            jsonWriter.value((String) obj);
        } else if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
        } else if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline9("Unknown value: ", obj));
        }
    }

    public static void readableArrayValue(JsonWriter jsonWriter, ReadableArray readableArray) throws IOException {
        jsonWriter.beginArray();
        for (int i = 0; i < readableArray.size(); i++) {
            try {
                int ordinal = readableArray.getType(i).ordinal();
                if (ordinal == 0) {
                    jsonWriter.nullValue();
                } else if (ordinal == 1) {
                    jsonWriter.value(readableArray.getBoolean(i));
                } else if (ordinal == 2) {
                    jsonWriter.value(readableArray.getDouble(i));
                } else if (ordinal == 3) {
                    jsonWriter.value(readableArray.getString(i));
                } else if (ordinal == 4) {
                    readableMapValue(jsonWriter, readableArray.getMap(i));
                } else if (ordinal == 5) {
                    readableArrayValue(jsonWriter, readableArray.getArray(i));
                } else {
                    throw new IllegalArgumentException("Unknown data type: " + readableArray.getType(i));
                }
            } finally {
                jsonWriter.endArray();
            }
        }
    }

    public static void readableMapValue(JsonWriter jsonWriter, ReadableMap readableMap) throws IOException {
        jsonWriter.beginObject();
        try {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                jsonWriter.name(nextKey);
                int ordinal = readableMap.getType(nextKey).ordinal();
                if (ordinal == 0) {
                    jsonWriter.nullValue();
                } else if (ordinal == 1) {
                    jsonWriter.value(readableMap.getBoolean(nextKey));
                } else if (ordinal == 2) {
                    jsonWriter.value(readableMap.getDouble(nextKey));
                } else if (ordinal == 3) {
                    jsonWriter.value(readableMap.getString(nextKey));
                } else if (ordinal == 4) {
                    readableMapValue(jsonWriter, readableMap.getMap(nextKey));
                } else if (ordinal == 5) {
                    readableArrayValue(jsonWriter, readableMap.getArray(nextKey));
                } else {
                    throw new IllegalArgumentException("Unknown data type: " + readableMap.getType(nextKey));
                }
            }
        } finally {
            jsonWriter.endObject();
        }
    }

    public static void value(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj instanceof Map) {
            mapValue(jsonWriter, (Map) obj);
        } else if (obj instanceof List) {
            listValue(jsonWriter, (List) obj);
        } else if (obj instanceof ReadableMap) {
            readableMapValue(jsonWriter, (ReadableMap) obj);
        } else if (obj instanceof ReadableArray) {
            readableArrayValue(jsonWriter, (ReadableArray) obj);
        } else if (obj instanceof Dynamic) {
            dynamicValue(jsonWriter, (Dynamic) obj);
        } else {
            objectValue(jsonWriter, obj);
        }
    }
}
