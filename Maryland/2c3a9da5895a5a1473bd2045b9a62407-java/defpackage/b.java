package defpackage;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import e.b.a.g;
import f.d.a.e.b.a;
import j.j.b.e;

/* renamed from: b  reason: default package */
/* compiled from: java-style lambda group */
public final class b implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f335d;

    public b(int i2, Object obj, Object obj2) {
        this.b = i2;
        this.c = obj;
        this.f335d = obj2;
    }

    public final void onClick(View view) {
        int i2 = this.b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw null;
                } else if (!TextUtils.isEmpty(((a) this.c).f3567e.q)) {
                    try {
                        g.a aVar = new g.a((Context) this.f335d);
                        aVar.a.f29f = Html.fromHtml(((a) this.c).f3567e.q);
                        g a = aVar.a();
                        e.b(a, "AlertDialog.Builder(ctx)…                .create()");
                        a.show();
                        TextView textView = (TextView) a.findViewById(16908299);
                        if (textView != null) {
                            textView.setMovementMethod(LinkMovementMethod.getInstance());
                        }
                    } catch (Exception unused) {
                    }
                }
            } else if (!TextUtils.isEmpty(((a) this.c).f3567e.o)) {
                try {
                    g.a aVar2 = new g.a((Context) this.f335d);
                    aVar2.a.f29f = Html.fromHtml(((a) this.c).f3567e.o);
                    g a2 = aVar2.a();
                    e.b(a2, "AlertDialog.Builder(ctx)…                .create()");
                    a2.show();
                    TextView textView2 = (TextView) a2.findViewById(16908299);
                    if (textView2 != null) {
                        textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                } catch (Exception unused2) {
                }
            }
        } else if (!TextUtils.isEmpty(((a) this.c).f3567e.m)) {
            try {
                g.a aVar3 = new g.a((Context) this.f335d);
                aVar3.a.f29f = Html.fromHtml(((a) this.c).f3567e.m);
                g a3 = aVar3.a();
                e.b(a3, "AlertDialog.Builder(ctx)…                .create()");
                a3.show();
                TextView textView3 = (TextView) a3.findViewById(16908299);
                if (textView3 != null) {
                    textView3.setMovementMethod(LinkMovementMethod.getInstance());
                }
            } catch (Exception unused3) {
            }
        }
    }
}
