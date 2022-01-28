package com.proudcrowd.exposure.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.storage.PartyEntity;
import com.proudcrowd.exposure.viewmodel.RepositoryViewModel;
import java.util.List;

public class PartyInstructionsFragment extends Fragment {
    private PartyInstructionsFragmentAdapter mAdapter;
    private ImageView mImageView;
    private PartyEntity mParty = null;
    private int mPartyId;
    private RecyclerView mRecyclerView;
    private RepositoryViewModel mRepositoryViewModel;

    public static PartyInstructionsFragment newInstance(int i) {
        PartyInstructionsFragment partyInstructionsFragment = new PartyInstructionsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("PartyId", i);
        partyInstructionsFragment.setArguments(bundle);
        return partyInstructionsFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mPartyId = getArguments().getInt("PartyId");
        RepositoryViewModel repositoryViewModel = (RepositoryViewModel) new ViewModelProvider(this).get(RepositoryViewModel.class);
        this.mRepositoryViewModel = repositoryViewModel;
        repositoryViewModel.getPartyLiveData().observe(getViewLifecycleOwner(), new Observer() {
            /* class com.proudcrowd.exposure.fragment.$$Lambda$PartyInstructionsFragment$WWZHh8I8B9C54Kg5z7BXJ0VzsQ */

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartyInstructionsFragment.this.refreshUiForPartyEntities((List) obj);
            }
        });
        this.mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
        this.mImageView = (ImageView) getView().findViewById(R.id.standard_icon);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_party_instructions, viewGroup, false);
    }

    /* access modifiers changed from: private */
    public void refreshUiForPartyEntities(List<PartyEntity> list) {
        for (PartyEntity partyEntity : list) {
            if (partyEntity.getId() == this.mPartyId) {
                this.mParty = partyEntity;
                this.mAdapter = new PartyInstructionsFragmentAdapter(partyEntity.getInstructions());
                this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                this.mRecyclerView.setAdapter(this.mAdapter);
                if (this.mParty.getImageUrl() != null) {
                    Glide.with(getActivity()).load(this.mParty.getImageUrl()).into(this.mImageView);
                }
            }
        }
    }
}
