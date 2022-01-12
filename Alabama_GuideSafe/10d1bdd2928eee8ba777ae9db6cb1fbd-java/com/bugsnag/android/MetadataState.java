package com.bugsnag.android;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.bugsnag.android.StateEvent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetadataState.kt */
public final class MetadataState extends BaseObservable {
    public final Metadata metadata;

    public MetadataState() {
        this(null, 1);
    }

    public MetadataState(Metadata metadata2) {
        Intrinsics.checkParameterIsNotNull(metadata2, "metadata");
        this.metadata = metadata2;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MetadataState) && Intrinsics.areEqual(this.metadata, ((MetadataState) obj).metadata);
        }
        return true;
    }

    public int hashCode() {
        Metadata metadata2 = this.metadata;
        if (metadata2 != null) {
            return metadata2.hashCode();
        }
        return 0;
    }

    public final void notifyClear(String str, String str2) {
        if (str2 == null) {
            notifyObservers(new StateEvent.ClearMetadataSection(str));
        } else {
            notifyObservers(new StateEvent.ClearMetadataValue(str, str2));
        }
    }

    public final void notifyMetadataAdded(String str, String str2, Object obj) {
        if (obj == null) {
            notifyClear(str, str2);
            return;
        }
        Metadata metadata2 = this.metadata;
        if (metadata2 != null) {
            Intrinsics.checkParameterIsNotNull(str, "section");
            Intrinsics.checkParameterIsNotNull(str2, "key");
            Object obj2 = metadata2.store.get(str);
            if (obj2 instanceof Map) {
                obj2 = ((Map) obj2).get(str2);
            }
            notifyObservers(new StateEvent.AddMetadata(str, str2, obj2));
            return;
        }
        throw null;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("MetadataState(metadata=");
        outline17.append(this.metadata);
        outline17.append(")");
        return outline17.toString();
    }

    public MetadataState(Metadata metadata2, int i) {
        Metadata metadata3 = (i & 1) != 0 ? new Metadata(null, null, null, 7) : null;
        Intrinsics.checkParameterIsNotNull(metadata3, "metadata");
        this.metadata = metadata3;
    }
}
