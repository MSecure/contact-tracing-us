package f.b.a.d.a.i0;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.j;
import f.b.g.z;
import java.util.Objects;
/* loaded from: classes.dex */
public final class b extends z<b, C0091b> implements Object {
    private static final b DEFAULT_INSTANCE;
    private static volatile b1<b> PARSER;
    public static final int RESPONSE_STATUS_FIELD_NUMBER;
    public static final int SHARES_FIELD_NUMBER;
    private int bitField0_;
    private e responseStatus_;
    private c0.i<j> shares_ = z.emptyProtobufList();

    /* renamed from: f.b.a.d.a.i0.b$b */
    /* loaded from: classes.dex */
    public static final class C0091b extends z.a<b, C0091b> implements Object {
        public C0091b() {
            super(b.DEFAULT_INSTANCE);
        }

        public C0091b(a aVar) {
            super(b.DEFAULT_INSTANCE);
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        z.registerDefaultInstance(b.class, bVar);
    }

    public static void c(b bVar, e eVar) {
        Objects.requireNonNull(bVar);
        eVar.getClass();
        bVar.responseStatus_ = eVar;
        bVar.bitField0_ |= 1;
    }

    public static C0091b f() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static b g(byte[] bArr) {
        return (b) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public e d() {
        e eVar = this.responseStatus_;
        return eVar == null ? e.e() : eVar;
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\t\u0000\u0002\u001c", new Object[]{"bitField0_", "responseStatus_", "shares_"});
            case 3:
                return new b();
            case 4:
                return new C0091b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<b> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (b.class) {
                        b1Var = PARSER;
                        if (b1Var == null) {
                            b1Var = new z.b<>(DEFAULT_INSTANCE);
                            PARSER = b1Var;
                        }
                    }
                }
                return b1Var;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public j e(int i2) {
        return this.shares_.get(i2);
    }
}
