package org.threeten.bp.temporal;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.Chronology;

public final class TemporalQueries {
    public static final TemporalQuery<Chronology> CHRONO = new TemporalQuery<Chronology>() {
        /* class org.threeten.bp.temporal.TemporalQueries.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // org.threeten.bp.temporal.TemporalQuery
        public Chronology queryFrom(TemporalAccessor temporalAccessor) {
            return (Chronology) temporalAccessor.query(this);
        }
    };
    public static final TemporalQuery<LocalDate> LOCAL_DATE = new TemporalQuery<LocalDate>() {
        /* class org.threeten.bp.temporal.TemporalQueries.AnonymousClass6 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // org.threeten.bp.temporal.TemporalQuery
        public LocalDate queryFrom(TemporalAccessor temporalAccessor) {
            if (temporalAccessor.isSupported(ChronoField.EPOCH_DAY)) {
                return LocalDate.ofEpochDay(temporalAccessor.getLong(ChronoField.EPOCH_DAY));
            }
            return null;
        }
    };
    public static final TemporalQuery<LocalTime> LOCAL_TIME = new TemporalQuery<LocalTime>() {
        /* class org.threeten.bp.temporal.TemporalQueries.AnonymousClass7 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // org.threeten.bp.temporal.TemporalQuery
        public LocalTime queryFrom(TemporalAccessor temporalAccessor) {
            if (temporalAccessor.isSupported(ChronoField.NANO_OF_DAY)) {
                return LocalTime.ofNanoOfDay(temporalAccessor.getLong(ChronoField.NANO_OF_DAY));
            }
            return null;
        }
    };
    public static final TemporalQuery<ZoneOffset> OFFSET = new TemporalQuery<ZoneOffset>() {
        /* class org.threeten.bp.temporal.TemporalQueries.AnonymousClass5 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneOffset queryFrom(TemporalAccessor temporalAccessor) {
            if (temporalAccessor.isSupported(ChronoField.OFFSET_SECONDS)) {
                return ZoneOffset.ofTotalSeconds(temporalAccessor.get(ChronoField.OFFSET_SECONDS));
            }
            return null;
        }
    };
    public static final TemporalQuery<TemporalUnit> PRECISION = new TemporalQuery<TemporalUnit>() {
        /* class org.threeten.bp.temporal.TemporalQueries.AnonymousClass3 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // org.threeten.bp.temporal.TemporalQuery
        public TemporalUnit queryFrom(TemporalAccessor temporalAccessor) {
            return (TemporalUnit) temporalAccessor.query(this);
        }
    };
    public static final TemporalQuery<ZoneId> ZONE = new TemporalQuery<ZoneId>() {
        /* class org.threeten.bp.temporal.TemporalQueries.AnonymousClass4 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.ZONE_ID);
            return zoneId != null ? zoneId : (ZoneId) temporalAccessor.query(TemporalQueries.OFFSET);
        }
    };
    public static final TemporalQuery<ZoneId> ZONE_ID = new TemporalQuery<ZoneId>() {
        /* class org.threeten.bp.temporal.TemporalQueries.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            return (ZoneId) temporalAccessor.query(this);
        }
    };
}
