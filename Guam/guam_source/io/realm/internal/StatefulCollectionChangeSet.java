package io.realm.internal;

import io.realm.OrderedCollectionChangeSet;

public class StatefulCollectionChangeSet implements OrderedCollectionChangeSet {
    public final Throwable error;

    public StatefulCollectionChangeSet(OsCollectionChangeSet osCollectionChangeSet) {
        osCollectionChangeSet.isFirstAsyncCallback();
        osCollectionChangeSet.isRemoteDataLoaded();
        this.error = osCollectionChangeSet.getError();
    }
}
