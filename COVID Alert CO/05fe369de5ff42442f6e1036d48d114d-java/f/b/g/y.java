package f.b.g;

import f.a.a.a.a;

public class y implements s0 {
    public static final y a = new y();

    @Override // f.b.g.s0
    public boolean a(Class<?> cls) {
        return z.class.isAssignableFrom(cls);
    }

    @Override // f.b.g.s0
    public r0 b(Class<?> cls) {
        if (z.class.isAssignableFrom(cls)) {
            try {
                return (r0) z.getDefaultInstance(cls.asSubclass(z.class)).buildMessageInfo();
            } catch (Exception e2) {
                StringBuilder i2 = a.i("Unable to get message info for ");
                i2.append(cls.getName());
                throw new RuntimeException(i2.toString(), e2);
            }
        } else {
            StringBuilder i3 = a.i("Unsupported message type: ");
            i3.append(cls.getName());
            throw new IllegalArgumentException(i3.toString());
        }
    }
}
