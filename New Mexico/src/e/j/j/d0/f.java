package e.j.j.d0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;
/* loaded from: classes.dex */
public final class f {
    public final c a;

    /* loaded from: classes.dex */
    public static final class a implements c {
        public final InputContentInfo a;

        public a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = new InputContentInfo(uri, clipDescription, uri2);
        }

        public a(Object obj) {
            this.a = (InputContentInfo) obj;
        }

        @Override // e.j.j.d0.f.c
        public void a() {
            this.a.requestPermission();
        }

        @Override // e.j.j.d0.f.c
        public Uri b() {
            return this.a.getLinkUri();
        }

        @Override // e.j.j.d0.f.c
        public ClipDescription c() {
            return this.a.getDescription();
        }

        @Override // e.j.j.d0.f.c
        public Object d() {
            return this.a;
        }

        @Override // e.j.j.d0.f.c
        public Uri e() {
            return this.a.getContentUri();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements c {
        public final Uri a;
        public final ClipDescription b;
        public final Uri c;

        public b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = uri;
            this.b = clipDescription;
            this.c = uri2;
        }

        @Override // e.j.j.d0.f.c
        public void a() {
        }

        @Override // e.j.j.d0.f.c
        public Uri b() {
            return this.c;
        }

        @Override // e.j.j.d0.f.c
        public ClipDescription c() {
            return this.b;
        }

        @Override // e.j.j.d0.f.c
        public Object d() {
            return null;
        }

        @Override // e.j.j.d0.f.c
        public Uri e() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
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
