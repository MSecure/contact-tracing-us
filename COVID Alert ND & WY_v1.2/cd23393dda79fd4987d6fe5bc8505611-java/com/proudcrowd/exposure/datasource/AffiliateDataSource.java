package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.AffiliateDetail;
import retrofit2.Callback;

public class AffiliateDataSource extends BaseDataSource<AffiliateDetail> {
    private final int mAffiliateId;
    private final Callback<AffiliateDetail> mCallback;
    private final int mRegionId;

    public AffiliateDataSource(int i, int i2, Callback<AffiliateDetail> callback) {
        this.mRegionId = i;
        this.mAffiliateId = i2;
        this.mCallback = callback;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        this.GetDataApi.AffiliateGetSingle(2, this.mRegionId, this.mAffiliateId).enqueue(this.mCallback);
    }
}
