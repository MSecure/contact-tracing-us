package e.b;

import java.io.InputStream;

public interface a {

    /* renamed from: e.b.a$a  reason: collision with other inner class name */
    public interface AbstractC0113a<T extends AbstractC0113a> {
    }

    public interface b {
        String a();

        boolean b();

        String c();

        InputStream d();

        String value();
    }

    public enum c {
        GET(false),
        POST(true),
        PUT(true),
        DELETE(false),
        PATCH(true),
        HEAD(false),
        OPTIONS(false),
        TRACE(false);
        

        /* renamed from: b  reason: collision with root package name */
        public final boolean f4801b;

        /* access modifiers changed from: public */
        c(boolean z) {
            this.f4801b = z;
        }
    }

    public interface d extends AbstractC0113a<d> {
    }

    public interface e extends AbstractC0113a<e> {
    }
}
