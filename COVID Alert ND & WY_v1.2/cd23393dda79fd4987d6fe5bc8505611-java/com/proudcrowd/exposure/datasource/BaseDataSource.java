package com.proudcrowd.exposure.datasource;

import com.google.gson.GsonBuilder;
import com.proudcrowd.exposure.core.ExposureApplication;
import java.util.ArrayList;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseDataSource<InnerType> {
    public static final int defaultAppId = 2;
    public ApiInterface GetDataApi = ((ApiInterface) new Retrofit.Builder().client(ExposureApplication.mOkHttpClient).baseUrl("https://exposureapi.care19.app/").addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create())).build().create(ApiInterface.class));
    public ArrayList<InnerType> Results;

    public abstract void ExecuteRequest();

    public ArrayList<InnerType> getResults() {
        return this.Results;
    }
}
