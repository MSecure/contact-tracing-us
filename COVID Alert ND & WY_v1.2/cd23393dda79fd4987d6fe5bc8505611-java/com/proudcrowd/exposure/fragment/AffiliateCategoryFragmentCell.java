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
import com.proudcrowd.exposure.datamodel.AffiliateCategoryDetail;
import com.proudcrowd.exposure.datasource.AffiliateCategoryDataSource;

public class AffiliateCategoryFragmentCell extends BaseCellAdapter<AffiliateCategoryDetail> {
    private ExposureApplication mContext;
    private FragmentActivity mControllingActivity;
    private AffiliateCategoryDataSource mDataSource = new AffiliateCategoryDataSource(this.mContext.mStudy.id, this);
    private LayoutInflater mLayoutInflater;

    public AffiliateCategoryFragmentCell(ExposureApplication exposureApplication, BaseListFragment baseListFragment) {
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
            linearLayout = (LinearLayout) this.mLayoutInflater.inflate(R.layout.standard_one_line_cell, viewGroup, false);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.standard_icon);
        TextView textView = (TextView) linearLayout.findViewById(R.id.standard_title);
        if (this.mDataSource.getResults() != null) {
            AffiliateCategoryDetail affiliateCategoryDetail = (AffiliateCategoryDetail) this.mDataSource.getResults().get(i);
            textView.setText(affiliateCategoryDetail.title);
            if (affiliateCategoryDetail.imageUrl != null) {
                Glide.with(this.mControllingActivity).load(affiliateCategoryDetail.imageUrl).into(imageView);
                imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this.mControllingActivity, R.color.colorAccent)));
            }
        }
        return linearLayout;
    }
}
