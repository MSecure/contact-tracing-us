package b.z;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<a> f1908a = new HashSet();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f1909a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1910b;

        public a(Uri uri, boolean z) {
            this.f1909a = uri;
            this.f1910b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1910b == aVar.f1910b && this.f1909a.equals(aVar.f1909a);
        }

        public int hashCode() {
            return (this.f1909a.hashCode() * 31) + (this.f1910b ? 1 : 0);
        }
    }

    public int a() {
        return this.f1908a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.f1908a.equals(((d) obj).f1908a);
    }

    public int hashCode() {
        return this.f1908a.hashCode();
    }
}
