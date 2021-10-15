package b.l.d;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import b.b.k.i;

public abstract class w<E> extends s {

    /* renamed from: b  reason: collision with root package name */
    public final Activity f2142b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f2143c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f2144d;

    /* renamed from: e  reason: collision with root package name */
    public final z f2145e = new a0();

    public w(m mVar) {
        Handler handler = new Handler();
        this.f2142b = mVar;
        i.j.h(mVar, "context == null");
        this.f2143c = mVar;
        i.j.h(handler, "handler == null");
        this.f2144d = handler;
    }
}
