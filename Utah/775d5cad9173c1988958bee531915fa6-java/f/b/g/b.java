package f.b.g;

import f.b.g.t0;
import f.b.g.z;
import java.util.Objects;

public abstract class b<MessageType extends t0> implements b1<MessageType> {
    static {
        r.a();
    }

    @Override // f.b.g.b1
    public Object a(k kVar, r rVar) {
        z parsePartialFrom = z.parsePartialFrom(((z.b) this).a, kVar, rVar);
        b(parsePartialFrom);
        return parsePartialFrom;
    }

    public final MessageType b(MessageType messagetype) {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        q1 newUninitializedMessageException = messagetype instanceof a ? ((a) messagetype).newUninitializedMessageException() : new q1();
        Objects.requireNonNull(newUninitializedMessageException);
        d0 d0Var = new d0(newUninitializedMessageException.getMessage());
        d0Var.b = messagetype;
        throw d0Var;
    }
}
