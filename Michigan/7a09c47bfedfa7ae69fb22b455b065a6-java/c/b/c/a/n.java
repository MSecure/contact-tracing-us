package c.b.c.a;

import c.a.a.a.a;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final CopyOnWriteArrayList<m> f5212a = new CopyOnWriteArrayList<>();

    public static m a(String str) {
        Iterator<m> it = f5212a.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next.b(str)) {
                return next;
            }
        }
        throw new GeneralSecurityException(a.q("No KMS client does support: ", str));
    }
}
