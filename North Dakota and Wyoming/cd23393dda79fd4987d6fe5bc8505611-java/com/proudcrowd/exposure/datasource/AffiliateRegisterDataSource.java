package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.AffiliateDetail;
import com.proudcrowd.exposure.datamodel.AffiliatePostDetail;
import retrofit2.Callback;

public class AffiliateRegisterDataSource extends BaseDataSource<AffiliateDetail> {
    private final int mAffiliateId;
    private final Callback<Void> mCallback;
    private final String mDeviceGuid;

    public AffiliateRegisterDataSource(String str, int i, Callback<Void> callback) {
        this.mDeviceGuid = str;
        this.mAffiliateId = i;
        this.mCallback = callback;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        AffiliatePostDetail affiliatePostDetail = new AffiliatePostDetail();
        affiliatePostDetail.affiliateId = this.mAffiliateId;
        this.GetDataApi.AffiliatePost(2, this.mDeviceGuid, affiliatePostDetail).enqueue(this.mCallback);
    }
}
