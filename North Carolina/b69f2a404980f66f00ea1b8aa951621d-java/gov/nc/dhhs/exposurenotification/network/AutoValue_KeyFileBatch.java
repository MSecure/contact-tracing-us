package gov.nc.dhhs.exposurenotification.network;

import android.net.Uri;
import c.b.b.b.c;
import java.io.File;

public final class AutoValue_KeyFileBatch extends KeyFileBatch {
    public final long batchNum;
    public final c<File> files;
    public final String region;
    public final c<Uri> uris;

    public AutoValue_KeyFileBatch(String str, long j, c<File> cVar, c<Uri> cVar2) {
        if (str != null) {
            this.region = str;
            this.batchNum = j;
            if (cVar != null) {
                this.files = cVar;
                if (cVar2 != null) {
                    this.uris = cVar2;
                    return;
                }
                throw new NullPointerException("Null uris");
            }
            throw new NullPointerException("Null files");
        }
        throw new NullPointerException("Null region");
    }

    @Override // gov.nc.dhhs.exposurenotification.network.KeyFileBatch
    public long batchNum() {
        return this.batchNum;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeyFileBatch)) {
            return false;
        }
        KeyFileBatch keyFileBatch = (KeyFileBatch) obj;
        return this.region.equals(keyFileBatch.region()) && this.batchNum == keyFileBatch.batchNum() && this.files.equals(keyFileBatch.files()) && this.uris.equals(keyFileBatch.uris());
    }

    @Override // gov.nc.dhhs.exposurenotification.network.KeyFileBatch
    public c<File> files() {
        return this.files;
    }

    public int hashCode() {
        long j = this.batchNum;
        return ((((((this.region.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.files.hashCode()) * 1000003) ^ this.uris.hashCode();
    }

    @Override // gov.nc.dhhs.exposurenotification.network.KeyFileBatch
    public String region() {
        return this.region;
    }

    @Override // gov.nc.dhhs.exposurenotification.network.KeyFileBatch
    public c<Uri> uris() {
        return this.uris;
    }
}
