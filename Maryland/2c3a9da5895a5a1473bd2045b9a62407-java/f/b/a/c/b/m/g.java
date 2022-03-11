package f.b.a.c.b.m;

import android.content.ServiceConnection;
import android.net.Uri;
import e.b.a.m;
import java.util.Arrays;

public abstract class g {
    public static final Object a = new Object();
    public static g b;

    public static final class a {

        /* renamed from: e  reason: collision with root package name */
        public static final Uri f2563e = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
        public final String a;
        public final String b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f2564d;

        public a(String str, String str2, int i2, boolean z) {
            m.h.m(str);
            this.a = str;
            m.h.m(str2);
            this.b = str2;
            this.c = i2;
            this.f2564d = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.h.U(this.a, aVar.a) && m.h.U(this.b, aVar.b) && m.h.U(null, null) && this.c == aVar.c && this.f2564d == aVar.f2564d;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b, null, Integer.valueOf(this.c), Boolean.valueOf(this.f2564d)});
        }

        public final String toString() {
            String str = this.a;
            if (str != null) {
                return str;
            }
            throw null;
        }
    }

    public abstract boolean a(a aVar, ServiceConnection serviceConnection, String str);

    public abstract void b(a aVar, ServiceConnection serviceConnection, String str);
}
