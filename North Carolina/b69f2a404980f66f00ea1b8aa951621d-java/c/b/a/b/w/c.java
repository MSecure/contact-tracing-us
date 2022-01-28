package c.b.a.b.w;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

public interface c {

    public static class b implements TypeEvaluator<e> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<e> f3211b = new b();

        /* renamed from: a  reason: collision with root package name */
        public final e f3212a = new e(null);

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public e evaluate(float f, e eVar, e eVar2) {
            e eVar3 = eVar;
            e eVar4 = eVar2;
            e eVar5 = this.f3212a;
            float z1 = c.b.a.a.c.n.c.z1(eVar3.f3215a, eVar4.f3215a, f);
            float z12 = c.b.a.a.c.n.c.z1(eVar3.f3216b, eVar4.f3216b, f);
            float z13 = c.b.a.a.c.n.c.z1(eVar3.f3217c, eVar4.f3217c, f);
            eVar5.f3215a = z1;
            eVar5.f3216b = z12;
            eVar5.f3217c = z13;
            return this.f3212a;
        }
    }

    /* renamed from: c.b.a.b.w.c$c  reason: collision with other inner class name */
    public static class C0072c extends Property<c, e> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<c, e> f3213a = new C0072c("circularReveal");

        public C0072c(String str) {
            super(e.class, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public e get(c cVar) {
            return cVar.getRevealInfo();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(c cVar, e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    public static class d extends Property<c, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<c, Integer> f3214a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public float f3215a;

        /* renamed from: b  reason: collision with root package name */
        public float f3216b;

        /* renamed from: c  reason: collision with root package name */
        public float f3217c;

        public e() {
        }

        public e(float f, float f2, float f3) {
            this.f3215a = f;
            this.f3216b = f2;
            this.f3217c = f3;
        }

        public e(a aVar) {
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(e eVar);
}
