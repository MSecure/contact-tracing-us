package c.b.d;

import c.a.a.a.a;
import c.b.d.n0;
import java.lang.reflect.Field;

public final class e0 implements Comparable<e0> {

    /* renamed from: b  reason: collision with root package name */
    public final Field f5249b;

    /* renamed from: c  reason: collision with root package name */
    public final g0 f5250c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<?> f5251d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5252e;

    /* renamed from: f  reason: collision with root package name */
    public final Field f5253f;

    /* renamed from: g  reason: collision with root package name */
    public final int f5254g;
    public final boolean h;
    public final boolean i;
    public final v1 j;
    public final Field k;
    public final Class<?> l;
    public final Object m;
    public final n0.d n;

    public e0(Field field, int i2, g0 g0Var, Class<?> cls, Field field2, int i3, boolean z, boolean z2, v1 v1Var, Class<?> cls2, Object obj, n0.d dVar, Field field3) {
        this.f5249b = field;
        this.f5250c = g0Var;
        this.f5251d = cls;
        this.f5252e = i2;
        this.f5253f = field2;
        this.f5254g = i3;
        this.h = z;
        this.i = z2;
        this.j = v1Var;
        this.l = cls2;
        this.m = obj;
        this.n = dVar;
        this.k = field3;
    }

    public static void b(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(a.n("fieldNumber must be positive: ", i2));
        }
    }

    public static e0 d(Field field, int i2, g0 g0Var, boolean z) {
        b(i2);
        n0.b(field, "field");
        n0.b(g0Var, "fieldType");
        if (g0Var != g0.MESSAGE_LIST && g0Var != g0.GROUP_LIST) {
            return new e0(field, i2, g0Var, null, null, 0, false, z, null, null, null, null, null);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static e0 f(Field field, int i2, Object obj, n0.d dVar) {
        n0.b(obj, "mapDefaultEntry");
        b(i2);
        n0.b(field, "field");
        return new e0(field, i2, g0.MAP, null, null, 0, false, true, null, null, obj, dVar, null);
    }

    public static e0 i(Field field, int i2, g0 g0Var, Field field2) {
        b(i2);
        n0.b(field, "field");
        n0.b(g0Var, "fieldType");
        if (g0Var != g0.MESSAGE_LIST && g0Var != g0.GROUP_LIST) {
            return new e0(field, i2, g0Var, null, null, 0, false, false, null, null, null, null, field2);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static e0 k(Field field, int i2, g0 g0Var, Class<?> cls) {
        b(i2);
        n0.b(field, "field");
        n0.b(g0Var, "fieldType");
        n0.b(cls, "messageClass");
        return new e0(field, i2, g0Var, cls, null, 0, false, false, null, null, null, null, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(e0 e0Var) {
        return this.f5252e - e0Var.f5252e;
    }
}
