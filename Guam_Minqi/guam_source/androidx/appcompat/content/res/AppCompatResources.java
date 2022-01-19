package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.ResourceManagerInternal;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
public final class AppCompatResources {
    public static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal<>();
    public static final Object sColorStateCacheLock = new Object();
    public static final WeakHashMap<Context, SparseArray<Object>> sColorStateCaches = new WeakHashMap<>(0);

    public static ColorStateList getColorStateList(Context context, int i) {
        return context.getColorStateList(i);
    }

    public static Drawable getDrawable(Context context, int i) {
        return ResourceManagerInternal.get().getDrawable(context, i);
    }
}
