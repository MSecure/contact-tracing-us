package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import com.google.android.gms.nearby.exposurenotification.DailySummary;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;
import io.realm.internal.OsResults;
import io.realm.internal.SubscriptionAwareOsResults;
import io.realm.internal.TableQuery;
import io.realm.internal.core.DescriptorOrdering;
import io.realm.internal.sync.SubscriptionAction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity;
import org.threeten.bp.Duration;

/* compiled from: RealmSecureStorageBte.kt */
public final class RealmSecureStorageBte$refreshWithDailySummaries$$inlined$use$lambda$1 implements Realm.Transaction {
    public final /* synthetic */ List $dailySummaries$inlined;
    public final /* synthetic */ Ref$BooleanRef $somethingAdded$inlined;

    public RealmSecureStorageBte$refreshWithDailySummaries$$inlined$use$lambda$1(List list, Ref$BooleanRef ref$BooleanRef) {
        this.$dailySummaries$inlined = list;
        this.$somethingAdded$inlined = ref$BooleanRef;
    }

    @Override // io.realm.Realm.Transaction
    public final void execute(Realm realm) {
        TableQuery tableQuery;
        OsResults osResults;
        boolean z;
        realm.checkIfValid();
        DescriptorOrdering descriptorOrdering = new DescriptorOrdering();
        if (!RealmModel.class.isAssignableFrom(ExposureEntity.class)) {
            tableQuery = null;
        } else {
            tableQuery = realm.schema.getSchemaForClass(ExposureEntity.class).table.where();
        }
        realm.checkIfValid();
        SubscriptionAction subscriptionAction = SubscriptionAction.NO_SUBSCRIPTION;
        if (subscriptionAction.subscriptionName != null) {
            osResults = SubscriptionAwareOsResults.createFromQuery(realm.sharedRealm, tableQuery, descriptorOrdering, subscriptionAction);
        } else {
            osResults = OsResults.createFromQuery(realm.sharedRealm, tableQuery, descriptorOrdering);
        }
        RealmResults realmResults = new RealmResults(realm, osResults, ExposureEntity.class);
        realmResults.realm.checkIfValid();
        OsResults osResults2 = realmResults.osResults;
        if (!osResults2.loaded) {
            OsResults.nativeEvaluateQueryIfNeeded(osResults2.nativePtr, false);
            osResults2.notifyChangeListeners(0);
        }
        Intrinsics.checkNotNullExpressionValue(realmResults, "db.where(ExposureEntity::class.java).findAll()");
        List copyFromRealm = realm.copyFromRealm(realmResults);
        Intrinsics.checkNotNullExpressionValue(copyFromRealm, "db.copyFromRealm(results)");
        for (DailySummary dailySummary : this.$dailySummaries$inlined) {
            long millis = Duration.ofDays((long) dailySummary.zza).toMillis();
            int size = copyFromRealm.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                } else if (((ExposureEntity) copyFromRealm.get(i)).realmGet$dateMillisSinceEpoch() == millis) {
                    copyFromRealm.remove(i);
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.$somethingAdded$inlined.element = true;
                realm.insert(new ExposureEntity(millis, System.currentTimeMillis()));
            }
        }
    }
}
