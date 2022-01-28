package gov.nc.dhhs.exposurenotification;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.l.d.z;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import d.a.a.a.a;
import d.a.a.a.b;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationActivity;
import gov.nc.dhhs.exposurenotification.home.HomeFragment;

public class AboutHomeFragment extends Fragment {
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    public String mParam1;
    public String mParam2;

    public static AboutHomeFragment newInstance(String str, String str2) {
        AboutHomeFragment aboutHomeFragment = new AboutHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", str);
        bundle.putString("param2", str2);
        aboutHomeFragment.setArguments(bundle);
        return aboutHomeFragment;
    }

    private void settingsAction() {
        startActivity(new Intent(ExposureNotificationClient.ACTION_EXPOSURE_NOTIFICATION_SETTINGS));
    }

    public /* synthetic */ void d(View view) {
        z f = getParentFragmentManager().f();
        f.i(R.id.about_exposure_fragment, HomeFragment.newInstance(), ExposureNotificationActivity.HOME_FRAGMENT_TAG);
        f.k(4099);
        f.c(null);
        f.d();
    }

    public /* synthetic */ void e(View view) {
        settingsAction();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString("param1");
            this.mParam2 = getArguments().getString("param2");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_about_home, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.findViewById(16908332).setOnClickListener(new b(this));
        ((Button) view.findViewById(R.id.exposure_about_settings_button)).setOnClickListener(new a(this));
        ((TextView) view.findViewById(R.id.exposure_learn_more)).setMovementMethod(LinkMovementMethod.getInstance());
    }
}
