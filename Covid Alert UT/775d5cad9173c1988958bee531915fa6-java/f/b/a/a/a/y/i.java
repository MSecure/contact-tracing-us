package f.b.a.a.a.y;

import e.b.a.m;
import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.y.c0;
import f.b.b.b.a;
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

public final /* synthetic */ class i implements d {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ e0 b;

    public /* synthetic */ i(c0 c0Var, e0 e0Var) {
        this.a = c0Var;
        this.b = e0Var;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        c0 c0Var = this.a;
        e0 e0Var = this.b;
        Objects.requireNonNull(c0Var);
        JSONObject put = new JSONObject().put("token", e0Var.h());
        ArrayList arrayList = new ArrayList(e0Var.g().size());
        a<f.b.a.a.a.c0.d> t = e0Var.g().listIterator();
        while (t.hasNext()) {
            f.b.a.a.a.c0.d next = t.next();
            arrayList.add(String.format(Locale.ENGLISH, "%s.%d.%d.%d", c0.f2490j.c(next.c()), Integer.valueOf(next.a()), Integer.valueOf(next.d()), Integer.valueOf(next.e())));
        }
        Collections.sort(arrayList);
        String a2 = c0.f2489i.a(arrayList);
        f.b.a.a.a.s.d0.a aVar = c0.f2488h;
        aVar.a(e0Var.g().size() + " keys for hashing prior to verification: [" + a2 + "]");
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            f.b.b.c.a aVar2 = c0.f2490j;
            instance.init(new SecretKeySpec(aVar2.a(e0Var.d()), "HmacSHA256"));
            JSONObject put2 = put.put("ekeyhmac", aVar2.c(instance.doFinal(a2.getBytes(StandardCharsets.UTF_8))));
            m.e.a(put2);
            aVar.a("Submitting request for certificate: " + put2);
            c0.a aVar3 = new c0.a(c0Var.f2493e, c0Var.b, put2, new g(c0Var, put2, bVar, e0Var), new c(c0Var, bVar), c0Var.f2494f, e0Var.f());
            c0Var.f2492d.a(aVar3);
            return aVar3;
        } catch (InvalidKeyException | NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
