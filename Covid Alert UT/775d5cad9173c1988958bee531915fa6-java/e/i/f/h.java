package e.i.f;

import android.content.Context;
import e.i.f.j;
import java.util.concurrent.Callable;

public class h implements Callable<j.a> {
    public final /* synthetic */ String a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ e c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f1509d;

    public h(String str, Context context, e eVar, int i2) {
        this.a = str;
        this.b = context;
        this.c = eVar;
        this.f1509d = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public j.a call() {
        return j.a(this.a, this.b, this.c, this.f1509d);
    }
}
