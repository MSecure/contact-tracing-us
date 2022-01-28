package e.m.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import e.b.a.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class b0<E> extends x {
    public final Activity b;
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f1407d;

    /* renamed from: e  reason: collision with root package name */
    public final e0 f1408e = new f0();

    public b0(r rVar) {
        Handler handler = new Handler();
        this.b = rVar;
        m.h.o(rVar, "context == null");
        this.c = rVar;
        m.h.o(handler, "handler == null");
        this.f1407d = handler;
    }

    public abstract void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract E j();

    public abstract LayoutInflater k();

    public abstract boolean l(m mVar);

    public abstract void m();
}
