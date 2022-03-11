package f.b.c.k.v;

import f.b.d.a.d;
import f.b.f.b1;
import f.b.f.z;
import java.util.Objects;

public final class a extends z<a, b> implements Object {
    private static final a DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 2;
    public static final int HAS_COMMITTED_MUTATIONS_FIELD_NUMBER = 4;
    public static final int NO_DOCUMENT_FIELD_NUMBER = 1;
    private static volatile b1<a> PARSER = null;
    public static final int UNKNOWN_DOCUMENT_FIELD_NUMBER = 3;
    private int documentTypeCase_ = 0;
    private Object documentType_;
    private boolean hasCommittedMutations_;

    public static final class b extends z.a<a, b> implements Object {
        public b() {
            super(a.DEFAULT_INSTANCE);
        }

        public b(C0117a aVar) {
            super(a.DEFAULT_INSTANCE);
        }

        public b b(boolean z) {
            copyOnWrite();
            a.c((a) this.instance, z);
            return this;
        }
    }

    public enum c {
        NO_DOCUMENT(1),
        DOCUMENT(2),
        UNKNOWN_DOCUMENT(3),
        DOCUMENTTYPE_NOT_SET(0);

        /* access modifiers changed from: public */
        c(int i2) {
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.registerDefaultInstance(a.class, aVar);
    }

    public static void c(a aVar, boolean z) {
        aVar.hasCommittedMutations_ = z;
    }

    public static void d(a aVar, b bVar) {
        Objects.requireNonNull(aVar);
        bVar.getClass();
        aVar.documentType_ = bVar;
        aVar.documentTypeCase_ = 1;
    }

    public static void e(a aVar, d dVar) {
        Objects.requireNonNull(aVar);
        dVar.getClass();
        aVar.documentType_ = dVar;
        aVar.documentTypeCase_ = 2;
    }

    public static void f(a aVar, d dVar) {
        Objects.requireNonNull(aVar);
        dVar.getClass();
        aVar.documentType_ = dVar;
        aVar.documentTypeCase_ = 3;
    }

    public static b l() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static a m(byte[] bArr) {
        return (a) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004\u0007", new Object[]{"documentType_", "documentTypeCase_", b.class, d.class, d.class, "hasCommittedMutations_"});
            case 3:
                return new a();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<a> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (a.class) {
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

    public d g() {
        return this.documentTypeCase_ == 2 ? (d) this.documentType_ : d.f();
    }

    public c h() {
        int i2 = this.documentTypeCase_;
        if (i2 == 0) {
            return c.DOCUMENTTYPE_NOT_SET;
        }
        if (i2 == 1) {
            return c.NO_DOCUMENT;
        }
        if (i2 == 2) {
            return c.DOCUMENT;
        }
        if (i2 != 3) {
            return null;
        }
        return c.UNKNOWN_DOCUMENT;
    }

    public boolean i() {
        return this.hasCommittedMutations_;
    }

    public b j() {
        return this.documentTypeCase_ == 1 ? (b) this.documentType_ : b.e();
    }

    public d k() {
        return this.documentTypeCase_ == 3 ? (d) this.documentType_ : d.e();
    }
}
