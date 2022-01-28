package e.l.a;

import android.view.View;
import e.l.a.a;
import e.l.a.b;
import java.util.ArrayList;
import java.util.Objects;

public abstract class b<T extends b<T>> implements a.b {

    /* renamed from: l  reason: collision with root package name */
    public static final k f1615l = new c("scaleX");
    public static final k m = new d("scaleY");
    public static final k n = new e("rotation");
    public static final k o = new f("rotationX");
    public static final k p = new g("rotationY");
    public static final k q = new a("alpha");
    public float a = 0.0f;
    public float b = Float.MAX_VALUE;
    public boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1616d;

    /* renamed from: e  reason: collision with root package name */
    public final c f1617e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1618f = false;

    /* renamed from: g  reason: collision with root package name */
    public float f1619g = -3.4028235E38f;

    /* renamed from: h  reason: collision with root package name */
    public long f1620h = 0;

    /* renamed from: i  reason: collision with root package name */
    public float f1621i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList<i> f1622j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList<j> f1623k = new ArrayList<>();

    public static class a extends k {
        public a(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.l.a.c
        public float a(View view) {
            return view.getAlpha();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // e.l.a.c
        public void b(View view, float f2) {
            view.setAlpha(f2);
        }
    }

    /* renamed from: e.l.a.b$b  reason: collision with other inner class name */
    public static class C0045b extends k {
    }

    public static class c extends k {
        public c(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.l.a.c
        public float a(View view) {
            return view.getScaleX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // e.l.a.c
        public void b(View view, float f2) {
            view.setScaleX(f2);
        }
    }

    public static class d extends k {
        public d(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.l.a.c
        public float a(View view) {
            return view.getScaleY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // e.l.a.c
        public void b(View view, float f2) {
            view.setScaleY(f2);
        }
    }

    public static class e extends k {
        public e(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.l.a.c
        public float a(View view) {
            return view.getRotation();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // e.l.a.c
        public void b(View view, float f2) {
            view.setRotation(f2);
        }
    }

    public static class f extends k {
        public f(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.l.a.c
        public float a(View view) {
            return view.getRotationX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // e.l.a.c
        public void b(View view, float f2) {
            view.setRotationX(f2);
        }
    }

    public static class g extends k {
        public g(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.l.a.c
        public float a(View view) {
            return view.getRotationY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // e.l.a.c
        public void b(View view, float f2) {
            view.setRotationY(f2);
        }
    }

    public static class h {
        public float a;
        public float b;
    }

    public interface i {
        void a(b bVar, boolean z, float f2, float f3);
    }

    public interface j {
        void a(b bVar, float f2, float f3);
    }

    public static abstract class k extends c<View> {
        public k(String str, C0045b bVar) {
            super(str);
        }
    }

    public <K> b(K k2, c<K> cVar) {
        float f2;
        this.f1616d = k2;
        this.f1617e = cVar;
        if (cVar == n || cVar == o || cVar == p) {
            f2 = 0.1f;
        } else if (cVar == q || cVar == f1615l || cVar == m) {
            this.f1621i = 0.00390625f;
            return;
        } else {
            f2 = 1.0f;
        }
        this.f1621i = f2;
    }

    public static <T> void b(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d8  */
    @Override // e.l.a.a.b
    public boolean a(long j2) {
        boolean z;
        double d2;
        float f2;
        long j3 = this.f1620h;
        if (j3 == 0) {
            this.f1620h = j2;
            c(this.b);
            return false;
        }
        long j4 = j2 - j3;
        this.f1620h = j2;
        d dVar = (d) this;
        if (dVar.t) {
            float f3 = dVar.s;
            if (f3 != Float.MAX_VALUE) {
                dVar.r.f1629i = (double) f3;
                dVar.s = Float.MAX_VALUE;
            }
            dVar.b = (float) dVar.r.f1629i;
            dVar.a = 0.0f;
            dVar.t = false;
        } else {
            int i2 = (dVar.s > Float.MAX_VALUE ? 1 : (dVar.s == Float.MAX_VALUE ? 0 : -1));
            e eVar = dVar.r;
            if (i2 != 0) {
                double d3 = eVar.f1629i;
                j4 /= 2;
                h b2 = eVar.b((double) dVar.b, (double) dVar.a, j4);
                eVar = dVar.r;
                eVar.f1629i = (double) dVar.s;
                dVar.s = Float.MAX_VALUE;
                d2 = (double) b2.a;
                f2 = b2.b;
            } else {
                d2 = (double) dVar.b;
                f2 = dVar.a;
            }
            h b3 = eVar.b(d2, (double) f2, j4);
            float f4 = b3.a;
            dVar.b = f4;
            dVar.a = b3.b;
            float max = Math.max(f4, dVar.f1619g);
            dVar.b = max;
            float min = Math.min(max, Float.MAX_VALUE);
            dVar.b = min;
            float f5 = dVar.a;
            e eVar2 = dVar.r;
            Objects.requireNonNull(eVar2);
            if (((double) Math.abs(f5)) < eVar2.f1625e && ((double) Math.abs(min - ((float) eVar2.f1629i))) < eVar2.f1624d) {
                dVar.b = (float) dVar.r.f1629i;
                dVar.a = 0.0f;
            } else {
                z = false;
                float min2 = Math.min(this.b, Float.MAX_VALUE);
                this.b = min2;
                float max2 = Math.max(min2, this.f1619g);
                this.b = max2;
                c(max2);
                if (z) {
                    this.f1618f = false;
                    a a2 = a.a();
                    a2.a.remove(this);
                    int indexOf = a2.b.indexOf(this);
                    if (indexOf >= 0) {
                        a2.b.set(indexOf, null);
                        a2.f1614f = true;
                    }
                    this.f1620h = 0;
                    this.c = false;
                    for (int i3 = 0; i3 < this.f1622j.size(); i3++) {
                        if (this.f1622j.get(i3) != null) {
                            this.f1622j.get(i3).a(this, false, this.b, this.a);
                        }
                    }
                    b(this.f1622j);
                }
                return z;
            }
        }
        z = true;
        float min22 = Math.min(this.b, Float.MAX_VALUE);
        this.b = min22;
        float max22 = Math.max(min22, this.f1619g);
        this.b = max22;
        c(max22);
        if (z) {
        }
        return z;
    }

    public void c(float f2) {
        this.f1617e.b(this.f1616d, f2);
        for (int i2 = 0; i2 < this.f1623k.size(); i2++) {
            if (this.f1623k.get(i2) != null) {
                this.f1623k.get(i2).a(this, this.b, this.a);
            }
        }
        b(this.f1623k);
    }
}
