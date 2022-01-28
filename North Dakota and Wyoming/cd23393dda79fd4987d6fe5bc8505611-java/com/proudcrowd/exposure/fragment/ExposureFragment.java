package com.proudcrowd.exposure.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.activity.PartyInstructionsActivity;
import com.proudcrowd.exposure.activity.PartyLookupActivity;
import com.proudcrowd.exposure.storage.ExposureEntity;
import com.proudcrowd.exposure.storage.PartyEntity;
import com.proudcrowd.exposure.viewmodel.RepositoryViewModel;
import java.text.MessageFormat;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatter;

public class ExposureFragment extends BaseFragment {
    private LocalDateTime mLatestExposure;
    private List<PartyEntity> mParties = null;
    private RepositoryViewModel mRepositoryViewModel;

    public static ExposureFragment newInstance() {
        return new ExposureFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RepositoryViewModel repositoryViewModel = (RepositoryViewModel) new ViewModelProvider(this).get(RepositoryViewModel.class);
        this.mRepositoryViewModel = repositoryViewModel;
        repositoryViewModel.getExposureLiveData().observe(getViewLifecycleOwner(), new Observer() {
            /* class com.proudcrowd.exposure.fragment.$$Lambda$ExposureFragment$VoFM317OTF1VBenPa9aOKcIMUeE */

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExposureFragment.this.refreshUiForExposureEntities((List) obj);
            }
        });
        this.mRepositoryViewModel.getPartyLiveData().observe(getViewLifecycleOwner(), new Observer() {
            /* class com.proudcrowd.exposure.fragment.$$Lambda$ExposureFragment$kXn4WNSvvajB8Az9wDafkzr03YE */

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExposureFragment.this.refreshUiForPartyEntities((List) obj);
            }
        });
        ((Button) getActivity().findViewById(R.id.exposure_instructions_button)).setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.fragment.ExposureFragment.AnonymousClass1 */

            public void onClick(View view) {
                Intent intent;
                if (ExposureFragment.this.mParties == null || ExposureFragment.this.mParties.size() != 1) {
                    intent = new Intent(ExposureFragment.this.mAppContext, PartyLookupActivity.class);
                } else {
                    intent = new Intent(ExposureFragment.this.mAppContext, PartyInstructionsActivity.class);
                    intent.putExtra("PartyId", ((PartyEntity) ExposureFragment.this.mParties.get(0)).getId());
                }
                ExposureFragment.this.getActivity().startActivity(intent);
                ExposureFragment.this.getActivity().overridePendingTransition(R.anim.animation_enter, R.anim.animation_none);
            }
        });
    }

    private void customizeText() {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("EEEE, MMMM d");
        ((TextView) getActivity().findViewById(R.id.exposure_explain_header)).setText(MessageFormat.format(getResources().getString(R.string.exposure_detail_header), this.mLatestExposure.format(ofPattern)));
        ((TextView) getActivity().findViewById(R.id.exposure_explain_footer)).setText(MessageFormat.format(getResources().getString(R.string.exposure_detail_footer), this.mAppContext.mStudy.institutionName));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_exposure, viewGroup, false);
    }

    /* access modifiers changed from: private */
    public void refreshUiForExposureEntities(List<ExposureEntity> list) {
        if (!list.isEmpty()) {
            long j = 0;
            for (ExposureEntity exposureEntity : list) {
                if (exposureEntity.getDateTimestampMs() > j) {
                    j = exposureEntity.getDateTimestampMs();
                }
            }
            LocalDateTime ofInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(j), ZoneId.systemDefault());
            this.mLatestExposure = ofInstant;
            this.mLatestExposure = ofInstant.plusHours(12);
            customizeText();
        }
    }

    /* access modifiers changed from: private */
    public void refreshUiForPartyEntities(List<PartyEntity> list) {
        this.mParties = list;
    }
}
