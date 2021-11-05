package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class b extends y<b, C0099b> implements Object {
    public static final b DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<b> PARSER;
    public int keySize_;
    public c params_;

    /* renamed from: c.b.c.a.i0.b$b  reason: collision with other inner class name */
    public static final class C0099b extends y.a<b, C0099b> implements Object {
        public C0099b(a aVar) {
            super(b.DEFAULT_INSTANCE);
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        y.defaultInstanceMap.put(b.class, bVar);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"keySize_", "params_"});
            case 3:
                return new b();
            case 4:
                return new C0099b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<b> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (b.class) {
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
}
