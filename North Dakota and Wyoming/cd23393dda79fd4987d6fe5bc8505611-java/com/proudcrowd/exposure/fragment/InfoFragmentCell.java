package com.proudcrowd.exposure.fragment;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.datamodel.InfoDetail;
import com.proudcrowd.exposure.datasource.InfoDataSource;

public class InfoFragmentCell extends BaseCellAdapter<InfoDetail> {
    private ExposureApplication mContext;
    private FragmentActivity mControllingActivity;
    private InfoDataSource mDataSource = new InfoDataSource(this, this.mContext.mDeviceGuid, this.mContext.mStudy.id);
    private LayoutInflater mLayoutInflater;

    public InfoFragmentCell(ExposureApplication exposureApplication, BaseListFragment baseListFragment) {
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
            InfoDetail infoDetail = (InfoDetail) this.mDataSource.getResults().get(i);
            textView.setText(infoDetail.title);
            if (infoDetail.detail != null) {
                textView2.setText(infoDetail.detail);
            } else {
                textView2.setText("");
            }
            if (infoDetail.imageUrl != null) {
                Glide.with(this.mControllingActivity).load(infoDetail.imageUrl).into(imageView);
                imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this.mControllingActivity, R.color.colorAccent)));
            }
        }
        return linearLayout;
    }
}
