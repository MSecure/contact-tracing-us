package com.proudcrowd.exposure.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.activity.AffiliateCategoryLookupActivity;
import com.proudcrowd.exposure.activity.AffiliateDetailActivity;
import com.proudcrowd.exposure.core.MaintenanceManager;
import com.proudcrowd.exposure.datamodel.AffiliateDetail;
import com.proudcrowd.exposure.fragment.BaseCellAdapter;
import com.proudcrowd.exposure.misc.TabFragmentConsumer;

public class AffiliateFragment extends BaseListFragment<AffiliateDetail> implements TabFragmentConsumer, AdapterView.OnItemClickListener, BaseCellAdapter.CellConsumer {
    LinearLayout mHasAffiliatesView;
    Button mLookupButton;
    RelativeLayout mNoAffiliatesView;

    @Override // com.proudcrowd.exposure.fragment.BaseCellAdapter.CellConsumer, com.proudcrowd.exposure.fragment.BaseListFragment
    public void onDataLoadedWithError(String str) {
    }

    @Override // com.proudcrowd.exposure.misc.TabFragmentConsumer
    public void onNotSelected() {
    }

    @Override // com.proudcrowd.exposure.misc.TabFragmentConsumer
    public void onSelected() {
    }

    public static AffiliateFragment newInstance() {
        AffiliateFragment affiliateFragment = new AffiliateFragment();
        affiliateFragment.setArguments(new Bundle());
        return affiliateFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getListView().setOnItemClickListener(this);
        this.mNoAffiliatesView = (RelativeLayout) getActivity().findViewById(R.id.affiliate_noaffiliates_layout);
        this.mHasAffiliatesView = (LinearLayout) getActivity().findViewById(R.id.affiliate_hasaffiliates_layout);
        Button button = (Button) getActivity().findViewById(R.id.affiliate_lookup_button);
        this.mLookupButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.fragment.AffiliateFragment.AnonymousClass1 */

            public void onClick(View view) {
                AffiliateFragment.this.getActivity().startActivityForResult(new Intent(AffiliateFragment.this.mAppContext, AffiliateCategoryLookupActivity.class), AffiliateDetailActivity.AFFILIATE_DETAIL_RESULT);
                AffiliateFragment.this.getActivity().overridePendingTransition(R.anim.animation_enter, R.anim.animation_none);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.ListFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mCellAdapter = new AffiliateFragmentCell(this.mAppContext, this);
        setListAdapter(this.mCellAdapter);
        return layoutInflater.inflate(R.layout.fragment_affiliate, viewGroup, false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this.mAppContext, AffiliateDetailActivity.class);
        intent.putExtra("AffiliateId", ((AffiliateDetail) getListView().getItemAtPosition(i)).id);
        intent.putExtra("IsJoinMode", false);
        getActivity().startActivityForResult(intent, AffiliateDetailActivity.AFFILIATE_DETAIL_RESULT);
        getActivity().overridePendingTransition(R.anim.animation_enter, R.anim.animation_none);
    }

    public void childDialogComplete() {
        MaintenanceManager.execute(this.mAppContext);
        this.mCellAdapter.reloadList();
    }

    private void setupViews() {
        if (this.mCellAdapter.mDataSource.getResults() == null || this.mCellAdapter.mDataSource.getResults().isEmpty()) {
            this.mHasAffiliatesView.setVisibility(8);
            this.mNoAffiliatesView.setVisibility(0);
            return;
        }
        this.mHasAffiliatesView.setVisibility(0);
        this.mNoAffiliatesView.setVisibility(8);
    }

    @Override // com.proudcrowd.exposure.fragment.BaseCellAdapter.CellConsumer, com.proudcrowd.exposure.fragment.BaseListFragment
    public void onDataLoaded() {
        setupViews();
    }

    @Override // com.proudcrowd.exposure.fragment.BaseCellAdapter.CellConsumer, com.proudcrowd.exposure.fragment.BaseListFragment
    public void onDataLoadedNoData() {
        setupViews();
    }
}
