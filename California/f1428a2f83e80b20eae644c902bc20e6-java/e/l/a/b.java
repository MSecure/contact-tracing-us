package e.l.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import e.l.a.a;
import e.l.a.b;
import java.util.ArrayList;
import java.util.Objects;

public abstract class b<T extends b<T>> implements a.b {

    /* renamed from: l  reason: collision with root package name */
    public static final k f1546l = new c("scaleX");
    public static final k m = new d("scaleY");
    public static final k n = new e("rotation");
    public static final k o = new f("rotationX");
    public static final k p = new g("rotationY");
    public static final k q = new a("alpha");
    public float a = 0.0f;
    public float b = Float.MAX_VALUE;
    public boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1547d;

    /* renamed from: e  reason: collision with root package name */
    public final c f1548e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1549f = false;

    /* renamed from: g  reason: collision with root package name */
    public float f1550g = -3.4028235E38f;

    /* renamed from: h  reason: collision with root package name */
    public long f1551h = 0;

    /* renamed from: i  reason: collision with root package name */
    public float f1552i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList<i> f1553j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList<j> f1554k = new ArrayList<>();

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
    public static class C0043b extends k {
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
        public k(String str, C0043b bVar) {
            super(str);
        }
    }

    public <K> b(K k2, c<K> cVar) {
        float f2;
        this.f1547d = k2;
        this.f1548e = cVar;
        if (cVar == n || cVar == o || cVar == p) {
            f2 = 0.1f;
        } else if (cVar == q || cVar == f1546l || cVar == m) {
            this.f1552i = 0.00390625f;
            return;
        } else {
            f2 = 1.0f;
        }
        this.f1552i = f2;
    }

    public static <T> void d(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // e.l.a.a.b
    public boolean a(long j2) {
        double d2;
        float f2;
        long j3 = this.f1551h;
        if (j3 == 0) {
            this.f1551h = j2;
            e(this.b);
            return false;
        }
        long j4 = j2 - j3;
        this.f1551h = j2;
        d dVar = (d) this;
        int i2 = (dVar.s > Float.MAX_VALUE ? 1 : (dVar.s == Float.MAX_VALUE ? 0 : -1));
        e eVar = dVar.r;
        if (i2 != 0) {
            double d3 = eVar.f1560i;
            j4 /= 2;
            h b2 = eVar.b((double) dVar.b, (double) dVar.a, j4);
            eVar = dVar.r;
            eVar.f1560i = (double) dVar.s;
            dVar.s = Float.MAX_VALUE;
            d2 = (double) b2.a;
            f2 = b2.b;
        } else {
            d2 = (double) dVar.b;
            f2 = dVar.a;
        }
        h b3 = eVar.b(d2, (double) f2, j4);
        float f3 = b3.a;
        dVar.b = f3;
        dVar.a = b3.b;
        float max = Math.max(f3, dVar.f1550g);
        dVar.b = max;
        float min = Math.min(max, Float.MAX_VALUE);
        dVar.b = min;
        float f4 = dVar.a;
        e eVar2 = dVar.r;
        Objects.requireNonNull(eVar2);
        boolean z = true;
        if (((double) Math.abs(f4)) < eVar2.f1556e && ((double) Math.abs(min - ((float) eVar2.f1560i))) < eVar2.f1555d) {
            dVar.b = (float) dVar.r.f1560i;
            dVar.a = 0.0f;
        } else {
            z = false;
        }
        float min2 = Math.min(this.b, Float.MAX_VALUE);
        this.b = min2;
        float max2 = Math.max(min2, this.f1550g);
        this.b = max2;
        e(max2);
        if (z) {
            c(false);
        }
        return z;
    }

    public void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.f1549f) {
            c(true);
        }
    }

    public final void c(boolean z) {
        this.f1549f = false;
        a a2 = a.a();
        a2.a.remove(this);
        int indexOf = a2.b.indexOf(this);
        if (indexOf >= 0) {
            a2.b.set(indexOf, null);
            a2.f1545f = true;
        }
        this.f1551h = 0;
        this.c = false;
        for (int i2 = 0; i2 < this.f1553j.size(); i2++) {
            if (this.f1553j.get(i2) != null) {
                this.f1553j.get(i2).a(this, z, this.b, this.a);
            }
        }
        d(this.f1553j);
    }

    public void e(float f2) {
        this.f1548e.b(this.f1547d, f2);
        for (int i2 = 0; i2 < this.f1554k.size(); i2++) {
            if (this.f1554k.get(i2) != null) {
                this.f1554k.get(i2).a(this, this.b, this.a);
            }
        }
        d(this.f1554k);
    }
}
