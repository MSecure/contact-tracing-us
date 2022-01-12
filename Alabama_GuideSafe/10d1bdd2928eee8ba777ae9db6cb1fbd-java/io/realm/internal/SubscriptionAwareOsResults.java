package io.realm.internal;

import io.realm.RealmChangeListener;
import io.realm.internal.ObservableCollection;
import io.realm.internal.core.DescriptorOrdering;
import io.realm.internal.sync.OsSubscription;
import io.realm.internal.sync.SubscriptionAction;

public class SubscriptionAwareOsResults extends OsResults {
    public boolean collectionChanged = false;
    public long delayedNotificationPtr = 0;
    public boolean firstCallback = true;
    public OsSubscription subscription = null;
    public boolean subscriptionChanged;

    public SubscriptionAwareOsResults(OsSharedRealm osSharedRealm, Table table, long j, SubscriptionAction subscriptionAction) {
        super(osSharedRealm, table, j);
        OsSubscription osSubscription = new OsSubscription(this, subscriptionAction);
        this.subscription = osSubscription;
        osSubscription.addChangeListener(new RealmChangeListener<OsSubscription>() {
            /* class io.realm.internal.SubscriptionAwareOsResults.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.realm.RealmChangeListener
            public void onChange(OsSubscription osSubscription) {
                SubscriptionAwareOsResults.this.subscriptionChanged = true;
            }
        });
        RealmNotifier realmNotifier = osSharedRealm.realmNotifier;
        realmNotifier.addBeginSendingNotificationsCallback(new Runnable() {
            /* class io.realm.internal.SubscriptionAwareOsResults.AnonymousClass2 */

            public void run() {
                SubscriptionAwareOsResults subscriptionAwareOsResults = SubscriptionAwareOsResults.this;
                subscriptionAwareOsResults.subscriptionChanged = false;
                subscriptionAwareOsResults.collectionChanged = false;
                subscriptionAwareOsResults.delayedNotificationPtr = 0;
            }
        });
        realmNotifier.addFinishedSendingNotificationsCallback(new Runnable() {
            /* class io.realm.internal.SubscriptionAwareOsResults.AnonymousClass3 */

            public void run() {
                OsCollectionChangeSet osCollectionChangeSet;
                SubscriptionAwareOsResults subscriptionAwareOsResults = SubscriptionAwareOsResults.this;
                if (subscriptionAwareOsResults.collectionChanged || subscriptionAwareOsResults.subscriptionChanged) {
                    SubscriptionAwareOsResults subscriptionAwareOsResults2 = SubscriptionAwareOsResults.this;
                    OsSubscription osSubscription = subscriptionAwareOsResults2.subscriptionChanged ? subscriptionAwareOsResults2.subscription : null;
                    if (subscriptionAwareOsResults2.delayedNotificationPtr != 0 || osSubscription == null || subscriptionAwareOsResults2.firstCallback || osSubscription.getState() == OsSubscription.SubscriptionState.ERROR || osSubscription.getState() == OsSubscription.SubscriptionState.COMPLETE) {
                        if (subscriptionAwareOsResults2.delayedNotificationPtr == 0) {
                            osCollectionChangeSet = new EmptyLoadChangeSet(osSubscription, subscriptionAwareOsResults2.firstCallback, true);
                        } else {
                            osCollectionChangeSet = new OsCollectionChangeSet(subscriptionAwareOsResults2.delayedNotificationPtr, subscriptionAwareOsResults2.firstCallback, osSubscription, true);
                        }
                        if (!osCollectionChangeSet.isEmpty() || !subscriptionAwareOsResults2.loaded) {
                            subscriptionAwareOsResults2.loaded = true;
                            subscriptionAwareOsResults2.firstCallback = false;
                            subscriptionAwareOsResults2.observerPairs.foreach(new ObservableCollection.Callback(osCollectionChangeSet));
                        }
                    }
                }
            }
        });
    }

    public static SubscriptionAwareOsResults createFromQuery(OsSharedRealm osSharedRealm, TableQuery tableQuery, DescriptorOrdering descriptorOrdering, SubscriptionAction subscriptionAction) {
        tableQuery.validateQuery();
        return new SubscriptionAwareOsResults(osSharedRealm, tableQuery.table, OsResults.nativeCreateResults(osSharedRealm.getNativePtr(), tableQuery.nativePtr, descriptorOrdering.nativePtr), subscriptionAction);
    }

    @Override // io.realm.internal.OsResults, io.realm.internal.ObservableCollection
    public void notifyChangeListeners(long j) {
        this.collectionChanged = true;
        this.delayedNotificationPtr = j;
    }
}
