package com.proudcrowd.exposure.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.proudcrowd.exposure.core.ExposureApplication;

public class BaseFragment extends Fragment {
    protected final String TAG = getClass().getSimpleName();
    protected ExposureApplication mAppContext;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAppContext = (ExposureApplication) getActivity().getApplicationContext();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }
}
