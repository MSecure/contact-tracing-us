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
import com.proudcrowd.exposure.storage.PartyEntity;

public class PartyLookupFragmentCell extends BaseCellAdapterLocal<PartyEntity> {
    private FragmentActivity mControllingActivity;
    private LayoutInflater mLayoutInflater;

    public PartyLookupFragmentCell(BaseListFragmentLocal baseListFragmentLocal) {
        this.mControllingActivity = baseListFragmentLocal.getActivity();
        this.mLayoutInflater = (LayoutInflater) baseListFragmentLocal.getActivity().getSystemService("layout_inflater");
    }

    @Override // com.proudcrowd.exposure.fragment.BaseCellAdapterLocal
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        if (view == null) {
            linearLayout = (LinearLayout) this.mLayoutInflater.inflate(R.layout.standard_two_line_cell, viewGroup, false);
        } else {
            linearLayout = (LinearLayout) view;
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.standard_icon);
        TextView textView = (TextView) linearLayout.findViewById(R.id.standard_title);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.standard_detail);
        if (this.mLocalData != null) {
            PartyEntity partyEntity = (PartyEntity) this.mLocalData.get(i);
            textView.setText(partyEntity.getName());
            textView2.setText(partyEntity.getConstituentName());
            if (partyEntity.getImageUrl() != null) {
                Glide.with(this.mControllingActivity).load(partyEntity.getImageUrl()).into(imageView);
            }
        }
        return linearLayout;
    }
}
