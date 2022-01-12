package io.realm;

import io.realm.internal.InvalidRow;
import io.realm.internal.OsResults;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SubscriptionAwareOsResults;
import io.realm.internal.Table;
import io.realm.internal.TableQuery;
import io.realm.internal.UncheckedRow;
import io.realm.internal.core.DescriptorOrdering;
import io.realm.internal.fields.FieldDescriptor;
import io.realm.internal.sync.SubscriptionAction;
import java.util.Arrays;
import java.util.Collections;

public class RealmQuery<E> {
    public Class<E> clazz;
    public final boolean forValues;
    public final TableQuery query;
    public DescriptorOrdering queryDescriptors = new DescriptorOrdering();
    public final BaseRealm realm;
    public final RealmObjectSchema schema;
    public final Table table;

    public RealmQuery(Realm realm2, Class<E> cls) {
        this.realm = realm2;
        this.clazz = cls;
        boolean z = !RealmModel.class.isAssignableFrom(cls);
        this.forValues = z;
        if (z) {
            this.schema = null;
            this.table = null;
            this.query = null;
            return;
        }
        RealmObjectSchema schemaForClass = realm2.schema.getSchemaForClass(cls);
        this.schema = schemaForClass;
        Table table2 = schemaForClass.table;
        this.table = table2;
        this.query = table2.where();
    }

    public static native String nativeSerializeQuery(long j, long j2);

    public static native long nativeSubscribe(long j, String str, long j2, long j3, long j4, boolean z);

    public RealmQuery<E> equalTo(String str, String str2) {
        Case r0 = Case.SENSITIVE;
        this.realm.checkIfValid();
        FieldDescriptor fieldDescriptors = this.schema.getFieldDescriptors(str, RealmFieldType.STRING);
        TableQuery tableQuery = this.query;
        long[] columnKeys = fieldDescriptors.getColumnKeys();
        fieldDescriptors.compileIfNecessary();
        long[] jArr = fieldDescriptors.nativeTablePointers;
        tableQuery.equalTo(columnKeys, Arrays.copyOf(jArr, jArr.length), str2, r0);
        return this;
    }

    public RealmResults<E> findAll() {
        OsResults osResults;
        this.realm.checkIfValid();
        TableQuery tableQuery = this.query;
        DescriptorOrdering descriptorOrdering = this.queryDescriptors;
        SubscriptionAction subscriptionAction = SubscriptionAction.NO_SUBSCRIPTION;
        if (subscriptionAction.subscriptionName != null) {
            osResults = SubscriptionAwareOsResults.createFromQuery(this.realm.sharedRealm, tableQuery, descriptorOrdering, subscriptionAction);
        } else {
            osResults = OsResults.createFromQuery(this.realm.sharedRealm, tableQuery, descriptorOrdering);
        }
        RealmResults<E> realmResults = new RealmResults<>(this.realm, osResults, this.clazz);
        realmResults.realm.checkIfValid();
        OsResults osResults2 = realmResults.osResults;
        if (!osResults2.loaded) {
            OsResults.nativeEvaluateQueryIfNeeded(osResults2.nativePtr, false);
            osResults2.notifyChangeListeners(0);
        }
        return realmResults;
    }

    public E findFirst() {
        long j;
        this.realm.checkIfValid();
        if (this.forValues) {
            return null;
        }
        if (!DescriptorOrdering.nativeIsEmpty(this.queryDescriptors.nativePtr)) {
            RealmResults<E> findAll = findAll();
            UncheckedRow firstUncheckedRow = findAll.osResults.firstUncheckedRow();
            RealmObjectProxy realmObjectProxy = (RealmObjectProxy) (firstUncheckedRow != null ? findAll.realm.get(findAll.classSpec, findAll.className, firstUncheckedRow) : null);
            j = realmObjectProxy != null ? realmObjectProxy.realmGet$proxyState().row.getObjectKey() : -1;
        } else {
            j = this.query.find();
        }
        if (j < 0) {
            return null;
        }
        BaseRealm baseRealm = this.realm;
        Class<E> cls = this.clazz;
        Row row = InvalidRow.INSTANCE;
        Table table2 = baseRealm.getSchema().getTable(cls);
        RealmProxyMediator realmProxyMediator = baseRealm.configuration.schemaMediator;
        if (j != -1) {
            row = UncheckedRow.getByRowKey(table2.context, table2, j);
        }
        RealmSchema schema2 = baseRealm.getSchema();
        schema2.checkColumnKeys();
        return (E) realmProxyMediator.newInstance(cls, baseRealm, row, schema2.columnIndices.getColumnInfo(cls), false, Collections.emptyList());
    }
}
