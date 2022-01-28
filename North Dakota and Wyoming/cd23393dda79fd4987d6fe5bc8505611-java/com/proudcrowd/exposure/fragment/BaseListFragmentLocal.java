package com.proudcrowd.exposure.fragment;

import android.os.Bundle;
import androidx.fragment.app.ListFragment;
import com.proudcrowd.exposure.core.ExposureApplication;

public class BaseListFragmentLocal<InnerType> extends ListFragment {
    protected ExposureApplication mAppContext;
    protected BaseCellAdapterLocal<InnerType> mCellAdapter;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAppContext = (ExposureApplication) getActivity().getApplicationContext();
    }
}
