package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.PartyDetail;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;

public class PartiesDataSource extends BaseFuturesDataSource<ArrayList<PartyDetail>> {
    Callback<ArrayList<PartyDetail>> mCallback;
    private final String mDeviceGuid;
    private final int mRegionId;

    public PartiesDataSource(String str, int i, Callback<ArrayList<PartyDetail>> callback) {
        this.mDeviceGuid = str;
        this.mRegionId = i;
        this.mCallback = callback;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseFuturesDataSource, com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        CallApi().enqueue(this.mCallback);
    }

    /* access modifiers changed from: protected */
    @Override // com.proudcrowd.exposure.datasource.BaseFuturesDataSource
    public Call<ArrayList<PartyDetail>> CallApi() {
        return ((BaseFuturesDataSource) this).GetDataApi.DevicePartiesGet(2, this.mDeviceGuid, this.mRegionId);
    }
}
