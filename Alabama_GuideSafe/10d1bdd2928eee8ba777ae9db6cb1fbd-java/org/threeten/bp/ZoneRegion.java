package org.threeten.bp;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;

public final class ZoneRegion extends ZoneId implements Serializable {
    public static final Pattern PATTERN = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    public final String id;
    public final transient ZoneRules rules;

    public ZoneRegion(String str, ZoneRules zoneRules) {
        this.id = str;
        this.rules = zoneRules;
    }

    public static ZoneId readExternal(DataInput dataInput) throws IOException {
        ZoneRegion zoneRegion;
        String readUTF = dataInput.readUTF();
        if (readUTF.equals("Z") || readUTF.startsWith("+") || readUTF.startsWith("-")) {
            throw new DateTimeException(GeneratedOutlineSupport.outline10("Invalid ID for region-based ZoneId, invalid format: ", readUTF));
        } else if (readUTF.equals("UTC") || readUTF.equals("GMT") || readUTF.equals("UT")) {
            return new ZoneRegion(readUTF, ZoneOffset.UTC.getRules());
        } else {
            if (readUTF.startsWith("UTC+") || readUTF.startsWith("GMT+") || readUTF.startsWith("UTC-") || readUTF.startsWith("GMT-")) {
                ZoneOffset of = ZoneOffset.of(readUTF.substring(3));
                if (of.totalSeconds == 0) {
                    zoneRegion = new ZoneRegion(readUTF.substring(0, 3), of.getRules());
                } else {
                    zoneRegion = new ZoneRegion(readUTF.substring(0, 3) + of.id, of.getRules());
                }
                return zoneRegion;
            } else if (readUTF.startsWith("UT+") || readUTF.startsWith("UT-")) {
                ZoneOffset of2 = ZoneOffset.of(readUTF.substring(2));
                if (of2.totalSeconds == 0) {
                    return new ZoneRegion("UT", of2.getRules());
                }
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("UT");
                outline17.append(of2.id);
                return new ZoneRegion(outline17.toString(), of2.getRules());
            } else {
                MoreExecutors.requireNonNull(readUTF, "zoneId");
                if (readUTF.length() < 2 || !PATTERN.matcher(readUTF).matches()) {
                    throw new DateTimeException(GeneratedOutlineSupport.outline10("Invalid ID for region-based ZoneId, invalid format: ", readUTF));
                }
                ZoneRules zoneRules = null;
                try {
                    zoneRules = ZoneRulesProvider.getRules(readUTF, true);
                } catch (ZoneRulesException unused) {
                    if (readUTF.equals("GMT0")) {
                        zoneRules = ZoneOffset.UTC.getRules();
                    }
                }
                return new ZoneRegion(readUTF, zoneRules);
            }
        }
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.id;
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        ZoneRules zoneRules = this.rules;
        return zoneRules != null ? zoneRules : ZoneRulesProvider.getRules(this.id, false);
    }

    @Override // org.threeten.bp.ZoneId
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.id);
    }
}
