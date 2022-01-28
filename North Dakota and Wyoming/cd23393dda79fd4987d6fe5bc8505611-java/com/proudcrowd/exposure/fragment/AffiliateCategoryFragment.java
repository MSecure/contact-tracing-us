package com.proudcrowd.exposure.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.activity.AffiliateDetailActivity;
import com.proudcrowd.exposure.activity.AffiliateLookupActivity;
import com.proudcrowd.exposure.datamodel.AffiliateCategoryDetail;

public class AffiliateCategoryFragment extends BaseListFragment<AffiliateCategoryDetail> implements AdapterView.OnItemClickListener {
    public static AffiliateCategoryFragment newInstance() {
        AffiliateCategoryFragment affiliateCategoryFragment = new AffiliateCategoryFragment();
        affiliateCategoryFragment.setArguments(new Bundle());
        return affiliateCategoryFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getListView().setOnItemClickListener(this);
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.ListFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mCellAdapter = new AffiliateCategoryFragmentCell(this.mAppContext, this);
        setListAdapter(this.mCellAdapter);
        return layoutInflater.inflate(R.layout.fragment_affiliate_category, viewGroup, false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this.mAppContext, AffiliateLookupActivity.class);
        intent.putExtra("CategoryId", ((AffiliateCategoryDetail) getListView().getItemAtPosition(i)).id);
        getActivity().startActivityForResult(intent, AffiliateDetailActivity.AFFILIATE_DETAIL_RESULT);
        getActivity().overridePendingTransition(R.anim.animation_enter, R.anim.animation_none);
    }
}
