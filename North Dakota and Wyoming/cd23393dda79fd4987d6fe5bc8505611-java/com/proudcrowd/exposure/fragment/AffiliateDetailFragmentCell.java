package com.proudcrowd.exposure.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.datamodel.CapabilityDetail;

public class AffiliateDetailFragmentCell extends BaseCellAdapterLocal<CapabilityDetail> {
    private FragmentActivity mControllingActivity;
    private LayoutInflater mLayoutInflater;

    public AffiliateDetailFragmentCell(BaseListFragmentLocal baseListFragmentLocal) {
        this.mControllingActivity = baseListFragmentLocal.getActivity();
        this.mLayoutInflater = (LayoutInflater) baseListFragmentLocal.getActivity().getSystemService("layout_inflater");
    }

    @Override // com.proudcrowd.exposure.fragment.BaseCellAdapterLocal
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        if (view == null) {
            linearLayout = (LinearLayout) this.mLayoutInflater.inflate(R.layout.fragment_affiliate_detail_cell, viewGroup, false);
        } else {
            linearLayout = (LinearLayout) view;
        }
        TextView textView = (TextView) linearLayout.findViewById(R.id.capability_title);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.capability_detail);
        if (this.mLocalData != null) {
            CapabilityDetail capabilityDetail = (CapabilityDetail) this.mLocalData.get(i);
            textView.setText(capabilityDetail.title);
            textView2.setText(capabilityDetail.detail);
        }
        return linearLayout;
    }
}
