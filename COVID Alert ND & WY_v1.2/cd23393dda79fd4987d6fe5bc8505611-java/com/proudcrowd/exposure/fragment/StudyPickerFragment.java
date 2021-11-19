package com.proudcrowd.exposure.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.activity.StudyWelcomeActivity;
import com.proudcrowd.exposure.datamodel.StudyDetail;
import com.proudcrowd.exposure.fragment.BaseCellAdapter;

public class StudyPickerFragment extends BaseListFragment<StudyDetail> implements BaseCellAdapter.CellConsumer, AdapterView.OnItemClickListener {
    @Override // com.proudcrowd.exposure.fragment.BaseListFragment, com.proudcrowd.exposure.fragment.BaseCellAdapter.CellConsumer
    public void onDataLoadedWithError(String str) {
    }

    public static StudyPickerFragment newInstance() {
        StudyPickerFragment studyPickerFragment = new StudyPickerFragment();
        studyPickerFragment.setArguments(new Bundle());
        return studyPickerFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getListView().setOnItemClickListener(this);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.ListFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_study_picker, viewGroup, false);
        this.mCellAdapter = new StudyPickerCell(this.mAppContext, this);
        setListAdapter(this.mCellAdapter);
        return inflate;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mAppContext.setStudy((StudyDetail) getListView().getItemAtPosition(i));
        getActivity().startActivity(new Intent(this.mAppContext, StudyWelcomeActivity.class));
    }
}
