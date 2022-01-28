package c.b.c.a.j0.a;

import java.io.IOException;

public class b0 extends IOException {

    public static class a extends b0 {
        public a(String str) {
            super(str);
        }
    }

    public b0(String str) {
        super(str);
    }

    public static b0 a() {
        return new b0("Protocol message end-group tag did not match expected tag.");
    }

    public static b0 b() {
        return new b0("Protocol message contained an invalid tag (zero).");
    }

    public static b0 c() {
        return new b0("Protocol message had invalid UTF-8.");
    }

    public static a d() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static b0 e() {
        return new b0("CodedInputStream encountered a malformed varint.");
    }

    public static b0 f() {
        return new b0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static b0 g() {
        return new b0("Failed to parse the message.");
    }

    public static b0 h() {
        return new b0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
