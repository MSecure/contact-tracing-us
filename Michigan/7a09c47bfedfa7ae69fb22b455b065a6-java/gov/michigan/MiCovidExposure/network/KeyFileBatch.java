package gov.michigan.MiCovidExposure.network;

import android.net.Uri;
import c.b.b.a.i;
import c.b.b.b.c;
import c.b.b.b.d;
import java.io.File;
import java.util.Collection;
import java.util.List;

public abstract class KeyFileBatch {
    public static KeyFileBatch ofFiles(String str, long j, Collection<File> collection) {
        return new AutoValue_KeyFileBatch(str, j, c.u(collection), d.f4689f);
    }

    public static KeyFileBatch ofFiles(String str, long j, File... fileArr) {
        return ofFiles(str, j, c.v(fileArr));
    }

    public static KeyFileBatch ofUris(String str, long j, Collection<Uri> collection) {
        return new AutoValue_KeyFileBatch(str, j, c.z(), c.u(collection));
    }

    public abstract long batchNum();

    public KeyFileBatch copyWith(List<File> list) {
        return new AutoValue_KeyFileBatch(region(), batchNum(), c.u(list), uris());
    }

    public abstract c<File> files();

    public abstract String region();

    public String toString() {
        i iVar = new i(KeyFileBatch.class.getSimpleName(), null);
        iVar.a("region", region());
        iVar.a("batchNum", String.valueOf(batchNum()));
        iVar.a("uris", uris());
        iVar.a("files", "{" + files().size() + " files}");
        return iVar.toString();
    }

    public abstract c<Uri> uris();
}
