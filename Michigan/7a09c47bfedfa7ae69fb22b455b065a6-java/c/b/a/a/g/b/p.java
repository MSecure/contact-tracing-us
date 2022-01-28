package c.b.a.a.g.b;

import c.b.a.a.g.b.p;
import c.b.a.a.g.b.q;
import java.io.IOException;

public abstract class p<MessageType extends p<MessageType, BuilderType>, BuilderType extends q<MessageType, BuilderType>> implements e2 {
    public static boolean zzey = false;
    public int zzex = 0;

    @Override // c.b.a.a.g.b.e2
    public final y f() {
        try {
            c0 g2 = y.g(d());
            b(g2.f3234a);
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
