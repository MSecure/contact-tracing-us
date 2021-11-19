package com.proudcrowd.exposure.datasource;

import com.proudcrowd.exposure.datamodel.AffiliateCategoryDetail;
import com.proudcrowd.exposure.datamodel.AffiliateDetail;
import com.proudcrowd.exposure.datamodel.AffiliatePostDetail;
import com.proudcrowd.exposure.datamodel.ConsentDetail;
import com.proudcrowd.exposure.datamodel.ConsentPostDetail;
import com.proudcrowd.exposure.datamodel.DeviceRegisterDetail;
import com.proudcrowd.exposure.datamodel.DeviceRegisterPostDetail;
import com.proudcrowd.exposure.datamodel.DeviceUpdatePostDetail;
import com.proudcrowd.exposure.datamodel.ExposureConfigurationDetail;
import com.proudcrowd.exposure.datamodel.InfoDetail;
import com.proudcrowd.exposure.datamodel.PartyDetail;
import com.proudcrowd.exposure.datamodel.ProtectDetail;
import com.proudcrowd.exposure.datamodel.ScanPostDetail;
import com.proudcrowd.exposure.datamodel.StudyDetail;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/api/v1/apps/{appId}/regions/{regionId}/affiliatecategories")
    Call<ArrayList<AffiliateCategoryDetail>> AffiliateCategoriesGet(@Path("appId") int i, @Path("regionId") int i2);

    @DELETE("/api/v1/apps/{appId}/devices/{deviceGuid}/affiliates/{affiliateId}")
    Call<Boolean> AffiliateDelete(@Path("appId") int i, @Path("deviceGuid") String str, @Path("affiliateId") int i2);

    @GET("/api/v1/apps/{appId}/regions/{regionId}/affiliates/{affiliateId}")
    Call<AffiliateDetail> AffiliateGetSingle(@Path("appId") int i, @Path("regionId") int i2, @Path("affiliateId") int i3);

    @POST("/api/v1/apps/{appId}/devices/{deviceGuid}/affiliates")
    Call<Void> AffiliatePost(@Path("appId") int i, @Path("deviceGuid") String str, @Body AffiliatePostDetail affiliatePostDetail);

    @GET("/api/v1/apps/{appId}/regions/{regionId}/affiliatecategories/{categoryId}")
    Call<ArrayList<AffiliateDetail>> AffiliatesGet(@Path("appId") int i, @Path("regionId") int i2, @Path("categoryId") int i3, @Query("deviceGuid") String str);

    @POST("/api/v1/apps/{appId}/devices/{deviceGuid}/notify")
    Call<ConsentDetail> ConsentPost(@Path("appId") int i, @Path("deviceGuid") String str, @Body ConsentPostDetail consentPostDetail);

    @GET("/api/v1/apps/{appId}/devices/{deviceGuid}/affiliates")
    Call<ArrayList<AffiliateDetail>> DeviceAffiliatesGet(@Path("appId") int i, @Path("deviceGuid") String str);

    @GET("/api/v1/apps/{appId}/devices/{deviceGuid}/exposureconfig")
    Call<ExposureConfigurationDetail> DeviceConfigurationGet(@Path("appId") int i, @Path("deviceGuid") String str, @Query("regionId") int i2, @Query("tekVersion") String str2);

    @POST("/api/v1/apps/{appId}/devices/{deviceGuid}/exposure")
    Call<Boolean> DeviceExposurePost(@Path("appId") int i, @Path("deviceGuid") String str, @Query("exposureDate") String str2, @Query("tekVersion") String str3);

    @GET("/api/v1/apps/{appId}/devices/{deviceGuid}/instructions")
    Call<ArrayList<PartyDetail>> DevicePartiesGet(@Path("appId") int i, @Path("deviceGuid") String str, @Query("regionId") int i2);

    @POST("/api/v1/apps/{appId}/devices")
    Call<DeviceRegisterDetail> DevicePost(@Path("appId") int i, @Query("regionId") int i2, @Body DeviceRegisterPostDetail deviceRegisterPostDetail);

    @PATCH("/api/v1/apps/{appId}/devices/{deviceGuid}")
    Call<Boolean> DeviceUpdatePatch(@Path("appId") int i, @Path("deviceGuid") String str, @Body DeviceUpdatePostDetail deviceUpdatePostDetail);

    @GET("/api/v1/apps/{appId}/regions/{regionId}/info")
    Call<ArrayList<InfoDetail>> InfoGet(@Path("appId") int i, @Path("regionId") int i2, @Query("deviceGuid") String str);

    @GET("/api/v1/apps/{appId}/devices/{deviceGuid}/notify")
    Call<ProtectDetail> ProtectGet(@Path("appId") int i, @Path("deviceGuid") String str);

    @GET("/api/v1/apps/{appId}/regions/{regionId}")
    Call<StudyDetail> RegionGet(@Path("appId") int i, @Path("regionId") int i2);

    @GET("/api/v1/apps/{appId}/regions")
    Call<ArrayList<StudyDetail>> RegionsGetAll(@Path("appId") int i);

    @POST("/api/v1/apps/{appId}/devices/{deviceGuid}/scans")
    Call<Boolean> ScanPost(@Path("appId") int i, @Path("deviceGuid") String str, @Body ScanPostDetail scanPostDetail);
}
