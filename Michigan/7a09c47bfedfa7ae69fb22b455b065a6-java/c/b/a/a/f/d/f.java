package c.b.a.a.f.d;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public final class f implements Callable<SharedPreferences> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3207a;

    public f(Context context) {
        this.f3207a = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ SharedPreferences call() {
        return this.f3207a.getSharedPreferences("google_sdk_flags", 0);
    }
}
