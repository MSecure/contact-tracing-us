package org.threeten.bp.zone;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAdjusters$RelativeDayOfWeek;
import org.threeten.bp.zone.ZoneOffsetTransitionRule;
import org.threeten.bp.zone.ZoneRules;

public final class StandardZoneRules extends ZoneRules implements Serializable {
    public final ZoneOffsetTransitionRule[] lastRules;
    public final ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache = new ConcurrentHashMap();
    public final long[] savingsInstantTransitions;
    public final LocalDateTime[] savingsLocalTransitions;
    public final ZoneOffset[] standardOffsets;
    public final long[] standardTransitions;
    public final ZoneOffset[] wallOffsets;

    public StandardZoneRules(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr) {
        this.standardTransitions = jArr;
        this.standardOffsets = zoneOffsetArr;
        this.savingsInstantTransitions = jArr2;
        this.wallOffsets = zoneOffsetArr2;
        this.lastRules = zoneOffsetTransitionRuleArr;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < jArr2.length) {
            int i2 = i + 1;
            ZoneOffsetTransition zoneOffsetTransition = new ZoneOffsetTransition(jArr2[i], zoneOffsetArr2[i], zoneOffsetArr2[i2]);
            if (zoneOffsetTransition.isGap()) {
                arrayList.add(zoneOffsetTransition.transition);
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
            } else {
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
                arrayList.add(zoneOffsetTransition.transition);
            }
            i = i2;
        }
        this.savingsLocalTransitions = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StandardZoneRules) {
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            return Arrays.equals(this.standardTransitions, standardZoneRules.standardTransitions) && Arrays.equals(this.standardOffsets, standardZoneRules.standardOffsets) && Arrays.equals(this.savingsInstantTransitions, standardZoneRules.savingsInstantTransitions) && Arrays.equals(this.wallOffsets, standardZoneRules.wallOffsets) && Arrays.equals(this.lastRules, standardZoneRules.lastRules);
        } else if (!(obj instanceof ZoneRules.Fixed)) {
            return false;
        } else {
            if (isFixedOffset()) {
                ZoneOffset offset = getOffset(Instant.EPOCH);
                Instant instant = Instant.EPOCH;
                if (offset.equals(((ZoneRules.Fixed) obj).offset)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final ZoneOffsetTransition[] findTransitionArray(int i) {
        LocalDate localDate;
        Integer valueOf = Integer.valueOf(i);
        ZoneOffsetTransition[] zoneOffsetTransitionArr = this.lastRulesCache.get(valueOf);
        if (zoneOffsetTransitionArr != null) {
            return zoneOffsetTransitionArr;
        }
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = this.lastRules;
        ZoneOffsetTransition[] zoneOffsetTransitionArr2 = new ZoneOffsetTransition[zoneOffsetTransitionRuleArr.length];
        for (int i2 = 0; i2 < zoneOffsetTransitionRuleArr.length; i2++) {
            ZoneOffsetTransitionRule zoneOffsetTransitionRule = zoneOffsetTransitionRuleArr[i2];
            byte b = zoneOffsetTransitionRule.dom;
            if (b < 0) {
                Month month = zoneOffsetTransitionRule.month;
                localDate = LocalDate.of(i, month, month.length(IsoChronology.INSTANCE.isLeapYear((long) i)) + 1 + zoneOffsetTransitionRule.dom);
                DayOfWeek dayOfWeek = zoneOffsetTransitionRule.dow;
                if (dayOfWeek != null) {
                    localDate = localDate.with((TemporalAdjuster) new TemporalAdjusters$RelativeDayOfWeek(1, dayOfWeek, null));
                }
            } else {
                localDate = LocalDate.of(i, zoneOffsetTransitionRule.month, b);
                DayOfWeek dayOfWeek2 = zoneOffsetTransitionRule.dow;
                if (dayOfWeek2 != null) {
                    localDate = localDate.with((TemporalAdjuster) new TemporalAdjusters$RelativeDayOfWeek(0, dayOfWeek2, null));
                }
            }
            LocalDateTime of = LocalDateTime.of(localDate.plusDays((long) zoneOffsetTransitionRule.adjustDays), zoneOffsetTransitionRule.time);
            ZoneOffsetTransitionRule.TimeDefinition timeDefinition = zoneOffsetTransitionRule.timeDefinition;
            ZoneOffset zoneOffset = zoneOffsetTransitionRule.standardOffset;
            ZoneOffset zoneOffset2 = zoneOffsetTransitionRule.offsetBefore;
            int ordinal = timeDefinition.ordinal();
            if (ordinal == 0) {
                of = of.plusSeconds((long) (zoneOffset2.totalSeconds - ZoneOffset.UTC.totalSeconds));
            } else if (ordinal == 2) {
                of = of.plusSeconds((long) (zoneOffset2.totalSeconds - zoneOffset.totalSeconds));
            }
            zoneOffsetTransitionArr2[i2] = new ZoneOffsetTransition(of, zoneOffsetTransitionRule.offsetBefore, zoneOffsetTransitionRule.offsetAfter);
        }
        if (i < 2100) {
            this.lastRulesCache.putIfAbsent(valueOf, zoneOffsetTransitionArr2);
        }
        return zoneOffsetTransitionArr2;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffset getOffset(Instant instant) {
        long j = instant.seconds;
        if (this.lastRules.length > 0) {
            long[] jArr = this.savingsInstantTransitions;
            if (j > jArr[jArr.length - 1]) {
                ZoneOffset[] zoneOffsetArr = this.wallOffsets;
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(LocalDate.ofEpochDay(PathParser.floorDiv(((long) zoneOffsetArr[zoneOffsetArr.length - 1].totalSeconds) + j, 86400)).year);
                ZoneOffsetTransition zoneOffsetTransition = null;
                for (int i = 0; i < findTransitionArray.length; i++) {
                    zoneOffsetTransition = findTransitionArray[i];
                    if (j < zoneOffsetTransition.transition.toEpochSecond(zoneOffsetTransition.offsetBefore)) {
                        return zoneOffsetTransition.offsetBefore;
                    }
                }
                return zoneOffsetTransition.offsetAfter;
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, j);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.wallOffsets[binarySearch + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0097 A[ADDED_TO_REGION, SYNTHETIC] */
    public final Object getOffsetInfo(LocalDateTime localDateTime) {
        Object obj;
        int i;
        int i2 = 0;
        if (this.lastRules.length > 0) {
            LocalDateTime[] localDateTimeArr = this.savingsLocalTransitions;
            LocalDateTime localDateTime2 = localDateTimeArr[localDateTimeArr.length - 1];
            Object obj2 = null;
            if (localDateTime != null) {
                if (!(localDateTime2 instanceof LocalDateTime) ? localDateTime.date.toEpochDay() > localDateTime2.date.toEpochDay() || (i == 0 && localDateTime.time.toNanoOfDay() > localDateTime2.time.toNanoOfDay()) : localDateTime.compareTo0(localDateTime2) > 0) {
                    ZoneOffsetTransition[] findTransitionArray = findTransitionArray(localDateTime.date.year);
                    int length = findTransitionArray.length;
                    while (i2 < length) {
                        ZoneOffsetTransition zoneOffsetTransition = findTransitionArray[i2];
                        LocalDateTime localDateTime3 = zoneOffsetTransition.transition;
                        if (zoneOffsetTransition.isGap()) {
                            if (localDateTime.isBefore(localDateTime3)) {
                                obj = zoneOffsetTransition.offsetBefore;
                            } else if (!localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter())) {
                                obj = zoneOffsetTransition.offsetAfter;
                            }
                            if ((obj instanceof ZoneOffsetTransition) || obj.equals(zoneOffsetTransition.offsetBefore)) {
                                return obj;
                            }
                            i2++;
                            obj2 = obj;
                        } else {
                            if (!localDateTime.isBefore(localDateTime3)) {
                                obj = zoneOffsetTransition.offsetAfter;
                            } else if (localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter())) {
                                obj = zoneOffsetTransition.offsetBefore;
                            }
                            if (obj instanceof ZoneOffsetTransition) {
                            }
                            return obj;
                        }
                        obj = zoneOffsetTransition;
                        if (obj instanceof ZoneOffsetTransition) {
                        }
                        return obj;
                    }
                    return obj2;
                }
            } else {
                throw null;
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsLocalTransitions, localDateTime);
        if (binarySearch == -1) {
            return this.wallOffsets[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else {
            LocalDateTime[] localDateTimeArr2 = this.savingsLocalTransitions;
            if (binarySearch < localDateTimeArr2.length - 1) {
                int i3 = binarySearch + 1;
                if (localDateTimeArr2[binarySearch].equals(localDateTimeArr2[i3])) {
                    binarySearch = i3;
                }
            }
        }
        if ((binarySearch & 1) != 0) {
            return this.wallOffsets[(binarySearch / 2) + 1];
        }
        LocalDateTime[] localDateTimeArr3 = this.savingsLocalTransitions;
        LocalDateTime localDateTime4 = localDateTimeArr3[binarySearch];
        LocalDateTime localDateTime5 = localDateTimeArr3[binarySearch + 1];
        ZoneOffset[] zoneOffsetArr = this.wallOffsets;
        int i4 = binarySearch / 2;
        ZoneOffset zoneOffset = zoneOffsetArr[i4];
        ZoneOffset zoneOffset2 = zoneOffsetArr[i4 + 1];
        if (zoneOffset2.totalSeconds > zoneOffset.totalSeconds) {
            return new ZoneOffsetTransition(localDateTime4, zoneOffset, zoneOffset2);
        }
        return new ZoneOffsetTransition(localDateTime5, zoneOffset, zoneOffset2);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) offsetInfo;
        }
        return null;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (!(offsetInfo instanceof ZoneOffsetTransition)) {
            return Collections.singletonList((ZoneOffset) offsetInfo);
        }
        ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) offsetInfo;
        if (zoneOffsetTransition.isGap()) {
            return Collections.emptyList();
        }
        return Arrays.asList(zoneOffsetTransition.offsetBefore, zoneOffsetTransition.offsetAfter);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.standardTransitions) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isFixedOffset() {
        return this.savingsInstantTransitions.length == 0;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return getValidOffsets(localDateTime).contains(zoneOffset);
    }

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("StandardZoneRules[currentStandardOffset=");
        ZoneOffset[] zoneOffsetArr = this.standardOffsets;
        outline15.append(zoneOffsetArr[zoneOffsetArr.length - 1]);
        outline15.append("]");
        return outline15.toString();
    }
}
