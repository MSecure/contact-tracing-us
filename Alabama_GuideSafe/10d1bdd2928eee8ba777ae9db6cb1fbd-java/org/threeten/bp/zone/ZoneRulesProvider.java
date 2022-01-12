package org.threeten.bp.zone;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.threeten.bp.zone.TzdbZoneRulesProvider;
import org.threeten.bp.zone.ZoneRulesInitializer;

public abstract class ZoneRulesProvider {
    public static final CopyOnWriteArrayList<ZoneRulesProvider> PROVIDERS = new CopyOnWriteArrayList<>();
    public static final ConcurrentMap<String, ZoneRulesProvider> ZONES = new ConcurrentHashMap(512, 0.75f, 2);

    static {
        if (!ZoneRulesInitializer.INITIALIZED.getAndSet(true)) {
            ZoneRulesInitializer.INITIALIZER.compareAndSet(null, new ZoneRulesInitializer.ServiceLoaderZoneRulesInitializer());
            ZoneRulesInitializer.INITIALIZER.get().initializeProviders();
            return;
        }
        throw new IllegalStateException("Already initialized");
    }

    public static ZoneRules getRules(String str, boolean z) {
        ZoneRules zoneRules;
        MoreExecutors.requireNonNull(str, "zoneId");
        ZoneRulesProvider zoneRulesProvider = ZONES.get(str);
        if (zoneRulesProvider != null) {
            MoreExecutors.requireNonNull(str, "zoneId");
            TzdbZoneRulesProvider.Version value = ((TzdbZoneRulesProvider) zoneRulesProvider).versions.lastEntry().getValue();
            int binarySearch = Arrays.binarySearch(value.regionArray, str);
            if (binarySearch < 0) {
                zoneRules = null;
            } else {
                try {
                    short s = value.ruleIndices[binarySearch];
                    Object obj = value.ruleData.get(s);
                    if (obj instanceof byte[]) {
                        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
                        obj = Ser.readInternal(dataInputStream.readByte(), dataInputStream);
                        value.ruleData.set(s, obj);
                    }
                    zoneRules = (ZoneRules) obj;
                } catch (Exception e) {
                    StringBuilder outline20 = GeneratedOutlineSupport.outline20("Invalid binary time-zone data: TZDB:", str, ", version: ");
                    outline20.append(value.versionId);
                    throw new ZoneRulesException(outline20.toString(), e);
                }
            }
            if (zoneRules != null) {
                return zoneRules;
            }
            throw new ZoneRulesException(GeneratedOutlineSupport.outline10("Unknown time-zone ID: ", str));
        } else if (ZONES.isEmpty()) {
            throw new ZoneRulesException("No time-zone data files registered");
        } else {
            throw new ZoneRulesException(GeneratedOutlineSupport.outline10("Unknown time-zone ID: ", str));
        }
    }

    public static void registerProvider(ZoneRulesProvider zoneRulesProvider) {
        MoreExecutors.requireNonNull(zoneRulesProvider, "provider");
        Iterator it = new HashSet(((TzdbZoneRulesProvider) zoneRulesProvider).regionIds).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            MoreExecutors.requireNonNull(str, "zoneId");
            if (ZONES.putIfAbsent(str, zoneRulesProvider) != null) {
                throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + zoneRulesProvider);
            }
        }
        PROVIDERS.add(zoneRulesProvider);
    }
}
