package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.InfoDetail;
import java.util.ArrayList;
import retrofit2.Callback;

public class InfoDataSource extends BaseDataSource<InfoDetail> {
    Callback<ArrayList<InfoDetail>> mCallback;
    String mDeviceGuid;
    int mStudyId;

    public InfoDataSource(Callback<ArrayList<InfoDetail>> callback, String str, int i) {
        this.mCallback = callback;
        this.mDeviceGuid = str;
        this.mStudyId = i;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        this.GetDataApi.InfoGet(2, this.mStudyId, this.mDeviceGuid).enqueue(this.mCallback);
    }
}
