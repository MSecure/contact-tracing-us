package com.proudcrowd.exposure.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.datamodel.StudyDetail;
import com.proudcrowd.exposure.datasource.StudyDataSource;

public class StudyPickerCell extends BaseCellAdapter<StudyDetail> {
    private ExposureApplication mContext;
    private FragmentActivity mControllingActivity;
    private StudyDataSource mDataSource = new StudyDataSource(this, this.mContext.mDeviceGuid);
    private LayoutInflater mLayoutInflater;

    public StudyPickerCell(ExposureApplication exposureApplication, BaseListFragment baseListFragment) {
        this.mContext = exposureApplication;
        this.mControllingActivity = baseListFragment.getActivity();
        this.mLayoutInflater = (LayoutInflater) baseListFragment.getActivity().getSystemService("layout_inflater");
        super.initDataSource(this.mDataSource, baseListFragment);
        super.loadData();
    }

    @Override // com.proudcrowd.exposure.fragment.BaseCellAdapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) view;
        if (view == null) {
            linearLayout = (LinearLayout) this.mLayoutInflater.inflate(R.layout.standard_two_line_cell, viewGroup, false);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.standard_icon);
        TextView textView = (TextView) linearLayout.findViewById(R.id.standard_title);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.standard_detail);
        if (this.mDataSource.getResults() != null) {
            StudyDetail studyDetail = (StudyDetail) this.mDataSource.getResults().get(i);
            textView.setText(studyDetail.name);
            textView2.setText(studyDetail.institutionName);
            Glide.with(this.mControllingActivity).load(studyDetail.imageUrl).into(imageView);
        }
        return linearLayout;
    }
}
