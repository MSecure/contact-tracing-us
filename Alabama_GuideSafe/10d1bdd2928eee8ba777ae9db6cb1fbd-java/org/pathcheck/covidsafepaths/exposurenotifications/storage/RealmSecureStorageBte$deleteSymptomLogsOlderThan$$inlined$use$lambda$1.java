package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import io.realm.Realm;
import io.realm.RealmFieldType;
import io.realm.RealmModel;
import io.realm.RealmObjectSchema;
import io.realm.RealmResults;
import io.realm.internal.OsResults;
import io.realm.internal.SubscriptionAwareOsResults;
import io.realm.internal.TableQuery;
import io.realm.internal.core.DescriptorOrdering;
import io.realm.internal.fields.FieldDescriptor;
import io.realm.internal.sync.SubscriptionAction;
import java.util.Arrays;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalUnit;

/* compiled from: RealmSecureStorageBte.kt */
public final class RealmSecureStorageBte$deleteSymptomLogsOlderThan$$inlined$use$lambda$1 implements Realm.Transaction {
    public final /* synthetic */ long $days$inlined;

    public RealmSecureStorageBte$deleteSymptomLogsOlderThan$$inlined$use$lambda$1(long j) {
        this.$days$inlined = j;
    }

    @Override // io.realm.Realm.Transaction
    public final void execute(Realm realm) {
        TableQuery tableQuery;
        RealmObjectSchema realmObjectSchema;
        OsResults osResults;
        realm.checkIfValid();
        DescriptorOrdering descriptorOrdering = new DescriptorOrdering();
        boolean z = true;
        if (!RealmModel.class.isAssignableFrom(SymptomLogEntry.class)) {
            realmObjectSchema = null;
            tableQuery = null;
        } else {
            realmObjectSchema = realm.schema.getSchemaForClass(SymptomLogEntry.class);
            tableQuery = realmObjectSchema.table.where();
        }
        RealmSecureStorageBte realmSecureStorageBte = RealmSecureStorageBte.INSTANCE;
        long epochMilli = Instant.now().plus(((long) -1) * this.$days$inlined, (TemporalUnit) ChronoUnit.DAYS).toEpochMilli();
        realm.checkIfValid();
        FieldDescriptor fieldDescriptors = realmObjectSchema.getFieldDescriptors(DatePickerDialogModule.ARG_DATE, RealmFieldType.INTEGER);
        long[] columnKeys = fieldDescriptors.getColumnKeys();
        fieldDescriptors.compileIfNecessary();
        long[] jArr = fieldDescriptors.nativeTablePointers;
        tableQuery.lessThan(columnKeys, Arrays.copyOf(jArr, jArr.length), epochMilli);
        realm.checkIfValid();
        SubscriptionAction subscriptionAction = SubscriptionAction.NO_SUBSCRIPTION;
        if (subscriptionAction.subscriptionName == null) {
            z = false;
        }
        if (z) {
            osResults = SubscriptionAwareOsResults.createFromQuery(realm.sharedRealm, tableQuery, descriptorOrdering, subscriptionAction);
        } else {
            osResults = OsResults.createFromQuery(realm.sharedRealm, tableQuery, descriptorOrdering);
        }
        RealmResults realmResults = new RealmResults(realm, osResults, SymptomLogEntry.class);
        realmResults.realm.checkIfValid();
        OsResults osResults2 = realmResults.osResults;
        if (!osResults2.loaded) {
            OsResults.nativeEvaluateQueryIfNeeded(osResults2.nativePtr, false);
            osResults2.notifyChangeListeners(0);
        }
        realmResults.realm.checkIfValid();
        if (realmResults.size() > 0) {
            OsResults.nativeClear(realmResults.osResults.nativePtr);
        }
    }
}
