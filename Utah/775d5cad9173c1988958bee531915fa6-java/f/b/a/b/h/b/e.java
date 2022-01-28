package f.b.a.b.h.b;

import f.b.c.i.d;

public final class e implements d<q> {
    public static final e a = new e();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // f.b.c.i.b
    public void a(Object obj, f.b.c.i.e eVar) {
        q qVar = (q) obj;
        f.b.c.i.e eVar2 = eVar;
        eVar2.d("eventTimeMs", qVar.b());
        eVar2.c("eventCode", qVar.a());
        eVar2.d("eventUptimeMs", qVar.c());
        eVar2.c("sourceExtension", qVar.e());
        eVar2.c("sourceExtensionJsonProto3", qVar.f());
        eVar2.d("timezoneOffsetSeconds", qVar.g());
        eVar2.c("networkConnectionInfo", qVar.d());
    }
}
