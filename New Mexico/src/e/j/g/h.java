package e.j.g;

import android.content.Context;
import e.j.g.j;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class h implements Callable<j.a> {
    public final /* synthetic */ String a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ e c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f1594d;

    public h(String str, Context context, e eVar, int i2) {
        this.a = str;
        this.b = context;
        this.c = eVar;
        this.f1594d = i2;
    }

    @Override // java.util.concurrent.Callable
    public j.a call() {
        return j.a(this.a, this.b, this.c, this.f1594d);
    }
}
