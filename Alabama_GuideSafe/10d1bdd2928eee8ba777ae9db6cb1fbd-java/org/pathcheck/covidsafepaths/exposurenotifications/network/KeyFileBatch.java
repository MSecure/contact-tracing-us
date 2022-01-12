package org.pathcheck.covidsafepaths.exposurenotifications.network;

import android.net.Uri;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.collect.ImmutableList;
import java.util.Collection;

public abstract class KeyFileBatch {
    public static KeyFileBatch ofUris(String str, long j, Collection<Uri> collection) {
        return new AutoValue_KeyFileBatch(str, j, ImmutableList.of(), ImmutableList.copyOf((Collection) collection));
    }

    public String toString() {
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = new MoreObjects$ToStringHelper(KeyFileBatch.class.getSimpleName(), null);
        AutoValue_KeyFileBatch autoValue_KeyFileBatch = (AutoValue_KeyFileBatch) this;
        moreObjects$ToStringHelper.addHolder("region", autoValue_KeyFileBatch.region);
        moreObjects$ToStringHelper.addHolder("batchNum", String.valueOf(autoValue_KeyFileBatch.batchNum));
        moreObjects$ToStringHelper.addHolder("uris", autoValue_KeyFileBatch.uris);
        moreObjects$ToStringHelper.addHolder("files", "{" + autoValue_KeyFileBatch.files.size() + " files}");
        return moreObjects$ToStringHelper.toString();
    }
}
