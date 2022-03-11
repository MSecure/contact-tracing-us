package f.b.a.a.a.n;

import e.b.a.m;
import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.n.s;
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
    public final /* synthetic */ s a;
    public final /* synthetic */ u b;

    public /* synthetic */ a(s sVar, u uVar) {
        this.a = sVar;
        this.b = uVar;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        s sVar = this.a;
        u uVar = this.b;
        Objects.requireNonNull(sVar);
        JSONObject put = new JSONObject().put("token", uVar.h());
        ArrayList arrayList = new ArrayList(uVar.g().size());
        f.b.b.b.a<f.b.a.a.a.q.d> t = uVar.g().listIterator();
        while (t.hasNext()) {
            f.b.a.a.a.q.d next = t.next();
            arrayList.add(String.format(Locale.ENGLISH, "%s.%d.%d.%d", s.f2194h.c(next.c()), Integer.valueOf(next.a()), Integer.valueOf(next.d()), Integer.valueOf(next.e())));
        }
        Collections.sort(arrayList);
        String a2 = s.f2193g.a(arrayList);
        uVar.g().size();
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            f.b.b.c.a aVar = s.f2194h;
            instance.init(new SecretKeySpec(aVar.a(uVar.d()), "HmacSHA256"));
            JSONObject put2 = put.put("ekeyhmac", aVar.c(instance.doFinal(a2.getBytes(StandardCharsets.UTF_8))));
            m.h.a(put2);
            String str = "Submitting request for certificate: " + put2;
            s.a aVar2 = new s.a(sVar.f2196d, sVar.b, put2, new f(sVar, put2, bVar, uVar), new c(sVar, bVar), sVar.f2197e, uVar.f());
            sVar.c.a(aVar2);
            return aVar2;
        } catch (InvalidKeyException | NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
