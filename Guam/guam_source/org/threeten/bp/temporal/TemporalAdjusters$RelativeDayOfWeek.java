package org.threeten.bp.temporal;

import com.horcrux.svg.PathParser;
import org.threeten.bp.DayOfWeek;

public final class TemporalAdjusters$RelativeDayOfWeek implements TemporalAdjuster {
    public final int dowValue;
    public final int relative;

    public TemporalAdjusters$RelativeDayOfWeek(int i, DayOfWeek dayOfWeek, TemporalAdjusters$1 temporalAdjusters$1) {
        PathParser.requireNonNull(dayOfWeek, "dayOfWeek");
        this.relative = i;
        this.dowValue = dayOfWeek.getValue();
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        int i = temporal.get(ChronoField.DAY_OF_WEEK);
        if (this.relative < 2 && i == this.dowValue) {
            return temporal;
        }
        if ((this.relative & 1) == 0) {
            int i2 = i - this.dowValue;
            return temporal.plus((long) (i2 >= 0 ? 7 - i2 : -i2), ChronoUnit.DAYS);
        }
        int i3 = this.dowValue - i;
        return temporal.minus((long) (i3 >= 0 ? 7 - i3 : -i3), ChronoUnit.DAYS);
    }
}
