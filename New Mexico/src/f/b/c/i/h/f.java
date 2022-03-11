package f.b.c.i.h;

import android.util.Base64;
import android.util.JsonWriter;
import f.b.c.i.c;
import f.b.c.i.d;
import f.b.c.i.e;
import f.b.c.i.g;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
/* loaded from: classes.dex */
public final class f implements e, g {
    public boolean a = true;
    public final JsonWriter b;
    public final Map<Class<?>, d<?>> c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Class<?>, f.b.c.i.f<?>> f3493d;

    /* renamed from: e  reason: collision with root package name */
    public final d<Object> f3494e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3495f;

    public f(Writer writer, Map<Class<?>, d<?>> map, Map<Class<?>, f.b.c.i.f<?>> map2, d<Object> dVar, boolean z) {
        this.b = new JsonWriter(writer);
        this.c = map;
        this.f3493d = map2;
        this.f3494e = dVar;
        this.f3495f = z;
    }

    @Override // f.b.c.i.g
    public g a(String str) {
        g();
        this.b.value(str);
        return this;
    }

    @Override // f.b.c.i.g
    public g b(boolean z) {
        g();
        this.b.value(z);
        return this;
    }

    @Override // f.b.c.i.e
    public e d(String str, long j2) {
        g();
        this.b.name(str);
        g();
        this.b.value(j2);
        return this;
    }

    public f e(Object obj, boolean z) {
        int i2 = 0;
        if (z) {
            if (obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number)) {
                Object[] objArr = new Object[1];
                objArr[0] = obj == null ? null : obj.getClass();
                throw new c(String.format("%s cannot be encoded inline", objArr));
            }
        }
        if (obj == null) {
            this.b.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.b.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                g();
                this.b.value(Base64.encodeToString((byte[]) obj, 2));
                return this;
            }
            this.b.beginArray();
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i2 < length) {
                    this.b.value((long) iArr[i2]);
                    i2++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i2 < length2) {
                    long j2 = jArr[i2];
                    g();
                    this.b.value(j2);
                    i2++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i2 < length3) {
                    this.b.value(dArr[i2]);
                    i2++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i2 < length4) {
                    this.b.value(zArr[i2]);
                    i2++;
                }
            } else if (obj instanceof Number[]) {
                for (Number number : (Number[]) obj) {
                    e(number, false);
                }
            } else {
                for (Object obj2 : (Object[]) obj) {
                    e(obj2, false);
                }
            }
            this.b.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.b.beginArray();
            for (Object obj3 : (Collection) obj) {
                e(obj3, false);
            }
            this.b.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.b.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    c((String) key, entry.getValue());
                } catch (ClassCastException e2) {
                    throw new c(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e2);
                }
            }
            this.b.endObject();
            return this;
        } else {
            d<?> dVar = this.c.get(obj.getClass());
            if (dVar != null) {
                if (!z) {
                    this.b.beginObject();
                }
                dVar.a(obj, this);
                if (!z) {
                    this.b.endObject();
                }
                return this;
            }
            f.b.c.i.f<?> fVar = this.f3493d.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            } else if (obj instanceof Enum) {
                String name = ((Enum) obj).name();
                g();
                this.b.value(name);
                return this;
            } else {
                d<Object> dVar2 = this.f3494e;
                if (!z) {
                    this.b.beginObject();
                }
                dVar2.a(obj, this);
                if (!z) {
                    this.b.endObject();
                }
                return this;
            }
        }
    }

    /* renamed from: f */
    public f c(String str, Object obj) {
        if (!this.f3495f) {
            g();
            this.b.name(str);
            if (obj != null) {
                return e(obj, false);
            }
            this.b.nullValue();
            return this;
        } else if (obj == null) {
            return this;
        } else {
            g();
            this.b.name(str);
            return e(obj, false);
        }
    }

    public final void g() {
        if (!this.a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
