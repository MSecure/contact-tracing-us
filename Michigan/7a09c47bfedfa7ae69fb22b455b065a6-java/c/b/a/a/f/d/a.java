package c.b.a.a.f.d;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public final class a implements Callable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f3194a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3195b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Boolean f3196c;

    public a(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f3194a = sharedPreferences;
        this.f3195b = str;
        this.f3196c = bool;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() {
        return Boolean.valueOf(this.f3194a.getBoolean(this.f3195b, this.f3196c.booleanValue()));
    }
}
