package e.i.i.d0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

public final class f {
    public final c a;

    public static final class a implements c {
        public final InputContentInfo a;

        public a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = new InputContentInfo(uri, clipDescription, uri2);
        }

        public a(Object obj) {
            this.a = (InputContentInfo) obj;
        }

        @Override // e.i.i.d0.f.c
        public void a() {
            this.a.requestPermission();
        }

        @Override // e.i.i.d0.f.c
        public Uri b() {
            return this.a.getLinkUri();
        }

        @Override // e.i.i.d0.f.c
        public ClipDescription c() {
            return this.a.getDescription();
        }

        @Override // e.i.i.d0.f.c
        public Object d() {
            return this.a;
        }

        @Override // e.i.i.d0.f.c
        public Uri e() {
            return this.a.getContentUri();
        }
    }

    public static final class b implements c {
        public final Uri a;
        public final ClipDescription b;
        public final Uri c;

        public b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = uri;
            this.b = clipDescription;
            this.c = uri2;
        }

        @Override // e.i.i.d0.f.c
        public void a() {
        }

        @Override // e.i.i.d0.f.c
        public Uri b() {
            return this.c;
        }

        @Override // e.i.i.d0.f.c
        public ClipDescription c() {
            return this.b;
        }

        @Override // e.i.i.d0.f.c
        public Object d() {
            return null;
        }

        @Override // e.i.i.d0.f.c
        public Uri e() {
            return this.a;
        }
    }

    public interface c {
        void a();

        Uri b();

        ClipDescription c();

        Object d();

        Uri e();
    }

    public f(c cVar) {
        this.a = cVar;
    }
}
