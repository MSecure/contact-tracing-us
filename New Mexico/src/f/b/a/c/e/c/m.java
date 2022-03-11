package f.b.a.c.e.c;

import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.f.b.d;
import f.b.a.c.i.i;
import java.util.AbstractCollection;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class m extends j1 {
    public final /* synthetic */ i a;

    public m(i iVar) {
        this.a = iVar;
    }

    @Override // f.b.a.c.e.c.k1
    public final void r(Status status, long j2) {
        AbstractCollection abstractCollection;
        Object[] objArr = new Object[4];
        d[] values = d.values();
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            d dVar = values[i3];
            if ((dVar.b & j2) != 0) {
                int i4 = i2 + 1;
                int length = objArr.length;
                if (length < i4) {
                    int i5 = length + (length >> 1) + 1;
                    if (i5 < i4) {
                        int highestOneBit = Integer.highestOneBit(i4 - 1);
                        i5 = highestOneBit + highestOneBit;
                    }
                    if (i5 < 0) {
                        i5 = Integer.MAX_VALUE;
                    }
                    objArr = Arrays.copyOf(objArr, i5);
                }
                objArr[i2] = dVar;
                i2 = i4;
            }
        }
        if (i2 == 0) {
            abstractCollection = e3.f2767j;
        } else if (i2 != 1) {
            abstractCollection = b3.r(i2, objArr);
            abstractCollection.size();
        } else {
            Object obj = objArr[0];
            obj.getClass();
            abstractCollection = new f3(obj);
        }
        m.e.S1(status, abstractCollection, this.a);
    }
}
