package com.proudcrowd.exposure.storage;

import java.util.Objects;

public class WatermarkUrlEntity {
    private long createdTimestampMs = System.currentTimeMillis();
    long id;
    private String urlFragment;

    WatermarkUrlEntity(String str) {
        this.urlFragment = str;
    }

    public static WatermarkUrlEntity create(String str) {
        return new WatermarkUrlEntity(str);
    }

    public long getId() {
        return this.id;
    }

    /* access modifiers changed from: package-private */
    public void setId(long j) {
        this.id = j;
    }

    public long getCreatedTimestampMs() {
        return this.createdTimestampMs;
    }

    /* access modifiers changed from: package-private */
    public void setCreatedTimestampMs(long j) {
        this.createdTimestampMs = j;
    }

    public String getUrlFragment() {
        return this.urlFragment;
    }

    public void setUrlFragment(String str) {
        this.urlFragment = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WatermarkUrlEntity watermarkUrlEntity = (WatermarkUrlEntity) obj;
        if (this.id == watermarkUrlEntity.id && this.createdTimestampMs == watermarkUrlEntity.createdTimestampMs) {
            String str = this.urlFragment;
            if (str.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id), this.urlFragment, Long.valueOf(this.createdTimestampMs));
    }
}
