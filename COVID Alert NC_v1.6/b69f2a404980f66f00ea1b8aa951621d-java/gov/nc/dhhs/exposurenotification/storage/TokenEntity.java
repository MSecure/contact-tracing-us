package gov.nc.dhhs.exposurenotification.storage;

import java.util.Objects;

public class TokenEntity {
    public long lastUpdatedTimestampMs = System.currentTimeMillis();
    public boolean responded;
    public String token;

    public TokenEntity(String str, boolean z) {
        this.token = str;
        this.responded = z;
    }

    public static TokenEntity create(String str, boolean z) {
        if (str != null) {
            return new TokenEntity(str, z);
        }
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TokenEntity.class != obj.getClass()) {
            return false;
        }
        TokenEntity tokenEntity = (TokenEntity) obj;
        return this.lastUpdatedTimestampMs == tokenEntity.lastUpdatedTimestampMs && this.responded == tokenEntity.responded && this.token.equals(tokenEntity.token);
    }

    public long getLastUpdatedTimestampMs() {
        return this.lastUpdatedTimestampMs;
    }

    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        return Objects.hash(this.token, Long.valueOf(this.lastUpdatedTimestampMs), Boolean.valueOf(this.responded));
    }

    public boolean isResponded() {
        return this.responded;
    }

    public void setLastUpdatedTimestampMs(long j) {
        this.lastUpdatedTimestampMs = j;
    }

    public void setResponded(boolean z) {
        this.responded = z;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
