package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.DeviceUpdatePostDetail;

public class DeviceUpdateDataSource extends BaseDataSource<Boolean> {
    String mDeviceGuid;
    String mMessagingToken;

    public DeviceUpdateDataSource(String str, String str2) {
        this.mDeviceGuid = str;
        this.mMessagingToken = str2;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        DeviceUpdatePostDetail deviceUpdatePostDetail = new DeviceUpdatePostDetail();
        deviceUpdatePostDetail.messagingToken = this.mMessagingToken;
        this.GetDataApi.DeviceUpdatePatch(2, this.mDeviceGuid, deviceUpdatePostDetail);
    }
}
