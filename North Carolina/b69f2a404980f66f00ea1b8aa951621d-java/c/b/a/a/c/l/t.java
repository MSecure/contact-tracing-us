package c.b.a.a.c.l;

import android.app.Activity;
import android.content.Intent;

public final class t extends e {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f2482b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f2483c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2484d;

    public t(Intent intent, Activity activity, int i) {
        this.f2482b = intent;
        this.f2483c = activity;
        this.f2484d = i;
    }

    @Override // c.b.a.a.c.l.e
    public final void a() {
        Intent intent = this.f2482b;
        if (intent != null) {
            this.f2483c.startActivityForResult(intent, this.f2484d);
        }
    }
}
