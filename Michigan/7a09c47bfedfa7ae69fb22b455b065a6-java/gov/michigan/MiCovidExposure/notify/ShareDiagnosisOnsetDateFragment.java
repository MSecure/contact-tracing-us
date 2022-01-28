package gov.michigan.MiCovidExposure.notify;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import b.l.d.a;
import b.l.d.z;
import b.o.y;
import b.x.t;
import c.b.a.a.d.k.b;
import com.google.android.material.snackbar.Snackbar;
import e.a.a.f.o;
import e.a.a.f.p;
import e.a.a.f.r;
import e.a.a.f.u;
import g.b.a.d;
import g.b.a.e;
import g.b.a.f;
import g.b.a.g;
import g.b.a.q;
import g.b.a.s;
import g.b.a.u.c;
import g.b.a.u.k;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
import gov.michigan.MiCovidExposure.utils.RequestCodes;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ShareDiagnosisOnsetDateFragment extends Fragment {
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    public static final long INTERVAL_LEN_MS = TimeUnit.MINUTES.toMillis(10);
    public String mParam1;
    public String mParam2;
    public ProgressDialog progress;
    public ShareDiagnosisViewModel shareDiagnosisViewModel;
    public String val;

    public static /* synthetic */ void f(Button button, Button button2, Boolean bool) {
        boolean z = !bool.booleanValue();
        button.setEnabled(z);
        button2.setEnabled(z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private c getDateTimeFormatter() {
        return c.b(k.MEDIUM).g(getResources().getConfiguration().locale);
    }

    /* access modifiers changed from: private */
    /* renamed from: maybeShowSnackbar */
    public void g(String str) {
        View view = getView();
        if (view != null) {
            Snackbar.i(view, str, 0).j();
        }
    }

    public static ShareDiagnosisOnsetDateFragment newInstance(String str, String str2) {
        ShareDiagnosisOnsetDateFragment shareDiagnosisOnsetDateFragment = new ShareDiagnosisOnsetDateFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", str);
        bundle.putString("param2", str2);
        shareDiagnosisOnsetDateFragment.setArguments(bundle);
        return shareDiagnosisOnsetDateFragment;
    }

    private void shareAction() {
        this.shareDiagnosisViewModel.share(this.progress);
    }

    private void transitionToFragment(Fragment fragment, ProgressDialog progressDialog) {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        getParentFragmentManager().Z(null, 1);
        z parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.h(R.id.share_exposure_fragment, fragment, ShareDiagnosisActivity.SHARE_EXPOSURE_FRAGMENT_TAG);
            aVar.f2040f = 4097;
            aVar.d();
            return;
        }
        throw null;
    }

    public void d(ExposureNotificationSharedPreferences exposureNotificationSharedPreferences, View view) {
        e j0 = e.j0(this.val, getDateTimeFormatter());
        q qVar = q.f6446g;
        if (j0 != null) {
            t.y2(qVar, "zone");
            s Y = s.Y(f.Y(j0, g.h), qVar);
            exposureNotificationSharedPreferences.setOnSetValue(d.G(Y.H(), (long) Y.Q().f6421e).S() / INTERVAL_LEN_MS);
            shareAction();
            return;
        }
        throw null;
    }

    public /* synthetic */ void e(ExposureNotificationSharedPreferences exposureNotificationSharedPreferences, View view) {
        exposureNotificationSharedPreferences.setOnSetValue(0);
        shareAction();
    }

    public void h(b bVar) {
        try {
            this.shareDiagnosisViewModel.setInflightResolution(true);
            bVar.f2941b.x(requireActivity(), RequestCodes.REQUEST_CODE_GET_TEMP_EXPOSURE_KEY_HISTORY);
        } catch (IntentSender.SendIntentException unused) {
            g(getString(R.string.generic_error_message));
        }
    }

    public /* synthetic */ void i(Boolean bool) {
        if (!bool.booleanValue()) {
            Toast.makeText(getContext(), (int) R.string.share_error, 1).show();
        }
        this.shareDiagnosisViewModel.save(bool.booleanValue(), this.progress);
    }

    public /* synthetic */ void j(Boolean bool) {
        transitionToFragment(bool.booleanValue() ? new ShareDiagnosisSharedFragment() : new NotifyHomeFragment(), this.progress);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2222) {
            this.shareDiagnosisViewModel.setInflightResolution(false);
            if (i2 == -1) {
                this.shareDiagnosisViewModel.share(this.progress);
            } else {
                this.shareDiagnosisViewModel.save(false, this.progress);
            }
        }
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
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_onset_date, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.shareDiagnosisViewModel = (ShareDiagnosisViewModel) new y(getActivity()).a(ShareDiagnosisViewModel.class);
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        this.progress = progressDialog;
        progressDialog.setMessage(getActivity().getString(R.string.uploading));
        this.progress.setCancelable(false);
        this.progress.setIndeterminate(true);
        this.progress.setProgressStyle(0);
        CalendarView calendarView = (CalendarView) view.findViewById(R.id.onsetcalender);
        calendarView.setMaxDate(System.currentTimeMillis());
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences = new ExposureNotificationSharedPreferences(getContext().getApplicationContext());
        c dateTimeFormatter = getDateTimeFormatter();
        d F = d.F(calendarView.getDate());
        q qVar = q.f6446g;
        if (F != null) {
            this.val = dateTimeFormatter.a(s.Z(F, qVar));
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                /* class gov.michigan.MiCovidExposure.notify.ShareDiagnosisOnsetDateFragment.AnonymousClass1 */

                public void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
                    Calendar instance = Calendar.getInstance();
                    instance.set(1, i);
                    instance.set(2, i2);
                    instance.set(5, i3);
                    Long valueOf = Long.valueOf(instance.getTimeInMillis());
                    ShareDiagnosisOnsetDateFragment shareDiagnosisOnsetDateFragment = ShareDiagnosisOnsetDateFragment.this;
                    c dateTimeFormatter = shareDiagnosisOnsetDateFragment.getDateTimeFormatter();
                    d F = d.F(valueOf.longValue());
                    q qVar = q.f6446g;
                    if (F != null) {
                        shareDiagnosisOnsetDateFragment.val = dateTimeFormatter.a(s.Z(F, qVar));
                        return;
                    }
                    throw null;
                }
            });
            Button button = (Button) view.findViewById(R.id.share_next_button);
            button.setOnClickListener(new e.a.a.f.s(this, exposureNotificationSharedPreferences));
            Button button2 = (Button) view.findViewById(R.id.share_skip_button);
            button2.setOnClickListener(new o(this, exposureNotificationSharedPreferences));
            this.shareDiagnosisViewModel.getInFlightResolutionLiveData().observe(getViewLifecycleOwner(), new e.a.a.f.t(button, button2));
            this.shareDiagnosisViewModel.getSnackbarSingleLiveEvent().observe(getViewLifecycleOwner(), new e.a.a.f.q(this));
            this.shareDiagnosisViewModel.getResolutionRequiredLiveEvent().observe(getViewLifecycleOwner(), new r(this));
            this.shareDiagnosisViewModel.getSharedLiveEvent().observe(getViewLifecycleOwner(), new u(this));
            this.shareDiagnosisViewModel.getSavedLiveEvent().observe(getViewLifecycleOwner(), new p(this));
            return;
        }
        throw null;
    }
}
