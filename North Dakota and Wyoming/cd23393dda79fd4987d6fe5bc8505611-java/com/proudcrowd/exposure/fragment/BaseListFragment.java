package com.proudcrowd.exposure.fragment;

import android.os.Bundle;
import androidx.fragment.app.ListFragment;
import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.fragment.BaseCellAdapter;

public class BaseListFragment<InnerType> extends ListFragment implements BaseCellAdapter.CellConsumer {
    protected ExposureApplication mAppContext;
    protected BaseCellAdapter<InnerType> mCellAdapter;

    @Override // com.proudcrowd.exposure.fragment.BaseCellAdapter.CellConsumer
    public void onDataLoaded() {
    }

    @Override // com.proudcrowd.exposure.fragment.BaseCellAdapter.CellConsumer
    public void onDataLoadedNoData() {
    }

    @Override // com.proudcrowd.exposure.fragment.BaseCellAdapter.CellConsumer
    public void onDataLoadedWithError(String str) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAppContext = (ExposureApplication) getActivity().getApplicationContext();
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.ListFragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.proudcrowd.exposure.fragment.BaseCellAdapter.CellConsumer
    public ExposureApplication getAppContext() {
        return this.mAppContext;
    }
}
