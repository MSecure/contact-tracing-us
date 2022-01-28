package c.b.c.a.j0.a;

import c.b.c.a.j0.a.a;
import c.b.c.a.j0.a.a.AbstractC0100a;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.r0;
import java.io.IOException;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0100a<MessageType, BuilderType>> implements r0 {
    public int memoizedHashCode = 0;

    /* renamed from: c.b.c.a.j0.a.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0100a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0100a<MessageType, BuilderType>> implements r0.a {
    }

    public int b(f1 f1Var) {
        y yVar = (y) this;
        int i = yVar.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int f2 = f1Var.f(this);
        yVar.memoizedSerializedSize = f2;
        return f2;
    }

    public final String c(String str) {
        StringBuilder h = c.a.a.a.a.h("Serializing ");
        h.append(getClass().getName());
        h.append(" to a ");
        h.append(str);
        h.append(" threw an IOException (should never happen).");
        return h.toString();
    }

    @Override // c.b.c.a.j0.a.r0
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            l N = l.N(bArr);
            a(N);
            if (N.O() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            throw new RuntimeException(c("byte array"), e2);
        }
    }

    @Override // c.b.c.a.j0.a.r0
    public i toByteString() {
        try {
            i.e o = i.o(getSerializedSize());
            a(o.f4938a);
            return o.a();
        } catch (IOException e2) {
            throw new RuntimeException(c("ByteString"), e2);
        }
    }
}
