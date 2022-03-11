package e.o.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import e.b.a.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class b0<E> extends x {
    public final Activity b;
    public final Context c;

    /* renamed from: d */
    public final Handler f1764d;

    /* renamed from: e */
    public final e0 f1765e = new f0();

    public b0(r rVar) {
        Handler handler = new Handler();
        this.b = rVar;
        m.e.q(rVar, "context == null");
        this.c = rVar;
        m.e.q(handler, "handler == null");
        this.f1764d = handler;
    }

    public abstract void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract E j();

    public abstract LayoutInflater k();

    public abstract boolean l(m mVar);

    public abstract void m();
}
