package gov.nc.dhhs.exposurenotification.notify;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.n.x;
import b.n.y;
import b.n.z;
import c.a.a.a.a;
import com.google.android.material.snackbar.Snackbar;
import d.a.a.a.h.b;
import d.a.a.a.h.c;
import d.a.a.a.h.d;
import d.a.a.a.h.e;
import d.a.a.a.h.f;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationViewModel;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisEntity;

public class NotifyHomeFragment extends Fragment {
    public static final String TAG = "NotifyHomeFragment";
    public ExposureNotificationViewModel exposureNotificationViewModel;
    public NotifyHomeViewModel notifyHomeViewModel;

    private void refreshUi() {
        this.exposureNotificationViewModel.refreshIsEnabledState();
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshUiForEnabled */
    public void d(Boolean bool) {
        View view = getView();
        if (view != null) {
            int i = 0;
            if (bool.booleanValue()) {
                new ExposureNotificationSharedPreferences(requireContext()).setOnboardedState(true);
            } else {
                new ExposureNotificationSharedPreferences(requireContext()).setOnboardedState(false);
            }
            view.findViewById(R.id.settings_banner_section).setVisibility(bool.booleanValue() ? 8 : 0);
            View findViewById = view.findViewById(R.id.notify_share_section);
            if (!bool.booleanValue()) {
                i = 8;
            }
            findViewById.setVisibility(i);
        }
    }

    public /* synthetic */ void e(View view) {
        this.exposureNotificationViewModel.startExposureNotifications();
    }

    public /* synthetic */ void g(Void r3) {
        View view = getView();
        if (view != null) {
            Snackbar.h(view, R.string.api_update_error_message_text, 0).j();
        }
    }

    public /* synthetic */ void h(View view) {
        startActivity(ShareDiagnosisActivity.newIntentForAddFlow(requireContext()));
    }

    public /* synthetic */ void i(PositiveDiagnosisEntity positiveDiagnosisEntity) {
        startActivity(ShareDiagnosisActivity.newIntentForViewFlow(requireContext(), positiveDiagnosisEntity));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_notify_home, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshUi();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.exposureNotificationViewModel = (ExposureNotificationViewModel) new y(requireActivity()).a(ExposureNotificationViewModel.class);
        y.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        z viewModelStore = getViewModelStore();
        String canonicalName = NotifyHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String o = a.o("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            x xVar = viewModelStore.f1427a.get(o);
            if (!NotifyHomeViewModel.class.isInstance(xVar)) {
                xVar = defaultViewModelProviderFactory instanceof y.c ? ((y.c) defaultViewModelProviderFactory).c(o, NotifyHomeViewModel.class) : defaultViewModelProviderFactory.a(NotifyHomeViewModel.class);
                x put = viewModelStore.f1427a.put(o, xVar);
                if (put != null) {
                    put.onCleared();
                }
            } else if (defaultViewModelProviderFactory instanceof y.e) {
                ((y.e) defaultViewModelProviderFactory).b(xVar);
            }
            this.notifyHomeViewModel = (NotifyHomeViewModel) xVar;
            this.exposureNotificationViewModel.getIsEnabledLiveData().observe(getViewLifecycleOwner(), new d(this));
            Button button = (Button) view.findViewById(R.id.start_api_button);
            button.setOnClickListener(new f(this));
            this.exposureNotificationViewModel.getInFlightLiveData().observe(getViewLifecycleOwner(), new d.a.a.a.h.a(button));
            this.exposureNotificationViewModel.getApiErrorLiveEvent().observe(getViewLifecycleOwner(), new e(this));
            ((Button) view.findViewById(R.id.fragment_notify_share_button)).setOnClickListener(new b(this));
            new PositiveDiagnosisEntityAdapter(new c(this));
            getContext();
            new LinearLayoutManager(1, false);
            ((TextView) view.findViewById(R.id.fragment_notify_description)).setMovementMethod(LinkMovementMethod.getInstance());
            ((TextView) view.findViewById(R.id.fragment_notify_learnmore)).setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
