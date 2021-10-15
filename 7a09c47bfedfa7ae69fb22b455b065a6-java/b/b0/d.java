package b.b0;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<a> f1023a = new HashSet();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f1024a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1025b;

        public a(Uri uri, boolean z) {
            this.f1024a = uri;
            this.f1025b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1025b == aVar.f1025b && this.f1024a.equals(aVar.f1024a);
        }

        public int hashCode() {
            return (this.f1024a.hashCode() * 31) + (this.f1025b ? 1 : 0);
        }
    }

    public int a() {
        return this.f1023a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.f1023a.equals(((d) obj).f1023a);
    }

    public int hashCode() {
        return this.f1023a.hashCode();
    }
}
