package f.b.a.b.h.b;

import android.util.SparseArray;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class u extends Enum<u> {
    public static final u b;
    public static final u c;

    /* renamed from: d  reason: collision with root package name */
    public static final u f2417d;

    /* renamed from: e  reason: collision with root package name */
    public static final u f2418e;

    /* renamed from: f  reason: collision with root package name */
    public static final u f2419f;

    /* renamed from: g  reason: collision with root package name */
    public static final u f2420g;

    /* renamed from: h  reason: collision with root package name */
    public static final SparseArray<u> f2421h;

    static {
        u uVar = new u("DEFAULT", 0);
        b = uVar;
        u uVar2 = new u("UNMETERED_ONLY", 1);
        c = uVar2;
        u uVar3 = new u("UNMETERED_OR_DAILY", 2);
        f2417d = uVar3;
        u uVar4 = new u("FAST_IF_RADIO_AWAKE", 3);
        f2418e = uVar4;
        u uVar5 = new u("NEVER", 4);
        f2419f = uVar5;
        u uVar6 = new u("UNRECOGNIZED", 5);
        f2420g = uVar6;
        SparseArray<u> sparseArray = new SparseArray<>();
        f2421h = sparseArray;
        sparseArray.put(0, uVar);
        sparseArray.put(1, uVar2);
        sparseArray.put(2, uVar3);
        sparseArray.put(3, uVar4);
        sparseArray.put(4, uVar5);
        sparseArray.put(-1, uVar6);
    }

    public u(String str, int i2) {
    }
}
