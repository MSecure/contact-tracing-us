package b.v;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import b.i.l.m;

public class v {

    /* renamed from: a  reason: collision with root package name */
    public static final b0 f1832a = (Build.VERSION.SDK_INT >= 29 ? new a0() : new z());

    /* renamed from: b  reason: collision with root package name */
    public static final Property<View, Float> f1833b = new a(Float.class, "translationAlpha");

    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(v.b(view));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f) {
            float floatValue = f.floatValue();
            v.f1832a.e(view, floatValue);
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
            return m.i(view);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Rect rect) {
            m.X(view, rect);
        }
    }

    static {
        new b(Rect.class, "clipBounds");
    }

    public static u a(View view) {
        return new t(view);
    }

    public static float b(View view) {
        return f1832a.b(view);
    }

    public static f0 c(View view) {
        return new e0(view);
    }

    public static void d(View view, int i, int i2, int i3, int i4) {
        f1832a.d(view, i, i2, i3, i4);
    }
}
