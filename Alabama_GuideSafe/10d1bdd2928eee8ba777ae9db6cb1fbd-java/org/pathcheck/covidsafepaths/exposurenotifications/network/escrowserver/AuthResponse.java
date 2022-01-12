package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import com.google.gson.annotations.SerializedName;

/* compiled from: EscrowVerificationClient.kt */
public final class AuthResponse {
    @SerializedName("access_token")
    public String accessToken;
    @SerializedName("expires_in")
    public int expiresIn;
    @SerializedName("refresh_token")
    public String refreshToken;
    @SerializedName("token_type")
    public String tokenType;
}
