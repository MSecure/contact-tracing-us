package gov.nc.dhhs.exposurenotification.exposure;

import android.os.Bundle;
import b.b.k.f;
import b.l.d.a;
import b.l.d.q;
import gov.nc.dhhs.exposurenotification.AboutHomeFragment;
import gov.nc.dhhs.exposurenotification.R;

public class ExposureAboutActivity extends f {
    public static final String TAG = "ExposureAboutActivity";

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.l.d.d, b.i.d.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        setContentView(R.layout.activity_exposure_about);
        q supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            a aVar = new a(supportFragmentManager);
            aVar.i(R.id.about_exposure_fragment, new AboutHomeFragment(), null);
            aVar.d();
            return;
        }
        throw null;
    }
}
