package e.a.a.b;

import android.view.View;
import gov.michigan.MiCovidExposure.exposure.ExposureEntityAdapter;

/* compiled from: lambda */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExposureEntityAdapter.ViewHolder f6224b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExposureEntityAdapter.OnExposureClickListener f6225c;

    public /* synthetic */ e(ExposureEntityAdapter.ViewHolder viewHolder, ExposureEntityAdapter.OnExposureClickListener onExposureClickListener) {
        this.f6224b = viewHolder;
        this.f6225c = onExposureClickListener;
    }

    public final void onClick(View view) {
        this.f6224b.a(this.f6225c, view);
    }
}
