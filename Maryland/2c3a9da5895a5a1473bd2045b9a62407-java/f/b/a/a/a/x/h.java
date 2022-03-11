package f.b.a.a.a.x;

import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;
import e.p.r;

public final /* synthetic */ class h implements r {
    public final /* synthetic */ ExposureAboutActivity a;

    public /* synthetic */ h(ExposureAboutActivity exposureAboutActivity) {
        this.a = exposureAboutActivity;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ExposureAboutActivity exposureAboutActivity = this.a;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        exposureAboutActivity.s.f2099e.setOnCheckedChangeListener(null);
        exposureAboutActivity.s.f2099e.setChecked(booleanValue);
        exposureAboutActivity.s.f2099e.setOnCheckedChangeListener(exposureAboutActivity.w);
    }
}
