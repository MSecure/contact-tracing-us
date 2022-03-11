package e.w;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import e.i.i.m;
import java.util.concurrent.atomic.AtomicInteger;

public class s {
    public static final y a;
    public static final Property<View, Float> b = new a(Float.class, "translationAlpha");

    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(s.a(view));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f2) {
            float floatValue = f2.floatValue();
            s.a.e(view, floatValue);
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
            AtomicInteger atomicInteger = m.a;
            return view.getClipBounds();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Rect rect) {
            AtomicInteger atomicInteger = m.a;
            view.setClipBounds(rect);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = i2 >= 29 ? new x() : i2 >= 23 ? new w() : i2 >= 22 ? new v() : new u();
        new b(Rect.class, "clipBounds");
    }

    public static float a(View view) {
        return a.b(view);
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        a.d(view, i2, i3, i4, i5);
    }
}
