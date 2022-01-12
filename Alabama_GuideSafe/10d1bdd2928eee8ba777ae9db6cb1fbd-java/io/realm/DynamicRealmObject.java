package io.realm;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class DynamicRealmObject extends RealmObject implements RealmObjectProxy {
    public final ProxyState<DynamicRealmObject> proxyState;

    public DynamicRealmObject(BaseRealm baseRealm, Row row) {
        ProxyState<DynamicRealmObject> proxyState2 = new ProxyState<>(this);
        this.proxyState = proxyState2;
        proxyState2.realm = baseRealm;
        proxyState2.row = row;
        proxyState2.setConstructionFinished();
    }

    public boolean equals(Object obj) {
        this.proxyState.realm.checkIfValid();
        if (this == obj) {
            return true;
        }
        if (obj == null || DynamicRealmObject.class != obj.getClass()) {
            return false;
        }
        DynamicRealmObject dynamicRealmObject = (DynamicRealmObject) obj;
        String str = this.proxyState.realm.configuration.canonicalPath;
        String str2 = dynamicRealmObject.proxyState.realm.configuration.canonicalPath;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String name = this.proxyState.row.getTable().getName();
        String name2 = dynamicRealmObject.proxyState.row.getTable().getName();
        if (name == null ? name2 == null : name.equals(name2)) {
            return this.proxyState.row.getObjectKey() == dynamicRealmObject.proxyState.row.getObjectKey();
        }
        return false;
    }

    public int hashCode() {
        this.proxyState.realm.checkIfValid();
        ProxyState<DynamicRealmObject> proxyState2 = this.proxyState;
        String str = proxyState2.realm.configuration.canonicalPath;
        String name = proxyState2.row.getTable().getName();
        long objectKey = this.proxyState.row.getObjectKey();
        int i = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        if (name != null) {
            i = name.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) ((objectKey >>> 32) ^ objectKey));
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
    }

    @Override // io.realm.internal.RealmObjectProxy
    public ProxyState realmGet$proxyState() {
        return this.proxyState;
    }

    public String toString() {
        this.proxyState.realm.checkIfValid();
        if (!this.proxyState.row.isValid()) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline10(this.proxyState.row.getTable().getClassName(), " = dynamic["));
        this.proxyState.realm.checkIfValid();
        String[] columnNames = this.proxyState.row.getColumnNames();
        for (String str : columnNames) {
            long columnKey = this.proxyState.row.getColumnKey(str);
            RealmFieldType columnType = this.proxyState.row.getColumnType(columnKey);
            sb.append("{");
            sb.append(str);
            sb.append(ColorPropConverter.PACKAGE_DELIMITER);
            String str2 = "null";
            switch (columnType.ordinal()) {
                case 0:
                    Long l = str2;
                    if (!this.proxyState.row.isNull(columnKey)) {
                        l = Long.valueOf(this.proxyState.row.getLong(columnKey));
                    }
                    sb.append(l);
                    break;
                case 1:
                    Boolean bool = str2;
                    if (!this.proxyState.row.isNull(columnKey)) {
                        bool = Boolean.valueOf(this.proxyState.row.getBoolean(columnKey));
                    }
                    sb.append(bool);
                    break;
                case 2:
                    sb.append(this.proxyState.row.getString(columnKey));
                    break;
                case 3:
                    sb.append(Arrays.toString(this.proxyState.row.getBinaryByteArray(columnKey)));
                    break;
                case 4:
                    Date date = str2;
                    if (!this.proxyState.row.isNull(columnKey)) {
                        date = this.proxyState.row.getDate(columnKey);
                    }
                    sb.append(date);
                    break;
                case 5:
                    Float f = str2;
                    if (!this.proxyState.row.isNull(columnKey)) {
                        f = Float.valueOf(this.proxyState.row.getFloat(columnKey));
                    }
                    sb.append(f);
                    break;
                case 6:
                    Double d = str2;
                    if (!this.proxyState.row.isNull(columnKey)) {
                        d = Double.valueOf(this.proxyState.row.getDouble(columnKey));
                    }
                    sb.append(d);
                    break;
                case 7:
                    String str3 = str2;
                    if (!this.proxyState.row.isNullLink(columnKey)) {
                        str3 = this.proxyState.row.getTable().getLinkTarget(columnKey).getClassName();
                    }
                    sb.append(str3);
                    break;
                case 8:
                    sb.append(String.format(Locale.US, "RealmList<%s>[%s]", this.proxyState.row.getTable().getLinkTarget(columnKey).getClassName(), Long.valueOf(this.proxyState.row.getModelList(columnKey).size())));
                    break;
                case 9:
                default:
                    sb.append(ColorPropConverter.PREFIX_ATTR);
                    break;
                case 10:
                    sb.append(String.format(Locale.US, "RealmList<Long>[%s]", Long.valueOf(this.proxyState.row.getValueList(columnKey, columnType).size())));
                    break;
                case 11:
                    sb.append(String.format(Locale.US, "RealmList<Boolean>[%s]", Long.valueOf(this.proxyState.row.getValueList(columnKey, columnType).size())));
                    break;
                case 12:
                    sb.append(String.format(Locale.US, "RealmList<String>[%s]", Long.valueOf(this.proxyState.row.getValueList(columnKey, columnType).size())));
                    break;
                case 13:
                    sb.append(String.format(Locale.US, "RealmList<byte[]>[%s]", Long.valueOf(this.proxyState.row.getValueList(columnKey, columnType).size())));
                    break;
                case 14:
                    sb.append(String.format(Locale.US, "RealmList<Date>[%s]", Long.valueOf(this.proxyState.row.getValueList(columnKey, columnType).size())));
                    break;
                case 15:
                    sb.append(String.format(Locale.US, "RealmList<Float>[%s]", Long.valueOf(this.proxyState.row.getValueList(columnKey, columnType).size())));
                    break;
                case 16:
                    sb.append(String.format(Locale.US, "RealmList<Double>[%s]", Long.valueOf(this.proxyState.row.getValueList(columnKey, columnType).size())));
                    break;
            }
            sb.append("},");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        sb.append("]");
        return sb.toString();
    }
}
