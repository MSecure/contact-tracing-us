package gov.nc.dhhs.exposurenotification.network;

import android.net.Uri;
import c.b.b.a.i;
import c.b.b.b.c;
import c.b.b.b.d;
import java.io.File;
import java.util.Collection;
import java.util.List;

public abstract class KeyFileBatch {
    public static KeyFileBatch ofFiles(String str, long j, Collection<File> collection) {
        return new AutoValue_KeyFileBatch(str, j, c.s(collection), d.f);
    }

    public static KeyFileBatch ofFiles(String str, long j, File... fileArr) {
        return ofFiles(str, j, c.t(fileArr));
    }

    public static KeyFileBatch ofUris(String str, long j, Collection<Uri> collection) {
        return new AutoValue_KeyFileBatch(str, j, c.w(), c.s(collection));
    }

    public abstract long batchNum();

    public KeyFileBatch copyWith(List<File> list) {
        return new AutoValue_KeyFileBatch(region(), batchNum(), c.s(list), uris());
    }

    public abstract c<File> files();

    public abstract String region();

    public String toString() {
        i iVar = new i(KeyFileBatch.class.getSimpleName(), null);
        iVar.b("region", region());
        iVar.b("batchNum", String.valueOf(batchNum()));
        iVar.b("uris", uris());
        iVar.b("files", "{" + files().size() + " files}");
        return iVar.toString();
    }

    public abstract c<Uri> uris();
}
