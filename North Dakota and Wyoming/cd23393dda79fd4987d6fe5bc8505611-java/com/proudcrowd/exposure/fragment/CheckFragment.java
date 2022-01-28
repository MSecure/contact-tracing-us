package com.proudcrowd.exposure.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.misc.TabFragmentConsumer;
import com.proudcrowd.exposure.storage.ExposureEntity;
import com.proudcrowd.exposure.viewmodel.RepositoryViewModel;
import java.util.List;

public class CheckFragment extends BaseFragment implements TabFragmentConsumer {
    private FragmentContainerView mExposuresFragment;
    private RepositoryViewModel mRepositoryViewModel;

    @Override // com.proudcrowd.exposure.misc.TabFragmentConsumer
    public void onNotSelected() {
    }

    @Override // com.proudcrowd.exposure.misc.TabFragmentConsumer
    public void onSelected() {
    }

    public static CheckFragment newInstance() {
        CheckFragment checkFragment = new CheckFragment();
        checkFragment.setArguments(new Bundle());
        return checkFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mExposuresFragment = (FragmentContainerView) getView().findViewById(R.id.check_exposures_fragment);
        RepositoryViewModel repositoryViewModel = (RepositoryViewModel) new ViewModelProvider(this).get(RepositoryViewModel.class);
        this.mRepositoryViewModel = repositoryViewModel;
        repositoryViewModel.getExposureLiveData().observe(getViewLifecycleOwner(), new Observer() {
            /* class com.proudcrowd.exposure.fragment.$$Lambda$CheckFragment$pTDIDc_Bdw02UNYhBVkQGg7tOyQ */

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CheckFragment.this.refreshUiForExposureEntities((List) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_check, viewGroup, false);
    }

    /* access modifiers changed from: private */
    public void refreshUiForExposureEntities(List<ExposureEntity> list) {
        if (!list.isEmpty()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mExposuresFragment.getLayoutParams();
            layoutParams.weight = 2.0f;
            this.mExposuresFragment.setLayoutParams(layoutParams);
        }
    }
}
