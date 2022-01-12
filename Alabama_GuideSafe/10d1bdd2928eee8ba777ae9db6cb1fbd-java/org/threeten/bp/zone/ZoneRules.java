package org.threeten.bp.zone;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

public abstract class ZoneRules {

    public static final class Fixed extends ZoneRules implements Serializable {
        public final ZoneOffset offset;

        public Fixed(ZoneOffset zoneOffset) {
            this.offset = zoneOffset;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Fixed) {
                return this.offset.equals(((Fixed) obj).offset);
            }
            if (!(obj instanceof StandardZoneRules)) {
                return false;
            }
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            if (!standardZoneRules.isFixedOffset() || !this.offset.equals(standardZoneRules.getOffset(Instant.EPOCH))) {
                return false;
            }
            return true;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffset getOffset(Instant instant) {
            return this.offset;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
            return null;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime) {
            return Collections.singletonList(this.offset);
        }

        public int hashCode() {
            int i = this.offset.totalSeconds;
            return ((i + 31) ^ (((i + 31) ^ 1) ^ 1)) ^ 1;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isFixedOffset() {
            return true;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
            return this.offset.equals(zoneOffset);
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("FixedRules:");
            outline17.append(this.offset);
            return outline17.toString();
        }
    }

    public abstract ZoneOffset getOffset(Instant instant);

    public abstract ZoneOffsetTransition getTransition(LocalDateTime localDateTime);

    public abstract List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime);

    public abstract boolean isFixedOffset();

    public abstract boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset zoneOffset);
}
