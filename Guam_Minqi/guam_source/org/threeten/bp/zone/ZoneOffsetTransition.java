package org.threeten.bp.zone;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import java.io.Serializable;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

public final class ZoneOffsetTransition implements Comparable<ZoneOffsetTransition>, Serializable {
    public final ZoneOffset offsetAfter;
    public final ZoneOffset offsetBefore;
    public final LocalDateTime transition;

    public ZoneOffsetTransition(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.transition = localDateTime;
        this.offsetBefore = zoneOffset;
        this.offsetAfter = zoneOffset2;
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(ZoneOffsetTransition zoneOffsetTransition) {
        Instant instant = getInstant();
        Instant instant2 = zoneOffsetTransition.getInstant();
        int compareLongs = PathParser.compareLongs(instant.seconds, instant2.seconds);
        return compareLongs != 0 ? compareLongs : instant.nanos - instant2.nanos;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransition)) {
            return false;
        }
        ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) obj;
        return this.transition.equals(zoneOffsetTransition.transition) && this.offsetBefore.equals(zoneOffsetTransition.offsetBefore) && this.offsetAfter.equals(zoneOffsetTransition.offsetAfter);
    }

    public LocalDateTime getDateTimeAfter() {
        return this.transition.plusSeconds((long) (this.offsetAfter.totalSeconds - this.offsetBefore.totalSeconds));
    }

    public Instant getInstant() {
        LocalDateTime localDateTime = this.transition;
        return Instant.ofEpochSecond(localDateTime.toEpochSecond(this.offsetBefore), (long) localDateTime.time.nano);
    }

    public int hashCode() {
        return (this.transition.hashCode() ^ this.offsetBefore.totalSeconds) ^ Integer.rotateLeft(this.offsetAfter.totalSeconds, 16);
    }

    public boolean isGap() {
        return this.offsetAfter.totalSeconds > this.offsetBefore.totalSeconds;
    }

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Transition[");
        outline15.append(isGap() ? "Gap" : "Overlap");
        outline15.append(" at ");
        outline15.append(this.transition);
        outline15.append(this.offsetBefore);
        outline15.append(" to ");
        outline15.append(this.offsetAfter);
        outline15.append(']');
        return outline15.toString();
    }

    public ZoneOffsetTransition(long j, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.transition = LocalDateTime.ofEpochSecond(j, 0, zoneOffset);
        this.offsetBefore = zoneOffset;
        this.offsetAfter = zoneOffset2;
    }
}
