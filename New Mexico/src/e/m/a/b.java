package e.m.a;

import android.view.View;
import e.m.a.a;
import e.m.a.b;
import java.util.ArrayList;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class b<T extends b<T>> implements a.b {

    /* renamed from: l */
    public static final k f1700l = new c("scaleX");
    public static final k m = new d("scaleY");
    public static final k n = new e("rotation");
    public static final k o = new f("rotationX");
    public static final k p = new g("rotationY");
    public static final k q = new a("alpha");

    /* renamed from: d */
    public final Object f1701d;

    /* renamed from: e */
    public final c f1702e;

    /* renamed from: i */
    public float f1706i;
    public float a = 0.0f;
    public float b = Float.MAX_VALUE;
    public boolean c = false;

    /* renamed from: f */
    public boolean f1703f = false;

    /* renamed from: g */
    public float f1704g = -3.4028235E38f;

    /* renamed from: h */
    public long f1705h = 0;

    /* renamed from: j */
    public final ArrayList<i> f1707j = new ArrayList<>();

    /* renamed from: k */
    public final ArrayList<j> f1708k = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class a extends k {
        public a(String str) {
            super(str, null);
        }

        @Override // e.m.a.c
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // e.m.a.c
        public void b(Object obj, float f2) {
            ((View) obj).setAlpha(f2);
        }
    }

    /* renamed from: e.m.a.b$b */
    /* loaded from: classes.dex */
    public static class C0049b extends k {
    }

    /* loaded from: classes.dex */
    public static class c extends k {
        public c(String str) {
            super(str, null);
        }

        @Override // e.m.a.c
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // e.m.a.c
        public void b(Object obj, float f2) {
            ((View) obj).setScaleX(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends k {
        public d(String str) {
            super(str, null);
        }

        @Override // e.m.a.c
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // e.m.a.c
        public void b(Object obj, float f2) {
            ((View) obj).setScaleY(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends k {
        public e(String str) {
            super(str, null);
        }

        @Override // e.m.a.c
        public float a(View view) {
            return view.getRotation();
        }

        @Override // e.m.a.c
        public void b(Object obj, float f2) {
            ((View) obj).setRotation(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class f extends k {
        public f(String str) {
            super(str, null);
        }

        @Override // e.m.a.c
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // e.m.a.c
        public void b(Object obj, float f2) {
            ((View) obj).setRotationX(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class g extends k {
        public g(String str) {
            super(str, null);
        }

        @Override // e.m.a.c
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // e.m.a.c
        public void b(Object obj, float f2) {
            ((View) obj).setRotationY(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class h {
        public float a;
        public float b;
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(b bVar, boolean z, float f2, float f3);
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(b bVar, float f2, float f3);
    }

    /* loaded from: classes.dex */
    public static abstract class k extends c<View> {
        public k(String str, C0049b bVar) {
            super(str);
        }
    }

    public <K> b(K k2, c<K> cVar) {
        float f2;
        this.f1701d = k2;
        this.f1702e = cVar;
        if (cVar == n || cVar == o || cVar == p) {
            f2 = 0.1f;
        } else if (cVar == q || cVar == f1700l || cVar == m) {
            this.f1706i = 0.00390625f;
            return;
        } else {
            f2 = 1.0f;
        }
        this.f1706i = f2;
    }

    public static <T> void b(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    @Override // e.m.a.a.b
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean a(long j2) {
        boolean z;
        double d2;
        float f2;
        long j3 = this.f1705h;
        if (j3 == 0) {
            this.f1705h = j2;
            c(this.b);
            return false;
        }
        long j4 = j2 - j3;
        this.f1705h = j2;
        d dVar = (d) this;
        if (dVar.t) {
            float f3 = dVar.s;
            if (f3 != Float.MAX_VALUE) {
                dVar.r.f1714i = (double) f3;
                dVar.s = Float.MAX_VALUE;
            }
            dVar.b = (float) dVar.r.f1714i;
            dVar.a = 0.0f;
            dVar.t = false;
        } else {
            int i2 = (dVar.s > Float.MAX_VALUE ? 1 : (dVar.s == Float.MAX_VALUE ? 0 : -1));
            e eVar = dVar.r;
            if (i2 != 0) {
                double d3 = eVar.f1714i;
                j4 /= 2;
                h b = eVar.b((double) dVar.b, (double) dVar.a, j4);
                eVar = dVar.r;
                eVar.f1714i = (double) dVar.s;
                dVar.s = Float.MAX_VALUE;
                d2 = (double) b.a;
                f2 = b.b;
            } else {
                d2 = (double) dVar.b;
                f2 = dVar.a;
            }
            h b2 = eVar.b(d2, (double) f2, j4);
            float f4 = b2.a;
            dVar.b = f4;
            dVar.a = b2.b;
            float max = Math.max(f4, dVar.f1704g);
            dVar.b = max;
            float min = Math.min(max, Float.MAX_VALUE);
            dVar.b = min;
            float f5 = dVar.a;
            e eVar2 = dVar.r;
            Objects.requireNonNull(eVar2);
            if (((double) Math.abs(f5)) < eVar2.f1710e && ((double) Math.abs(min - ((float) eVar2.f1714i))) < eVar2.f1709d) {
                dVar.b = (float) dVar.r.f1714i;
                dVar.a = 0.0f;
            } else {
                z = false;
                float min2 = Math.min(this.b, Float.MAX_VALUE);
                this.b = min2;
                float max2 = Math.max(min2, this.f1704g);
                this.b = max2;
                c(max2);
                if (z) {
                    this.f1703f = false;
                    a a2 = a.a();
                    a2.a.remove(this);
                    int indexOf = a2.b.indexOf(this);
                    if (indexOf >= 0) {
                        a2.b.set(indexOf, null);
                        a2.f1699f = true;
                    }
                    this.f1705h = 0;
                    this.c = false;
                    for (int i3 = 0; i3 < this.f1707j.size(); i3++) {
                        if (this.f1707j.get(i3) != null) {
                            this.f1707j.get(i3).a(this, false, this.b, this.a);
                        }
                    }
                    b(this.f1707j);
                }
                return z;
            }
        }
        z = true;
        float min22 = Math.min(this.b, Float.MAX_VALUE);
        this.b = min22;
        float max22 = Math.max(min22, this.f1704g);
        this.b = max22;
        c(max22);
        if (z) {
        }
        return z;
    }

    public void c(float f2) {
        this.f1702e.b(this.f1701d, f2);
        for (int i2 = 0; i2 < this.f1708k.size(); i2++) {
            if (this.f1708k.get(i2) != null) {
                this.f1708k.get(i2).a(this, this.b, this.a);
            }
        }
        b(this.f1708k);
    }
}
