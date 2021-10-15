package b.x;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import b.i.l.m;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f2726a = (Build.VERSION.SDK_INT >= 29 ? new b0() : new a0());

    /* renamed from: b  reason: collision with root package name */
    public static final Property<View, Float> f2727b = new a(Float.class, "translationAlpha");

    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(w.b(view));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f2) {
            float floatValue = f2.floatValue();
            w.f2726a.e(view, floatValue);
        }
    }

    public static class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Rect get(View view) {
            return m.j(view);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Rect rect) {
            m.Y(view, rect);
        }
    }

    static {
        new b(Rect.class, "clipBounds");
    }

    public static v a(View view) {
        return new u(view);
    }

    public static float b(View view) {
        return f2726a.b(view);
    }

    public static g0 c(View view) {
        return new f0(view);
    }

    public static void d(View view, int i, int i2, int i3, int i4) {
        f2726a.d(view, i, i2, i3, i4);
    }
}
