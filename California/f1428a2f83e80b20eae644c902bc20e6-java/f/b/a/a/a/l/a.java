package f.b.a.a.a.l;

import e.b.a.m;
import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.l.r;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public final /* synthetic */ class a implements d {
    public final /* synthetic */ r a;
    public final /* synthetic */ t b;

    public /* synthetic */ a(r rVar, t tVar) {
        this.a = rVar;
        this.b = tVar;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        r rVar = this.a;
        t tVar = this.b;
        Objects.requireNonNull(rVar);
        JSONObject put = new JSONObject().put("token", tVar.h());
        ArrayList arrayList = new ArrayList(tVar.g().size());
        f.b.b.b.a<f.b.a.a.a.o.d> t = tVar.g().listIterator();
        while (t.hasNext()) {
            f.b.a.a.a.o.d next = t.next();
            arrayList.add(String.format(Locale.ENGLISH, "%s.%d.%d.%d", r.f2115h.c(next.c()), Integer.valueOf(next.a()), Integer.valueOf(next.d()), Integer.valueOf(next.e())));
        }
        Collections.sort(arrayList);
        String a2 = r.f2114g.a(arrayList);
        tVar.g().size();
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            f.b.b.c.a aVar = r.f2115h;
            instance.init(new SecretKeySpec(aVar.a(tVar.d()), "HmacSHA256"));
            JSONObject put2 = put.put("ekeyhmac", aVar.c(instance.doFinal(a2.getBytes(StandardCharsets.UTF_8))));
            m.h.a(put2);
            String str = "Submitting request for certificate: " + put2;
            r.a aVar2 = new r.a(rVar.f2117d, rVar.b, put2, new f(rVar, put2, bVar, tVar), new c(rVar, bVar), rVar.f2118e, tVar.f());
            rVar.c.a(aVar2);
            return aVar2;
        } catch (InvalidKeyException | NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
