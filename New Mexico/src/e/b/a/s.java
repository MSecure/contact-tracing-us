package e.b.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import e.b.f.d;
import e.b.f.d0;
import e.b.f.f;
import e.b.f.g;
import e.b.f.u;
import e.f.h;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class s {
    public static final Class<?>[] b = {Context.class, AttributeSet.class};
    public static final int[] c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f746d = {16844160};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f747e = {16844156};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f748f = {16844148};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f749g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h  reason: collision with root package name */
    public static final h<String, Constructor<? extends View>> f750h = new h<>();
    public final Object[] a = new Object[2];

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {
        public final View b;
        public final String c;

        /* renamed from: d  reason: collision with root package name */
        public Method f751d;

        /* renamed from: e  reason: collision with root package name */
        public Context f752e;

        public a(View view, String str) {
            this.b = view;
            this.c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Method method;
            if (this.f751d == null) {
                Context context = this.b.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.c, View.class)) != null) {
                            this.f751d = method;
                            this.f752e = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
                int id = this.b.getId();
                if (id == -1) {
                    str = "";
                } else {
                    StringBuilder h2 = f.a.a.a.a.h(" with id '");
                    h2.append(this.b.getContext().getResources().getResourceEntryName(id));
                    h2.append("'");
                    str = h2.toString();
                }
                StringBuilder h3 = f.a.a.a.a.h("Could not find method ");
                h3.append(this.c);
                h3.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                h3.append(this.b.getClass());
                h3.append(str);
                throw new IllegalStateException(h3.toString());
            }
            try {
                this.f751d.invoke(this.f752e, view);
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

    public u d(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    public d0 e(Context context, AttributeSet attributeSet) {
        return new d0(context, attributeSet);
    }

    public View f() {
        return null;
    }

    public final View g(Context context, String str, String str2) {
        String str3;
        h<String, Constructor<? extends View>> hVar = f750h;
        Constructor<? extends View> orDefault = hVar.getOrDefault(str, null);
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
            orDefault = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(b);
            hVar.put(str, orDefault);
        }
        orDefault.setAccessible(true);
        return (View) orDefault.newInstance(this.a);
    }

    public final void h(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }
}
