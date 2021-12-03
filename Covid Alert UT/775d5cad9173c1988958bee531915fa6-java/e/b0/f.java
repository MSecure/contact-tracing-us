package e.b0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class f {
    public static final String b = n.e("Data");
    public static final f c;
    public Map<String, Object> a;

    public static final class a {
        public Map<String, Object> a = new HashMap();

        public f a() {
            f fVar = new f(this.a);
            f.c(fVar);
            return fVar;
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
                            String str = f.b;
                            Boolean[] boolArr = new Boolean[zArr.length];
                            while (i2 < zArr.length) {
                                boolArr[i2] = Boolean.valueOf(zArr[i2]);
                                i2++;
                            }
                            map2.put(key, boolArr);
                        } else if (cls == byte[].class) {
                            this.a.put(key, f.a((byte[]) value));
                        } else if (cls == int[].class) {
                            Map<String, Object> map3 = this.a;
                            int[] iArr = (int[]) value;
                            String str2 = f.b;
                            Integer[] numArr = new Integer[iArr.length];
                            while (i2 < iArr.length) {
                                numArr[i2] = Integer.valueOf(iArr[i2]);
                                i2++;
                            }
                            map3.put(key, numArr);
                        } else if (cls == long[].class) {
                            Map<String, Object> map4 = this.a;
                            long[] jArr = (long[]) value;
                            String str3 = f.b;
                            Long[] lArr = new Long[jArr.length];
                            while (i2 < jArr.length) {
                                lArr[i2] = Long.valueOf(jArr[i2]);
                                i2++;
                            }
                            map4.put(key, lArr);
                        } else if (cls == float[].class) {
                            Map<String, Object> map5 = this.a;
                            float[] fArr = (float[]) value;
                            String str4 = f.b;
                            Float[] fArr2 = new Float[fArr.length];
                            while (i2 < fArr.length) {
                                fArr2[i2] = Float.valueOf(fArr[i2]);
                                i2++;
                            }
                            map5.put(key, fArr2);
                        } else if (cls == double[].class) {
                            Map<String, Object> map6 = this.a;
                            double[] dArr = (double[]) value;
                            String str5 = f.b;
                            Double[] dArr2 = new Double[dArr.length];
                            while (i2 < dArr.length) {
                                dArr2[i2] = Double.valueOf(dArr[i2]);
                                i2++;
                            }
                            map6.put(key, dArr2);
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
        f fVar = new f(new HashMap());
        c(fVar);
        c = fVar;
    }

    public f() {
    }

    public f(f fVar) {
        this.a = new HashMap(fVar.a);
    }

    public f(Map<String, ?> map) {
        this.a = new HashMap(map);
    }

    public static Byte[] a(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = Byte.valueOf(bArr[i2]);
        }
        return bArr2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|(2:18|19)|20|21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|(7:3|4|5|6|(2:8|9)|10|11)|27|28|29|31) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0043 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[SYNTHETIC, Splitter:B:18:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040  */
    public static f b(byte[] bArr) {
        Throwable th;
        if (bArr.length <= 10240) {
            HashMap hashMap = new HashMap();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = null;
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
                try {
                    for (int readInt = objectInputStream2.readInt(); readInt > 0; readInt--) {
                        hashMap.put(objectInputStream2.readUTF(), objectInputStream2.readObject());
                    }
                    objectInputStream2.close();
                } catch (IOException | ClassNotFoundException unused) {
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    return new f(hashMap);
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    throw th;
                }
            } catch (IOException | ClassNotFoundException unused2) {
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return new f(hashMap);
            } catch (Throwable th3) {
                th = th3;
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                throw th;
            }
            byteArrayInputStream.close();
            return new f(hashMap);
        }
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:23|(2:34|35)|36|37|38) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:22|21|24|25|(0)|29|30|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|(2:7|5)|8|9|10|11|13|(2:15|16)(2:17|18)) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0068 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0071 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065 A[SYNTHETIC, Splitter:B:27:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e A[SYNTHETIC, Splitter:B:34:0x006e] */
    public static byte[] c(f fVar) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        try {
            objectOutputStream2.writeInt(fVar.a.size());
            for (Map.Entry<String, Object> entry : fVar.a.entrySet()) {
                objectOutputStream2.writeUTF(entry.getKey());
                objectOutputStream2.writeObject(entry.getValue());
            }
            objectOutputStream2.close();
            byteArrayOutputStream.close();
            if (byteArrayOutputStream.size() > 10240) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        } catch (IOException unused) {
            objectOutputStream = objectOutputStream2;
            try {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                }
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = objectOutputStream2;
            if (objectOutputStream != null) {
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        Set<String> keySet = this.a.keySet();
        if (!keySet.equals(fVar.a.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.a.get(str);
            Object obj3 = fVar.a.get(str);
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
