package com.proudcrowd.exposure.datamodel;

import android.net.Uri;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.Objects;

/* access modifiers changed from: package-private */
public final class AutoValue_DiagnosisKeyFile extends DiagnosisKeyFile {
    private final long batchNum;
    private final ImmutableList<File> files;
    private final String region;
    private final ImmutableList<Uri> uris;

    AutoValue_DiagnosisKeyFile(String str, long j, ImmutableList<File> immutableList, ImmutableList<Uri> immutableList2) {
        Objects.requireNonNull(str, "Null region");
        this.region = str;
        this.batchNum = j;
        Objects.requireNonNull(immutableList, "Null files");
        this.files = immutableList;
        Objects.requireNonNull(immutableList2, "Null uris");
        this.uris = immutableList2;
    }

    @Override // com.proudcrowd.exposure.datamodel.DiagnosisKeyFile
    public String region() {
        return this.region;
    }

    @Override // com.proudcrowd.exposure.datamodel.DiagnosisKeyFile
    public long batchNum() {
        return this.batchNum;
    }

    @Override // com.proudcrowd.exposure.datamodel.DiagnosisKeyFile
    public ImmutableList<File> files() {
        return this.files;
    }

    @Override // com.proudcrowd.exposure.datamodel.DiagnosisKeyFile
    public ImmutableList<Uri> uris() {
        return this.uris;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DiagnosisKeyFile)) {
            return false;
        }
        DiagnosisKeyFile diagnosisKeyFile = (DiagnosisKeyFile) obj;
        return this.region.equals(diagnosisKeyFile.region()) && this.batchNum == diagnosisKeyFile.batchNum() && this.files.equals(diagnosisKeyFile.files()) && this.uris.equals(diagnosisKeyFile.uris());
    }

    public int hashCode() {
        long j = this.batchNum;
        return ((((((this.region.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.files.hashCode()) * 1000003) ^ this.uris.hashCode();
    }
}
