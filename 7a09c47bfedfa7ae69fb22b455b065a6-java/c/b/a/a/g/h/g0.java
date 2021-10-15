package c.b.a.a.g.h;

import c.b.a.a.g.h.g0;
import c.b.a.a.g.h.j0;
import java.io.IOException;

public abstract class g0<MessageType extends g0<MessageType, BuilderType>, BuilderType extends j0<MessageType, BuilderType>> implements c3 {
    public int zzte = 0;

    @Override // c.b.a.a.g.h.c3
    public final q0 c() {
        try {
            w0 g2 = q0.g(d());
            f(g2.f4051a);
            return g2.a();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder("ByteString".length() + name.length() + 62);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }
}
