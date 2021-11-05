package b.b0;

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

    /* renamed from: b  reason: collision with root package name */
    public static final String f1026b = m.e("Data");

    /* renamed from: c  reason: collision with root package name */
    public static final e f1027c;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f1028a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, Object> f1029a = new HashMap();

        public e a() {
            e eVar = new e(this.f1029a);
            e.h(eVar);
            return eVar;
        }

        public a b(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    this.f1029a.put(key, null);
                } else {
                    Class<?> cls = value.getClass();
                    if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                        this.f1029a.put(key, value);
                    } else if (cls == boolean[].class) {
                        this.f1029a.put(key, e.a((boolean[]) value));
                    } else if (cls == byte[].class) {
                        this.f1029a.put(key, e.b((byte[]) value));
                    } else if (cls == int[].class) {
                        this.f1029a.put(key, e.e((int[]) value));
                    } else if (cls == long[].class) {
                        this.f1029a.put(key, e.f((long[]) value));
                    } else if (cls == float[].class) {
                        this.f1029a.put(key, e.d((float[]) value));
                    } else if (cls == double[].class) {
                        this.f1029a.put(key, e.c((double[]) value));
                    } else {
                        throw new IllegalArgumentException(String.format("Key %s has invalid type %s", key, cls));
                    }
                }
            }
            return this;
        }
    }

    static {
        e eVar = new e(new HashMap());
        h(eVar);
        f1027c = eVar;
    }

    public e() {
    }

    public e(e eVar) {
        this.f1028a = new HashMap(eVar.f1028a);
    }

    public e(Map<String, ?> map) {
        this.f1028a = new HashMap(map);
    }

    public static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    public static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static Double[] c(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    public static Float[] d(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    public static Integer[] e(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static Long[] f(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|(2:18|19)|20|21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|(7:3|4|5|6|(2:8|9)|10|11)|27|28|29|31) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0042 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[SYNTHETIC, Splitter:B:18:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003f  */
    public static e g(byte[] bArr) {
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
                    return new e(hashMap);
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
                return new e(hashMap);
            } catch (Throwable th3) {
                th = th3;
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                throw th;
            }
            byteArrayInputStream.close();
            return new e(hashMap);
        }
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:19|20|(0)|36|37|38) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:22|21|24|25|(0)|29|30|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|(2:7|5)|8|9|10|11|12|(2:15|16)(2:17|18)) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x006f */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063 A[SYNTHETIC, Splitter:B:27:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c A[SYNTHETIC, Splitter:B:34:0x006c] */
    public static byte[] h(e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        try {
            objectOutputStream2.writeInt(eVar.f1028a.size());
            for (Map.Entry<String, Object> entry : eVar.f1028a.entrySet()) {
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
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (objectOutputStream != null) {
            }
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            Throwable th2 = th;
            objectOutputStream = objectOutputStream2;
            if (objectOutputStream != null) {
            }
            byteArrayOutputStream.close();
            throw th2;
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
        Set<String> keySet = this.f1028a.keySet();
        if (!keySet.equals(eVar.f1028a.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.f1028a.get(str);
            Object obj3 = eVar.f1028a.get(str);
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
        return this.f1028a.hashCode() * 31;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.f1028a.isEmpty()) {
            for (String str : this.f1028a.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.f1028a.get(str);
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
