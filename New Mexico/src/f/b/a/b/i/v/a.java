package f.b.a.b.i.v;

import android.util.SparseArray;
import f.b.a.b.d;
import java.util.EnumMap;
/* loaded from: classes.dex */
public final class a {
    public static SparseArray<d> a = new SparseArray<>();
    public static EnumMap<d, Integer> b;

    static {
        EnumMap<d, Integer> enumMap = new EnumMap<>(d.class);
        b = enumMap;
        enumMap.put((EnumMap<d, Integer>) d.DEFAULT, (d) 0);
        b.put((EnumMap<d, Integer>) d.VERY_LOW, (d) 1);
        b.put((EnumMap<d, Integer>) d.HIGHEST, (d) 2);
        for (d dVar : b.keySet()) {
            a.append(b.get(dVar).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i2) {
        d dVar = a.get(i2);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(f.a.a.a.a.u("Unknown Priority for value ", i2));
    }
}
