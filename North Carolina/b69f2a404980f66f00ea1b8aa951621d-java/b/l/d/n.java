package b.l.d;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import b.b.k.i;

public abstract class n<E> extends j {

    /* renamed from: b  reason: collision with root package name */
    public final Activity f1320b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f1321c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f1322d;

    /* renamed from: e  reason: collision with root package name */
    public final q f1323e = new s();

    public n(d dVar) {
        Handler handler = new Handler();
        this.f1320b = dVar;
        i.j.r(dVar, "context == null");
        this.f1321c = dVar;
        i.j.r(handler, "handler == null");
        this.f1322d = handler;
    }
}
