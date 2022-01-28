package c.b.c.a.i0;

import c.b.c.a.j0.a.a0;
import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class v0 extends y<v0, b> implements Object {
    public static final v0 DEFAULT_INSTANCE;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    public static volatile y0<v0> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    public int keyMaterialType_;
    public String typeUrl_ = "";
    public i value_ = i.f3564c;

    public enum c implements a0.a {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f3508b;

        /* access modifiers changed from: public */
        c(int i2) {
            this.f3508b = i2;
        }

        public static c b(int i2) {
            if (i2 == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i2 == 1) {
                return SYMMETRIC;
            }
            if (i2 == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i2 == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i2 != 4) {
                return null;
            }
            return REMOTE;
        }

        @Override // c.b.c.a.j0.a.a0.a
        public final int a() {
            if (this != UNRECOGNIZED) {
                return this.f3508b;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        v0 v0Var = new v0();
        DEFAULT_INSTANCE = v0Var;
        y.defaultInstanceMap.put(v0.class, v0Var);
    }

    public static void n(v0 v0Var, String str) {
        if (v0Var != null) {
            str.getClass();
            v0Var.typeUrl_ = str;
            return;
        }
        throw null;
    }

    public static void o(v0 v0Var, i iVar) {
        if (v0Var != null) {
            iVar.getClass();
            v0Var.value_ = iVar;
            return;
        }
        throw null;
    }

    public static void p(v0 v0Var, c cVar) {
        if (v0Var != null) {
            v0Var.keyMaterialType_ = cVar.a();
            return;
        }
        throw null;
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "keyMaterialType_"});
            case 3:
                return new v0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<v0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (v0.class) {
                        y0Var = PARSER;
                        if (y0Var == null) {
                            y0Var = new y.b<>(DEFAULT_INSTANCE);
                            PARSER = y0Var;
                        }
                    }
                }
                return y0Var;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static final class b extends y.a<v0, b> implements Object {
        public b() {
            super(v0.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(v0.DEFAULT_INSTANCE);
        }
    }
}
