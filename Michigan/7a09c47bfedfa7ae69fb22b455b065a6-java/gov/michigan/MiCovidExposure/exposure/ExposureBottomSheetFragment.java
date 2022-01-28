package gov.michigan.MiCovidExposure.exposure;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import c.b.a.b.r.d;
import e.a.a.b.c;
import g.b.a.w.b;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.common.StringUtils;
import gov.michigan.MiCovidExposure.storage.ExposureEntity;

public class ExposureBottomSheetFragment extends d {
    public static final String KEY_DATE_MILLIS_SINCE_EPOCH = "KEY_DATE_MILLIS_SINCE_EPOCH";
    public static final String KEY_RECEIVED_TIMESTAMP_MS = "KEY_RECEIVED_TIMESTAMP_MS";
    public static final String TAG = "ExposureBottomSheetFragment";

    private void doneClicked() {
        dismiss();
    }

    private String getFormattedInfoText(long j) {
        return getString(R.string.info_saved_locally, StringUtils.epochTimestampToMediumUTCDateString(j, getResources().getConfiguration().locale));
    }

    private String getFormattedPossibleExposureSubheading(long j) {
        g.b.a.d F = g.b.a.d.F(System.currentTimeMillis());
        g.b.a.d F2 = g.b.a.d.F(j);
        b bVar = b.DAYS;
        if (bVar != null) {
            int y = (int) F2.y(F, bVar);
            return getResources().getQuantityString(R.plurals.possible_exposure_subheading, y, Integer.valueOf(y));
        }
        throw null;
    }

    private String getFormattedResultsExplanation(long j) {
        return getString(R.string.verified_result_explanation, StringUtils.epochTimestampToMediumUTCDateString(j, getResources().getConfiguration().locale));
    }

    private void learnMoreClicked() {
        startActivity(new Intent(requireContext(), ExposureLearnMoreActivity.class));
    }

    public static ExposureBottomSheetFragment newInstance(ExposureEntity exposureEntity) {
        ExposureBottomSheetFragment exposureBottomSheetFragment = new ExposureBottomSheetFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(KEY_DATE_MILLIS_SINCE_EPOCH, exposureEntity.getDateMillisSinceEpoch());
        bundle.putLong(KEY_RECEIVED_TIMESTAMP_MS, exposureEntity.getReceivedTimestampMs());
        exposureBottomSheetFragment.setArguments(bundle);
        return exposureBottomSheetFragment;
    }

    public /* synthetic */ void d(View view) {
        learnMoreClicked();
    }

    public /* synthetic */ void e(View view) {
        doneClicked();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_exposure_bottom_sheet, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.possible_exposure_subheading);
        TextView textView2 = (TextView) view.findViewById(R.id.verified_result_explanation);
        Button button = (Button) view.findViewById(R.id.learn_more_button);
        TextView textView3 = (TextView) view.findViewById(R.id.info_status);
        Button button2 = (Button) view.findViewById(R.id.done_button);
        if (getArguments() != null) {
            long j = getArguments().getLong(KEY_DATE_MILLIS_SINCE_EPOCH);
            textView2.setText(getFormattedResultsExplanation(j));
            textView.setText(getFormattedPossibleExposureSubheading(j));
            textView3.setText(getFormattedInfoText(getArguments().getLong(KEY_RECEIVED_TIMESTAMP_MS)));
        }
        button.setOnClickListener(new c(this));
        button2.setOnClickListener(new e.a.a.b.d(this));
    }
}
