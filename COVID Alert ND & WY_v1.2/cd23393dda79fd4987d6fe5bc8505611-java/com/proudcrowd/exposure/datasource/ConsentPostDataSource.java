package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.ConsentDetail;
import com.proudcrowd.exposure.datamodel.ConsentPostDetail;
import retrofit2.Call;

public class ConsentPostDataSource extends BaseFuturesDataSource<ConsentDetail> {
    ConsentPostDetail mConsentPostDetail;
    String mDeviceGuid;

    public ConsentPostDataSource(String str, ConsentPostDetail consentPostDetail) {
        this.mDeviceGuid = str;
        this.mConsentPostDetail = consentPostDetail;
    }

    /* access modifiers changed from: protected */
    @Override // com.proudcrowd.exposure.datasource.BaseFuturesDataSource
    public Call<ConsentDetail> CallApi() {
        return ((BaseFuturesDataSource) this).GetDataApi.ConsentPost(2, this.mDeviceGuid, this.mConsentPostDetail);
    }
}
