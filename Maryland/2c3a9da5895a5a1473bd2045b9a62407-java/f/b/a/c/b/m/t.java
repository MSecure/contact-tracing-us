package f.b.a.c.b.m;

import android.content.Context;
import android.util.SparseIntArray;
import f.b.a.c.b.e;
import f.b.a.c.b.l.a;
import java.util.Objects;

public final class t {
    public final SparseIntArray a = new SparseIntArray();
    public e b;

    public t(e eVar) {
        Objects.requireNonNull(eVar, "null reference");
        this.b = eVar;
    }

    public final int a(Context context, a.e eVar) {
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(eVar, "null reference");
        int i2 = 0;
        if (!eVar.o()) {
            return 0;
        }
        int p = eVar.p();
        int i3 = this.a.get(p, -1);
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= this.a.size()) {
                i2 = i3;
                break;
            }
            int keyAt = this.a.keyAt(i4);
            if (keyAt > p && this.a.get(keyAt) == 0) {
                break;
            }
            i4++;
        }
        if (i2 == -1) {
            i2 = this.b.b(context, p);
        }
        this.a.put(p, i2);
        return i2;
    }
}
