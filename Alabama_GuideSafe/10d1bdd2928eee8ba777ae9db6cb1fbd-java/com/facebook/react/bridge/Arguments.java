package com.facebook.react.bridge;

import android.os.Bundle;
import android.os.Parcelable;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Arguments {

    /* renamed from: com.facebook.react.bridge.Arguments$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
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

    public static void addEntry(WritableNativeMap writableNativeMap, String str, Object obj) {
        Object makeNativeObject = makeNativeObject(obj);
        if (makeNativeObject == null) {
            writableNativeMap.putNull(str);
        } else if (makeNativeObject instanceof Boolean) {
            writableNativeMap.putBoolean(str, ((Boolean) makeNativeObject).booleanValue());
        } else if (makeNativeObject instanceof Integer) {
            writableNativeMap.putInt(str, ((Integer) makeNativeObject).intValue());
        } else if (makeNativeObject instanceof Number) {
            writableNativeMap.putDouble(str, ((Number) makeNativeObject).doubleValue());
        } else if (makeNativeObject instanceof String) {
            writableNativeMap.putString(str, (String) makeNativeObject);
        } else if (makeNativeObject instanceof WritableNativeArray) {
            writableNativeMap.putArray(str, (WritableNativeArray) makeNativeObject);
        } else if (makeNativeObject instanceof WritableNativeMap) {
            writableNativeMap.putMap(str, (WritableNativeMap) makeNativeObject);
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Could not convert ");
            outline17.append(makeNativeObject.getClass());
            throw new IllegalArgumentException(outline17.toString());
        }
    }

    public static WritableArray createArray() {
        return new WritableNativeArray();
    }

    public static WritableMap createMap() {
        return new WritableNativeMap();
    }

    public static WritableArray fromArray(Object obj) {
        WritableArray createArray = createArray();
        int i = 0;
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            int length = strArr.length;
            while (i < length) {
                createArray.pushString(strArr[i]);
                i++;
            }
        } else if (obj instanceof Bundle[]) {
            Bundle[] bundleArr = (Bundle[]) obj;
            int length2 = bundleArr.length;
            while (i < length2) {
                createArray.pushMap(fromBundle(bundleArr[i]));
                i++;
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length;
            while (i < length3) {
                createArray.pushInt(iArr[i]);
                i++;
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length4 = fArr.length;
            while (i < length4) {
                createArray.pushDouble((double) fArr[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length5 = dArr.length;
            while (i < length5) {
                createArray.pushDouble(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length6 = zArr.length;
            while (i < length6) {
                createArray.pushBoolean(zArr[i]);
                i++;
            }
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            int length7 = parcelableArr.length;
            while (i < length7) {
                Parcelable parcelable = parcelableArr[i];
                if (parcelable instanceof Bundle) {
                    createArray.pushMap(fromBundle((Bundle) parcelable));
                    i++;
                } else {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Unexpected array member type ");
                    outline17.append(parcelable.getClass());
                    throw new IllegalArgumentException(outline17.toString());
                }
            }
        } else {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("Unknown array type ");
            outline172.append(obj.getClass());
            throw new IllegalArgumentException(outline172.toString());
        }
        return createArray;
    }

    public static WritableMap fromBundle(Bundle bundle) {
        WritableMap createMap = createMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                createMap.putNull(str);
            } else if (obj.getClass().isArray()) {
                createMap.putArray(str, fromArray(obj));
            } else if (obj instanceof String) {
                createMap.putString(str, (String) obj);
            } else if (obj instanceof Number) {
                if (obj instanceof Integer) {
                    createMap.putInt(str, ((Integer) obj).intValue());
                } else {
                    createMap.putDouble(str, ((Number) obj).doubleValue());
                }
            } else if (obj instanceof Boolean) {
                createMap.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Bundle) {
                createMap.putMap(str, fromBundle((Bundle) obj));
            } else if (obj instanceof List) {
                createMap.putArray(str, fromList((List) obj));
            } else {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Could not convert ");
                outline17.append(obj.getClass());
                throw new IllegalArgumentException(outline17.toString());
            }
        }
        return createMap;
    }

    public static WritableNativeArray fromJavaArgs(Object[] objArr) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (Object obj : objArr) {
            if (obj == null) {
                writableNativeArray.pushNull();
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class) {
                    writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (cls == Integer.class) {
                    writableNativeArray.pushDouble(((Integer) obj).doubleValue());
                } else if (cls == Double.class) {
                    writableNativeArray.pushDouble(((Double) obj).doubleValue());
                } else if (cls == Float.class) {
                    writableNativeArray.pushDouble(((Float) obj).doubleValue());
                } else if (cls == String.class) {
                    writableNativeArray.pushString(obj.toString());
                } else if (cls == WritableNativeMap.class) {
                    writableNativeArray.pushMap((WritableNativeMap) obj);
                } else if (cls == WritableNativeArray.class) {
                    writableNativeArray.pushArray((WritableNativeArray) obj);
                } else {
                    throw new RuntimeException("Cannot convert argument of type " + cls);
                }
            }
        }
        return writableNativeArray;
    }

    public static WritableArray fromList(List list) {
        WritableArray createArray = createArray();
        for (Object obj : list) {
            if (obj == null) {
                createArray.pushNull();
            } else if (obj.getClass().isArray()) {
                createArray.pushArray(fromArray(obj));
            } else if (obj instanceof Bundle) {
                createArray.pushMap(fromBundle((Bundle) obj));
            } else if (obj instanceof List) {
                createArray.pushArray(fromList((List) obj));
            } else if (obj instanceof String) {
                createArray.pushString((String) obj);
            } else if (obj instanceof Integer) {
                createArray.pushInt(((Integer) obj).intValue());
            } else if (obj instanceof Number) {
                createArray.pushDouble(((Number) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                createArray.pushBoolean(((Boolean) obj).booleanValue());
            } else {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Unknown value type ");
                outline17.append(obj.getClass());
                throw new IllegalArgumentException(outline17.toString());
            }
        }
        return createArray;
    }

    public static WritableNativeArray makeNativeArray(List list) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (list == null) {
            return writableNativeArray;
        }
        for (Object obj : list) {
            Object makeNativeObject = makeNativeObject(obj);
            if (makeNativeObject == null) {
                writableNativeArray.pushNull();
            } else if (makeNativeObject instanceof Boolean) {
                writableNativeArray.pushBoolean(((Boolean) makeNativeObject).booleanValue());
            } else if (makeNativeObject instanceof Integer) {
                writableNativeArray.pushInt(((Integer) makeNativeObject).intValue());
            } else if (makeNativeObject instanceof Double) {
                writableNativeArray.pushDouble(((Double) makeNativeObject).doubleValue());
            } else if (makeNativeObject instanceof String) {
                writableNativeArray.pushString((String) makeNativeObject);
            } else if (makeNativeObject instanceof WritableNativeArray) {
                writableNativeArray.pushArray((WritableNativeArray) makeNativeObject);
            } else if (makeNativeObject instanceof WritableNativeMap) {
                writableNativeArray.pushMap((WritableNativeMap) makeNativeObject);
            } else {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Could not convert ");
                outline17.append(makeNativeObject.getClass());
                throw new IllegalArgumentException(outline17.toString());
            }
        }
        return writableNativeArray;
    }

    public static WritableNativeMap makeNativeMap(Map<String, Object> map) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (map == null) {
            return writableNativeMap;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            addEntry(writableNativeMap, entry.getKey(), entry.getValue());
        }
        return writableNativeMap;
    }

    public static Object makeNativeObject(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Float) || (obj instanceof Long) || (obj instanceof Byte) || (obj instanceof Short)) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj.getClass().isArray()) {
            return makeNativeArray(obj);
        }
        if (obj instanceof List) {
            return makeNativeArray((List) obj);
        }
        if (obj instanceof Map) {
            return makeNativeMap((Map) obj);
        }
        return obj instanceof Bundle ? makeNativeMap((Bundle) obj) : obj;
    }

    public static Bundle toBundle(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        Bundle bundle = new Bundle();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            int ordinal = readableMap.getType(nextKey).ordinal();
            if (ordinal == 0) {
                bundle.putString(nextKey, null);
            } else if (ordinal == 1) {
                bundle.putBoolean(nextKey, readableMap.getBoolean(nextKey));
            } else if (ordinal == 2) {
                bundle.putDouble(nextKey, readableMap.getDouble(nextKey));
            } else if (ordinal == 3) {
                bundle.putString(nextKey, readableMap.getString(nextKey));
            } else if (ordinal == 4) {
                bundle.putBundle(nextKey, toBundle(readableMap.getMap(nextKey)));
            } else if (ordinal == 5) {
                bundle.putSerializable(nextKey, toList(readableMap.getArray(nextKey)));
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline11("Could not convert object with key: ", nextKey, "."));
            }
        }
        return bundle;
    }

    public static ArrayList toList(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            int ordinal = readableArray.getType(i).ordinal();
            if (ordinal == 0) {
                arrayList.add(null);
            } else if (ordinal == 1) {
                arrayList.add(Boolean.valueOf(readableArray.getBoolean(i)));
            } else if (ordinal == 2) {
                double d = readableArray.getDouble(i);
                if (d == Math.rint(d)) {
                    arrayList.add(Integer.valueOf((int) d));
                } else {
                    arrayList.add(Double.valueOf(d));
                }
            } else if (ordinal == 3) {
                arrayList.add(readableArray.getString(i));
            } else if (ordinal == 4) {
                arrayList.add(toBundle(readableArray.getMap(i)));
            } else if (ordinal == 5) {
                arrayList.add(toList(readableArray.getArray(i)));
            } else {
                throw new IllegalArgumentException("Could not convert object in array.");
            }
        }
        return arrayList;
    }

    public static WritableNativeMap makeNativeMap(Bundle bundle) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (bundle == null) {
            return writableNativeMap;
        }
        for (String str : bundle.keySet()) {
            addEntry(writableNativeMap, str, bundle.get(str));
        }
        return writableNativeMap;
    }

    public static <T> WritableNativeArray makeNativeArray(final Object obj) {
        if (obj == null) {
            return new WritableNativeArray();
        }
        return makeNativeArray((List) new AbstractList() {
            /* class com.facebook.react.bridge.Arguments.AnonymousClass1 */

            @Override // java.util.List, java.util.AbstractList
            public Object get(int i) {
                return Array.get(obj, i);
            }

            public int size() {
                return Array.getLength(obj);
            }
        });
    }
}
