package b.b.k;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import b.b.q.d;
import b.b.q.f;
import b.b.q.g;
import b.b.q.r;
import b.b.q.z;
import b.e.h;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class q {

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?>[] f405b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f406c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f407d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e  reason: collision with root package name */
    public static final h<String, Constructor<? extends View>> f408e = new h<>();

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f409a = new Object[2];

    public static class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final View f410b;

        /* renamed from: c  reason: collision with root package name */
        public final String f411c;

        /* renamed from: d  reason: collision with root package name */
        public Method f412d;

        /* renamed from: e  reason: collision with root package name */
        public Context f413e;

        public a(View view, String str) {
            this.f410b = view;
            this.f411c = str;
        }

        public void onClick(View view) {
            String str;
            Method method;
            if (this.f412d == null) {
                Context context = this.f410b.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.f411c, View.class)) != null) {
                            this.f412d = method;
                            this.f413e = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
                int id = this.f410b.getId();
                if (id == -1) {
                    str = "";
                } else {
                    StringBuilder g = c.a.a.a.a.g(" with id '");
                    g.append(this.f410b.getContext().getResources().getResourceEntryName(id));
                    g.append("'");
                    str = g.toString();
                }
                StringBuilder g2 = c.a.a.a.a.g("Could not find method ");
                g2.append(this.f411c);
                g2.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                g2.append(this.f410b.getClass());
                g2.append(str);
                throw new IllegalStateException(g2.toString());
            }
            try {
                this.f412d.invoke(this.f413e, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    public d a(Context context, AttributeSet attributeSet) {
        return new d(context, attributeSet);
    }

    public f b(Context context, AttributeSet attributeSet) {
        return new f(context, attributeSet);
    }

    public g c(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    public r d(Context context, AttributeSet attributeSet) {
        return new r(context, attributeSet, b.b.a.radioButtonStyle);
    }

    public z e(Context context, AttributeSet attributeSet) {
        return new z(context, attributeSet);
    }

    public View f() {
        return null;
    }

    public final View g(Context context, String str, String str2) {
        String str3;
        Constructor<? extends View> orDefault = f408e.getOrDefault(str, null);
        if (orDefault == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            orDefault = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f405b);
            f408e.put(str, orDefault);
        }
        orDefault.setAccessible(true);
        return (View) orDefault.newInstance(this.f409a);
    }

    public final void h(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }
}
