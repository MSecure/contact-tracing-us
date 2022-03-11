package f.b.a.e.a;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class d extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> b = new d();
    public final WeakHashMap<Drawable, Integer> a = new WeakHashMap<>();

    public d() {
        super(Integer.class, "drawableAlphaCompat");
    }

    @Override // android.util.Property
    public Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    public void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
