package c.b.d;

import java.io.IOException;

public class o0 extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public i1 f5447b = null;

    public static class a extends o0 {
        public a(String str) {
            super(str);
        }
    }

    public o0(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public o0(String str) {
        super(str);
    }

    public static o0 a() {
        return new o0("Protocol message end-group tag did not match expected tag.");
    }

    public static o0 b() {
        return new o0("Protocol message contained an invalid tag (zero).");
    }

    public static o0 c() {
        return new o0("Protocol message had invalid UTF-8.");
    }

    public static a d() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static o0 e() {
        return new o0("CodedInputStream encountered a malformed varint.");
    }

    public static o0 f() {
        return new o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static o0 g() {
        return new o0("Failed to parse the message.");
    }

    public static o0 h() {
        return new o0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static o0 i() {
        return new o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public IOException j() {
        return getCause() instanceof IOException ? (IOException) getCause() : this;
    }
}
