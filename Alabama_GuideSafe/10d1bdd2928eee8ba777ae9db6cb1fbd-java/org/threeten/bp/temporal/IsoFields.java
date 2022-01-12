package org.threeten.bp.temporal;

import com.google.common.util.concurrent.MoreExecutors;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;

public final class IsoFields {
    public static final TemporalField QUARTER_OF_YEAR = Field.QUARTER_OF_YEAR;
    public static final TemporalField WEEK_BASED_YEAR = Field.WEEK_BASED_YEAR;
    public static final TemporalField WEEK_OF_WEEK_BASED_YEAR = Field.WEEK_OF_WEEK_BASED_YEAR;

    public enum Field implements TemporalField {
        DAY_OF_QUARTER {
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r, long j) {
                long from = getFrom(r);
                range().checkValidValue(j, this);
                ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                return (R) r.with(chronoField, (j - from) + r.getLong(chronoField));
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return (long) (temporalAccessor.get(ChronoField.DAY_OF_YEAR) - Field.QUARTER_DAYS[((temporalAccessor.get(ChronoField.MONTH_OF_YEAR) - 1) / 3) + (IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? 4 : 0)]);
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR) && temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && temporalAccessor.isSupported(ChronoField.YEAR) && Field.access$100(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1, 90, 92);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    long j = temporalAccessor.getLong(Field.QUARTER_OF_YEAR);
                    if (j == 1) {
                        return IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? ValueRange.of(1, 91) : ValueRange.of(1, 90);
                    } else if (j == 2) {
                        return ValueRange.of(1, 91);
                    } else {
                        if (j == 3 || j == 4) {
                            return ValueRange.of(1, 92);
                        }
                        return range();
                    }
                } else {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
            }

            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR {
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r, long j) {
                long from = getFrom(r);
                range().checkValidValue(j, this);
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                return (R) r.with(chronoField, ((j - from) * 3) + r.getLong(chronoField));
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return (temporalAccessor.getLong(ChronoField.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && Field.access$100(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1, 4);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                return range();
            }

            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR {
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r, long j) {
                range().checkValidValue(j, this);
                return (R) r.plus(MoreExecutors.safeSubtract(j, getFrom(r)), ChronoUnit.WEEKS);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return (long) Field.access$400(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.access$100(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1, 52, 53);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return ValueRange.of(1, (long) Field.getWeekRange(Field.getWeekBasedYear(LocalDate.from(temporalAccessor))));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR {
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r, long j) {
                if (isSupportedBy(r)) {
                    int checkValidIntValue = ChronoField.YEAR.range.checkValidIntValue(j, Field.WEEK_BASED_YEAR);
                    LocalDate from = LocalDate.from(r);
                    int i = from.get(ChronoField.DAY_OF_WEEK);
                    int access$400 = Field.access$400(from);
                    if (access$400 == 53 && Field.getWeekRange(checkValidIntValue) == 52) {
                        access$400 = 52;
                    }
                    LocalDate of = LocalDate.of(checkValidIntValue, 1, 4);
                    return (R) r.with(of.plusDays((long) (((access$400 - 1) * 7) + (i - of.get(ChronoField.DAY_OF_WEEK)))));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return (long) Field.getWeekBasedYear(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.access$100(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ChronoField.YEAR.range;
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                return ChronoField.YEAR.range;
            }

            public String toString() {
                return "WeekBasedYear";
            }
        };
        
        public static final int[] QUARTER_DAYS = {0, 90, 181, 273, 0, 91, 182, 274};

        /* access modifiers changed from: public */
        Field(AnonymousClass1 r3) {
        }

        public static boolean access$100(TemporalAccessor temporalAccessor) {
            return Chronology.from(temporalAccessor).equals(IsoChronology.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0054, code lost:
            if ((r0 == -3 || (r0 == -2 && r5.isLeapYear())) == false) goto L_0x0058;
         */
        public static int access$400(LocalDate localDate) {
            int ordinal = localDate.getDayOfWeek().ordinal();
            int i = 1;
            int dayOfYear = localDate.getDayOfYear() - 1;
            int i2 = (3 - ordinal) + dayOfYear;
            int i3 = (i2 - ((i2 / 7) * 7)) - 3;
            if (i3 < -3) {
                i3 += 7;
            }
            if (dayOfYear < i3) {
                return (int) ValueRange.of(1, (long) getWeekRange(getWeekBasedYear(localDate.withDayOfYear(180).plusYears(-1)))).maxLargest;
            }
            int i4 = ((dayOfYear - i3) / 7) + 1;
            if (i4 == 53) {
            }
            i = i4;
            return i;
        }

        public static int getWeekBasedYear(LocalDate localDate) {
            int i = localDate.year;
            int dayOfYear = localDate.getDayOfYear();
            if (dayOfYear <= 3) {
                if (dayOfYear - localDate.getDayOfWeek().ordinal() < -2) {
                    return i - 1;
                }
                return i;
            } else if (dayOfYear < 363) {
                return i;
            } else {
                return ((dayOfYear - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0 ? i + 1 : i;
            }
        }

        public static int getWeekRange(int i) {
            LocalDate of = LocalDate.of(i, 1, 1);
            if (of.getDayOfWeek() != DayOfWeek.THURSDAY) {
                return (of.getDayOfWeek() != DayOfWeek.WEDNESDAY || !of.isLeapYear()) ? 52 : 53;
            }
            return 53;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }
    }

    public enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));
        
        public final String name;

        /* access modifiers changed from: public */
        Unit(String str, Duration duration) {
            this.name = str;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public <R extends Temporal> R addTo(R r, long j) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return (R) r.with(IsoFields.WEEK_BASED_YEAR, MoreExecutors.safeAdd((long) r.get(IsoFields.WEEK_BASED_YEAR), j));
            } else if (ordinal == 1) {
                return (R) r.plus(j / 256, ChronoUnit.YEARS).plus((j % 256) * 3, ChronoUnit.MONTHS);
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isDateBased() {
            return true;
        }

        public String toString() {
            return this.name;
        }
    }

    static {
        Unit unit = Unit.WEEK_BASED_YEARS;
        Unit unit2 = Unit.QUARTER_YEARS;
    }
}
