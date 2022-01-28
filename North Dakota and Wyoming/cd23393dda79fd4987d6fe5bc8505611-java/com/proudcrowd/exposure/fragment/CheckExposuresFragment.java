package com.proudcrowd.exposure.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.activity.ExposureActivity;
import com.proudcrowd.exposure.storage.ExposureEntity;
import com.proudcrowd.exposure.viewmodel.ExposureViewModel;
import com.proudcrowd.exposure.viewmodel.RepositoryViewModel;
import java.util.List;

public class CheckExposuresFragment extends BaseFragment {
    private LinearLayoutCompat mCongratsLayout;
    private LinearLayoutCompat mExposureLayout;
    private ExposureViewModel mExposureViewModel;
    private Button mLookup;
    private RepositoryViewModel mRepositoryViewModel;

    /* access modifiers changed from: private */
    /* renamed from: refreshUiForEnabled */
    public void lambda$onActivityCreated$0$CheckExposuresFragment(Boolean bool) {
    }

    public static CheckExposuresFragment newInstance() {
        return new CheckExposuresFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mCongratsLayout = (LinearLayoutCompat) getView().findViewById(R.id.congrats_panel);
        this.mExposureLayout = (LinearLayoutCompat) getView().findViewById(R.id.exposure_panel);
        ExposureViewModel exposureViewModel = (ExposureViewModel) new ViewModelProvider(this).get(ExposureViewModel.class);
        this.mExposureViewModel = exposureViewModel;
        exposureViewModel.getIsEnabledLiveData().observe(getActivity(), new Observer() {
            /* class com.proudcrowd.exposure.fragment.$$Lambda$CheckExposuresFragment$L3woq6a5oAnQeVbjKW4mSd8sC7U */

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CheckExposuresFragment.this.lambda$onActivityCreated$0$CheckExposuresFragment((Boolean) obj);
            }
        });
        RepositoryViewModel repositoryViewModel = (RepositoryViewModel) new ViewModelProvider(this).get(RepositoryViewModel.class);
        this.mRepositoryViewModel = repositoryViewModel;
        repositoryViewModel.getExposureLiveData().observe(getViewLifecycleOwner(), new Observer() {
            /* class com.proudcrowd.exposure.fragment.$$Lambda$CheckExposuresFragment$gJiNT6xRDYTytl6736mk0H8XbAg */

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CheckExposuresFragment.lambda$gJiNT6xRDYTytl6736mk0H8XbAg(CheckExposuresFragment.this, (List) obj);
            }
        });
        Button button = (Button) getActivity().findViewById(R.id.exposure_instructions_button);
        this.mLookup = button;
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.fragment.CheckExposuresFragment.AnonymousClass1 */

            public void onClick(View view) {
                CheckExposuresFragment.this.getActivity().startActivity(new Intent(CheckExposuresFragment.this.mAppContext, ExposureActivity.class));
                CheckExposuresFragment.this.getActivity().overridePendingTransition(R.anim.animation_enter, R.anim.animation_none);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_check_exposures, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mExposureViewModel.refreshIsEnabledState();
    }

    /* access modifiers changed from: private */
    public void refreshUiForExposureEntities(List<ExposureEntity> list) {
        if (!list.isEmpty()) {
            this.mCongratsLayout.setVisibility(8);
            this.mExposureLayout.setVisibility(0);
        }
    }
}
