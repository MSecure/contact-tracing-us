package c.b.a.a.d.m;

import android.content.Context;
import android.util.SparseIntArray;
import b.x.t;
import c.b.a.a.d.e;
import c.b.a.a.d.k.a;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final SparseIntArray f3158a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    public e f3159b;

    public v(e eVar) {
        t.C(eVar);
        this.f3159b = eVar;
    }

    public final int a(Context context, a.f fVar) {
        t.C(context);
        t.C(fVar);
        int i = 0;
        if (!fVar.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = fVar.getMinApkVersion();
        int i2 = this.f3158a.get(minApkVersion, -1);
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.f3158a.size()) {
                i = i2;
                break;
            }
            int keyAt = this.f3158a.keyAt(i3);
            if (keyAt > minApkVersion && this.f3158a.get(keyAt) == 0) {
                break;
            }
            i3++;
        }
        if (i == -1) {
            i = this.f3159b.b(context, minApkVersion);
        }
        this.f3158a.put(minApkVersion, i);
        return i;
    }
}
