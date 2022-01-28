package d.a.a.a.d;

import android.view.View;
import gov.nc.dhhs.exposurenotification.exposure.ExposureEntityAdapter;

/* compiled from: lambda */
public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExposureEntityAdapter.ViewHolder f4608b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExposureEntityAdapter.OnExposureClickListener f4609c;

    public /* synthetic */ c(ExposureEntityAdapter.ViewHolder viewHolder, ExposureEntityAdapter.OnExposureClickListener onExposureClickListener) {
        this.f4608b = viewHolder;
        this.f4609c = onExposureClickListener;
    }

    public final void onClick(View view) {
        this.f4608b.a(this.f4609c, view);
    }
}
