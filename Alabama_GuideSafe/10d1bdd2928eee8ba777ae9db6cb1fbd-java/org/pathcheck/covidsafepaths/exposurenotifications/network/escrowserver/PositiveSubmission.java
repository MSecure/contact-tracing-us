package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.BuildConfig;

/* compiled from: EscrowVerificationClient.kt */
public final class PositiveSubmission {
    @SerializedName("appPackageName")
    public String appPackageName;
    @SerializedName("deviceVerificationPayload")
    public String deviceVerificationPayload;
    @SerializedName("temporaryExposureKeys")
    public List<ExposureKey> keys;
    @SerializedName("platform")
    public String platform;
    @SerializedName("regions")
    public String regions;
    @SerializedName("verification_code")
    public String verifyCode;
    @SerializedName("test_date")
    public String verifyDate;

    public PositiveSubmission() {
        this(null, null, null, null, null, null, null, 127);
    }

    public PositiveSubmission(List list, String str, String str2, String str3, String str4, String str5, String str6, int i) {
        list = (i & 1) != 0 ? EmptyList.INSTANCE : list;
        String str7 = null;
        str = (i & 2) != 0 ? null : str;
        str2 = (i & 4) != 0 ? null : str2;
        String str8 = (i & 8) != 0 ? "" : null;
        String str9 = (i & 16) != 0 ? BuildConfig.REGION_CODES : null;
        String str10 = (i & 32) != 0 ? "gov.adph.exposurenotifications" : null;
        str7 = (i & 64) != 0 ? "Android" : str7;
        Intrinsics.checkNotNullParameter(str8, "_deviceVerificationPayload");
        this.keys = list;
        this.verifyCode = str;
        this.verifyDate = str2;
        this.regions = str9;
        this.appPackageName = str10;
        this.platform = str7;
        this.deviceVerificationPayload = str8;
    }
}
