package org.threeten.bp.zone;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class TzdbZoneRulesProvider extends ZoneRulesProvider {
    public List<String> regionIds;
    public final ConcurrentNavigableMap<String, Version> versions = new ConcurrentSkipListMap();

    public static class Version {
        public final String[] regionArray;
        public final AtomicReferenceArray<Object> ruleData;
        public final short[] ruleIndices;
        public final String versionId;

        public Version(String str, String[] strArr, short[] sArr, AtomicReferenceArray<Object> atomicReferenceArray) {
            this.ruleData = atomicReferenceArray;
            this.versionId = str;
            this.regionArray = strArr;
            this.ruleIndices = sArr;
        }

        public String toString() {
            return this.versionId;
        }
    }

    public TzdbZoneRulesProvider(InputStream inputStream) {
        new CopyOnWriteArraySet();
        try {
            load(inputStream);
        } catch (Exception e) {
            throw new ZoneRulesException("Unable to load TZDB time-zone rules", e);
        }
    }

    public final boolean load(InputStream inputStream) throws IOException, StreamCorruptedException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        if (dataInputStream.readByte() != 1) {
            throw new StreamCorruptedException("File format not recognised");
        } else if ("TZDB".equals(dataInputStream.readUTF())) {
            int readShort = dataInputStream.readShort();
            String[] strArr = new String[readShort];
            boolean z = false;
            for (int i = 0; i < readShort; i++) {
                strArr[i] = dataInputStream.readUTF();
            }
            int readShort2 = dataInputStream.readShort();
            String[] strArr2 = new String[readShort2];
            for (int i2 = 0; i2 < readShort2; i2++) {
                strArr2[i2] = dataInputStream.readUTF();
            }
            this.regionIds = Arrays.asList(strArr2);
            int readShort3 = dataInputStream.readShort();
            Object[] objArr = new Object[readShort3];
            for (int i3 = 0; i3 < readShort3; i3++) {
                byte[] bArr = new byte[dataInputStream.readShort()];
                dataInputStream.readFully(bArr);
                objArr[i3] = bArr;
            }
            AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(objArr);
            HashSet hashSet = new HashSet(readShort);
            for (int i4 = 0; i4 < readShort; i4++) {
                int readShort4 = dataInputStream.readShort();
                String[] strArr3 = new String[readShort4];
                short[] sArr = new short[readShort4];
                for (int i5 = 0; i5 < readShort4; i5++) {
                    strArr3[i5] = strArr2[dataInputStream.readShort()];
                    sArr[i5] = dataInputStream.readShort();
                }
                hashSet.add(new Version(strArr[i4], strArr3, sArr, atomicReferenceArray));
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Version version = (Version) it.next();
                Version putIfAbsent = this.versions.putIfAbsent(version.versionId, version);
                if (putIfAbsent == null || putIfAbsent.versionId.equals(version.versionId)) {
                    z = true;
                } else {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Data already loaded for TZDB time-zone rules version: ");
                    outline17.append(version.versionId);
                    throw new ZoneRulesException(outline17.toString());
                }
            }
            return z;
        } else {
            throw new StreamCorruptedException("File format not recognised");
        }
    }

    public String toString() {
        return "TZDB";
    }
}
