package e.b0;

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

public final class e {
    public static final String b = l.e("Data");
    public static final e c;
    public Map<String, Object> a;

    public static final class a {
        public Map<String, Object> a = new HashMap();

        public e a() {
            e eVar = new e(this.a);
            e.b(eVar);
            return eVar;
        }

        public a b(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    this.a.put(key, null);
                } else {
                    Class<?> cls = value.getClass();
                    if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                        this.a.put(key, value);
                    } else {
                        int i2 = 0;
                        if (cls == boolean[].class) {
                            Map<String, Object> map2 = this.a;
                            boolean[] zArr = (boolean[]) value;
                            String str = e.b;
                            Boolean[] boolArr = new Boolean[zArr.length];
                            while (i2 < zArr.length) {
                                boolArr[i2] = Boolean.valueOf(zArr[i2]);
                                i2++;
                            }
                            map2.put(key, boolArr);
                        } else if (cls == byte[].class) {
                            Map<String, Object> map3 = this.a;
                            byte[] bArr = (byte[]) value;
                            String str2 = e.b;
                            Byte[] bArr2 = new Byte[bArr.length];
                            while (i2 < bArr.length) {
                                bArr2[i2] = Byte.valueOf(bArr[i2]);
                                i2++;
                            }
                            map3.put(key, bArr2);
                        } else if (cls == int[].class) {
                            Map<String, Object> map4 = this.a;
                            int[] iArr = (int[]) value;
                            String str3 = e.b;
                            Integer[] numArr = new Integer[iArr.length];
                            while (i2 < iArr.length) {
                                numArr[i2] = Integer.valueOf(iArr[i2]);
                                i2++;
                            }
                            map4.put(key, numArr);
                        } else if (cls == long[].class) {
                            Map<String, Object> map5 = this.a;
                            long[] jArr = (long[]) value;
                            String str4 = e.b;
                            Long[] lArr = new Long[jArr.length];
                            while (i2 < jArr.length) {
                                lArr[i2] = Long.valueOf(jArr[i2]);
                                i2++;
                            }
                            map5.put(key, lArr);
                        } else if (cls == float[].class) {
                            Map<String, Object> map6 = this.a;
                            float[] fArr = (float[]) value;
                            String str5 = e.b;
                            Float[] fArr2 = new Float[fArr.length];
                            while (i2 < fArr.length) {
                                fArr2[i2] = Float.valueOf(fArr[i2]);
                                i2++;
                            }
                            map6.put(key, fArr2);
                        } else if (cls == double[].class) {
                            Map<String, Object> map7 = this.a;
                            double[] dArr = (double[]) value;
                            String str6 = e.b;
                            Double[] dArr2 = new Double[dArr.length];
                            while (i2 < dArr.length) {
                                dArr2[i2] = Double.valueOf(dArr[i2]);
                                i2++;
                            }
                            map7.put(key, dArr2);
                        } else {
                            throw new IllegalArgumentException(String.format("Key %s has invalid type %s", key, cls));
                        }
                    }
                }
            }
            return this;
        }
    }

    static {
        e eVar = new e(new HashMap());
        b(eVar);
        c = eVar;
    }

    public e() {
    }

    public e(e eVar) {
        this.a = new HashMap(eVar.a);
    }

    public e(Map<String, ?> map) {
        this.a = new HashMap(map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050 A[SYNTHETIC, Splitter:B:25:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a A[SYNTHETIC, Splitter:B:34:0x006a] */
    public static e a(byte[] bArr) {
        Throwable th;
        Throwable e2;
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
                    } catch (IOException e3) {
                        Log.e(b, "Error in Data#fromByteArray: ", e3);
                    }
                } catch (IOException | ClassNotFoundException e4) {
                    e2 = e4;
                    try {
                        Log.e(b, "Error in Data#fromByteArray: ", e2);
                        if (objectInputStream != null) {
                        }
                        byteArrayInputStream.close();
                        return new e(hashMap);
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream2 = objectInputStream;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e5) {
                                Log.e(b, "Error in Data#fromByteArray: ", e5);
                            }
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e6) {
                            Log.e(b, "Error in Data#fromByteArray: ", e6);
                        }
                        throw th;
                    }
                }
            } catch (IOException | ClassNotFoundException e7) {
                objectInputStream = null;
                e2 = e7;
                Log.e(b, "Error in Data#fromByteArray: ", e2);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e8) {
                        Log.e(b, "Error in Data#fromByteArray: ", e8);
                    }
                }
                byteArrayInputStream.close();
                return new e(hashMap);
            } catch (Throwable th3) {
                th = th3;
                if (objectInputStream2 != null) {
                }
                byteArrayInputStream.close();
                throw th;
            }
            try {
                byteArrayInputStream.close();
            } catch (IOException e9) {
                Log.e(b, "Error in Data#fromByteArray: ", e9);
            }
            return new e(hashMap);
        }
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c A[SYNTHETIC, Splitter:B:31:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093 A[SYNTHETIC, Splitter:B:41:0x0093] */
    public static byte[] b(e eVar) {
        Throwable th;
        IOException e2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream2.writeInt(eVar.a.size());
                for (Map.Entry<String, Object> entry : eVar.a.entrySet()) {
                    objectOutputStream2.writeUTF(entry.getKey());
                    objectOutputStream2.writeObject(entry.getValue());
                }
                try {
                    objectOutputStream2.close();
                } catch (IOException e3) {
                    Log.e(b, "Error in Data#toByteArray: ", e3);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    Log.e(b, "Error in Data#toByteArray: ", e4);
                }
                if (byteArrayOutputStream.size() <= 10240) {
                    return byteArrayOutputStream.toByteArray();
                }
                throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
            } catch (IOException e5) {
                e2 = e5;
                objectOutputStream = objectOutputStream2;
                try {
                    Log.e(b, "Error in Data#toByteArray: ", e2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e6) {
                            Log.e(b, "Error in Data#toByteArray: ", e6);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e7) {
                        Log.e(b, "Error in Data#toByteArray: ", e7);
                    }
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        Log.e(b, "Error in Data#toByteArray: ", e8);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = objectOutputStream2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e9) {
                        Log.e(b, "Error in Data#toByteArray: ", e9);
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e10) {
            e2 = e10;
            Log.e(b, "Error in Data#toByteArray: ", e2);
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
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        Set<String> keySet = this.a.keySet();
        if (!keySet.equals(eVar.a.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.a.get(str);
            Object obj3 = eVar.a.get(str);
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
        return this.a.hashCode() * 31;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.a.isEmpty()) {
            for (String str : this.a.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.a.get(str);
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
}
