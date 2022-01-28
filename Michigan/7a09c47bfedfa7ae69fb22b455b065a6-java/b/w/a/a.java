package b.w.a;

import b.w.a.g.e;

public final class a implements e {

    /* renamed from: b  reason: collision with root package name */
    public final String f2608b;

    /* renamed from: c  reason: collision with root package name */
    public final Object[] f2609c;

    public a(String str) {
        this.f2608b = str;
        this.f2609c = null;
    }

    public a(String str, Object[] objArr) {
        this.f2608b = str;
        this.f2609c = objArr;
    }

    @Override // b.w.a.e
    public String a() {
        return this.f2608b;
    }

    @Override // b.w.a.e
    public void b(d dVar) {
        double d2;
        long j;
        int i;
        Object[] objArr = this.f2609c;
        if (objArr != null) {
            int length = objArr.length;
            int i2 = 0;
            while (i2 < length) {
                Object obj = objArr[i2];
                i2++;
                if (obj == null) {
                    ((e) dVar).f2630b.bindNull(i2);
                } else if (obj instanceof byte[]) {
                    ((e) dVar).f2630b.bindBlob(i2, (byte[]) obj);
                } else {
                    if (obj instanceof Float) {
                        d2 = (double) ((Float) obj).floatValue();
                    } else if (obj instanceof Double) {
                        d2 = ((Double) obj).doubleValue();
                    } else {
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                        } else {
                            if (obj instanceof Integer) {
                                i = ((Integer) obj).intValue();
                            } else if (obj instanceof Short) {
                                i = ((Short) obj).shortValue();
                            } else if (obj instanceof Byte) {
                                i = ((Byte) obj).byteValue();
                            } else if (obj instanceof String) {
                                ((e) dVar).f2630b.bindString(i2, (String) obj);
                            } else if (obj instanceof Boolean) {
                                j = ((Boolean) obj).booleanValue() ? 1 : 0;
                            } else {
                                throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i2 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
                            }
                            j = (long) i;
                        }
                        ((e) dVar).f2630b.bindLong(i2, j);
                    }
                    ((e) dVar).f2630b.bindDouble(i2, d2);
                }
            }
        }
    }
}
