package org.threeten.bp.zone;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;

public final class ZoneOffsetTransitionRule implements Serializable {
    public final int adjustDays;
    public final byte dom;
    public final DayOfWeek dow;
    public final Month month;
    public final ZoneOffset offsetAfter;
    public final ZoneOffset offsetBefore;
    public final ZoneOffset standardOffset;
    public final LocalTime time;
    public final TimeDefinition timeDefinition;

    public enum TimeDefinition {
        UTC,
        WALL,
        STANDARD
    }

    public ZoneOffsetTransitionRule(Month month2, int i, DayOfWeek dayOfWeek, LocalTime localTime, int i2, TimeDefinition timeDefinition2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.month = month2;
        this.dom = (byte) i;
        this.dow = dayOfWeek;
        this.time = localTime;
        this.adjustDays = i2;
        this.timeDefinition = timeDefinition2;
        this.standardOffset = zoneOffset;
        this.offsetBefore = zoneOffset2;
        this.offsetAfter = zoneOffset3;
    }

    public static ZoneOffsetTransitionRule readExternal(DataInput dataInput) throws IOException {
        DayOfWeek dayOfWeek;
        ZoneOffset zoneOffset;
        ZoneOffset zoneOffset2;
        int readInt = dataInput.readInt();
        Month of = Month.of(readInt >>> 28);
        int i = ((264241152 & readInt) >>> 22) - 32;
        int i2 = (3670016 & readInt) >>> 19;
        if (i2 == 0) {
            dayOfWeek = null;
        } else {
            dayOfWeek = DayOfWeek.of(i2);
        }
        int i3 = (507904 & readInt) >>> 14;
        TimeDefinition timeDefinition2 = TimeDefinition.values()[(readInt & 12288) >>> 12];
        int i4 = (readInt & 4080) >>> 4;
        int i5 = (readInt & 12) >>> 2;
        int i6 = readInt & 3;
        int readInt2 = i3 == 31 ? dataInput.readInt() : i3 * 3600;
        ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds(i4 == 255 ? dataInput.readInt() : (i4 - 128) * 900);
        if (i5 == 3) {
            zoneOffset = ZoneOffset.ofTotalSeconds(dataInput.readInt());
        } else {
            zoneOffset = ZoneOffset.ofTotalSeconds((i5 * 1800) + ofTotalSeconds.totalSeconds);
        }
        if (i6 == 3) {
            zoneOffset2 = ZoneOffset.ofTotalSeconds(dataInput.readInt());
        } else {
            zoneOffset2 = ZoneOffset.ofTotalSeconds((i6 * 1800) + ofTotalSeconds.totalSeconds);
        }
        if (i < -28 || i > 31 || i == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        return new ZoneOffsetTransitionRule(of, i, dayOfWeek, LocalTime.ofSecondOfDay((long) (((readInt2 % 86400) + 86400) % 86400)), readInt2 >= 0 ? readInt2 / 86400 : ((readInt2 + 1) / 86400) - 1, timeDefinition2, ofTotalSeconds, zoneOffset, zoneOffset2);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransitionRule)) {
            return false;
        }
        ZoneOffsetTransitionRule zoneOffsetTransitionRule = (ZoneOffsetTransitionRule) obj;
        return this.month == zoneOffsetTransitionRule.month && this.dom == zoneOffsetTransitionRule.dom && this.dow == zoneOffsetTransitionRule.dow && this.timeDefinition == zoneOffsetTransitionRule.timeDefinition && this.adjustDays == zoneOffsetTransitionRule.adjustDays && this.time.equals(zoneOffsetTransitionRule.time) && this.standardOffset.equals(zoneOffsetTransitionRule.standardOffset) && this.offsetBefore.equals(zoneOffsetTransitionRule.offsetBefore) && this.offsetAfter.equals(zoneOffsetTransitionRule.offsetAfter);
    }

    public int hashCode() {
        int secondOfDay = ((this.time.toSecondOfDay() + this.adjustDays) << 15) + (this.month.ordinal() << 11) + ((this.dom + 32) << 5);
        DayOfWeek dayOfWeek = this.dow;
        return ((this.standardOffset.totalSeconds ^ (this.timeDefinition.ordinal() + (secondOfDay + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)))) ^ this.offsetBefore.totalSeconds) ^ this.offsetAfter.totalSeconds;
    }

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("TransitionRule[");
        ZoneOffset zoneOffset = this.offsetBefore;
        ZoneOffset zoneOffset2 = this.offsetAfter;
        if (zoneOffset != null) {
            outline15.append(zoneOffset2.totalSeconds - zoneOffset.totalSeconds > 0 ? "Gap " : "Overlap ");
            outline15.append(this.offsetBefore);
            outline15.append(" to ");
            outline15.append(this.offsetAfter);
            outline15.append(", ");
            DayOfWeek dayOfWeek = this.dow;
            if (dayOfWeek != null) {
                byte b = this.dom;
                if (b == -1) {
                    outline15.append(dayOfWeek.name());
                    outline15.append(" on or before last day of ");
                    outline15.append(this.month.name());
                } else if (b < 0) {
                    outline15.append(dayOfWeek.name());
                    outline15.append(" on or before last day minus ");
                    outline15.append((-this.dom) - 1);
                    outline15.append(" of ");
                    outline15.append(this.month.name());
                } else {
                    outline15.append(dayOfWeek.name());
                    outline15.append(" on or after ");
                    outline15.append(this.month.name());
                    outline15.append(' ');
                    outline15.append((int) this.dom);
                }
            } else {
                outline15.append(this.month.name());
                outline15.append(' ');
                outline15.append((int) this.dom);
            }
            outline15.append(" at ");
            if (this.adjustDays == 0) {
                outline15.append(this.time);
            } else {
                long secondOfDay = (long) ((this.adjustDays * 24 * 60) + (this.time.toSecondOfDay() / 60));
                long floorDiv = PathParser.floorDiv(secondOfDay, 60);
                if (floorDiv < 10) {
                    outline15.append(0);
                }
                outline15.append(floorDiv);
                outline15.append(':');
                long floorMod = (long) PathParser.floorMod(secondOfDay, 60);
                if (floorMod < 10) {
                    outline15.append(0);
                }
                outline15.append(floorMod);
            }
            outline15.append(" ");
            outline15.append(this.timeDefinition);
            outline15.append(", standard offset ");
            outline15.append(this.standardOffset);
            outline15.append(']');
            return outline15.toString();
        }
        throw null;
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        byte b;
        int i;
        int i2;
        int secondOfDay = (this.adjustDays * 86400) + this.time.toSecondOfDay();
        int i3 = this.standardOffset.totalSeconds;
        int i4 = this.offsetBefore.totalSeconds - i3;
        int i5 = this.offsetAfter.totalSeconds - i3;
        if (secondOfDay % 3600 != 0 || secondOfDay > 86400) {
            b = 31;
        } else {
            b = secondOfDay == 86400 ? 24 : this.time.hour;
        }
        int i6 = i3 % 900 == 0 ? (i3 / 900) + 128 : 255;
        if (i4 == 0 || i4 == 1800 || i4 == 3600) {
            i = i4 / 1800;
        } else {
            i = 3;
        }
        if (i5 == 0 || i5 == 1800 || i5 == 3600) {
            i2 = i5 / 1800;
        } else {
            i2 = 3;
        }
        DayOfWeek dayOfWeek = this.dow;
        dataOutput.writeInt((this.month.getValue() << 28) + ((this.dom + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.getValue()) << 19) + (b << 14) + (this.timeDefinition.ordinal() << 12) + (i6 << 4) + (i << 2) + i2);
        if (b == 31) {
            dataOutput.writeInt(secondOfDay);
        }
        if (i6 == 255) {
            dataOutput.writeInt(i3);
        }
        if (i == 3) {
            dataOutput.writeInt(this.offsetBefore.totalSeconds);
        }
        if (i2 == 3) {
            dataOutput.writeInt(this.offsetAfter.totalSeconds);
        }
    }
}
