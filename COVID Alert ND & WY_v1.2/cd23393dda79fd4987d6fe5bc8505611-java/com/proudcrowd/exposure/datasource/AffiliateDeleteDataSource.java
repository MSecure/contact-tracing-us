package com.proudcrowd.exposure.datasource;

import retrofit2.Callback;

public class AffiliateDeleteDataSource extends BaseDataSource<Boolean> {
    private final int mAffiliateId;
    private final Callback<Boolean> mCallback;
    private final String mDeviceGuid;

    public AffiliateDeleteDataSource(String str, int i, Callback<Boolean> callback) {
        this.mDeviceGuid = str;
        this.mAffiliateId = i;
        this.mCallback = callback;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        this.GetDataApi.AffiliateDelete(2, this.mDeviceGuid, this.mAffiliateId).enqueue(this.mCallback);
    }
}
