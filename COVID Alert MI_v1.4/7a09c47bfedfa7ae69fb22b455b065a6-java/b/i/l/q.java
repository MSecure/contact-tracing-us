package b.i.l;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import gov.michigan.MiCovidExposure.network.DiagnosisKeyUploader;
import java.lang.reflect.Method;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static Method f1879a;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f1879a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }

    public static float a(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = f1879a) != null) {
            try {
                return (float) ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static float b(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : a(viewConfiguration, context);
    }

    public static int c(ViewConfiguration viewConfiguration) {
        return Build.VERSION.SDK_INT >= 28 ? viewConfiguration.getScaledHoverSlop() : viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static boolean d(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", DiagnosisKeyUploader.PLATFORM);
        return identifier != 0 && resources.getBoolean(identifier);
    }
}
