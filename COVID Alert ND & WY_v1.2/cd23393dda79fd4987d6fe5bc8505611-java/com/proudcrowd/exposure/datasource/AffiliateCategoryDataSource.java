package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.AffiliateCategoryDetail;
import java.util.ArrayList;
import retrofit2.Callback;

public class AffiliateCategoryDataSource extends BaseDataSource<AffiliateCategoryDetail> {
    private final Callback<ArrayList<AffiliateCategoryDetail>> mCallback;
    private final int mRegionId;

    public AffiliateCategoryDataSource(int i, Callback<ArrayList<AffiliateCategoryDetail>> callback) {
        this.mRegionId = i;
        this.mCallback = callback;
    }

    @Override // com.proudcrowd.exposure.datasource.BaseDataSource
    public void ExecuteRequest() {
        this.GetDataApi.AffiliateCategoriesGet(2, this.mRegionId).enqueue(this.mCallback);
    }
}
