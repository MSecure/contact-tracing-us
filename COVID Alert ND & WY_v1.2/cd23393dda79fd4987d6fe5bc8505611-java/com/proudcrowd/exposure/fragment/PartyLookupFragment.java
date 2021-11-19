package com.proudcrowd.exposure.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.activity.PartyInstructionsActivity;
import com.proudcrowd.exposure.storage.PartyEntity;
import com.proudcrowd.exposure.viewmodel.RepositoryViewModel;
import java.util.List;

public class PartyLookupFragment extends BaseListFragmentLocal<PartyEntity> implements AdapterView.OnItemClickListener {
    private List<PartyEntity> mParties = null;
    private RepositoryViewModel mRepositoryViewModel;

    public static PartyLookupFragment newInstance() {
        return new PartyLookupFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getListView().setOnItemClickListener(this);
        RepositoryViewModel repositoryViewModel = (RepositoryViewModel) new ViewModelProvider(this).get(RepositoryViewModel.class);
        this.mRepositoryViewModel = repositoryViewModel;
        repositoryViewModel.getPartyLiveData().observe(getViewLifecycleOwner(), new Observer() {
            /* class com.proudcrowd.exposure.fragment.$$Lambda$PartyLookupFragment$hsMg9B9tlaEYlvWfQZ7pvay5hV4 */

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartyLookupFragment.this.refreshUiForPartyEntities((List) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.ListFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mCellAdapter = new PartyLookupFragmentCell(this);
        setListAdapter(this.mCellAdapter);
        return layoutInflater.inflate(R.layout.fragment_party_lookup, viewGroup, false);
    }

    /* access modifiers changed from: private */
    public void refreshUiForPartyEntities(List<PartyEntity> list) {
        this.mCellAdapter.loadData(list);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this.mAppContext, PartyInstructionsActivity.class);
        intent.putExtra("PartyId", ((PartyEntity) getListView().getItemAtPosition(i)).getId());
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.animation_enter, R.anim.animation_none);
    }
}
