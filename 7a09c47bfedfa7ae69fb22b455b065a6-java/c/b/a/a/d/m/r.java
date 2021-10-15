package c.b.a.a.d.m;

import android.app.Activity;
import android.content.Intent;

public final class r extends p {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f3150b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f3151c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f3152d;

    public r(Intent intent, Activity activity, int i) {
        this.f3150b = intent;
        this.f3151c = activity;
        this.f3152d = i;
    }

    @Override // c.b.a.a.d.m.p
    public final void a() {
        Intent intent = this.f3150b;
        if (intent != null) {
            this.f3151c.startActivityForResult(intent, this.f3152d);
        }
    }
}
