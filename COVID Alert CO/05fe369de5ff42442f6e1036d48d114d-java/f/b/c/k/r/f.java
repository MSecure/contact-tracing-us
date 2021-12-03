package f.b.c.k.r;

import f.a.a.a.a;

public final class f {
    public static final f b = new f(null);
    public final String a;

    public f(String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        String str = this.a;
        String str2 = ((f) obj).a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.f(a.i("User(uid:"), this.a, ")");
    }
}
