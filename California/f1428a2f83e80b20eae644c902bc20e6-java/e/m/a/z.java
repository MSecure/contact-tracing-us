package e.m.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import e.b.a.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class z<E> extends v {
    public final Activity b;
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f1693d;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f1694e = new e0();

    public z(o oVar) {
        Handler handler = new Handler();
        this.b = oVar;
        m.h.o(oVar, "context == null");
        this.c = oVar;
        m.h.o(handler, "handler == null");
        this.f1693d = handler;
    }

    public abstract void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract E j();

    public abstract LayoutInflater k();

    public abstract boolean l(l lVar);

    public abstract void m();
}
