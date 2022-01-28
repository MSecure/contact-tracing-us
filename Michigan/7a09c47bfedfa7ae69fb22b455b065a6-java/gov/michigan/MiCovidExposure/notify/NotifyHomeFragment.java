package gov.michigan.MiCovidExposure.notify;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.o.x;
import b.o.y;
import b.o.z;
import c.a.a.a.a;
import com.google.android.material.snackbar.Snackbar;
import e.a.a.f.b;
import e.a.a.f.c;
import e.a.a.f.d;
import e.a.a.f.e;
import e.a.a.f.f;
import e.a.a.f.g;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.home.ExposureNotificationViewModel;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
import gov.michigan.MiCovidExposure.storage.PositiveDiagnosisEntity;
import java.util.List;

public class NotifyHomeFragment extends Fragment {
    public static final String TAG = "NotifyHomeFragment";
    public ExposureNotificationViewModel exposureNotificationViewModel;
    public NotifyHomeViewModel notifyHomeViewModel;

    public static void appendLearnMoreLink(final TextView textView, final Intent intent) {
        AnonymousClass1 r0 = new ClickableSpan() {
            /* class gov.michigan.MiCovidExposure.notify.NotifyHomeFragment.AnonymousClass1 */

            public void onClick(View view) {
                textView.getContext().startActivity(intent.addFlags(67108864));
            }
        };
        String string = textView.getContext().getString(R.string.learn_more);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(r0, 0, string.length(), 33);
        textView.setText(TextUtils.concat(textView.getText(), " ", spannableString));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static /* synthetic */ void j(ViewSwitcher viewSwitcher, PositiveDiagnosisEntityAdapter positiveDiagnosisEntityAdapter, TextView textView, List list) {
        int i = 8;
        viewSwitcher.setVisibility(list.isEmpty() ? 8 : 0);
        viewSwitcher.setDisplayedChild(!list.isEmpty());
        positiveDiagnosisEntityAdapter.setPositiveDiagnosisEntities(list);
        if (!list.isEmpty()) {
            i = 0;
        }
        textView.setVisibility(i);
    }

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
            String q = a.q("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            x xVar = viewModelStore.f2263a.get(q);
            if (!NotifyHomeViewModel.class.isInstance(xVar)) {
                xVar = defaultViewModelProviderFactory instanceof y.c ? ((y.c) defaultViewModelProviderFactory).c(q, NotifyHomeViewModel.class) : defaultViewModelProviderFactory.a(NotifyHomeViewModel.class);
                x put = viewModelStore.f2263a.put(q, xVar);
                if (put != null) {
                    put.onCleared();
                }
            } else if (defaultViewModelProviderFactory instanceof y.e) {
                ((y.e) defaultViewModelProviderFactory).b(xVar);
            }
            this.notifyHomeViewModel = (NotifyHomeViewModel) xVar;
            this.exposureNotificationViewModel.getIsEnabledLiveData().observe(getViewLifecycleOwner(), new g(this));
            Button button = (Button) view.findViewById(R.id.start_api_button);
            button.setOnClickListener(new c(this));
            this.exposureNotificationViewModel.getInFlightLiveData().observe(getViewLifecycleOwner(), new e(button));
            this.exposureNotificationViewModel.getApiErrorLiveEvent().observe(getViewLifecycleOwner(), new d(this));
            ((Button) view.findViewById(R.id.fragment_notify_share_button)).setOnClickListener(new f(this));
            PositiveDiagnosisEntityAdapter positiveDiagnosisEntityAdapter = new PositiveDiagnosisEntityAdapter(new e.a.a.f.a(this));
            getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1, false);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.notify_recycler_view);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(positiveDiagnosisEntityAdapter);
            this.notifyHomeViewModel.getAllPositiveDiagnosisEntityLiveData().observe(getViewLifecycleOwner(), new b((ViewSwitcher) requireView().findViewById(R.id.fragment_notify_diagnosis_switcher), positiveDiagnosisEntityAdapter, (TextView) view.findViewById(R.id.fragment_notify_diagnosis_heading)));
            ((TextView) view.findViewById(R.id.fragment_notify_description)).setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
