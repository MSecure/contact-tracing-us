package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.ProtectDetail;
import retrofit2.Callback;

public class ProtectDataSource extends BaseDataSource<ProtectDetail> {
    Callback<ProtectDetail> mCallback;
    String mDeviceGuid;

    public ProtectDataSource(Callback<ProtectDetail> callback, String str) {
        this.mCallback = callback;
        this.mDeviceGuid = str;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        this.GetDataApi.ProtectGet(2, this.mDeviceGuid).enqueue(this.mCallback);
    }
}
