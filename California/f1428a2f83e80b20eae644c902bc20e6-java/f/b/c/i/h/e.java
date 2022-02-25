package f.b.c.i.h;

import f.b.c.i.d;
import f.b.c.i.f;
import f.b.c.i.g;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class e {

    /* renamed from: e  reason: collision with root package name */
    public static final a f2974e = new a(null);
    public final Map<Class<?>, d<?>> a;
    public final Map<Class<?>, f<?>> b;
    public d<Object> c = a.a;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2975d = false;

    public static final class a implements f<Date> {
        public static final DateFormat a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public a(d dVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // f.b.c.i.b
        public void a(Object obj, g gVar) {
            gVar.a(a.format((Date) obj));
        }
    }

    public e() {
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        HashMap hashMap2 = new HashMap();
        this.b = hashMap2;
        hashMap2.put(String.class, b.a);
        hashMap.remove(String.class);
        hashMap2.put(Boolean.class, c.a);
        hashMap.remove(Boolean.class);
        hashMap2.put(Date.class, f2974e);
        hashMap.remove(Date.class);
    }
}
