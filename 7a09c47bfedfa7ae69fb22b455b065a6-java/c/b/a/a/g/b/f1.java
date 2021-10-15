package c.b.a.a.g.b;

import java.io.IOException;

public class f1 extends IOException {
    public f1(String str) {
        super(str);
    }

    public static f1 a() {
        return new f1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static f1 b() {
        return new f1("Protocol message contained an invalid tag (zero).");
    }

    public static g1 c() {
        return new g1("Protocol message tag had invalid wire type.");
    }

    public static f1 d() {
        return new f1("Failed to parse the message.");
    }

    public static f1 e() {
        return new f1("Protocol message had invalid UTF-8.");
    }
}
