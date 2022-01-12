package io.realm.rx;

import io.reactivex.BackpressureStrategy;
import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmResults;
import java.util.IdentityHashMap;

public class RealmObservableFactory implements RxObservableFactory {

    public static class StrongReferenceCounter<K> {
        public StrongReferenceCounter(AnonymousClass1 r1) {
            new IdentityHashMap();
        }
    }

    static {
        BackpressureStrategy backpressureStrategy = BackpressureStrategy.LATEST;
    }

    public RealmObservableFactory(boolean z) {
        new ThreadLocal<StrongReferenceCounter<RealmResults>>(this) {
            /* class io.realm.rx.RealmObservableFactory.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.lang.ThreadLocal
            public StrongReferenceCounter<RealmResults> initialValue() {
                return new StrongReferenceCounter(null);
            }
        };
        new ThreadLocal<StrongReferenceCounter<RealmList>>(this) {
            /* class io.realm.rx.RealmObservableFactory.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.lang.ThreadLocal
            public StrongReferenceCounter<RealmList> initialValue() {
                return new StrongReferenceCounter(null);
            }
        };
        new ThreadLocal<StrongReferenceCounter<RealmModel>>(this) {
            /* class io.realm.rx.RealmObservableFactory.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.lang.ThreadLocal
            public StrongReferenceCounter<RealmModel> initialValue() {
                return new StrongReferenceCounter(null);
            }
        };
    }

    public boolean equals(Object obj) {
        return obj instanceof RealmObservableFactory;
    }

    public int hashCode() {
        return 37;
    }
}
