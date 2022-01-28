package c.b.b.a;

import java.util.Arrays;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f3323a;

    /* renamed from: b  reason: collision with root package name */
    public final a f3324b;

    /* renamed from: c  reason: collision with root package name */
    public a f3325c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3326d = false;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f3327a;

        /* renamed from: b  reason: collision with root package name */
        public Object f3328b;

        /* renamed from: c  reason: collision with root package name */
        public a f3329c;

        public a(h hVar) {
        }
    }

    public i(String str, h hVar) {
        a aVar = new a(null);
        this.f3324b = aVar;
        this.f3325c = aVar;
        this.f3323a = str;
    }

    public i a(String str, int i) {
        b(str, String.valueOf(i));
        return this;
    }

    public final i b(String str, Object obj) {
        a aVar = new a(null);
        this.f3325c.f3329c = aVar;
        this.f3325c = aVar;
        aVar.f3328b = obj;
        if (str != null) {
            aVar.f3327a = str;
            return this;
        }
        throw null;
    }

    public String toString() {
        boolean z = this.f3326d;
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f3323a);
        sb.append('{');
        String str = "";
        for (a aVar = this.f3324b.f3329c; aVar != null; aVar = aVar.f3329c) {
            Object obj = aVar.f3328b;
            if (!z || obj != null) {
                sb.append(str);
                String str2 = aVar.f3327a;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
