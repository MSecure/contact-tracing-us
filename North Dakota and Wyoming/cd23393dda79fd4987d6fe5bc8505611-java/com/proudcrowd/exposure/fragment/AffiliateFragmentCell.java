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
import com.proudcrowd.exposure.datamodel.AffiliateDetail;
import com.proudcrowd.exposure.datasource.DeviceAffiliatesDataSource;

public class AffiliateFragmentCell extends BaseCellAdapter<AffiliateDetail> {
    private ExposureApplication mContext;
    private FragmentActivity mControllingActivity;
    private DeviceAffiliatesDataSource mDataSource = new DeviceAffiliatesDataSource(this.mContext.mDeviceGuid, this);
    private LayoutInflater mLayoutInflater;

    public AffiliateFragmentCell(ExposureApplication exposureApplication, BaseListFragment baseListFragment) {
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
            linearLayout = (LinearLayout) this.mLayoutInflater.inflate(R.layout.fragment_affiliate_cell, viewGroup, false);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.affiliate_icon);
        TextView textView = (TextView) linearLayout.findViewById(R.id.affiliate_name);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.affiliate_detail);
        if (this.mDataSource.getResults() != null) {
            AffiliateDetail affiliateDetail = (AffiliateDetail) this.mDataSource.getResults().get(i);
            textView.setText(affiliateDetail.name);
            if (affiliateDetail.constituentName != null) {
                textView2.setText(affiliateDetail.constituentName);
            } else {
                textView2.setText("");
            }
            if (affiliateDetail.imageUrl != null) {
                Glide.with(this.mControllingActivity).load(affiliateDetail.imageUrl).into(imageView);
            }
        }
        return linearLayout;
    }
}
