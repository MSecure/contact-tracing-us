package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.AffiliateDetail;
import java.util.ArrayList;
import retrofit2.Callback;

public class AffiliatesDataSource extends BaseDataSource<AffiliateDetail> {
    private final Callback<ArrayList<AffiliateDetail>> mCallback;
    private final int mCategoryId;
    private final String mDeviceGuid;
    private final int mRegionId;

    public AffiliatesDataSource(int i, int i2, String str, Callback<ArrayList<AffiliateDetail>> callback) {
        this.mRegionId = i;
        this.mCategoryId = i2;
        this.mDeviceGuid = str;
        this.mCallback = callback;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        this.GetDataApi.AffiliatesGet(2, this.mRegionId, this.mCategoryId, this.mDeviceGuid).enqueue(this.mCallback);
    }
}
