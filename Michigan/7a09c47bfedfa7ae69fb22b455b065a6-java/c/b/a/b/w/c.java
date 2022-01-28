package c.b.a.b.w;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import b.x.t;

public interface c {

    public static class b implements TypeEvaluator<e> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<e> f4532b = new b();

        /* renamed from: a  reason: collision with root package name */
        public final e f4533a = new e(null);

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public e evaluate(float f2, e eVar, e eVar2) {
            e eVar3 = eVar;
            e eVar4 = eVar2;
            e eVar5 = this.f4533a;
            float c2 = t.c2(eVar3.f4536a, eVar4.f4536a, f2);
            float c22 = t.c2(eVar3.f4537b, eVar4.f4537b, f2);
            float c23 = t.c2(eVar3.f4538c, eVar4.f4538c, f2);
            eVar5.f4536a = c2;
            eVar5.f4537b = c22;
            eVar5.f4538c = c23;
            return this.f4533a;
        }
    }

    /* renamed from: c.b.a.b.w.c$c  reason: collision with other inner class name */
    public static class C0081c extends Property<c, e> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<c, e> f4534a = new C0081c("circularReveal");

        public C0081c(String str) {
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
        public static final Property<c, Integer> f4535a = new d("circularRevealScrimColor");

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
        public float f4536a;

        /* renamed from: b  reason: collision with root package name */
        public float f4537b;

        /* renamed from: c  reason: collision with root package name */
        public float f4538c;

        public e() {
        }

        public e(float f2, float f3, float f4) {
            this.f4536a = f2;
            this.f4537b = f3;
            this.f4538c = f4;
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
