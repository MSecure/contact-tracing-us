package f.b.a.a.a.x;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.google.android.apps.exposurenotification.R$string;
import e.m.a.r;
import f.d.a.b;
import j.j.b.e;
import java.lang.reflect.Field;
import java.util.Objects;

public final /* synthetic */ class c0 implements View.OnClickListener {
    public final /* synthetic */ r0 b;

    public /* synthetic */ c0(r0 r0Var) {
        this.b = r0Var;
    }

    public final void onClick(View view) {
        r0 r0Var = this.b;
        Objects.requireNonNull(r0Var);
        b bVar = new b();
        Field[] fields = R$string.class.getFields();
        e.c(fields, "fields");
        String[] S1 = f.b.a.c.b.o.b.S1(fields);
        e.c(S1, "fields");
        bVar.b = S1;
        boolean z = true;
        bVar.f3543e = true;
        r g2 = r0Var.g();
        e.c(g2, "ctx");
        Class<?> cls = bVar.t;
        e.c(g2, "ctx");
        e.c(cls, "clazz");
        if (bVar.b.length != 0) {
            z = false;
        }
        if (z) {
            Log.w("AboutLibraries", "Have you missed to call withFields(R.string.class.getFields())? - autoDetect won't work - https://github.com/mikepenz/AboutLibraries/wiki/HOWTO:-Fragment");
        }
        Intent intent = new Intent(g2, cls);
        intent.putExtra("data", bVar);
        intent.putExtra("ABOUT_LIBRARIES_EDGE_TO_EDGE", false);
        intent.addFlags(268435456);
        g2.startActivity(intent);
    }
}
