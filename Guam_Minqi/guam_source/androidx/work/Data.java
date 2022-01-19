package androidx.work;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Data {
    public static final Data EMPTY;
    public static final String TAG = Logger.tagWithPrefix("Data");
    public Map<String, Object> mValues;

    public static final class Builder {
        public Map<String, Object> mValues = new HashMap();

        public Data build() {
            Data data = new Data(this.mValues);
            Data.toByteArrayInternal(data);
            return data;
        }

        public Builder putAll(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    this.mValues.put(key, null);
                } else {
                    Class<?> cls = value.getClass();
                    if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                        this.mValues.put(key, value);
                    } else if (cls == boolean[].class) {
                        this.mValues.put(key, Data.convertPrimitiveBooleanArray((boolean[]) value));
                    } else if (cls == byte[].class) {
                        this.mValues.put(key, Data.convertPrimitiveByteArray((byte[]) value));
                    } else if (cls == int[].class) {
                        this.mValues.put(key, Data.convertPrimitiveIntArray((int[]) value));
                    } else if (cls == long[].class) {
                        this.mValues.put(key, Data.convertPrimitiveLongArray((long[]) value));
                    } else if (cls == float[].class) {
                        this.mValues.put(key, Data.convertPrimitiveFloatArray((float[]) value));
                    } else if (cls == double[].class) {
                        this.mValues.put(key, Data.convertPrimitiveDoubleArray((double[]) value));
                    } else {
                        throw new IllegalArgumentException(String.format("Key %s has invalid type %s", key, cls));
                    }
                }
            }
            return this;
        }
    }

    static {
        Data data = new Data(new HashMap());
        toByteArrayInternal(data);
        EMPTY = data;
    }

    public Data() {
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    public static Byte[] convertPrimitiveByteArray(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    public static Float[] convertPrimitiveFloatArray(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    public static Integer[] convertPrimitiveIntArray(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static Long[] convertPrimitiveLongArray(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050 A[SYNTHETIC, Splitter:B:25:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a A[SYNTHETIC, Splitter:B:34:0x006a] */
    public static Data fromByteArray(byte[] bArr) {
        Throwable th;
        Throwable e;
        ObjectInputStream objectInputStream;
        if (bArr.length <= 10240) {
            HashMap hashMap = new HashMap();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream2 = null;
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                        hashMap.put(objectInputStream.readUTF(), objectInputStream.readObject());
                    }
                    try {
                        objectInputStream.close();
                    } catch (IOException e2) {
                        Log.e(TAG, "Error in Data#fromByteArray: ", e2);
                    }
                } catch (IOException | ClassNotFoundException e3) {
                    e = e3;
                    try {
                        Log.e(TAG, "Error in Data#fromByteArray: ", e);
                        if (objectInputStream != null) {
                        }
                        byteArrayInputStream.close();
                        return new Data(hashMap);
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream2 = objectInputStream;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e4) {
                                Log.e(TAG, "Error in Data#fromByteArray: ", e4);
                            }
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e5) {
                            Log.e(TAG, "Error in Data#fromByteArray: ", e5);
                        }
                        throw th;
                    }
                }
            } catch (IOException | ClassNotFoundException e6) {
                objectInputStream = null;
                e = e6;
                Log.e(TAG, "Error in Data#fromByteArray: ", e);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e7) {
                        Log.e(TAG, "Error in Data#fromByteArray: ", e7);
                    }
                }
                byteArrayInputStream.close();
                return new Data(hashMap);
            } catch (Throwable th3) {
                th = th3;
                if (objectInputStream2 != null) {
                }
                byteArrayInputStream.close();
                throw th;
            }
            try {
                byteArrayInputStream.close();
            } catch (IOException e8) {
                Log.e(TAG, "Error in Data#fromByteArray: ", e8);
            }
            return new Data(hashMap);
        }
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c A[SYNTHETIC, Splitter:B:31:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093 A[SYNTHETIC, Splitter:B:41:0x0093] */
    public static byte[] toByteArrayInternal(Data data) {
        Throwable th;
        IOException e;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream2.writeInt(data.mValues.size());
                for (Map.Entry<String, Object> entry : data.mValues.entrySet()) {
                    objectOutputStream2.writeUTF(entry.getKey());
                    objectOutputStream2.writeObject(entry.getValue());
                }
                try {
                    objectOutputStream2.close();
                } catch (IOException e2) {
                    Log.e(TAG, "Error in Data#toByteArray: ", e2);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    Log.e(TAG, "Error in Data#toByteArray: ", e3);
                }
                if (byteArrayOutputStream.size() <= 10240) {
                    return byteArrayOutputStream.toByteArray();
                }
                throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
            } catch (IOException e4) {
                e = e4;
                objectOutputStream = objectOutputStream2;
                try {
                    Log.e(TAG, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                            Log.e(TAG, "Error in Data#toByteArray: ", e5);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                        Log.e(TAG, "Error in Data#toByteArray: ", e6);
                    }
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e7) {
                        Log.e(TAG, "Error in Data#toByteArray: ", e7);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = objectOutputStream2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e8) {
                        Log.e(TAG, "Error in Data#toByteArray: ", e8);
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            Log.e(TAG, "Error in Data#toByteArray: ", e);
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            if (objectOutputStream != null) {
            }
            byteArrayOutputStream.close();
            return byteArray2;
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || Data.class != obj.getClass()) {
            return false;
        }
        Data data = (Data) obj;
        Set<String> keySet = this.mValues.keySet();
        if (!keySet.equals(data.mValues.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.mValues.get(str);
            Object obj3 = data.mValues.get(str);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z = obj2.equals(obj3);
                continue;
            } else {
                z = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.mValues.isEmpty()) {
            for (String str : this.mValues.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.mValues.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public Data(Data data) {
        this.mValues = new HashMap(data.mValues);
    }

    public Data(Map<String, ?> map) {
        this.mValues = new HashMap(map);
    }
}
