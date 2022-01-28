package f.b.a.a.a.j0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.google.android.apps.exposurenotification.R$string;
import f.b.a.a.a.t.v;
import f.b.a.a.a.w.z0;
import f.d.a.b;
import f.d.a.e.a;
import gov.ut.covid19.exposurenotifications.R;
import j.k.b.e;
import java.lang.reflect.Field;

public class y0 extends z0 {
    public v X;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = s().inflate(R.layout.fragment_open_source_licenses, (ViewGroup) null, false);
        int i2 = 16908332;
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.main_container);
            if (frameLayout != null) {
                this.X = new v((LinearLayout) inflate, imageButton, frameLayout);
                b bVar = new b();
                Field[] fields = R$string.class.getFields();
                e.c(fields, "fields");
                String[] s1 = f.b.a.c.b.o.b.s1(fields);
                e.c(s1, "fields");
                bVar.b = s1;
                bVar.f3761e = true;
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("data", bVar);
                a aVar = new a();
                aVar.y0(bundle2);
                e.n.a.a aVar2 = new e.n.a.a(h());
                aVar2.f(R.id.main_container, aVar, null);
                aVar2.d();
                return this.X.a;
            }
            i2 = R.id.main_container;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        this.X.b.setContentDescription(E(R.string.navigate_up));
        this.X.b.setOnClickListener(new t(this));
    }
}
