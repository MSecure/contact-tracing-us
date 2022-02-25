package f.b.a.a.a.v;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.google.android.apps.exposurenotification.R$string;
import e.m.a.o;
import f.d.a.a;
import f.d.a.b;
import gov.wa.doh.exposurenotifications.R;
import j.j.b.e;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;

public final /* synthetic */ class d0 implements View.OnClickListener {
    public final /* synthetic */ t0 b;

    public /* synthetic */ d0(t0 t0Var) {
        this.b = t0Var;
    }

    public final void onClick(View view) {
        t0 t0Var = this.b;
        Objects.requireNonNull(t0Var);
        b bVar = new b();
        Field[] fields = R$string.class.getFields();
        e.c(fields, "fields");
        String[] T1 = f.b.a.c.b.o.b.T1(fields);
        e.c(T1, "fields");
        bVar.b = T1;
        a.EnumC0125a aVar = a.EnumC0125a.LIBRARY_DESCRIPTION;
        String z = t0Var.z(R.string.jsr_cddl_description);
        e.c("javax_annotation__jsr250_api", "library");
        e.c(aVar, "modificationKey");
        e.c(z, "modificationValue");
        if (!bVar.r.containsKey("javax_annotation__jsr250_api")) {
            bVar.r.put("javax_annotation__jsr250_api", new HashMap<>());
        }
        HashMap<String, String> hashMap = bVar.r.get("javax_annotation__jsr250_api");
        if (hashMap != null) {
            hashMap.put(aVar.name(), z);
        }
        boolean z2 = true;
        bVar.f3447e = true;
        o g2 = t0Var.g();
        e.c(g2, "ctx");
        Class<?> cls = bVar.t;
        e.c(g2, "ctx");
        e.c(cls, "clazz");
        if (bVar.b.length != 0) {
            z2 = false;
        }
        if (z2) {
            Log.w("AboutLibraries", "Have you missed to call withFields(R.string.class.getFields())? - autoDetect won't work - https://github.com/mikepenz/AboutLibraries/wiki/HOWTO:-Fragment");
        }
        Intent intent = new Intent(g2, cls);
        intent.putExtra("data", bVar);
        intent.putExtra("ABOUT_LIBRARIES_EDGE_TO_EDGE", false);
        intent.addFlags(268435456);
        g2.startActivity(intent);
    }
}
