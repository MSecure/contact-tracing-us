package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EscrowVerificationClient.kt */
public final class MetaInfoSubmission {
    @SerializedName("phone_number")
    public String phone_number;
    @SerializedName("tek_sha512")
    public String tek_sign;

    public MetaInfoSubmission(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "_tek_sign");
        Intrinsics.checkNotNullParameter(str2, "_phone_number");
        this.tek_sign = str;
        this.phone_number = str2;
    }
}
