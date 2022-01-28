package gov.michigan.MiCovidExposure.storage;

import b.x.t;
import g.b.a.s;
import g.b.a.u.c;

public class ZonedDateTimeTypeConverter {
    public static final c sFormatter = c.l;

    public static String fromOffsetDateTime(s sVar) {
        if (sVar == null) {
            return null;
        }
        c cVar = sFormatter;
        t.y2(cVar, "formatter");
        return cVar.a(sVar);
    }

    public static s toOffsetDateTime(String str) {
        if (str != null) {
            return (s) sFormatter.c(str, s.f6452e);
        }
        return null;
    }
}
