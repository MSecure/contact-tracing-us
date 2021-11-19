package com.proudcrowd.exposure.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.datamodel.AffiliateDetail;
import com.proudcrowd.exposure.datamodel.CapabilityDetail;
import com.proudcrowd.exposure.datasource.AffiliateDataSource;
import com.proudcrowd.exposure.datasource.AffiliateDeleteDataSource;
import com.proudcrowd.exposure.datasource.AffiliateRegisterDataSource;
import java.util.Arrays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AffiliateDetailFragment extends BaseListFragmentLocal<CapabilityDetail> implements Callback<AffiliateDetail> {
    private Button mActionButton;
    private int mAffiliateId;
    private AffiliateDataSource mDataSource;
    private AffiliateDeleteDataSource mDeleteDataSource;
    private boolean mIsJoinMode;
    private AffiliateRegisterDataSource mRegisterDataSource;

    @Override // retrofit2.Callback
    public void onFailure(Call<AffiliateDetail> call, Throwable th) {
    }

    public static AffiliateDetailFragment newInstance(int i, boolean z) {
        AffiliateDetailFragment affiliateDetailFragment = new AffiliateDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("AffiliateId", i);
        bundle.putBoolean("IsJoinMode", z);
        affiliateDetailFragment.setArguments(bundle);
        return affiliateDetailFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        this.mAffiliateId = arguments.getInt("AffiliateId");
        this.mIsJoinMode = arguments.getBoolean("IsJoinMode");
        Button button = (Button) getActivity().findViewById(R.id.affiliate_join_button);
        this.mActionButton = button;
        if (this.mIsJoinMode) {
            button.setText("JOIN");
        } else {
            button.setText("DELETE");
        }
        this.mActionButton.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.fragment.AffiliateDetailFragment.AnonymousClass1 */

            public void onClick(View view) {
                if (AffiliateDetailFragment.this.mIsJoinMode) {
                    AffiliateDetailFragment.this.joinAffiliate();
                } else {
                    AffiliateDetailFragment.this.leaveAffiliate();
                }
            }
        });
        AffiliateDataSource affiliateDataSource = new AffiliateDataSource(this.mAppContext.mStudy.id, this.mAffiliateId, this);
        this.mDataSource = affiliateDataSource;
        affiliateDataSource.ExecuteRequest();
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.ListFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mCellAdapter = new AffiliateDetailFragmentCell(this);
        setListAdapter(this.mCellAdapter);
        return layoutInflater.inflate(R.layout.fragment_affiliate_detail, viewGroup, false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void joinAffiliate() {
        this.mActionButton.setEnabled(false);
        AffiliateRegisterDataSource affiliateRegisterDataSource = new AffiliateRegisterDataSource(this.mAppContext.mDeviceGuid, this.mAffiliateId, new Callback<Void>() {
            /* class com.proudcrowd.exposure.fragment.AffiliateDetailFragment.AnonymousClass2 */

            @Override // retrofit2.Callback
            public void onResponse(Call<Void> call, Response<Void> response) {
                AffiliateDetailFragment.this.getActivity().setResult(-1, new Intent());
                AffiliateDetailFragment.this.getActivity().finish();
                AffiliateDetailFragment.this.getActivity().overridePendingTransition(R.anim.animation_none, R.anim.animation_exit);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<Void> call, Throwable th) {
                AffiliateDetailFragment.this.mActionButton.setEnabled(true);
            }
        });
        this.mRegisterDataSource = affiliateRegisterDataSource;
        affiliateRegisterDataSource.ExecuteRequest();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void leaveAffiliate() {
        this.mActionButton.setEnabled(false);
        AffiliateDeleteDataSource affiliateDeleteDataSource = new AffiliateDeleteDataSource(this.mAppContext.mDeviceGuid, this.mAffiliateId, new Callback<Boolean>() {
            /* class com.proudcrowd.exposure.fragment.AffiliateDetailFragment.AnonymousClass3 */

            @Override // retrofit2.Callback
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                AffiliateDetailFragment.this.getActivity().setResult(-1, new Intent());
                AffiliateDetailFragment.this.getActivity().finish();
                AffiliateDetailFragment.this.getActivity().overridePendingTransition(R.anim.animation_none, R.anim.animation_exit);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<Boolean> call, Throwable th) {
                AffiliateDetailFragment.this.mActionButton.setEnabled(true);
            }
        });
        this.mDeleteDataSource = affiliateDeleteDataSource;
        affiliateDeleteDataSource.ExecuteRequest();
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<AffiliateDetail> call, Response<AffiliateDetail> response) {
        if (response.body() != null) {
            AffiliateDetail body = response.body();
            this.mCellAdapter.loadData(Arrays.asList(body.capabilities));
            ((TextView) getView().findViewById(R.id.affiliate_name)).setText(body.name);
            ImageView imageView = (ImageView) getView().findViewById(R.id.affiliate_icon);
            if (body.imageUrl != null) {
                Glide.with(getActivity()).load(body.imageUrl).into(imageView);
            }
        }
    }
}
