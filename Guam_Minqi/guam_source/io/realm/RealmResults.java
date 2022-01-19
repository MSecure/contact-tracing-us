package io.realm;

import io.realm.internal.OsResults;

public class RealmResults<E> extends OrderedRealmCollectionImpl<E> {
    public RealmResults(BaseRealm baseRealm, OsResults osResults, Class<E> cls) {
        super(baseRealm, osResults, cls);
    }

    @Override // io.realm.RealmCollection
    public boolean isLoaded() {
        this.realm.checkIfValid();
        return this.osResults.loaded;
    }
}
