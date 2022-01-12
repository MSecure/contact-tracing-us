package io.realm.internal;

import io.realm.RealmChangeListener;
import io.realm.internal.ObserverPairList;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

@Keep
public abstract class RealmNotifier implements Closeable {
    public List<Runnable> finishedSendingNotificationsCallbacks = new ArrayList();
    public final ObserverPairList.Callback<RealmObserverPair> onChangeCallBack = new ObserverPairList.Callback<RealmObserverPair>() {
        /* class io.realm.internal.RealmNotifier.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.realm.internal.ObserverPairList$ObserverPair, java.lang.Object] */
        @Override // io.realm.internal.ObserverPairList.Callback
        public void onCalled(RealmObserverPair realmObserverPair, Object obj) {
            RealmObserverPair realmObserverPair2 = realmObserverPair;
            if (RealmNotifier.this.sharedRealm != null && !RealmNotifier.this.sharedRealm.isClosed()) {
                realmObserverPair2.listener.onChange(obj);
            }
        }
    };
    public ObserverPairList<RealmObserverPair> realmObserverPairs = new ObserverPairList<>();
    public OsSharedRealm sharedRealm;
    public List<Runnable> startSendingNotificationsCallbacks = new ArrayList();
    public List<Runnable> transactionCallbacks = new ArrayList();

    public static class RealmObserverPair<T> extends ObserverPairList.ObserverPair<T, RealmChangeListener<T>> {
        public RealmObserverPair(T t, RealmChangeListener<T> realmChangeListener) {
            super(t, realmChangeListener);
        }
    }

    public RealmNotifier(OsSharedRealm osSharedRealm) {
        this.sharedRealm = osSharedRealm;
    }

    private void removeAllChangeListeners() {
        ObserverPairList<RealmObserverPair> observerPairList = this.realmObserverPairs;
        observerPairList.cleared = true;
        observerPairList.pairs.clear();
    }

    public void addBeginSendingNotificationsCallback(Runnable runnable) {
        this.startSendingNotificationsCallbacks.add(runnable);
    }

    public <T> void addChangeListener(T t, RealmChangeListener<T> realmChangeListener) {
        this.realmObserverPairs.add(new RealmObserverPair(t, realmChangeListener));
    }

    public void addFinishedSendingNotificationsCallback(Runnable runnable) {
        this.finishedSendingNotificationsCallbacks.add(runnable);
    }

    public void addTransactionCallback(Runnable runnable) {
        this.transactionCallbacks.add(runnable);
    }

    public void beforeNotify() {
        this.sharedRealm.invalidateIterators();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        removeAllChangeListeners();
        this.startSendingNotificationsCallbacks.clear();
        this.finishedSendingNotificationsCallbacks.clear();
    }

    public void didChange() {
        this.realmObserverPairs.foreach(this.onChangeCallBack);
        if (!this.transactionCallbacks.isEmpty()) {
            List<Runnable> list = this.transactionCallbacks;
            this.transactionCallbacks = new ArrayList();
            for (Runnable runnable : list) {
                runnable.run();
            }
        }
    }

    public void didSendNotifications() {
        for (int i = 0; i < this.startSendingNotificationsCallbacks.size(); i++) {
            this.finishedSendingNotificationsCallbacks.get(i).run();
        }
    }

    public int getListenersListSize() {
        return this.realmObserverPairs.pairs.size();
    }

    public abstract boolean post(Runnable runnable);

    public <E> void removeChangeListener(E e, RealmChangeListener<E> realmChangeListener) {
        this.realmObserverPairs.remove(e, realmChangeListener);
    }

    public <E> void removeChangeListeners(E e) {
        this.realmObserverPairs.removeByObserver(e);
    }

    public void willSendNotifications() {
        for (int i = 0; i < this.startSendingNotificationsCallbacks.size(); i++) {
            this.startSendingNotificationsCallbacks.get(i).run();
        }
    }
}
