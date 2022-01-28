package androidx.slice;

import android.os.Parcelable;
import e.y.b;
import e.y.d;
import java.util.Objects;

public final class SliceItemHolderParcelizer {
    public static SliceItemHolder read(b bVar) {
        SliceItemHolder sliceItemHolder = new SliceItemHolder();
        sliceItemHolder.a = bVar.t(sliceItemHolder.a, 1);
        sliceItemHolder.b = bVar.o(sliceItemHolder.b, 2);
        sliceItemHolder.c = bVar.q(sliceItemHolder.c, 3);
        sliceItemHolder.f294d = bVar.l(sliceItemHolder.f294d, 4);
        long j2 = sliceItemHolder.f295e;
        if (bVar.j(5)) {
            j2 = bVar.m();
        }
        sliceItemHolder.f295e = j2;
        return sliceItemHolder;
    }

    public static void write(SliceItemHolder sliceItemHolder, b bVar) {
        Objects.requireNonNull(bVar);
        d dVar = sliceItemHolder.a;
        bVar.u(1);
        bVar.E(dVar);
        Parcelable parcelable = sliceItemHolder.b;
        bVar.u(2);
        bVar.B(parcelable);
        String str = sliceItemHolder.c;
        bVar.u(3);
        bVar.C(str);
        int i2 = sliceItemHolder.f294d;
        bVar.u(4);
        bVar.z(i2);
        long j2 = sliceItemHolder.f295e;
        bVar.u(5);
        bVar.A(j2);
    }
}
