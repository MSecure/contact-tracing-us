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
    public static final Class<?>[] f561b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f562c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f563d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e  reason: collision with root package name */
    public static final h<String, Constructor<? extends View>> f564e = new h<>();

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f565a = new Object[2];

    public static class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final View f566b;

        /* renamed from: c  reason: collision with root package name */
        public final String f567c;

        /* renamed from: d  reason: collision with root package name */
        public Method f568d;

        /* renamed from: e  reason: collision with root package name */
        public Context f569e;

        public a(View view, String str) {
            this.f566b = view;
            this.f567c = str;
        }

        public void onClick(View view) {
            String str;
            Method method;
            if (this.f568d == null) {
                Context context = this.f566b.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.f567c, View.class)) != null) {
                            this.f568d = method;
                            this.f569e = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
                int id = this.f566b.getId();
                if (id == -1) {
                    str = "";
                } else {
                    StringBuilder h = c.a.a.a.a.h(" with id '");
                    h.append(this.f566b.getContext().getResources().getResourceEntryName(id));
                    h.append("'");
                    str = h.toString();
                }
                StringBuilder h2 = c.a.a.a.a.h("Could not find method ");
                h2.append(this.f567c);
                h2.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                h2.append(this.f566b.getClass());
                h2.append(str);
                throw new IllegalStateException(h2.toString());
            }
            try {
                this.f568d.invoke(this.f569e, view);
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
        Constructor<? extends View> orDefault = f564e.getOrDefault(str, null);
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
            orDefault = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f561b);
            f564e.put(str, orDefault);
        }
        orDefault.setAccessible(true);
        return (View) orDefault.newInstance(this.f565a);
    }

    public final void h(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }
}
