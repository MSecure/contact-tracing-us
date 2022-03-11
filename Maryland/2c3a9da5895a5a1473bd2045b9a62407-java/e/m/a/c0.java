package e.m.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import e.b.a.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class c0<E> extends y {
    public final Activity b;
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f1584d;

    /* renamed from: e  reason: collision with root package name */
    public final f0 f1585e = new h0();

    public c0(r rVar) {
        Handler handler = new Handler();
        this.b = rVar;
        m.h.o(rVar, "context == null");
        this.c = rVar;
        m.h.o(handler, "handler == null");
        this.f1584d = handler;
    }

    public abstract void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract E j();

    public abstract LayoutInflater k();

    public abstract boolean l(l lVar);

    public abstract void m();
}
