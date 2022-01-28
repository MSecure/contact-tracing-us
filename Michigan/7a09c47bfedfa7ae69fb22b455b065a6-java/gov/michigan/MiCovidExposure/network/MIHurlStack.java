package gov.michigan.MiCovidExposure.network;

import c.a.b.o;
import c.a.b.x.e;
import c.a.b.x.f;
import java.util.HashMap;
import java.util.Map;

public class MIHurlStack extends f {
    @Override // c.a.b.x.a, c.a.b.x.f
    public e executeRequest(o<?> oVar, Map<String, String> map) {
        HashMap hashMap = new HashMap(map);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        return super.executeRequest(oVar, hashMap);
    }
}
