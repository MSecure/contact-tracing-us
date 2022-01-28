package com.proudcrowd.exposure.datamodel;

import android.net.Uri;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.Collection;
import java.util.List;

public abstract class DiagnosisKeyFile {
    public abstract long batchNum();

    public abstract ImmutableList<File> files();

    public abstract String region();

    public abstract ImmutableList<Uri> uris();

    public static DiagnosisKeyFile ofFiles(String str, long j, Collection<File> collection) {
        return new AutoValue_DiagnosisKeyFile(str, j, ImmutableList.copyOf((Collection) collection), ImmutableList.of());
    }

    public static DiagnosisKeyFile ofFiles(String str, long j, File... fileArr) {
        return ofFiles(str, j, ImmutableList.copyOf(fileArr));
    }

    public static DiagnosisKeyFile ofUris(String str, long j, Collection<Uri> collection) {
        return new AutoValue_DiagnosisKeyFile(str, j, ImmutableList.of(), ImmutableList.copyOf((Collection) collection));
    }

    public DiagnosisKeyFile copyWith(List<File> list) {
        return new AutoValue_DiagnosisKeyFile(region(), batchNum(), ImmutableList.copyOf((Collection) list), uris());
    }

    public String toString() {
        MoreObjects.ToStringHelper add = MoreObjects.toStringHelper((Class<?>) DiagnosisKeyFile.class).add("region", region()).add("batchNum", batchNum()).add("uris", uris());
        return add.add("files", "{" + files().size() + " files}").toString();
    }
}
