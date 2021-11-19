package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.DeviceRegisterDetail;
import com.proudcrowd.exposure.datamodel.DeviceRegisterPostDetail;
import retrofit2.Callback;

public class DeviceRegisterDataSource extends BaseDataSource<DeviceRegisterDetail> {
    Callback<DeviceRegisterDetail> mCallback;
    String mDeviceGuid;
    String mDeviceType;
    String mOperatorName;
    int mRegionId;

    public DeviceRegisterDataSource(Callback<DeviceRegisterDetail> callback, String str, String str2, String str3, int i) {
        this.mCallback = callback;
        this.mDeviceGuid = str;
        this.mDeviceType = str2;
        this.mOperatorName = str3;
        this.mRegionId = i;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        DeviceRegisterPostDetail deviceRegisterPostDetail = new DeviceRegisterPostDetail();
        deviceRegisterPostDetail.deviceGuid = this.mDeviceGuid;
        deviceRegisterPostDetail.deviceType = this.mDeviceType;
        deviceRegisterPostDetail.operatorName = this.mOperatorName;
        deviceRegisterPostDetail.isAndroid = true;
        this.GetDataApi.DevicePost(2, this.mRegionId, deviceRegisterPostDetail).enqueue(this.mCallback);
    }
}
