package f.b.a.e.j;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public static class b implements TypeEvaluator<e> {
        public static final TypeEvaluator<e> b = new b();
        public final e a = new e(null);

        @Override // android.animation.TypeEvaluator
        public e evaluate(float f2, e eVar, e eVar2) {
            e eVar3 = eVar;
            e eVar4 = eVar2;
            e eVar5 = this.a;
            float c1 = f.b.a.c.b.o.b.c1(eVar3.a, eVar4.a, f2);
            float c12 = f.b.a.c.b.o.b.c1(eVar3.b, eVar4.b, f2);
            float c13 = f.b.a.c.b.o.b.c1(eVar3.c, eVar4.c, f2);
            eVar5.a = c1;
            eVar5.b = c12;
            eVar5.c = c13;
            return this.a;
        }
    }

    /* renamed from: f.b.a.e.j.c$c */
    /* loaded from: classes.dex */
    public static class C0093c extends Property<c, e> {
        public static final Property<c, e> a = new C0093c("circularReveal");

        public C0093c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        public e get(c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        public void set(c cVar, e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends Property<c, Integer> {
        public static final Property<c, Integer> a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public float a;
        public float b;
        public float c;

        public e() {
        }

        public e(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
        }

        public e(a aVar) {
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(e eVar);
}
