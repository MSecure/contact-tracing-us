package io.realm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmChangeListener;
import io.realm.internal.ObserverPairList;

@Keep
public interface ObservableCollection {

    public static class Callback implements ObserverPairList.Callback<CollectionObserverPair> {
        public final OsCollectionChangeSet changeSet;

        public Callback(OsCollectionChangeSet osCollectionChangeSet) {
            this.changeSet = osCollectionChangeSet;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.realm.internal.ObserverPairList$ObserverPair, java.lang.Object] */
        @Override // io.realm.internal.ObserverPairList.Callback
        public void onCalled(CollectionObserverPair collectionObserverPair, Object obj) {
            CollectionObserverPair collectionObserverPair2 = collectionObserverPair;
            OsCollectionChangeSet osCollectionChangeSet = this.changeSet;
            S s = collectionObserverPair2.listener;
            if (s instanceof OrderedRealmCollectionChangeListener) {
                s.onChange(obj, new StatefulCollectionChangeSet(osCollectionChangeSet));
            } else if (s instanceof RealmChangeListener) {
                s.onChange(obj);
            } else {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Unsupported listener type: ");
                outline15.append((Object) collectionObserverPair2.listener);
                throw new RuntimeException(outline15.toString());
            }
        }
    }

    public static class CollectionObserverPair<T> extends ObserverPairList.ObserverPair<T, Object> {
    }

    void notifyChangeListeners(long j);
}
