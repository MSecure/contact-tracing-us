package gov.nc.dhhs.exposurenotification.network;

import c.a.b.l;
import c.a.b.v;
import java.nio.charset.StandardCharsets;

public class VolleyUtils {
    public static String getErrorMessage(v vVar, String str) {
        l lVar = vVar.f2238b;
        return (lVar == null || lVar.f2218b == null) ? str : new String(vVar.f2238b.f2218b, StandardCharsets.UTF_8);
    }

    public static int getHttpStatus(v vVar, int i) {
        l lVar = vVar.f2238b;
        return lVar == null ? i : lVar.f2217a;
    }
}
