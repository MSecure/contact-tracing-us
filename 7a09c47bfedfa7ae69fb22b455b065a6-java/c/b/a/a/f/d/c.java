package c.b.a.a.f.d;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public final class c implements Callable<Long> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f3200a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3201b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Long f3202c;

    public c(SharedPreferences sharedPreferences, String str, Long l) {
        this.f3200a = sharedPreferences;
        this.f3201b = str;
        this.f3202c = l;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() {
        return Long.valueOf(this.f3200a.getLong(this.f3201b, this.f3202c.longValue()));
    }
}
