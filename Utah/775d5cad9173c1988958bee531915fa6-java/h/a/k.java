package h.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public interface k extends l, s {

    public static final class a implements k {
        @Override // h.a.l, h.a.s
        public String a() {
            return "gzip";
        }

        @Override // h.a.s
        public InputStream b(InputStream inputStream) {
            return new GZIPInputStream(inputStream);
        }

        @Override // h.a.l
        public OutputStream c(OutputStream outputStream) {
            return new GZIPOutputStream(outputStream);
        }
    }

    public static final class b implements k {
        public static final k a = new b();

        @Override // h.a.l, h.a.s
        public String a() {
            return "identity";
        }

        @Override // h.a.s
        public InputStream b(InputStream inputStream) {
            return inputStream;
        }

        @Override // h.a.l
        public OutputStream c(OutputStream outputStream) {
            return outputStream;
        }
    }
}
