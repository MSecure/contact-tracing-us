package androidx.transition;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

public class ViewUtils {
    public static final ViewUtilsBase IMPL;
    public static final Property<View, Float> TRANSITION_ALPHA = new Property<View, Float>(Float.class, "translationAlpha") {
        /* class androidx.transition.ViewUtils.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(ViewUtils.getTransitionAlpha(view));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f) {
            float floatValue = f.floatValue();
            ViewUtils.IMPL.setTransitionAlpha(view, floatValue);
        }
    };

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            IMPL = new ViewUtilsApi29();
        } else {
            IMPL = new ViewUtilsApi23();
        }
        new Property<View, Rect>(Rect.class, "clipBounds") {
            /* class androidx.transition.ViewUtils.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.util.Property
            public Rect get(View view) {
                return ViewCompat.getClipBounds(view);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // android.util.Property
            public void set(View view, Rect rect) {
                ViewCompat.setClipBounds(view, rect);
            }
        };
    }

    public static ViewOverlayImpl getOverlay(View view) {
        return new ViewOverlayApi18(view);
    }

    public static float getTransitionAlpha(View view) {
        return IMPL.getTransitionAlpha(view);
    }

    public static WindowIdImpl getWindowId(View view) {
        return new WindowIdApi18(view);
    }

    public static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }
}
