package e.b.f;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import e.b.a.m;
import e.b.b.a.c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class i0 {
    public static final int[] a = {16842912};
    public static final int[] b = new int[0];
    public static final Rect c = new Rect();

    /* loaded from: classes.dex */
    public static class a {
        public static final boolean a;
        public static final Method b;
        public static final Field c;

        /* renamed from: d  reason: collision with root package name */
        public static final Field f966d;

        /* renamed from: e  reason: collision with root package name */
        public static final Field f967e;

        /* renamed from: f  reason: collision with root package name */
        public static final Field f968f;

        /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
        static {
            boolean z;
            Field field;
            Field field2;
            Field field3;
            Method method;
            Field field4;
            Class<?> cls;
            try {
                cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", new Class[0]);
            } catch (ClassNotFoundException unused) {
                method = null;
                field3 = null;
            } catch (NoSuchFieldException unused2) {
                method = null;
                field3 = null;
            } catch (NoSuchMethodException unused3) {
                method = null;
                field3 = null;
            }
            try {
                field3 = cls.getField("left");
                try {
                    field2 = cls.getField("top");
                    try {
                        field = cls.getField("right");
                    } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused4) {
                        field = null;
                    }
                    try {
                        field4 = cls.getField("bottom");
                        z = true;
                    } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused5) {
                        field4 = null;
                        z = false;
                        if (!z) {
                        }
                    }
                } catch (ClassNotFoundException unused6) {
                    field2 = null;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (NoSuchFieldException unused7) {
                    field2 = null;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (NoSuchMethodException unused8) {
                    field2 = null;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                }
            } catch (ClassNotFoundException unused9) {
                field3 = null;
                field2 = field3;
                field = field2;
                field4 = null;
                z = false;
                if (!z) {
                }
            } catch (NoSuchFieldException unused10) {
                field3 = null;
                field2 = field3;
                field = field2;
                field4 = null;
                z = false;
                if (!z) {
                }
            } catch (NoSuchMethodException unused11) {
                field3 = null;
                field2 = field3;
                field = field2;
                field4 = null;
                z = false;
                if (!z) {
                }
            }
            if (!z) {
                b = method;
                c = field3;
                f966d = field2;
                f967e = field;
                f968f = field4;
                a = true;
                return;
            }
            b = null;
            c = null;
            f966d = null;
            f967e = null;
            f968f = null;
            a = false;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static boolean a(Drawable drawable) {
        Drawable drawable2;
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable drawable3 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!a(drawable3)) {
                    return false;
                }
            }
            return true;
        }
        if (drawable instanceof e.j.c.m.b) {
            drawable2 = ((e.j.c.m.b) drawable).a();
        } else if (drawable instanceof c) {
            return a(((c) drawable).b);
        } else {
            if (!(drawable instanceof ScaleDrawable)) {
                return true;
            }
            drawable2 = ((ScaleDrawable) drawable).getDrawable();
        }
        return a(drawable2);
    }

    public static void b(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) || (i2 >= 29 && i2 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name))) {
            c(drawable);
        }
    }

    public static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(a);
        } else {
            drawable.setState(b);
        }
        drawable.setState(state);
    }

    public static Rect d(Drawable drawable) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            Insets a2 = b.a(drawable);
            return new Rect(a2.left, a2.top, a2.right, a2.bottom);
        }
        Drawable T1 = m.e.T1(drawable);
        boolean z = a.a;
        if (i2 < 29 && a.a) {
            try {
                Object invoke = a.b.invoke(T1, new Object[0]);
                if (invoke != null) {
                    return new Rect(a.c.getInt(invoke), a.f966d.getInt(invoke), a.f967e.getInt(invoke), a.f968f.getInt(invoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return c;
    }

    public static PorterDuff.Mode e(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
