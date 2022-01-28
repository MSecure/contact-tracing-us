package androidx.slice;

import b.z.b;
import b.z.c;
import b.z.d;

public final class SliceItemHolderParcelizer {
    public static SliceItemHolder read(b bVar) {
        SliceItemHolder sliceItemHolder = new SliceItemHolder();
        sliceItemHolder.f402a = bVar.p(sliceItemHolder.f402a, 1);
        sliceItemHolder.f403b = bVar.l(sliceItemHolder.f403b, 2);
        sliceItemHolder.f404c = bVar.n(sliceItemHolder.f404c, 3);
        sliceItemHolder.f405d = bVar.k(sliceItemHolder.f405d, 4);
        long j = sliceItemHolder.f406e;
        if (bVar.i(5)) {
            j = ((c) bVar).f2791e.readLong();
        }
        sliceItemHolder.f406e = j;
        return sliceItemHolder;
    }

    public static void write(SliceItemHolder sliceItemHolder, b bVar) {
        if (bVar != null) {
            d dVar = sliceItemHolder.f402a;
            bVar.q(1);
            bVar.w(dVar);
            bVar.u(sliceItemHolder.f403b, 2);
            bVar.v(sliceItemHolder.f404c, 3);
            bVar.t(sliceItemHolder.f405d, 4);
            long j = sliceItemHolder.f406e;
            bVar.q(5);
            ((c) bVar).f2791e.writeLong(j);
            return;
        }
        throw null;
    }
}
