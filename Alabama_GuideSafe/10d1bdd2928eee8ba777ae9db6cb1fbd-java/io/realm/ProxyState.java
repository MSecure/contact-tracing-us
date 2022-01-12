package io.realm;

import io.realm.RealmModel;
import io.realm.internal.ObserverPairList;
import io.realm.internal.OsObject;
import io.realm.internal.Row;
import java.util.List;

public final class ProxyState<E extends RealmModel> {
    public static QueryCallback queryCallback = new QueryCallback(null);
    public boolean acceptDefaultValue;
    public List<String> excludeFields;
    public ObserverPairList<OsObject.ObjectObserverPair> observerPairs = new ObserverPairList<>();
    public BaseRealm realm;
    public Row row;
    public boolean underConstruction = true;

    public static class QueryCallback implements ObserverPairList.Callback<OsObject.ObjectObserverPair> {
        public QueryCallback(AnonymousClass1 r1) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.realm.internal.ObserverPairList$ObserverPair, java.lang.Object] */
        @Override // io.realm.internal.ObserverPairList.Callback
        public void onCalled(OsObject.ObjectObserverPair objectObserverPair, Object obj) {
            objectObserverPair.listener.onChange((RealmModel) obj, null);
        }
    }

    public ProxyState(E e) {
    }

    public void setConstructionFinished() {
        this.underConstruction = false;
        this.excludeFields = null;
    }
}
