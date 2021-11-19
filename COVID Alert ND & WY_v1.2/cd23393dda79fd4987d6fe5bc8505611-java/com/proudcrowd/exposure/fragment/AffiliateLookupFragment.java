package com.proudcrowd.exposure.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.activity.AffiliateDetailActivity;
import com.proudcrowd.exposure.datamodel.AffiliateDetail;
import com.proudcrowd.exposure.fragment.BaseCellAdapter;

public class AffiliateLookupFragment extends BaseListFragment<AffiliateDetail> implements AdapterView.OnItemClickListener, BaseCellAdapter.CellConsumer {
    private int mCategoryId;

    public static AffiliateLookupFragment newInstance(int i) {
        AffiliateLookupFragment affiliateLookupFragment = new AffiliateLookupFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("CategoryId", i);
        affiliateLookupFragment.setArguments(bundle);
        return affiliateLookupFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mCategoryId = getArguments().getInt("CategoryId");
        this.mCellAdapter = new AffiliateLookupFragmentCell(this.mAppContext, this.mCategoryId, this);
        setListAdapter(this.mCellAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.ListFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_affiliate_lookup, viewGroup, false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this.mAppContext, AffiliateDetailActivity.class);
        intent.putExtra("AffiliateId", ((AffiliateDetail) getListView().getItemAtPosition(i)).id);
        intent.putExtra("IsJoinMode", true);
        getActivity().startActivityForResult(intent, AffiliateDetailActivity.AFFILIATE_DETAIL_RESULT);
        getActivity().overridePendingTransition(R.anim.animation_enter, R.anim.animation_none);
    }

    @Override // com.proudcrowd.exposure.fragment.BaseListFragment, com.proudcrowd.exposure.fragment.BaseCellAdapter.CellConsumer
    public void onDataLoadedNoData() {
        ((TextView) getView().findViewById(16908292)).setText("No Affiliates Available.");
    }
}
