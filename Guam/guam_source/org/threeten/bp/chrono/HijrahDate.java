package org.threeten.bp.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class HijrahDate extends ChronoDateImpl<HijrahDate> implements Serializable {
    public static final Long[] ADJUSTED_CYCLES = new Long[334];
    public static final HashMap<Integer, Integer[]> ADJUSTED_CYCLE_YEARS = new HashMap<>();
    public static final Integer[] ADJUSTED_LEAST_MAX_VALUES = new Integer[LEAST_MAX_VALUES.length];
    public static final Integer[] ADJUSTED_MAX_VALUES = new Integer[MAX_VALUES.length];
    public static final Integer[] ADJUSTED_MIN_VALUES = new Integer[MIN_VALUES.length];
    public static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_DAYS = new HashMap<>();
    public static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_LENGTHS = new HashMap<>();
    public static final int[] CYCLEYEAR_START_DATE = {0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
    public static final String DEFAULT_CONFIG_PATH;
    public static final Integer[] DEFAULT_CYCLE_YEARS = new Integer[CYCLEYEAR_START_DATE.length];
    public static final Integer[] DEFAULT_LEAP_MONTH_DAYS = new Integer[LEAP_NUM_DAYS.length];
    public static final Integer[] DEFAULT_LEAP_MONTH_LENGTHS = new Integer[LEAP_MONTH_LENGTH.length];
    public static final Integer[] DEFAULT_MONTH_DAYS = new Integer[NUM_DAYS.length];
    public static final Integer[] DEFAULT_MONTH_LENGTHS = new Integer[MONTH_LENGTH.length];
    public static final char FILE_SEP = File.separatorChar;
    public static final int[] LEAP_MONTH_LENGTH = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
    public static final int[] LEAP_NUM_DAYS = {0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};
    public static final int[] LEAST_MAX_VALUES = {1, 9999, 11, 51, 5, 29, 354};
    public static final int[] MAX_VALUES = {1, 9999, 11, 52, 6, 30, 355};
    public static final int[] MIN_VALUES = {0, 1, 0, 1, 0, 1, 1};
    public static final int[] MONTH_LENGTH = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
    public static final int[] NUM_DAYS = {0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};
    public static final String PATH_SEP = File.pathSeparator;
    public final transient int dayOfMonth;
    public final transient DayOfWeek dayOfWeek;
    public final transient int dayOfYear;
    public final transient HijrahEra era;
    public final long gregorianEpochDay;
    public final transient int monthOfYear;
    public final transient int yearOfEra;

    static {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("org");
        outline15.append(FILE_SEP);
        outline15.append("threeten");
        outline15.append(FILE_SEP);
        outline15.append("bp");
        outline15.append(FILE_SEP);
        outline15.append("chrono");
        DEFAULT_CONFIG_PATH = outline15.toString();
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = NUM_DAYS;
            if (i2 >= iArr.length) {
                break;
            }
            DEFAULT_MONTH_DAYS[i2] = Integer.valueOf(iArr[i2]);
            i2++;
        }
        int i3 = 0;
        while (true) {
            int[] iArr2 = LEAP_NUM_DAYS;
            if (i3 >= iArr2.length) {
                break;
            }
            DEFAULT_LEAP_MONTH_DAYS[i3] = Integer.valueOf(iArr2[i3]);
            i3++;
        }
        int i4 = 0;
        while (true) {
            int[] iArr3 = MONTH_LENGTH;
            if (i4 >= iArr3.length) {
                break;
            }
            DEFAULT_MONTH_LENGTHS[i4] = Integer.valueOf(iArr3[i4]);
            i4++;
        }
        int i5 = 0;
        while (true) {
            int[] iArr4 = LEAP_MONTH_LENGTH;
            if (i5 >= iArr4.length) {
                break;
            }
            DEFAULT_LEAP_MONTH_LENGTHS[i5] = Integer.valueOf(iArr4[i5]);
            i5++;
        }
        int i6 = 0;
        while (true) {
            int[] iArr5 = CYCLEYEAR_START_DATE;
            if (i6 >= iArr5.length) {
                break;
            }
            DEFAULT_CYCLE_YEARS[i6] = Integer.valueOf(iArr5[i6]);
            i6++;
        }
        int i7 = 0;
        while (true) {
            Long[] lArr = ADJUSTED_CYCLES;
            if (i7 >= lArr.length) {
                break;
            }
            lArr[i7] = Long.valueOf((long) (i7 * 10631));
            i7++;
        }
        int i8 = 0;
        while (true) {
            int[] iArr6 = MIN_VALUES;
            if (i8 >= iArr6.length) {
                break;
            }
            ADJUSTED_MIN_VALUES[i8] = Integer.valueOf(iArr6[i8]);
            i8++;
        }
        int i9 = 0;
        while (true) {
            int[] iArr7 = LEAST_MAX_VALUES;
            if (i9 >= iArr7.length) {
                break;
            }
            ADJUSTED_LEAST_MAX_VALUES[i9] = Integer.valueOf(iArr7[i9]);
            i9++;
        }
        while (true) {
            int[] iArr8 = MAX_VALUES;
            if (i < iArr8.length) {
                ADJUSTED_MAX_VALUES[i] = Integer.valueOf(iArr8[i]);
                i++;
            } else {
                try {
                    readDeviationConfig();
                    return;
                } catch (IOException | ParseException unused) {
                    return;
                }
            }
        }
    }

    public HijrahDate(long j) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Long l;
        int i7;
        long j2 = j - -492148;
        if (j2 >= 0) {
            Long[] lArr = ADJUSTED_CYCLES;
            for (int i8 = 0; i8 < lArr.length; i8++) {
                try {
                    if (j2 < lArr[i8].longValue()) {
                        i6 = i8 - 1;
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    i7 = ((int) j2) / 10631;
                }
            }
            i7 = ((int) j2) / 10631;
            i6 = i7;
            try {
                l = ADJUSTED_CYCLES[i6];
            } catch (ArrayIndexOutOfBoundsException unused2) {
                l = null;
            }
            int longValue = (int) (j2 - (l == null ? Long.valueOf((long) (i6 * 10631)) : l).longValue());
            int yearInCycle = getYearInCycle(i6, (long) longValue);
            i5 = getDayOfYear(i6, longValue, yearInCycle);
            i4 = (i6 * 30) + yearInCycle + 1;
            i3 = getMonthOfYear(i5, i4);
            i2 = getDayOfMonth(i5, i3, i4) + 1;
            i = 1;
        } else {
            int i9 = (int) j2;
            int i10 = i9 / 10631;
            int i11 = i9 % 10631;
            if (i11 == 0) {
                i11 = -10631;
                i10++;
            }
            int yearInCycle2 = getYearInCycle(i10, (long) i11);
            int dayOfYear2 = getDayOfYear(i10, i11, yearInCycle2);
            i4 = 1 - ((i10 * 30) - yearInCycle2);
            i5 = isLeapYear((long) i4) ? dayOfYear2 + 355 : dayOfYear2 + 354;
            i3 = getMonthOfYear(i5, i4);
            i2 = getDayOfMonth(i5, i3, i4) + 1;
            i = 0;
        }
        int i12 = (int) ((j2 + 5) % 7);
        int[] iArr = {i, i4, i3 + 1, i2, i5 + 1, i12 + (i12 <= 0 ? 7 : 0)};
        int i13 = iArr[1];
        if (i13 < 1 || i13 > 9999) {
            throw new DateTimeException("Invalid year of Hijrah Era");
        }
        int i14 = iArr[2];
        if (i14 < 1 || i14 > 12) {
            throw new DateTimeException("Invalid month of Hijrah date");
        }
        checkValidDayOfMonth(iArr[3]);
        int i15 = iArr[4];
        if (i15 < 1 || i15 > ADJUSTED_MAX_VALUES[6].intValue()) {
            throw new DateTimeException("Invalid day of year of Hijrah date");
        }
        this.era = HijrahEra.of(iArr[0]);
        this.yearOfEra = iArr[1];
        this.monthOfYear = iArr[2];
        this.dayOfMonth = iArr[3];
        this.dayOfYear = iArr[4];
        this.dayOfWeek = DayOfWeek.of(iArr[5]);
        this.gregorianEpochDay = j;
        isLeapYear((long) this.yearOfEra);
    }

    public static void checkValidDayOfMonth(int i) {
        if (i < 1 || i > ADJUSTED_MAX_VALUES[5].intValue()) {
            StringBuilder outline16 = GeneratedOutlineSupport.outline16("Invalid day of month of Hijrah date, day ", i, " greater than ");
            outline16.append(ADJUSTED_MAX_VALUES[5].intValue());
            outline16.append(" or less than 1");
            throw new DateTimeException(outline16.toString());
        }
    }

    public static Integer[] getAdjustedCycle(int i) {
        Integer[] numArr;
        try {
            numArr = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? DEFAULT_CYCLE_YEARS : numArr;
    }

    public static Integer[] getAdjustedMonthDays(int i) {
        Integer[] numArr;
        try {
            numArr = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(i));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        if (numArr != null) {
            return numArr;
        }
        if (isLeapYear((long) i)) {
            return DEFAULT_LEAP_MONTH_DAYS;
        }
        return DEFAULT_MONTH_DAYS;
    }

    public static int getDayOfMonth(int i, int i2, int i3) {
        int intValue;
        Integer[] adjustedMonthDays = getAdjustedMonthDays(i3);
        if (i < 0) {
            i = isLeapYear((long) i3) ? i + 355 : i + 354;
            if (i2 <= 0) {
                return i;
            }
            intValue = adjustedMonthDays[i2].intValue();
        } else if (i2 <= 0) {
            return i;
        } else {
            intValue = adjustedMonthDays[i2].intValue();
        }
        return i - intValue;
    }

    public static int getDayOfYear(int i, int i2, int i3) {
        Integer[] adjustedCycle = getAdjustedCycle(i);
        if (i2 > 0) {
            return i2 - adjustedCycle[i3].intValue();
        }
        return adjustedCycle[i3].intValue() + i2;
    }

    public static long getGregorianEpochDay(int i, int i2, int i3) {
        Long l;
        int i4 = i - 1;
        int i5 = i4 / 30;
        int i6 = i4 % 30;
        int intValue = getAdjustedCycle(i5)[Math.abs(i6)].intValue();
        if (i6 < 0) {
            intValue = -intValue;
        }
        try {
            l = ADJUSTED_CYCLES[i5];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l = null;
        }
        if (l == null) {
            l = Long.valueOf((long) (i5 * 10631));
        }
        return (((l.longValue() + ((long) intValue)) - 492148) - 1) + ((long) getAdjustedMonthDays(i)[i2 - 1].intValue()) + ((long) i3);
    }

    public static int getMonthOfYear(int i, int i2) {
        Integer[] adjustedMonthDays = getAdjustedMonthDays(i2);
        int i3 = 0;
        if (i >= 0) {
            while (i3 < adjustedMonthDays.length) {
                if (i < adjustedMonthDays[i3].intValue()) {
                    return i3 - 1;
                }
                i3++;
            }
            return 11;
        }
        int i4 = isLeapYear((long) i2) ? i + 355 : i + 354;
        while (i3 < adjustedMonthDays.length) {
            if (i4 < adjustedMonthDays[i3].intValue()) {
                return i3 - 1;
            }
            i3++;
        }
        return 11;
    }

    public static int getYearInCycle(int i, long j) {
        Integer[] adjustedCycle = getAdjustedCycle(i);
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i2 > 0) {
            while (i3 < adjustedCycle.length) {
                if (j < ((long) adjustedCycle[i3].intValue())) {
                    return i3 - 1;
                }
                i3++;
            }
            return 29;
        }
        long j2 = -j;
        while (i3 < adjustedCycle.length) {
            if (j2 <= ((long) adjustedCycle[i3].intValue())) {
                return i3 - 1;
            }
            i3++;
        }
        return 29;
    }

    public static boolean isLeapYear(long j) {
        if (j <= 0) {
            j = -j;
        }
        return ((j * 11) + 14) % 30 < 11;
    }

    public static HijrahDate of(int i, int i2, int i3) {
        if (i >= 1) {
            return of(HijrahEra.AH, i, i2, i3);
        }
        return of(HijrahEra.BEFORE_AH, 1 - i, i2, i3);
    }

    public static void parseLine(String str, int i) throws ParseException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(58);
            if (indexOf != -1) {
                try {
                    int parseInt = Integer.parseInt(nextToken.substring(indexOf + 1, nextToken.length()));
                    int indexOf2 = nextToken.indexOf(45);
                    if (indexOf2 != -1) {
                        String substring = nextToken.substring(0, indexOf2);
                        String substring2 = nextToken.substring(indexOf2 + 1, indexOf);
                        int indexOf3 = substring.indexOf(47);
                        int indexOf4 = substring2.indexOf(47);
                        if (indexOf3 != -1) {
                            String substring3 = substring.substring(0, indexOf3);
                            String substring4 = substring.substring(indexOf3 + 1, substring.length());
                            try {
                                int parseInt2 = Integer.parseInt(substring3);
                                try {
                                    int parseInt3 = Integer.parseInt(substring4);
                                    if (indexOf4 != -1) {
                                        String substring5 = substring2.substring(0, indexOf4);
                                        String substring6 = substring2.substring(indexOf4 + 1, substring2.length());
                                        try {
                                            int parseInt4 = Integer.parseInt(substring5);
                                            try {
                                                int parseInt5 = Integer.parseInt(substring6);
                                                if (parseInt2 == -1 || parseInt3 == -1 || parseInt4 == -1 || parseInt5 == -1) {
                                                    throw new ParseException(GeneratedOutlineSupport.outline5("Unknown error at line ", i, "."), i);
                                                } else if (parseInt2 < 1) {
                                                    throw new IllegalArgumentException("startYear < 1");
                                                } else if (parseInt4 < 1) {
                                                    throw new IllegalArgumentException("endYear < 1");
                                                } else if (parseInt3 < 0 || parseInt3 > 11) {
                                                    throw new IllegalArgumentException("startMonth < 0 || startMonth > 11");
                                                } else if (parseInt5 < 0 || parseInt5 > 11) {
                                                    throw new IllegalArgumentException("endMonth < 0 || endMonth > 11");
                                                } else if (parseInt4 > 9999) {
                                                    throw new IllegalArgumentException("endYear > 9999");
                                                } else if (parseInt4 < parseInt2) {
                                                    throw new IllegalArgumentException("startYear > endYear");
                                                } else if (parseInt4 != parseInt2 || parseInt5 >= parseInt3) {
                                                    boolean isLeapYear = isLeapYear((long) parseInt2);
                                                    Integer[] numArr = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(parseInt2));
                                                    if (numArr == null) {
                                                        if (!isLeapYear) {
                                                            numArr = new Integer[NUM_DAYS.length];
                                                            int i2 = 0;
                                                            while (true) {
                                                                int[] iArr = NUM_DAYS;
                                                                if (i2 >= iArr.length) {
                                                                    break;
                                                                }
                                                                numArr[i2] = Integer.valueOf(iArr[i2]);
                                                                i2++;
                                                            }
                                                        } else {
                                                            numArr = new Integer[LEAP_NUM_DAYS.length];
                                                            int i3 = 0;
                                                            while (true) {
                                                                int[] iArr2 = LEAP_NUM_DAYS;
                                                                if (i3 >= iArr2.length) {
                                                                    break;
                                                                }
                                                                numArr[i3] = Integer.valueOf(iArr2[i3]);
                                                                i3++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr2 = new Integer[numArr.length];
                                                    for (int i4 = 0; i4 < 12; i4++) {
                                                        if (i4 > parseInt3) {
                                                            numArr2[i4] = Integer.valueOf(numArr[i4].intValue() - parseInt);
                                                        } else {
                                                            numArr2[i4] = Integer.valueOf(numArr[i4].intValue());
                                                        }
                                                    }
                                                    ADJUSTED_MONTH_DAYS.put(Integer.valueOf(parseInt2), numArr2);
                                                    Integer[] numArr3 = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(parseInt2));
                                                    if (numArr3 == null) {
                                                        if (!isLeapYear) {
                                                            numArr3 = new Integer[MONTH_LENGTH.length];
                                                            int i5 = 0;
                                                            while (true) {
                                                                int[] iArr3 = MONTH_LENGTH;
                                                                if (i5 >= iArr3.length) {
                                                                    break;
                                                                }
                                                                numArr3[i5] = Integer.valueOf(iArr3[i5]);
                                                                i5++;
                                                            }
                                                        } else {
                                                            numArr3 = new Integer[LEAP_MONTH_LENGTH.length];
                                                            int i6 = 0;
                                                            while (true) {
                                                                int[] iArr4 = LEAP_MONTH_LENGTH;
                                                                if (i6 >= iArr4.length) {
                                                                    break;
                                                                }
                                                                numArr3[i6] = Integer.valueOf(iArr4[i6]);
                                                                i6++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr4 = new Integer[numArr3.length];
                                                    for (int i7 = 0; i7 < 12; i7++) {
                                                        if (i7 == parseInt3) {
                                                            numArr4[i7] = Integer.valueOf(numArr3[i7].intValue() - parseInt);
                                                        } else {
                                                            numArr4[i7] = Integer.valueOf(numArr3[i7].intValue());
                                                        }
                                                    }
                                                    ADJUSTED_MONTH_LENGTHS.put(Integer.valueOf(parseInt2), numArr4);
                                                    if (parseInt2 != parseInt4) {
                                                        int i8 = parseInt2 - 1;
                                                        int i9 = i8 / 30;
                                                        int i10 = i8 % 30;
                                                        Integer[] numArr5 = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i9));
                                                        if (numArr5 == null) {
                                                            int length = CYCLEYEAR_START_DATE.length;
                                                            Integer[] numArr6 = new Integer[length];
                                                            for (int i11 = 0; i11 < length; i11++) {
                                                                numArr6[i11] = Integer.valueOf(CYCLEYEAR_START_DATE[i11]);
                                                            }
                                                            numArr5 = numArr6;
                                                        }
                                                        for (int i12 = i10 + 1; i12 < CYCLEYEAR_START_DATE.length; i12++) {
                                                            numArr5[i12] = Integer.valueOf(numArr5[i12].intValue() - parseInt);
                                                        }
                                                        ADJUSTED_CYCLE_YEARS.put(Integer.valueOf(i9), numArr5);
                                                        int i13 = parseInt4 - 1;
                                                        int i14 = i13 / 30;
                                                        if (i9 != i14) {
                                                            while (true) {
                                                                i9++;
                                                                Long[] lArr = ADJUSTED_CYCLES;
                                                                if (i9 >= lArr.length) {
                                                                    break;
                                                                }
                                                                lArr[i9] = Long.valueOf(lArr[i9].longValue() - ((long) parseInt));
                                                            }
                                                            int i15 = i14 + 1;
                                                            while (true) {
                                                                Long[] lArr2 = ADJUSTED_CYCLES;
                                                                if (i15 >= lArr2.length) {
                                                                    break;
                                                                }
                                                                lArr2[i15] = Long.valueOf(lArr2[i15].longValue() + ((long) parseInt));
                                                                i15++;
                                                            }
                                                        }
                                                        int i16 = i13 % 30;
                                                        Integer[] numArr7 = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i14));
                                                        if (numArr7 == null) {
                                                            int length2 = CYCLEYEAR_START_DATE.length;
                                                            Integer[] numArr8 = new Integer[length2];
                                                            for (int i17 = 0; i17 < length2; i17++) {
                                                                numArr8[i17] = Integer.valueOf(CYCLEYEAR_START_DATE[i17]);
                                                            }
                                                            numArr7 = numArr8;
                                                        }
                                                        while (true) {
                                                            i16++;
                                                            if (i16 >= CYCLEYEAR_START_DATE.length) {
                                                                break;
                                                            }
                                                            numArr7[i16] = Integer.valueOf(numArr7[i16].intValue() + parseInt);
                                                        }
                                                        ADJUSTED_CYCLE_YEARS.put(Integer.valueOf(i14), numArr7);
                                                    }
                                                    boolean isLeapYear2 = isLeapYear((long) parseInt4);
                                                    Integer[] numArr9 = ADJUSTED_MONTH_DAYS.get(Integer.valueOf(parseInt4));
                                                    if (numArr9 == null) {
                                                        if (!isLeapYear2) {
                                                            numArr9 = new Integer[NUM_DAYS.length];
                                                            int i18 = 0;
                                                            while (true) {
                                                                int[] iArr5 = NUM_DAYS;
                                                                if (i18 >= iArr5.length) {
                                                                    break;
                                                                }
                                                                numArr9[i18] = Integer.valueOf(iArr5[i18]);
                                                                i18++;
                                                            }
                                                        } else {
                                                            numArr9 = new Integer[LEAP_NUM_DAYS.length];
                                                            int i19 = 0;
                                                            while (true) {
                                                                int[] iArr6 = LEAP_NUM_DAYS;
                                                                if (i19 >= iArr6.length) {
                                                                    break;
                                                                }
                                                                numArr9[i19] = Integer.valueOf(iArr6[i19]);
                                                                i19++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr10 = new Integer[numArr9.length];
                                                    for (int i20 = 0; i20 < 12; i20++) {
                                                        if (i20 > parseInt5) {
                                                            numArr10[i20] = Integer.valueOf(numArr9[i20].intValue() + parseInt);
                                                        } else {
                                                            numArr10[i20] = Integer.valueOf(numArr9[i20].intValue());
                                                        }
                                                    }
                                                    ADJUSTED_MONTH_DAYS.put(Integer.valueOf(parseInt4), numArr10);
                                                    Integer[] numArr11 = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(parseInt4));
                                                    if (numArr11 == null) {
                                                        if (!isLeapYear2) {
                                                            numArr11 = new Integer[MONTH_LENGTH.length];
                                                            int i21 = 0;
                                                            while (true) {
                                                                int[] iArr7 = MONTH_LENGTH;
                                                                if (i21 >= iArr7.length) {
                                                                    break;
                                                                }
                                                                numArr11[i21] = Integer.valueOf(iArr7[i21]);
                                                                i21++;
                                                            }
                                                        } else {
                                                            numArr11 = new Integer[LEAP_MONTH_LENGTH.length];
                                                            int i22 = 0;
                                                            while (true) {
                                                                int[] iArr8 = LEAP_MONTH_LENGTH;
                                                                if (i22 >= iArr8.length) {
                                                                    break;
                                                                }
                                                                numArr11[i22] = Integer.valueOf(iArr8[i22]);
                                                                i22++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr12 = new Integer[numArr11.length];
                                                    for (int i23 = 0; i23 < 12; i23++) {
                                                        if (i23 == parseInt5) {
                                                            numArr12[i23] = Integer.valueOf(numArr11[i23].intValue() + parseInt);
                                                        } else {
                                                            numArr12[i23] = Integer.valueOf(numArr11[i23].intValue());
                                                        }
                                                    }
                                                    ADJUSTED_MONTH_LENGTHS.put(Integer.valueOf(parseInt4), numArr12);
                                                    Integer[] numArr13 = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(parseInt2));
                                                    Integer[] numArr14 = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(parseInt4));
                                                    int intValue = numArr13[parseInt3].intValue();
                                                    int intValue2 = numArr14[parseInt5].intValue();
                                                    int intValue3 = numArr13[11].intValue() + ADJUSTED_MONTH_DAYS.get(Integer.valueOf(parseInt2))[11].intValue();
                                                    int intValue4 = numArr14[11].intValue() + ADJUSTED_MONTH_DAYS.get(Integer.valueOf(parseInt4))[11].intValue();
                                                    int intValue5 = ADJUSTED_MAX_VALUES[5].intValue();
                                                    int intValue6 = ADJUSTED_LEAST_MAX_VALUES[5].intValue();
                                                    if (intValue5 < intValue) {
                                                        intValue5 = intValue;
                                                    }
                                                    if (intValue5 < intValue2) {
                                                        intValue5 = intValue2;
                                                    }
                                                    ADJUSTED_MAX_VALUES[5] = Integer.valueOf(intValue5);
                                                    if (intValue6 <= intValue) {
                                                        intValue = intValue6;
                                                    }
                                                    if (intValue <= intValue2) {
                                                        intValue2 = intValue;
                                                    }
                                                    ADJUSTED_LEAST_MAX_VALUES[5] = Integer.valueOf(intValue2);
                                                    int intValue7 = ADJUSTED_MAX_VALUES[6].intValue();
                                                    int intValue8 = ADJUSTED_LEAST_MAX_VALUES[6].intValue();
                                                    if (intValue7 < intValue3) {
                                                        intValue7 = intValue3;
                                                    }
                                                    if (intValue7 < intValue4) {
                                                        intValue7 = intValue4;
                                                    }
                                                    ADJUSTED_MAX_VALUES[6] = Integer.valueOf(intValue7);
                                                    if (intValue8 <= intValue3) {
                                                        intValue3 = intValue8;
                                                    }
                                                    if (intValue3 <= intValue4) {
                                                        intValue4 = intValue3;
                                                    }
                                                    ADJUSTED_LEAST_MAX_VALUES[6] = Integer.valueOf(intValue4);
                                                } else {
                                                    throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
                                                }
                                            } catch (NumberFormatException unused) {
                                                throw new ParseException(GeneratedOutlineSupport.outline5("End month is not properly set at line ", i, "."), i);
                                            }
                                        } catch (NumberFormatException unused2) {
                                            throw new ParseException(GeneratedOutlineSupport.outline5("End year is not properly set at line ", i, "."), i);
                                        }
                                    } else {
                                        throw new ParseException(GeneratedOutlineSupport.outline5("End year/month has incorrect format at line ", i, "."), i);
                                    }
                                } catch (NumberFormatException unused3) {
                                    throw new ParseException(GeneratedOutlineSupport.outline5("Start month is not properly set at line ", i, "."), i);
                                }
                            } catch (NumberFormatException unused4) {
                                throw new ParseException(GeneratedOutlineSupport.outline5("Start year is not properly set at line ", i, "."), i);
                            }
                        } else {
                            throw new ParseException(GeneratedOutlineSupport.outline5("Start year/month has incorrect format at line ", i, "."), i);
                        }
                    } else {
                        throw new ParseException(GeneratedOutlineSupport.outline5("Start and end year/month has incorrect format at line ", i, "."), i);
                    }
                } catch (NumberFormatException unused5) {
                    throw new ParseException(GeneratedOutlineSupport.outline5("Offset is not properly set at line ", i, "."), i);
                }
            } else {
                throw new ParseException(GeneratedOutlineSupport.outline5("Offset has incorrect format at line ", i, "."), i);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x010c A[SYNTHETIC, Splitter:B:50:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public static void readDeviationConfig() throws IOException, ParseException {
        InputStream inputStream;
        Throwable th;
        ZipFile zipFile;
        String property = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (property == null) {
            property = "hijrah_deviation.cfg";
        }
        String property2 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        BufferedReader bufferedReader = null;
        if (property2 == null) {
            StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.class.path"), PATH_SEP);
            while (true) {
                if (!stringTokenizer.hasMoreTokens()) {
                    break;
                }
                String nextToken = stringTokenizer.nextToken();
                File file = new File(nextToken);
                if (file.exists()) {
                    if (file.isDirectory()) {
                        StringBuilder outline15 = GeneratedOutlineSupport.outline15(nextToken);
                        outline15.append(FILE_SEP);
                        outline15.append(DEFAULT_CONFIG_PATH);
                        if (new File(outline15.toString(), property).exists()) {
                            try {
                                inputStream = new FileInputStream(nextToken + FILE_SEP + DEFAULT_CONFIG_PATH + FILE_SEP + property);
                                break;
                            } catch (IOException e) {
                                throw e;
                            }
                        }
                    } else {
                        try {
                            zipFile = new ZipFile(file);
                        } catch (IOException unused) {
                            zipFile = null;
                        }
                        if (zipFile != null) {
                            String str = DEFAULT_CONFIG_PATH + FILE_SEP + property;
                            ZipEntry entry = zipFile.getEntry(str);
                            if (entry == null) {
                                char c = FILE_SEP;
                                if (c == '/') {
                                    str = str.replace('/', '\\');
                                } else if (c == '\\') {
                                    str = str.replace('\\', '/');
                                }
                                entry = zipFile.getEntry(str);
                            }
                            if (entry != null) {
                                try {
                                    inputStream = zipFile.getInputStream(entry);
                                    break;
                                } catch (IOException e2) {
                                    throw e2;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } else {
            if (property2.length() != 0 || !property2.endsWith(System.getProperty("file.separator"))) {
                StringBuilder outline152 = GeneratedOutlineSupport.outline15(property2);
                outline152.append(System.getProperty("file.separator"));
                property2 = outline152.toString();
            }
            StringBuilder outline153 = GeneratedOutlineSupport.outline15(property2);
            outline153.append(FILE_SEP);
            outline153.append(property);
            File file2 = new File(outline153.toString());
            if (file2.exists()) {
                try {
                    inputStream = new FileInputStream(file2);
                    if (inputStream == null) {
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                            int i = 0;
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine != null) {
                                        i++;
                                        parseLine(readLine.trim(), i);
                                    } else {
                                        bufferedReader2.close();
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader = bufferedReader2;
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedReader != null) {
                            }
                            throw th;
                        }
                    } else {
                        return;
                    }
                } catch (IOException e3) {
                    throw e3;
                }
            }
        }
        inputStream = null;
        if (inputStream == null) {
        }
    }

    public static ChronoLocalDate readExternal(DataInput dataInput) throws IOException {
        int readInt = dataInput.readInt();
        byte readByte = dataInput.readByte();
        byte readByte2 = dataInput.readByte();
        HijrahChronology hijrahChronology = HijrahChronology.INSTANCE;
        return of(readInt, readByte, readByte2);
    }

    private Object readResolve() {
        return new HijrahDate(this.gregorianEpochDay);
    }

    public static HijrahDate resolvePreviousValid(int i, int i2, int i3) {
        int intValue = getAdjustedMonthDays(i)[i2 - 1].intValue();
        if (i3 > intValue) {
            i3 = intValue;
        }
        return of(i, i2, i3);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl
    public final ChronoLocalDateTime<HijrahDate> atTime(LocalTime localTime) {
        return new ChronoLocalDateTimeImpl(this, localTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Chronology getChronology() {
        return HijrahChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Era getEra() {
        return this.era;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i;
        int i2;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        switch (((ChronoField) temporalField).ordinal()) {
            case 15:
                i = this.dayOfWeek.getValue();
                break;
            case 16:
                i2 = (this.dayOfMonth - 1) % 7;
                i = i2 + 1;
                break;
            case 17:
                i2 = (this.dayOfYear - 1) % 7;
                i = i2 + 1;
                break;
            case 18:
                i = this.dayOfMonth;
                break;
            case 19:
                i = this.dayOfYear;
                break;
            case 20:
                return toEpochDay();
            case 21:
                i2 = (this.dayOfMonth - 1) / 7;
                i = i2 + 1;
                break;
            case 22:
                i2 = (this.dayOfYear - 1) / 7;
                i = i2 + 1;
                break;
            case 23:
                i = this.monthOfYear;
                break;
            case 24:
            default:
                throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Unsupported field: ", temporalField));
            case 25:
                i = this.yearOfEra;
                break;
            case 26:
                i = this.yearOfEra;
                break;
            case 27:
                return (long) this.era.ordinal();
        }
        return (long) i;
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDate minus(long j, TemporalUnit temporalUnit) {
        return (HijrahDate) super.minus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<HijrahDate> plus(long j, TemporalUnit temporalUnit) {
        return (HijrahDate) super.plus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<HijrahDate> plusDays(long j) {
        return new HijrahDate(this.gregorianEpochDay + j);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<HijrahDate> plusMonths(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.monthOfYear - 1) + ((int) j);
        int i2 = i / 12;
        int i3 = i % 12;
        while (i3 < 0) {
            i3 += 12;
            int i4 = i2 - 1;
            if ((i2 ^ i4) >= 0 || (i2 ^ 1) >= 0) {
                i2 = i4;
            } else {
                throw new ArithmeticException("Subtraction overflows an int: " + i2 + " - " + 1);
            }
        }
        return of(this.era, PathParser.safeAdd(this.yearOfEra, i2), i3 + 1, this.dayOfMonth);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<HijrahDate> plusYears(long j) {
        if (j == 0) {
            return this;
        }
        return of(this.era, PathParser.safeAdd(this.yearOfEra, (int) j), this.monthOfYear, this.dayOfMonth);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        int i;
        int i2;
        int i3;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (isSupported(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int ordinal = chronoField.ordinal();
            Integer[] numArr = null;
            if (ordinal == 18) {
                int i4 = this.monthOfYear - 1;
                int i5 = this.yearOfEra;
                try {
                    numArr = ADJUSTED_MONTH_LENGTHS.get(Integer.valueOf(i5));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                if (numArr == null) {
                    if (isLeapYear((long) i5)) {
                        numArr = DEFAULT_LEAP_MONTH_LENGTHS;
                    } else {
                        numArr = DEFAULT_MONTH_LENGTHS;
                    }
                }
                return ValueRange.of(1, (long) numArr[i4].intValue());
            } else if (ordinal == 19) {
                int i6 = this.yearOfEra;
                int i7 = i6 - 1;
                int i8 = i7 / 30;
                try {
                    numArr = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(i8));
                } catch (ArrayIndexOutOfBoundsException unused2) {
                }
                if (numArr != null) {
                    int i9 = i7 % 30;
                    if (i9 == 29) {
                        i2 = ADJUSTED_CYCLES[i8 + 1].intValue() - ADJUSTED_CYCLES[i8].intValue();
                        i3 = numArr[i9].intValue();
                    } else {
                        i2 = numArr[i9 + 1].intValue();
                        i3 = numArr[i9].intValue();
                    }
                    i = i2 - i3;
                } else {
                    i = isLeapYear((long) i6) ? 355 : 354;
                }
                return ValueRange.of(1, (long) i);
            } else if (ordinal == 21) {
                return ValueRange.of(1, 5);
            } else {
                if (ordinal == 25) {
                    return ValueRange.of(1, 1000);
                }
                HijrahChronology hijrahChronology = HijrahChronology.INSTANCE;
                return chronoField.range;
            }
        } else {
            throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Unsupported field: ", temporalField));
        }
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        return getGregorianEpochDay(this.yearOfEra, this.monthOfYear, this.dayOfMonth);
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    /* renamed from: minus  reason: collision with other method in class */
    public Temporal m13minus(long j, TemporalUnit temporalUnit) {
        return (HijrahDate) super.minus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoLocalDate' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    /* renamed from: plus  reason: collision with other method in class */
    public ChronoDateImpl<HijrahDate> m14plus(long j, TemporalUnit temporalUnit) {
        return (HijrahDate) super.plus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.HijrahDate' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* renamed from: plusDays  reason: collision with other method in class */
    public ChronoDateImpl<HijrahDate> m16plusDays(long j) {
        return new HijrahDate(this.gregorianEpochDay + j);
    }

    public static HijrahDate of(HijrahEra hijrahEra, int i, int i2, int i3) {
        PathParser.requireNonNull(hijrahEra, "era");
        if (i < 1 || i > 9999) {
            throw new DateTimeException("Invalid year of Hijrah Era");
        } else if (i2 < 1 || i2 > 12) {
            throw new DateTimeException("Invalid month of Hijrah date");
        } else {
            checkValidDayOfMonth(i3);
            if (hijrahEra != HijrahEra.AH) {
                i = 1 - i;
            }
            return new HijrahDate(getGregorianEpochDay(i, i2, i3));
        }
    }

    /* Return type fixed from 'org.threeten.bp.temporal.Temporal' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    /* renamed from: plus  reason: collision with other method in class */
    public ChronoDateImpl<HijrahDate> m15plus(long j, TemporalUnit temporalUnit) {
        return (HijrahDate) super.plus(j, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return (HijrahDate) HijrahChronology.INSTANCE.ensureChronoLocalDate(temporalAdjuster.adjustInto(this));
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    /* renamed from: with  reason: collision with other method in class */
    public Temporal m17with(TemporalAdjuster temporalAdjuster) {
        return (HijrahDate) HijrahChronology.INSTANCE.ensureChronoLocalDate(((LocalDate) temporalAdjuster).adjustInto(this));
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [org.threeten.bp.chrono.HijrahDate] */
    /* JADX WARN: Type inference failed for: r6v7, types: [org.threeten.bp.chrono.HijrahDate] */
    /* JADX WARN: Type inference failed for: r6v9, types: [org.threeten.bp.chrono.HijrahDate] */
    /* JADX WARN: Type inference failed for: r6v16, types: [org.threeten.bp.chrono.HijrahDate] */
    /* JADX WARN: Type inference failed for: r6v18, types: [org.threeten.bp.chrono.HijrahDate] */
    /* JADX WARNING: Unknown variable types count: 5 */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public HijrahDate with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (HijrahDate) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.range.checkValidValue(j, chronoField);
        int i = (int) j;
        switch (chronoField.ordinal()) {
            case 15:
                return m16plusDays(j - ((long) this.dayOfWeek.getValue()));
            case 16:
                return m16plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 17:
                return m16plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 18:
                return resolvePreviousValid(this.yearOfEra, this.monthOfYear, i);
            case 19:
                int i2 = i - 1;
                return resolvePreviousValid(this.yearOfEra, (i2 / 30) + 1, (i2 % 30) + 1);
            case 20:
                return new HijrahDate((long) i);
            case 21:
                return m16plusDays((j - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 22:
                return m16plusDays((j - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 23:
                return resolvePreviousValid(this.yearOfEra, i, this.dayOfMonth);
            case 24:
            default:
                throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Unsupported field: ", temporalField));
            case 25:
                if (this.yearOfEra < 1) {
                    i = 1 - i;
                }
                return resolvePreviousValid(i, this.monthOfYear, this.dayOfMonth);
            case 26:
                return resolvePreviousValid(i, this.monthOfYear, this.dayOfMonth);
            case 27:
                return resolvePreviousValid(1 - this.yearOfEra, this.monthOfYear, this.dayOfMonth);
        }
    }
}
