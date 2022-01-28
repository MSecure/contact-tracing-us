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

public class i0 {
    public static final int[] a = {16842912};
    public static final int[] b = new int[0];
    public static final Rect c = new Rect();

    public static class a {
        public static final boolean a;
        public static final Method b;
        public static final Field c;

        /* renamed from: d  reason: collision with root package name */
        public static final Field f902d;

        /* renamed from: e  reason: collision with root package name */
        public static final Field f903e;

        /* renamed from: f  reason: collision with root package name */
        public static final Field f904f;

        /* JADX WARNING: Removed duplicated region for block: B:43:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0058  */
        static {
            boolean z;
            Field field;
            Field field2;
            Field field3;
            Method method;
            Field field4;
            try {
                Class<?> cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", new Class[0]);
                try {
                    field3 = cls.getField("left");
                } catch (NoSuchMethodException unused) {
                    field3 = null;
                    field2 = field3;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (ClassNotFoundException unused2) {
                    field3 = null;
                    field2 = field3;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (NoSuchFieldException unused3) {
                    field3 = null;
                    field2 = field3;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                }
                try {
                    field2 = cls.getField("top");
                } catch (NoSuchMethodException unused4) {
                    field2 = null;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (ClassNotFoundException unused5) {
                    field2 = null;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (NoSuchFieldException unused6) {
                    field2 = null;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                }
                try {
                    field = cls.getField("right");
                    try {
                        field4 = cls.getField("bottom");
                        z = true;
                    } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused7) {
                        field4 = null;
                        z = false;
                        if (!z) {
                        }
                    }
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused8) {
                    field = null;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                }
            } catch (NoSuchMethodException unused9) {
                method = null;
                field3 = null;
                field2 = field3;
                field = field2;
                field4 = null;
                z = false;
                if (!z) {
                }
            } catch (ClassNotFoundException unused10) {
                method = null;
                field3 = null;
                field2 = field3;
                field = field2;
                field4 = null;
                z = false;
                if (!z) {
                }
            } catch (NoSuchFieldException unused11) {
                method = null;
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
                f902d = field2;
                f903e = field;
                f904f = field4;
                a = true;
                return;
            }
            b = null;
            c = null;
            f902d = null;
            f903e = null;
            f904f = null;
            a = false;
        }
    }

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
        if (drawable instanceof e.i.c.m.b) {
            drawable2 = ((e.i.c.m.b) drawable).a();
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
        Drawable L1 = m.e.L1(drawable);
        boolean z = a.a;
        if (i2 < 29 && a.a) {
            try {
                Object invoke = a.b.invoke(L1, new Object[0]);
                if (invoke != null) {
                    return new Rect(a.c.getInt(invoke), a.f902d.getInt(invoke), a.f903e.getInt(invoke), a.f904f.getInt(invoke));
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
