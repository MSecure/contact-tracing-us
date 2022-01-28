package androidx.slice;

import e.y.b;
import java.util.Objects;

public final class SliceSpecParcelizer {
    public static SliceSpec read(b bVar) {
        SliceSpec sliceSpec = new SliceSpec();
        sliceSpec.a = bVar.q(sliceSpec.a, 1);
        sliceSpec.b = bVar.l(sliceSpec.b, 2);
        return sliceSpec;
    }

    public static void write(SliceSpec sliceSpec, b bVar) {
        Objects.requireNonNull(bVar);
        String str = sliceSpec.a;
        bVar.u(1);
        bVar.C(str);
        int i2 = sliceSpec.b;
        bVar.u(2);
        bVar.z(i2);
    }
}
