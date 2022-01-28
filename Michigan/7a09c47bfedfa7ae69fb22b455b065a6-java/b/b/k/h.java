package b.b.k;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import b.b.p.a;
import b.e.c;
import b.e.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class h {

    /* renamed from: b  reason: collision with root package name */
    public static final c<WeakReference<h>> f517b = new c<>();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f518c = new Object();

    public static h d(Activity activity, g gVar) {
        return new i(activity, null, gVar, activity);
    }

    public static h e(Dialog dialog, g gVar) {
        return new i(dialog.getContext(), dialog.getWindow(), gVar, dialog);
    }

    public static void j(h hVar) {
        synchronized (f518c) {
            Iterator<WeakReference<h>> it = f517b.iterator();
            while (true) {
                g.a aVar = (g.a) it;
                if (aVar.hasNext()) {
                    h hVar2 = (h) ((WeakReference) aVar.next()).get();
                    if (hVar2 == hVar || hVar2 == null) {
                        aVar.remove();
                    }
                }
            }
        }
    }

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void f();

    public abstract void g();

    public abstract void h(Bundle bundle);

    public abstract void i();

    public abstract boolean k(int i);

    public abstract void l(int i);

    public abstract void m(View view);

    public abstract void n(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void o(CharSequence charSequence);

    public abstract a p(a.AbstractC0012a aVar);
}
