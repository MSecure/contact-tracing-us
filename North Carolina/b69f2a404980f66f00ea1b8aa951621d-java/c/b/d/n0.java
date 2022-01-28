package c.b.d;

import java.io.IOException;

public class n0 extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public h1 f4007b = null;

    public static class a extends n0 {
        public a(String str) {
            super(str);
        }
    }

    public n0(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public n0(String str) {
        super(str);
    }

    public static n0 a() {
        return new n0("Protocol message end-group tag did not match expected tag.");
    }

    public static n0 b() {
        return new n0("Protocol message contained an invalid tag (zero).");
    }

    public static n0 c() {
        return new n0("Protocol message had invalid UTF-8.");
    }

    public static a d() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static n0 e() {
        return new n0("CodedInputStream encountered a malformed varint.");
    }

    public static n0 f() {
        return new n0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static n0 g() {
        return new n0("Failed to parse the message.");
    }

    public static n0 h() {
        return new n0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static n0 i() {
        return new n0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public IOException j() {
        return getCause() instanceof IOException ? (IOException) getCause() : this;
    }
}
