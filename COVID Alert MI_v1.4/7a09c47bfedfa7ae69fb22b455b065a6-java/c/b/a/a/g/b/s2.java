package c.b.a.a.g.b;

import com.google.android.gms.nearby.messages.BleSignal;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.lang.reflect.Field;
import java.util.Arrays;

public final class s2 {
    public int A;
    public int B;
    public Field C;
    public Object D;
    public Object E;
    public Object F;

    /* renamed from: a  reason: collision with root package name */
    public final t2 f3406a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f3407b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f3408c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3409d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3410e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3411f;

    /* renamed from: g  reason: collision with root package name */
    public final int f3412g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int[] n;
    public int o;
    public int p;
    public int q = Integer.MAX_VALUE;
    public int r = BleSignal.UNKNOWN_TX_POWER;
    public int s = 0;
    public int t = 0;
    public int u = 0;
    public int v = 0;
    public int w = 0;
    public int x;
    public int y;
    public int z;

    public s2(Class<?> cls, String str, Object[] objArr) {
        this.f3408c = cls;
        t2 t2Var = new t2(str);
        this.f3406a = t2Var;
        this.f3407b = objArr;
        this.f3409d = t2Var.a();
        int a2 = this.f3406a.a();
        this.f3410e = a2;
        int[] iArr = null;
        if (a2 == 0) {
            this.f3411f = 0;
            this.f3412g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.l = 0;
            this.k = 0;
            this.m = 0;
            this.n = null;
            return;
        }
        this.f3411f = this.f3406a.a();
        this.f3412g = this.f3406a.a();
        this.h = this.f3406a.a();
        this.i = this.f3406a.a();
        this.l = this.f3406a.a();
        this.k = this.f3406a.a();
        this.j = this.f3406a.a();
        this.m = this.f3406a.a();
        int a3 = this.f3406a.a();
        this.n = a3 != 0 ? new int[a3] : iArr;
        this.o = (this.f3411f << 1) + this.f3412g;
    }

    public static Field b(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + name.length() + String.valueOf(str).length() + 40);
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c7, code lost:
        if (d() != false) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0129, code lost:
        if (r3 != false) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0130, code lost:
        if (d() != false) goto L_0x0132;
     */
    public final boolean a() {
        int i2;
        Object obj;
        t2 t2Var = this.f3406a;
        boolean z2 = false;
        if (!(t2Var.f3419b < t2Var.f3418a.length())) {
            return false;
        }
        this.x = this.f3406a.a();
        int a2 = this.f3406a.a();
        this.y = a2;
        this.z = a2 & BuildConfig.VERSION_CODE;
        int i3 = this.x;
        if (i3 < this.q) {
            this.q = i3;
        }
        int i4 = this.x;
        if (i4 > this.r) {
            this.r = i4;
        }
        int i5 = this.z;
        if (i5 == u0.MAP.f3432b) {
            this.s++;
        } else if (i5 >= u0.DOUBLE_LIST.f3432b && i5 <= u0.GROUP_LIST.f3432b) {
            this.t++;
        }
        int i6 = this.w + 1;
        this.w = i6;
        if (w2.s(this.q, this.x, i6)) {
            int i7 = this.x + 1;
            this.v = i7;
            i2 = i7 - this.q;
        } else {
            i2 = this.u + 1;
        }
        this.u = i2;
        if ((this.y & 1024) != 0) {
            int[] iArr = this.n;
            int i8 = this.p;
            this.p = i8 + 1;
            iArr[i8] = this.x;
        }
        this.D = null;
        this.E = null;
        this.F = null;
        if (this.z > u0.MAP.f3432b) {
            this.A = this.f3406a.a();
            int i9 = this.z;
            if (!(i9 == u0.MESSAGE.f3432b + 51 || i9 == u0.GROUP.f3432b + 51)) {
                if (i9 == u0.ENUM.f3432b + 51) {
                }
                return true;
            }
            obj = c();
            this.D = obj;
            return true;
        }
        this.C = b(this.f3408c, (String) c());
        if (e()) {
            this.B = this.f3406a.a();
        }
        int i10 = this.z;
        if (i10 == u0.MESSAGE.f3432b || i10 == u0.GROUP.f3432b) {
            obj = this.C.getType();
            this.D = obj;
            return true;
        }
        if (!(i10 == u0.MESSAGE_LIST.f3432b || i10 == u0.GROUP_LIST.f3432b)) {
            if (i10 != u0.ENUM.f3432b && i10 != u0.ENUM_LIST.f3432b && i10 != u0.ENUM_LIST_PACKED.f3432b) {
                if (i10 == u0.MAP.f3432b) {
                    this.F = c();
                    if ((this.y & 2048) != 0) {
                        z2 = true;
                    }
                }
                return true;
            }
        }
        obj = c();
        this.D = obj;
        return true;
        this.E = c();
        return true;
    }

    public final Object c() {
        Object[] objArr = this.f3407b;
        int i2 = this.o;
        this.o = i2 + 1;
        return objArr[i2];
    }

    public final boolean d() {
        return (this.f3409d & 1) == 1;
    }

    public final boolean e() {
        return d() && this.z <= u0.GROUP.f3432b;
    }
}
