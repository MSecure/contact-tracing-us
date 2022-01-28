package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.AffiliateDetail;
import java.util.ArrayList;
import retrofit2.Callback;

public class DeviceAffiliatesDataSource extends BaseDataSource<AffiliateDetail> {
    private final Callback<ArrayList<AffiliateDetail>> mCallback;
    private final String mDeviceGuid;

    public DeviceAffiliatesDataSource(String str, Callback<ArrayList<AffiliateDetail>> callback) {
        this.mDeviceGuid = str;
        this.mCallback = callback;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        this.GetDataApi.DeviceAffiliatesGet(2, this.mDeviceGuid).enqueue(this.mCallback);
    }
}
