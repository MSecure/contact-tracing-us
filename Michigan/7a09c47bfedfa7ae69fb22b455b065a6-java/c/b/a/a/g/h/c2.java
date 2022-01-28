package c.b.a.a.g.h;

import java.io.IOException;

public class c2 extends IOException {
    public c2(String str) {
        super(str);
    }

    public static c2 a() {
        return new c2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static c2 b() {
        return new c2("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static c2 c() {
        return new c2("Protocol message contained an invalid tag (zero).");
    }

    public static b2 d() {
        return new b2("Protocol message tag had invalid wire type.");
    }

    public static c2 e() {
        return new c2("Failed to parse the message.");
    }

    public static c2 f() {
        return new c2("Protocol message had invalid UTF-8.");
    }
}
