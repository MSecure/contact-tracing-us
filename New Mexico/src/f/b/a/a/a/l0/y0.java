package f.b.a.a.a.l0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.google.android.apps.exposurenotification.R$string;
import f.b.a.a.a.u.y;
import f.b.a.a.a.x.a1;
import f.d.a.b;
import f.d.a.e.a;
import gov.nm.covid19.exposurenotifications.R;
import j.k.b.e;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class y0 extends a1 {
    public y X;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = t().inflate(R.layout.fragment_open_source_licenses, (ViewGroup) null, false);
        int i2 = 16908332;
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.main_container);
            if (frameLayout != null) {
                this.X = new y((LinearLayout) inflate, imageButton, frameLayout);
                b bVar = new b();
                Field[] fields = R$string.class.getFields();
                e.c(fields, "fields");
                String[] t1 = f.b.a.c.b.o.b.t1(fields);
                e.c(t1, "fields");
                bVar.b = t1;
                bVar.f4016e = true;
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("data", bVar);
                a aVar = new a();
                aVar.A0(bundle2);
                e.o.a.a aVar2 = new e.o.a.a(j());
                aVar2.g(R.id.main_container, aVar, null);
                aVar2.d();
                return this.X.a;
            }
            i2 = R.id.main_container;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        this.X.b.setContentDescription(F(R.string.navigate_up));
        this.X.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y0.this.u0().onBackPressed();
            }
        });
    }
}
