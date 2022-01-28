package e.a.a.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import gov.michigan.MiCovidExposure.exposure.ExposureHomeFragment;

/* compiled from: lambda */
public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExposureHomeFragment f6233b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f6234c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f6235d;

    public /* synthetic */ m(ExposureHomeFragment exposureHomeFragment, LinearLayout linearLayout, TextView textView) {
        this.f6233b = exposureHomeFragment;
        this.f6234c = linearLayout;
        this.f6235d = textView;
    }

    public final void onClick(View view) {
        this.f6233b.k(this.f6234c, this.f6235d, view);
    }
}
