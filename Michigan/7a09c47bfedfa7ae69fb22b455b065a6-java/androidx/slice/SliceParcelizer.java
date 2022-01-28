package androidx.slice;

import b.z.b;

public final class SliceParcelizer {
    public static Slice read(b bVar) {
        Slice slice = new Slice();
        slice.f393a = (SliceSpec) bVar.p(slice.f393a, 1);
        slice.f394b = (SliceItem[]) bVar.f(slice.f394b, 2);
        slice.f395c = (String[]) bVar.f(slice.f395c, 3);
        slice.f396d = bVar.n(slice.f396d, 4);
        return slice;
    }

    public static void write(Slice slice, b bVar) {
        if (bVar != null) {
            SliceSpec sliceSpec = slice.f393a;
            bVar.q(1);
            bVar.w(sliceSpec);
            bVar.r(slice.f394b, 2);
            bVar.r(slice.f395c, 3);
            bVar.v(slice.f396d, 4);
            return;
        }
        throw null;
    }
}
