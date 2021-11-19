package com.proudcrowd.exposure.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.activity.AboutActivity;
import com.proudcrowd.exposure.datamodel.InfoDetail;
import com.proudcrowd.exposure.misc.TabFragmentConsumer;

public class InfoFragment extends BaseListFragment<InfoDetail> implements TabFragmentConsumer, AdapterView.OnItemClickListener {
    private static final String TAG = "InfoFragment";

    @Override // com.proudcrowd.exposure.misc.TabFragmentConsumer
    public void onNotSelected() {
    }

    @Override // com.proudcrowd.exposure.misc.TabFragmentConsumer
    public void onSelected() {
    }

    public static InfoFragment newInstance() {
        InfoFragment infoFragment = new InfoFragment();
        infoFragment.setArguments(new Bundle());
        return infoFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getListView().setOnItemClickListener(this);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.ListFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mCellAdapter = new InfoFragmentCell(this.mAppContext, this);
        setListAdapter(this.mCellAdapter);
        return layoutInflater.inflate(R.layout.fragment_info, viewGroup, false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        InfoDetail infoDetail = (InfoDetail) getListView().getItemAtPosition(i);
        if (infoDetail.isSystem) {
            if (infoDetail.systemCode.equalsIgnoreCase("About")) {
                startActivity(new Intent(this.mAppContext, AboutActivity.class));
            }
        } else if (infoDetail.infoUrl != null) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(infoDetail.infoUrl)));
        }
    }
}
