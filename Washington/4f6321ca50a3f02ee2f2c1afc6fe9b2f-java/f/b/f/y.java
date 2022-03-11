package f.b.f;

import f.a.a.a.a;

public class y implements s0 {
    public static final y a = new y();

    @Override // f.b.f.s0
    public boolean a(Class<?> cls) {
        return z.class.isAssignableFrom(cls);
    }

    @Override // f.b.f.s0
    public r0 b(Class<?> cls) {
        if (z.class.isAssignableFrom(cls)) {
            try {
                return (r0) z.getDefaultInstance(cls.asSubclass(z.class)).buildMessageInfo();
            } catch (Exception e2) {
                StringBuilder h2 = a.h("Unable to get message info for ");
                h2.append(cls.getName());
                throw new RuntimeException(h2.toString(), e2);
            }
        } else {
            StringBuilder h3 = a.h("Unsupported message type: ");
            h3.append(cls.getName());
            throw new IllegalArgumentException(h3.toString());
        }
    }
}
