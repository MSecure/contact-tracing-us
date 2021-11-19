package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.datamodel.ExposureConfigurationDetail;
import retrofit2.Call;

public class ExposureConfigurationDataSource extends BaseFuturesDataSource<ExposureConfigurationDetail> {
    private final String mDeviceGuid;
    private final int mRegionId;

    public ExposureConfigurationDataSource(String str, int i) {
        this.mDeviceGuid = str;
        this.mRegionId = i;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseFuturesDataSource
    public Call<ExposureConfigurationDetail> CallApi() {
        return ((BaseFuturesDataSource) this).GetDataApi.DeviceConfigurationGet(2, this.mDeviceGuid, this.mRegionId, ExposureApplication.TEK_SERVER_VERSION);
    }
}
