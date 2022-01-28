package c.b.a.a.c.l;

import android.content.Context;
import android.util.SparseIntArray;
import b.b.k.i;
import c.b.a.a.c.e;
import c.b.a.a.c.k.a;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final SparseIntArray f2469a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    public e f2470b;

    public i(e eVar) {
        i.j.s(eVar);
        this.f2470b = eVar;
    }

    public int a(Context context, a.f fVar) {
        i.j.s(context);
        i.j.s(fVar);
        int i = 0;
        if (!fVar.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = fVar.getMinApkVersion();
        int i2 = this.f2469a.get(minApkVersion, -1);
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.f2469a.size()) {
                i = i2;
                break;
            }
            int keyAt = this.f2469a.keyAt(i3);
            if (keyAt > minApkVersion && this.f2469a.get(keyAt) == 0) {
                break;
            }
            i3++;
        }
        if (i == -1) {
            i = this.f2470b.b(context, minApkVersion);
        }
        this.f2469a.put(minApkVersion, i);
        return i;
    }
}
