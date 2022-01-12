package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.pathcheck.covidsafepaths.BuildConfig;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.ValueRange;

public final class JapaneseChronology extends Chronology implements Serializable {
    public static final Map<String, String[]> ERA_FULL_NAMES = new HashMap();
    public static final Map<String, String[]> ERA_NARROW_NAMES = new HashMap();
    public static final Map<String, String[]> ERA_SHORT_NAMES = new HashMap();
    public static final JapaneseChronology INSTANCE = new JapaneseChronology();
    public static final Locale LOCALE = new Locale("ja", "JP", "JP");

    static {
        ERA_NARROW_NAMES.put(BuildConfig.SUPPORTED_LOCALES, new String[]{"Unknown", "K", "M", "T", "S", "H"});
        ERA_NARROW_NAMES.put("ja", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        ERA_SHORT_NAMES.put(BuildConfig.SUPPORTED_LOCALES, new String[]{"Unknown", "K", "M", "T", "S", "H"});
        ERA_SHORT_NAMES.put("ja", new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        ERA_FULL_NAMES.put(BuildConfig.SUPPORTED_LOCALES, new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        ERA_FULL_NAMES.put("ja", new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof JapaneseDate) {
            return (JapaneseDate) temporalAccessor;
        }
        return new JapaneseDate(LocalDate.from(temporalAccessor));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public Era eraOf(int i) {
        return JapaneseEra.of(i);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "japanese";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "Japanese";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: org.threeten.bp.chrono.ChronoLocalDateTime<?>, org.threeten.bp.chrono.ChronoLocalDateTime<org.threeten.bp.chrono.JapaneseDate> */
    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime<JapaneseDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    public ValueRange range(ChronoField chronoField) {
        int ordinal = chronoField.ordinal();
        if (!(ordinal == 15 || ordinal == 18 || ordinal == 20 || ordinal == 24)) {
            switch (ordinal) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    Calendar instance = Calendar.getInstance(LOCALE);
                    int ordinal2 = chronoField.ordinal();
                    int i = 0;
                    if (ordinal2 == 19) {
                        JapaneseEra[] values = JapaneseEra.values();
                        int i2 = 366;
                        while (i < values.length) {
                            i2 = Math.min(i2, ((values[i].since.isLeapYear() ? 366 : 365) - values[i].since.getDayOfYear()) + 1);
                            i++;
                        }
                        return ValueRange.of(1, (long) i2, 366);
                    } else if (ordinal2 == 23) {
                        return ValueRange.of((long) (instance.getMinimum(2) + 1), (long) (instance.getGreatestMinimum(2) + 1), (long) (instance.getLeastMaximum(2) + 1), (long) (instance.getMaximum(2) + 1));
                    } else {
                        switch (ordinal2) {
                            case 25:
                                JapaneseEra[] values2 = JapaneseEra.values();
                                int i3 = (values2[values2.length - 1].endDate().year - values2[values2.length - 1].since.year) + 1;
                                int i4 = Integer.MAX_VALUE;
                                while (i < values2.length) {
                                    i4 = Math.min(i4, (values2[i].endDate().year - values2[i].since.year) + 1);
                                    i++;
                                }
                                return ValueRange.of(1, 6, (long) i4, (long) i3);
                            case 26:
                                JapaneseEra[] values3 = JapaneseEra.values();
                                return ValueRange.of((long) JapaneseDate.MIN_DATE.year, (long) values3[values3.length - 1].endDate().year);
                            case 27:
                                JapaneseEra[] values4 = JapaneseEra.values();
                                return ValueRange.of((long) values4[0].eraValue, (long) values4[values4.length - 1].eraValue);
                            default:
                                throw new UnsupportedOperationException("Unimplementable field: " + chronoField);
                        }
                    }
            }
        }
        return chronoField.range;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<JapaneseDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofInstant(this, instant, zoneId);
    }
}
