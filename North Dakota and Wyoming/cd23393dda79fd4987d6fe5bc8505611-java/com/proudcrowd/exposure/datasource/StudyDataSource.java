package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.StudyDetail;
import java.util.ArrayList;
import retrofit2.Callback;

public class StudyDataSource extends BaseDataSource<StudyDetail> {
    String mDeviceGuid;
    Callback<ArrayList<StudyDetail>> mStudiesCallback;
    Callback<StudyDetail> mStudyCallback;
    int mStudyId;

    public StudyDataSource(Callback<ArrayList<StudyDetail>> callback, String str) {
        this.mStudiesCallback = callback;
        this.mDeviceGuid = str;
        this.mStudyId = 0;
    }

    public StudyDataSource(Callback<StudyDetail> callback, String str, int i) {
        this.mStudyCallback = callback;
        this.mDeviceGuid = str;
        this.mStudyId = i;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        if (this.mStudyId == 0) {
            this.GetDataApi.RegionsGetAll(2).enqueue(this.mStudiesCallback);
        } else {
            this.GetDataApi.RegionGet(2, this.mStudyId).enqueue(this.mStudyCallback);
        }
    }
}
