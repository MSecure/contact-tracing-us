package org.pathcheck.covidsafepaths.exposurenotifications.network;

import android.net.Uri;
import com.google.common.collect.ImmutableList;
import java.io.File;

public final class AutoValue_KeyFileBatch extends KeyFileBatch {
    public final long batchNum;
    public final ImmutableList<File> files;
    public final String region;
    public final ImmutableList<Uri> uris;

    public AutoValue_KeyFileBatch(String str, long j, ImmutableList<File> immutableList, ImmutableList<Uri> immutableList2) {
        if (str != null) {
            this.region = str;
            this.batchNum = j;
            if (immutableList != null) {
                this.files = immutableList;
                if (immutableList2 != null) {
                    this.uris = immutableList2;
                    return;
                }
                throw new NullPointerException("Null uris");
            }
            throw new NullPointerException("Null files");
        }
        throw new NullPointerException("Null region");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeyFileBatch)) {
            return false;
        }
        KeyFileBatch keyFileBatch = (KeyFileBatch) obj;
        if (this.region.equals(((AutoValue_KeyFileBatch) keyFileBatch).region)) {
            AutoValue_KeyFileBatch autoValue_KeyFileBatch = (AutoValue_KeyFileBatch) keyFileBatch;
            if (this.batchNum == autoValue_KeyFileBatch.batchNum && this.files.equals(autoValue_KeyFileBatch.files) && this.uris.equals(autoValue_KeyFileBatch.uris)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.batchNum;
        return ((((((this.region.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.files.hashCode()) * 1000003) ^ this.uris.hashCode();
    }
}
