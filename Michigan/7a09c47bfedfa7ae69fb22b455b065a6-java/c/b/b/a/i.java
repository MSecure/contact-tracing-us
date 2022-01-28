package c.b.b.a;

import java.util.Arrays;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f4660a;

    /* renamed from: b  reason: collision with root package name */
    public final a f4661b;

    /* renamed from: c  reason: collision with root package name */
    public a f4662c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4663d = false;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f4664a;

        /* renamed from: b  reason: collision with root package name */
        public Object f4665b;

        /* renamed from: c  reason: collision with root package name */
        public a f4666c;

        public a(h hVar) {
        }
    }

    public i(String str, h hVar) {
        a aVar = new a(null);
        this.f4661b = aVar;
        this.f4662c = aVar;
        this.f4660a = str;
    }

    public final i a(String str, Object obj) {
        a aVar = new a(null);
        this.f4662c.f4666c = aVar;
        this.f4662c = aVar;
        aVar.f4665b = obj;
        if (str != null) {
            aVar.f4664a = str;
            return this;
        }
        throw null;
    }

    public String toString() {
        boolean z = this.f4663d;
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f4660a);
        sb.append('{');
        String str = "";
        for (a aVar = this.f4661b.f4666c; aVar != null; aVar = aVar.f4666c) {
            Object obj = aVar.f4665b;
            if (!z || obj != null) {
                sb.append(str);
                String str2 = aVar.f4664a;
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
