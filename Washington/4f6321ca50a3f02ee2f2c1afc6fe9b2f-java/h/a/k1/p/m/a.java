package h.a.k1.p.m;

public enum a {
    NO_ERROR(0, -1, 0),
    PROTOCOL_ERROR(1, 1, 1),
    INVALID_STREAM(1, 2, -1),
    UNSUPPORTED_VERSION(1, 4, -1),
    STREAM_IN_USE(1, 8, -1),
    STREAM_ALREADY_CLOSED(1, 9, -1),
    INTERNAL_ERROR(2, 6, 2),
    FLOW_CONTROL_ERROR(3, 7, -1),
    STREAM_CLOSED(5, -1, -1),
    FRAME_TOO_LARGE(6, 11, -1),
    REFUSED_STREAM(7, 3, -1),
    CANCEL(8, 5, -1),
    COMPRESSION_ERROR(9, -1, -1),
    CONNECT_ERROR(10, -1, -1),
    ENHANCE_YOUR_CALM(11, -1, -1),
    INADEQUATE_SECURITY(12, -1, -1),
    HTTP_1_1_REQUIRED(13, -1, -1),
    INVALID_CREDENTIALS(-1, 10, -1);
    
    public final int b;

    /* access modifiers changed from: public */
    a(int i2, int i3, int i4) {
        this.b = i2;
    }

    public static a a(int i2) {
        a[] values = values();
        for (int i3 = 0; i3 < 18; i3++) {
            a aVar = values[i3];
            if (aVar.b == i2) {
                return aVar;
            }
        }
        return null;
    }
}
