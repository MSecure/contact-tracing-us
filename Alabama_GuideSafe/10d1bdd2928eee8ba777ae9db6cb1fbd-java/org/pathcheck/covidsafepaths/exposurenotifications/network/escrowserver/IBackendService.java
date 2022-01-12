package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/* compiled from: EscrowVerificationClient.kt */
public interface IBackendService {
    @FormUrlEncoded
    @POST("authtracking/token")
    Call<AuthResponse> auth(@Header("Cookie") String str, @Field("grant_type") String str2, @Field("device_type") String str3, @Field("device_code") String str4);

    @GET("authtracking/nonce")
    Call<NonceResponse> getNonce(@Header("uniqueID") String str);

    @POST("verification/postMetaInfo")
    Call<SuccessResponse> postMetaInfo(@Header("Authorization") String str, @Body MetaInfoSubmission metaInfoSubmission);

    @POST("verification/postVerificationCode")
    Call<SuccessResponse> postPositiveDiagnosis(@Header("Authorization") String str, @Header("Cookie") String str2, @Body PositiveSubmission positiveSubmission);

    @FormUrlEncoded
    @POST("authtracking/token")
    Call<AuthResponse> refreshToken(@Field("refresh_token") String str, @Field("grant_type") String str2);
}
