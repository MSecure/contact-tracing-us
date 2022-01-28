package gov.nc.dhhs.exposurenotification.storage;

import e.c.a.s;
import e.c.a.u.c;

public class ZonedDateTimeTypeConverter {
    public static final c sFormatter = c.l;

    public static String fromOffsetDateTime(s sVar) {
        if (sVar == null) {
            return null;
        }
        c cVar = sFormatter;
        c.b.a.a.c.n.c.T1(cVar, "formatter");
        return cVar.a(sVar);
    }

    public static s toOffsetDateTime(String str) {
        if (str != null) {
            return (s) sFormatter.c(str, s.f5007e);
        }
        return null;
    }
}
