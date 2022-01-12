package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import android.util.Base64;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EscrowVerificationClient.kt */
public final class ExposureKey {
    @SerializedName("key")
    public String keyData;
    @SerializedName("rollingPeriod")
    public int rollingPeriod;
    @SerializedName("rollingStartNumber")
    public int rollingStartNumber;
    @SerializedName("transmissionRiskLevel")
    public int transmissionRiskLevel;

    public ExposureKey(byte[] bArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "_keyData");
        String encodeToString = Base64.encodeToString(bArr, 8);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.encodeToString(_keyData, Base64.URL_SAFE)");
        this.keyData = encodeToString;
        this.rollingPeriod = i;
        this.transmissionRiskLevel = i2;
        this.rollingStartNumber = i3;
    }
}
