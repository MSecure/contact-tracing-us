package c.b.a.a.f.d;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public final class b implements Callable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f3197a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3198b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Integer f3199c;

    public b(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f3197a = sharedPreferences;
        this.f3198b = str;
        this.f3199c = num;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() {
        return Integer.valueOf(this.f3197a.getInt(this.f3198b, this.f3199c.intValue()));
    }
}
