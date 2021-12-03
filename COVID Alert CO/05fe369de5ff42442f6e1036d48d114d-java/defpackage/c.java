package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import f.d.a.e.b.d;
import j.k.b.e;
import java.util.Objects;

/* renamed from: c  reason: default package */
/* compiled from: java-style lambda group */
public final class c implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f324d;

    public c(int i2, Object obj, Object obj2) {
        this.b = i2;
        this.c = obj;
        this.f324d = obj2;
    }

    public final void onClick(View view) {
        int i2 = this.b;
        if (i2 == 0) {
            Context context = (Context) this.f324d;
            e.b(context, "ctx");
            String str = ((d) this.c).b.f3712g;
            Objects.requireNonNull((d) this.c);
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
        } else if (i2 == 1) {
            Context context2 = (Context) this.f324d;
            e.b(context2, "ctx");
            String str2 = ((d) this.c).b.f3716k;
            Objects.requireNonNull((d) this.c);
            try {
                context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
            } catch (Exception unused2) {
            }
        } else if (i2 == 2) {
            Context context3 = (Context) this.f324d;
            e.b(context3, "ctx");
            d dVar = (d) this.c;
            d.m((d) this.c, context3, dVar.c, dVar.b);
        } else {
            throw null;
        }
    }
}
