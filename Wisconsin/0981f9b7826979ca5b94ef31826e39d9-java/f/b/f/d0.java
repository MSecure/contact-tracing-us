package f.b.f;

import java.io.IOException;

public class d0 extends IOException {
    public t0 b;

    public static class a extends d0 {
        public a(String str) {
            super(str);
        }
    }

    public d0(String str) {
        super(str);
    }

    public static d0 a() {
        return new d0("Protocol message end-group tag did not match expected tag.");
    }

    public static d0 b() {
        return new d0("Protocol message contained an invalid tag (zero).");
    }

    public static d0 c() {
        return new d0("Protocol message had invalid UTF-8.");
    }

    public static a d() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static d0 e() {
        return new d0("CodedInputStream encountered a malformed varint.");
    }

    public static d0 f() {
        return new d0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static d0 g() {
        return new d0("Failed to parse the message.");
    }

    public static d0 h() {
        return new d0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
