package e.i.f;

import android.content.Context;
import android.graphics.Typeface;
import e.i.f.e;
import java.util.concurrent.Callable;

public class b implements Callable<e.d> {
    public final /* synthetic */ Context a;
    public final /* synthetic */ a b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1443d;

    public b(Context context, a aVar, int i2, String str) {
        this.a = context;
        this.b = aVar;
        this.c = i2;
        this.f1443d = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public e.d call() {
        e.d b2 = e.b(this.a, this.b, this.c);
        Typeface typeface = b2.a;
        if (typeface != null) {
            e.a.b(this.f1443d, typeface);
        }
        return b2;
    }
}
