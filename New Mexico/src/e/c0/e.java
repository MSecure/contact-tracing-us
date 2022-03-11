package e.c0;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class e {
    public final Set<a> a = new HashSet();

    /* loaded from: classes.dex */
    public static final class a {
        public final Uri a;
        public final boolean b;

        public a(Uri uri, boolean z) {
            this.a = uri;
            this.b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.a.equals(aVar.a);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + (this.b ? 1 : 0);
        }
    }

    public int a() {
        return this.a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((e) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
