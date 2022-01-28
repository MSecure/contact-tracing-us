package d.a.a.a.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import gov.nc.dhhs.exposurenotification.exposure.ExposureHomeFragment;

/* compiled from: lambda */
public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExposureHomeFragment f4621b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f4622c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f4623d;

    public /* synthetic */ o(ExposureHomeFragment exposureHomeFragment, LinearLayout linearLayout, TextView textView) {
        this.f4621b = exposureHomeFragment;
        this.f4622c = linearLayout;
        this.f4623d = textView;
    }

    public final void onClick(View view) {
        this.f4621b.m(this.f4622c, this.f4623d, view);
    }
}
