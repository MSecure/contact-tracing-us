package com.proudcrowd.exposure.storage;

import java.util.Objects;

public class KeyScanEntity {
    private long createdTimestampMs = System.currentTimeMillis();
    private String errorMessage;
    long id;
    private boolean succeeded;

    KeyScanEntity(boolean z, String str) {
        this.succeeded = z;
        this.errorMessage = str;
    }

    public static KeyScanEntity create() {
        return create(true, null);
    }

    public static KeyScanEntity create(boolean z, String str) {
        return new KeyScanEntity(z, str);
    }

    public long getId() {
        return this.id;
    }

    public long getCreatedTimestampMs() {
        return this.createdTimestampMs;
    }

    /* access modifiers changed from: package-private */
    public void setCreatedTimestampMs(long j) {
        this.createdTimestampMs = j;
    }

    public boolean getSucceeded() {
        return this.succeeded;
    }

    public void setSucceeded(boolean z) {
        this.succeeded = z;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyScanEntity keyScanEntity = (KeyScanEntity) obj;
        return this.id == keyScanEntity.id && this.createdTimestampMs == keyScanEntity.createdTimestampMs && this.succeeded == keyScanEntity.succeeded && this.errorMessage.equals(keyScanEntity.errorMessage);
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id), Long.valueOf(this.createdTimestampMs), Boolean.valueOf(this.succeeded), this.errorMessage);
    }
}
