package androidx.slice;

import e.y.b;
import java.util.Objects;

public final class SliceParcelizer {
    public static Slice read(b bVar) {
        Slice slice = new Slice();
        slice.a = (SliceSpec) bVar.t(slice.a, 1);
        slice.b = (SliceItem[]) bVar.f(slice.b, 2);
        slice.c = (String[]) bVar.f(slice.c, 3);
        slice.f291d = bVar.q(slice.f291d, 4);
        return slice;
    }

    public static void write(Slice slice, b bVar) {
        Objects.requireNonNull(bVar);
        SliceSpec sliceSpec = slice.a;
        bVar.u(1);
        bVar.E(sliceSpec);
        bVar.v(slice.b, 2);
        bVar.v(slice.c, 3);
        String str = slice.f291d;
        bVar.u(4);
        bVar.C(str);
    }
}
