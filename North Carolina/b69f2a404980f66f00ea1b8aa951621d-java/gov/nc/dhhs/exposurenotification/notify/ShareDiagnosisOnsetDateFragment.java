package gov.nc.dhhs.exposurenotification.notify;

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
import b.l.d.q;
import b.n.y;
import c.b.a.a.c.k.b;
import com.google.android.material.snackbar.Snackbar;
import d.a.a.a.h.o;
import d.a.a.a.h.p;
import d.a.a.a.h.r;
import d.a.a.a.h.t;
import d.a.a.a.h.u;
import e.c.a.d;
import e.c.a.e;
import e.c.a.f;
import e.c.a.g;
import e.c.a.s;
import e.c.a.u.c;
import e.c.a.u.k;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import gov.nc.dhhs.exposurenotification.utils.RequestCodes;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ShareDiagnosisOnsetDateFragment extends Fragment {
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    public static final long INTERVAL_LEN_MS = TimeUnit.MINUTES.toMillis(10);
    public String mParam1;
    public String mParam2;
    public ProgressDialog progress;
    public String selectedDate = "";
    public ShareDiagnosisViewModel shareDiagnosisViewModel;

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
        getParentFragmentManager().a0(null, 1);
        q parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.i(R.id.share_exposure_fragment, fragment, ShareDiagnosisActivity.SHARE_EXPOSURE_FRAGMENT_TAG);
            aVar.f = 4097;
            aVar.d();
            return;
        }
        throw null;
    }

    public void d(ExposureNotificationSharedPreferences exposureNotificationSharedPreferences, View view) {
        e T = e.T(this.selectedDate, getDateTimeFormatter());
        e.c.a.q qVar = e.c.a.q.f;
        if (T != null) {
            c.b.a.a.c.n.c.T1(qVar, "zone");
            s I = s.I(f.I(T, g.h), qVar);
            exposureNotificationSharedPreferences.setOnSetValue(d.w(I.x(), (long) I.A().f4980e).C() / INTERVAL_LEN_MS);
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
            bVar.f2304b.q(requireActivity(), RequestCodes.REQUEST_CODE_GET_TEMP_EXPOSURE_KEY_HISTORY);
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
        d v = d.v(calendarView.getDate());
        e.c.a.q qVar = e.c.a.q.f;
        if (v != null) {
            c.b.a.a.c.n.c.T1(v, "instant");
            c.b.a.a.c.n.c.T1(qVar, "zone");
            this.selectedDate = dateTimeFormatter.a(s.F(v.f4967b, v.f4968c, qVar));
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisOnsetDateFragment.AnonymousClass1 */

                public void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
                    Calendar instance = Calendar.getInstance();
                    instance.set(1, i);
                    instance.set(2, i2);
                    instance.set(5, i3);
                    Long valueOf = Long.valueOf(instance.getTimeInMillis());
                    ShareDiagnosisOnsetDateFragment shareDiagnosisOnsetDateFragment = ShareDiagnosisOnsetDateFragment.this;
                    c dateTimeFormatter = shareDiagnosisOnsetDateFragment.getDateTimeFormatter();
                    d v = d.v(valueOf.longValue());
                    e.c.a.q qVar = e.c.a.q.f;
                    if (v != null) {
                        c.b.a.a.c.n.c.T1(v, "instant");
                        c.b.a.a.c.n.c.T1(qVar, "zone");
                        shareDiagnosisOnsetDateFragment.selectedDate = dateTimeFormatter.a(s.F(v.f4967b, v.f4968c, qVar));
                        return;
                    }
                    throw null;
                }
            });
            Button button = (Button) view.findViewById(R.id.share_next_button);
            button.setOnClickListener(new u(this, exposureNotificationSharedPreferences));
            Button button2 = (Button) view.findViewById(R.id.share_skip_button);
            button2.setOnClickListener(new o(this, exposureNotificationSharedPreferences));
            this.shareDiagnosisViewModel.getInFlightResolutionLiveData().observe(getViewLifecycleOwner(), new d.a.a.a.h.q(button, button2));
            this.shareDiagnosisViewModel.getSnackbarSingleLiveEvent().observe(getViewLifecycleOwner(), new d.a.a.a.h.s(this));
            this.shareDiagnosisViewModel.getResolutionRequiredLiveEvent().observe(getViewLifecycleOwner(), new r(this));
            this.shareDiagnosisViewModel.getSharedLiveEvent().observe(getViewLifecycleOwner(), new p(this));
            this.shareDiagnosisViewModel.getSavedLiveEvent().observe(getViewLifecycleOwner(), new t(this));
            return;
        }
        throw null;
    }
}
