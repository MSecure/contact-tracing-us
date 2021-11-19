package com.proudcrowd.exposure.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.storage.KeyScanEntity;
import com.proudcrowd.exposure.viewmodel.ExposureViewModel;
import com.proudcrowd.exposure.viewmodel.RepositoryViewModel;
import java.util.List;

public class CheckScansFragment extends BaseListFragmentLocal<KeyScanEntity> {
    private ExposureViewModel mExposureViewModel;
    private RepositoryViewModel mRepositoryViewModel;
    private LinearLayout mScanLayout;
    private LinearLayout mWarningLayout;
    private TextView mWarningText;

    public static CheckScansFragment newInstance() {
        CheckScansFragment checkScansFragment = new CheckScansFragment();
        checkScansFragment.setArguments(new Bundle());
        return checkScansFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getArguments();
        this.mScanLayout = (LinearLayout) getView().findViewById(R.id.check_scan_list_section);
        this.mWarningLayout = (LinearLayout) getView().findViewById(R.id.check_scan_warning_section);
        this.mWarningText = (TextView) getView().findViewById(R.id.check_scan_warning_text);
        ExposureViewModel exposureViewModel = (ExposureViewModel) new ViewModelProvider(this).get(ExposureViewModel.class);
        this.mExposureViewModel = exposureViewModel;
        exposureViewModel.getStateLiveData().observe(getActivity(), new Observer() {
            /* class com.proudcrowd.exposure.fragment.$$Lambda$CheckScansFragment$EszFeLdYxR5m637R9DXYfsF6__w */

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CheckScansFragment.this.lambda$onActivityCreated$0$CheckScansFragment((ExposureViewModel.ExposureNotificationState) obj);
            }
        });
        RepositoryViewModel repositoryViewModel = (RepositoryViewModel) new ViewModelProvider(this).get(RepositoryViewModel.class);
        this.mRepositoryViewModel = repositoryViewModel;
        repositoryViewModel.getScanLiveData().observe(getViewLifecycleOwner(), new Observer() {
            /* class com.proudcrowd.exposure.fragment.$$Lambda$CheckScansFragment$qh1H8HsJmIc97aZyqtmwcle2Rg8 */

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CheckScansFragment.lambda$qh1H8HsJmIc97aZyqtmwcle2Rg8(CheckScansFragment.this, (List) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.ListFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mCellAdapter = new CheckScansFragmentCell(this);
        setListAdapter(this.mCellAdapter);
        return layoutInflater.inflate(R.layout.fragment_check_scans, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mExposureViewModel.refreshIsEnabledState();
    }

    /* access modifiers changed from: private */
    public void refreshUiForExposureEntities(List<KeyScanEntity> list) {
        this.mCellAdapter.loadData(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.proudcrowd.exposure.fragment.CheckScansFragment$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$proudcrowd$exposure$viewmodel$ExposureViewModel$ExposureNotificationState;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[ExposureViewModel.ExposureNotificationState.values().length];
            $SwitchMap$com$proudcrowd$exposure$viewmodel$ExposureViewModel$ExposureNotificationState = iArr;
            iArr[ExposureViewModel.ExposureNotificationState.ENABLED.ordinal()] = 1;
            $SwitchMap$com$proudcrowd$exposure$viewmodel$ExposureViewModel$ExposureNotificationState[ExposureViewModel.ExposureNotificationState.PAUSED_BLE_OFF.ordinal()] = 2;
            $SwitchMap$com$proudcrowd$exposure$viewmodel$ExposureViewModel$ExposureNotificationState[ExposureViewModel.ExposureNotificationState.PAUSED_LOCATION_OFF.ordinal()] = 3;
            $SwitchMap$com$proudcrowd$exposure$viewmodel$ExposureViewModel$ExposureNotificationState[ExposureViewModel.ExposureNotificationState.STORAGE_LOW.ordinal()] = 4;
            $SwitchMap$com$proudcrowd$exposure$viewmodel$ExposureViewModel$ExposureNotificationState[ExposureViewModel.ExposureNotificationState.DISABLED.ordinal()] = 5;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshUiForState */
    public void lambda$onActivityCreated$0$CheckScansFragment(ExposureViewModel.ExposureNotificationState exposureNotificationState) {
        int i = AnonymousClass1.$SwitchMap$com$proudcrowd$exposure$viewmodel$ExposureViewModel$ExposureNotificationState[exposureNotificationState.ordinal()];
        if (i == 1) {
            this.mScanLayout.setVisibility(0);
            this.mWarningLayout.setVisibility(8);
        } else if (i == 2) {
            this.mScanLayout.setVisibility(8);
            this.mWarningLayout.setVisibility(0);
            this.mWarningText.setText(R.string.check_warning_text_noble);
        } else if (i == 3) {
            this.mScanLayout.setVisibility(8);
            this.mWarningLayout.setVisibility(0);
            this.mWarningText.setText(R.string.check_warning_text_nolocation);
        } else if (i != 4) {
            this.mScanLayout.setVisibility(8);
            this.mWarningLayout.setVisibility(0);
            this.mWarningText.setText(R.string.check_warning_text_enoff);
        } else {
            this.mScanLayout.setVisibility(8);
            this.mWarningLayout.setVisibility(0);
            this.mWarningText.setText(R.string.check_warning_text_nospace);
        }
    }
}
