package c.b.a.a.f.d;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public final class d implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f3203a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3204b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f3205c;

    public d(SharedPreferences sharedPreferences, String str, String str2) {
        this.f3203a = sharedPreferences;
        this.f3204b = str;
        this.f3205c = str2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        return this.f3203a.getString(this.f3204b, this.f3205c);
    }
}
