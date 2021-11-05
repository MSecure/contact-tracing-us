package gov.nc.dhhs.exposurenotification.onboarding;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.l.d.a;
import b.l.d.q;
import b.n.y;
import com.google.android.material.snackbar.Snackbar;
import d.a.a.a.i.t;
import d.a.a.a.i.u;
import d.a.a.a.i.v;
import d.a.a.a.i.w;
import d.a.a.a.i.x;
import gov.nc.dhhs.exposurenotification.BuildConfig;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationActivity;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationViewModel;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import gov.nc.dhhs.exposurenotification.utils.CustomUtility;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class OnboardingStartFragment extends Fragment {
    public ExposureNotificationViewModel exposureNotificationViewModel;

    public final class TotalDownloads extends AsyncTask<Void, Void, String> {
        public TotalDownloads() {
        }

        public String doInBackground(Void... voidArr) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DataInputStream(((HttpsURLConnection) new URL(BuildConfig.TOTAL_DOWNLOADS_URL).openConnection()).getInputStream())));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        new ExposureNotificationSharedPreferences(OnboardingStartFragment.this.getActivity().getApplicationContext()).setTotalDownloads(sb.toString());
                        return "";
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    private void nextAction() {
        new TotalDownloads().execute(new Void[0]);
        this.exposureNotificationViewModel.startExposureNotifications();
    }

    private void transitionToFinishFragment() {
        getParentFragmentManager().a0(null, 1);
        q parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.i(R.id.home_fragment, new OnboardingFinishFragment(), ExposureNotificationActivity.HOME_FRAGMENT_TAG);
            aVar.f = 4099;
            aVar.d();
            return;
        }
        throw null;
    }

    public /* synthetic */ void d(Boolean bool) {
        if (bool.booleanValue()) {
            transitionToFinishFragment();
        }
    }

    public /* synthetic */ void e(Void r3) {
        View view = getView();
        if (view != null) {
            Snackbar.h(view, R.string.api_update_error_message_text, 0).j();
        }
    }

    public /* synthetic */ void f(View view) {
        nextAction();
    }

    public /* synthetic */ void h(View view) {
        startActivity(new Intent(requireContext(), HowItWorksActivity.class));
    }

    public void i(View view) {
        q parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.i(R.id.home_fragment, new PrivacyChecklist(), ExposureNotificationActivity.HOME_FRAGMENT_TAG);
            aVar.f = 4099;
            aVar.c(null);
            aVar.d();
            return;
        }
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences = new ExposureNotificationSharedPreferences(getContext().getApplicationContext());
        if (!exposureNotificationSharedPreferences.getCheckIfAppInstalled(false)) {
            CustomUtility.customLogger("A_CW_91011 - app installed");
            exposureNotificationSharedPreferences.setCheckIfAppInstalled(true);
        }
        return layoutInflater.inflate(R.layout.fragment_onboarding_start, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ExposureNotificationViewModel exposureNotificationViewModel2 = (ExposureNotificationViewModel) new y(requireActivity()).a(ExposureNotificationViewModel.class);
        this.exposureNotificationViewModel = exposureNotificationViewModel2;
        exposureNotificationViewModel2.getIsEnabledLiveData().observe(getViewLifecycleOwner(), new d.a.a.a.i.y(this));
        this.exposureNotificationViewModel.getApiErrorLiveEvent().observe(getViewLifecycleOwner(), new w(this));
        Button button = (Button) view.findViewById(R.id.onboarding_next_button);
        button.setOnClickListener(new u(this));
        this.exposureNotificationViewModel.getInFlightLiveData().observe(getViewLifecycleOwner(), new t(button));
        Button button2 = (Button) view.findViewById(R.id.onboarding_how_it_works_button);
        TextView textView = (TextView) view.findViewById(R.id.privacy_policy);
        Spannable spannable = (Spannable) Html.fromHtml(Html.toHtml((Spanned) getText(R.string.privacy_policy)));
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (URLSpan uRLSpan : uRLSpanArr) {
            spannable.setSpan(new UnderlineSpan() {
                /* class gov.nc.dhhs.exposurenotification.onboarding.OnboardingStartFragment.AnonymousClass1 */

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 0);
        }
        textView.setText(spannable);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        button2.setOnClickListener(new v(this));
        ((TextView) view.findViewById(R.id.privacy_checklist)).setOnClickListener(new x(this));
    }
}
