package androidx.slice;

import b.z.b;

public final class SliceSpecParcelizer {
    public static SliceSpec read(b bVar) {
        SliceSpec sliceSpec = new SliceSpec();
        sliceSpec.f407a = bVar.n(sliceSpec.f407a, 1);
        sliceSpec.f408b = bVar.k(sliceSpec.f408b, 2);
        return sliceSpec;
    }

    public static void write(SliceSpec sliceSpec, b bVar) {
        if (bVar != null) {
            bVar.v(sliceSpec.f407a, 1);
            bVar.t(sliceSpec.f408b, 2);
            return;
        }
        throw null;
    }
}
