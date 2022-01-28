package org.threeten.bp.format;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.modules.network.NetworkingModule;
import com.horcrux.svg.PathParser;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.SimpleDateTimeTextProvider;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;

public final class DateTimeFormatterBuilder {
    public static final Map<Character, TemporalField> FIELD_MAP;
    public static final TemporalQuery<ZoneId> QUERY_REGION_ONLY = new TemporalQuery<ZoneId>() {
        /* class org.threeten.bp.format.DateTimeFormatterBuilder.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.ZONE_ID);
            if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                return null;
            }
            return zoneId;
        }
    };
    public DateTimeFormatterBuilder active;
    public final boolean optional;
    public char padNextChar;
    public int padNextWidth;
    public final DateTimeFormatterBuilder parent;
    public final List<DateTimePrinterParser> printerParsers;
    public int valueParserIndex;

    public static final class CharLiteralPrinterParser implements DateTimePrinterParser {
        public final char literal;

        public CharLiteralPrinterParser(char c) {
            this.literal = c;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.literal);
            return true;
        }

        public String toString() {
            if (this.literal == '\'') {
                return "''";
            }
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("'");
            outline15.append(this.literal);
            outline15.append("'");
            return outline15.toString();
        }
    }

    public interface DateTimePrinterParser {
        boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb);
    }

    public static final class FractionPrinterParser implements DateTimePrinterParser {
        public final boolean decimalPoint;
        public final TemporalField field;
        public final int maxWidth;
        public final int minWidth;

        public FractionPrinterParser(TemporalField temporalField, int i, int i2, boolean z) {
            PathParser.requireNonNull(temporalField, "field");
            ValueRange range = temporalField.range();
            if (!(range.minSmallest == range.minLargest && range.maxSmallest == range.maxLargest)) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline10("Field must have a fixed set of values: ", temporalField));
            } else if (i < 0 || i > 9) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline4("Minimum width must be from 0 to 9 inclusive but was ", i));
            } else if (i2 < 1 || i2 > 9) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline4("Maximum width must be from 1 to 9 inclusive but was ", i2));
            } else if (i2 >= i) {
                this.field = temporalField;
                this.minWidth = i;
                this.maxWidth = i2;
                this.decimalPoint = z;
            } else {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
            }
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            DecimalStyle decimalStyle = dateTimePrintContext.symbols;
            long longValue = value.longValue();
            ValueRange range = this.field.range();
            range.checkValidValue(longValue, this.field);
            BigDecimal valueOf = BigDecimal.valueOf(range.minSmallest);
            BigDecimal divide = BigDecimal.valueOf(longValue).subtract(valueOf).divide(BigDecimal.valueOf(range.maxLargest).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal stripTrailingZeros = divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
            if (stripTrailingZeros.scale() != 0) {
                String convertNumberToI18N = decimalStyle.convertNumberToI18N(stripTrailingZeros.setScale(Math.min(Math.max(stripTrailingZeros.scale(), this.minWidth), this.maxWidth), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.decimalPoint) {
                    sb.append(decimalStyle.decimalSeparator);
                }
                sb.append(convertNumberToI18N);
                return true;
            } else if (this.minWidth <= 0) {
                return true;
            } else {
                if (this.decimalPoint) {
                    sb.append(decimalStyle.decimalSeparator);
                }
                for (int i = 0; i < this.minWidth; i++) {
                    sb.append(decimalStyle.zeroDigit);
                }
                return true;
            }
        }

        public String toString() {
            String str = this.decimalPoint ? ",DecimalPoint" : "";
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Fraction(");
            outline15.append(this.field);
            outline15.append(",");
            outline15.append(this.minWidth);
            outline15.append(",");
            outline15.append(this.maxWidth);
            outline15.append(str);
            outline15.append(")");
            return outline15.toString();
        }
    }

    public static final class InstantPrinterParser implements DateTimePrinterParser {
        public final int fractionalDigits;

        public InstantPrinterParser(int i) {
            this.fractionalDigits = i;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(ChronoField.INSTANT_SECONDS);
            Long l = 0L;
            if (dateTimePrintContext.temporal.isSupported(ChronoField.NANO_OF_SECOND)) {
                l = Long.valueOf(dateTimePrintContext.temporal.getLong(ChronoField.NANO_OF_SECOND));
            }
            int i = 0;
            if (value == null) {
                return false;
            }
            long longValue = value.longValue();
            int checkValidIntValue = ChronoField.NANO_OF_SECOND.checkValidIntValue(l.longValue());
            if (longValue >= -62167219200L) {
                long j = (longValue - 315569520000L) + 62167219200L;
                long floorDiv = PathParser.floorDiv(j, 315569520000L) + 1;
                LocalDateTime ofEpochSecond = LocalDateTime.ofEpochSecond(PathParser.floorMod(j, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                if (floorDiv > 0) {
                    sb.append('+');
                    sb.append(floorDiv);
                }
                sb.append(ofEpochSecond);
                if (ofEpochSecond.time.second == 0) {
                    sb.append(":00");
                }
            } else {
                long j2 = longValue + 62167219200L;
                long j3 = j2 / 315569520000L;
                long j4 = j2 % 315569520000L;
                LocalDateTime ofEpochSecond2 = LocalDateTime.ofEpochSecond(j4 - 62167219200L, 0, ZoneOffset.UTC);
                int length = sb.length();
                sb.append(ofEpochSecond2);
                if (ofEpochSecond2.time.second == 0) {
                    sb.append(":00");
                }
                if (j3 < 0) {
                    if (ofEpochSecond2.date.year == -10000) {
                        sb.replace(length, length + 2, Long.toString(j3 - 1));
                    } else if (j4 == 0) {
                        sb.insert(length, j3);
                    } else {
                        sb.insert(length + 1, Math.abs(j3));
                    }
                }
            }
            int i2 = this.fractionalDigits;
            if (i2 == -2) {
                if (checkValidIntValue != 0) {
                    sb.append('.');
                    if (checkValidIntValue % 1000000 == 0) {
                        sb.append(Integer.toString((checkValidIntValue / 1000000) + 1000).substring(1));
                    } else if (checkValidIntValue % 1000 == 0) {
                        sb.append(Integer.toString((checkValidIntValue / 1000) + 1000000).substring(1));
                    } else {
                        sb.append(Integer.toString(checkValidIntValue + 1000000000).substring(1));
                    }
                }
            } else if (i2 > 0 || (i2 == -1 && checkValidIntValue > 0)) {
                sb.append('.');
                int i3 = NetworkingModule.CHUNK_TIMEOUT_NS;
                while (true) {
                    if ((this.fractionalDigits != -1 || checkValidIntValue <= 0) && i >= this.fractionalDigits) {
                        break;
                    }
                    int i4 = checkValidIntValue / i3;
                    sb.append((char) (i4 + 48));
                    checkValidIntValue -= i4 * i3;
                    i3 /= 10;
                    i++;
                }
            }
            sb.append('Z');
            return true;
        }

        public String toString() {
            return "Instant()";
        }
    }

    public static final class OffsetIdPrinterParser implements DateTimePrinterParser {
        public static final OffsetIdPrinterParser INSTANCE_ID = new OffsetIdPrinterParser("Z", "+HH:MM:ss");
        public static final String[] PATTERNS = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        public final String noOffsetText;
        public final int type;

        public OffsetIdPrinterParser(String str, String str2) {
            PathParser.requireNonNull(str, "noOffsetText");
            PathParser.requireNonNull(str2, "pattern");
            this.noOffsetText = str;
            int i = 0;
            while (true) {
                String[] strArr = PATTERNS;
                if (i >= strArr.length) {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline8("Invalid zone offset pattern: ", str2));
                } else if (strArr[i].equals(str2)) {
                    this.type = i;
                    return;
                } else {
                    i++;
                }
            }
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(ChronoField.OFFSET_SECONDS);
            if (value == null) {
                return false;
            }
            long longValue = value.longValue();
            if (longValue > 2147483647L || longValue < -2147483648L) {
                throw new ArithmeticException(GeneratedOutlineSupport.outline6("Calculation overflows an int: ", longValue));
            }
            int i = (int) longValue;
            if (i == 0) {
                sb.append(this.noOffsetText);
            } else {
                int abs = Math.abs((i / 3600) % 100);
                int abs2 = Math.abs((i / 60) % 60);
                int abs3 = Math.abs(i % 60);
                int length = sb.length();
                sb.append(i < 0 ? "-" : "+");
                sb.append((char) ((abs / 10) + 48));
                sb.append((char) ((abs % 10) + 48));
                int i2 = this.type;
                if (i2 >= 3 || (i2 >= 1 && abs2 > 0)) {
                    int i3 = this.type % 2;
                    String str = ColorPropConverter.PACKAGE_DELIMITER;
                    sb.append(i3 == 0 ? str : "");
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int i4 = this.type;
                    if (i4 >= 7 || (i4 >= 5 && abs3 > 0)) {
                        if (this.type % 2 != 0) {
                            str = "";
                        }
                        sb.append(str);
                        sb.append((char) ((abs3 / 10) + 48));
                        sb.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb.setLength(length);
                    sb.append(this.noOffsetText);
                }
            }
            return true;
        }

        public String toString() {
            String replace = this.noOffsetText.replace("'", "''");
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Offset(");
            outline15.append(PATTERNS[this.type]);
            outline15.append(",'");
            outline15.append(replace);
            outline15.append("')");
            return outline15.toString();
        }
    }

    public static final class PadPrinterParserDecorator implements DateTimePrinterParser {
        public final char padChar;
        public final int padWidth;
        public final DateTimePrinterParser printerParser;

        public PadPrinterParserDecorator(DateTimePrinterParser dateTimePrinterParser, int i, char c) {
            this.printerParser = dateTimePrinterParser;
            this.padWidth = i;
            this.padChar = c;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (!this.printerParser.print(dateTimePrintContext, sb)) {
                return false;
            }
            int length2 = sb.length() - length;
            if (length2 <= this.padWidth) {
                for (int i = 0; i < this.padWidth - length2; i++) {
                    sb.insert(length, this.padChar);
                }
                return true;
            }
            StringBuilder outline16 = GeneratedOutlineSupport.outline16("Cannot print as output of ", length2, " characters exceeds pad width of ");
            outline16.append(this.padWidth);
            throw new DateTimeException(outline16.toString());
        }

        public String toString() {
            String str;
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Pad(");
            outline15.append(this.printerParser);
            outline15.append(",");
            outline15.append(this.padWidth);
            if (this.padChar == ' ') {
                str = ")";
            } else {
                StringBuilder outline152 = GeneratedOutlineSupport.outline15(",'");
                outline152.append(this.padChar);
                outline152.append("')");
                str = outline152.toString();
            }
            outline15.append(str);
            return outline15.toString();
        }
    }

    public enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return true;
        }

        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (ordinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (ordinal == 2) {
                return "ParseStrict(true)";
            }
            if (ordinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    public static final class StringLiteralPrinterParser implements DateTimePrinterParser {
        public final String literal;

        public StringLiteralPrinterParser(String str) {
            this.literal = str;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.literal);
            return true;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline9("'", this.literal.replace("'", "''"), "'");
        }
    }

    public static final class TextPrinterParser implements DateTimePrinterParser {
        public final TemporalField field;
        public volatile NumberPrinterParser numberPrinterParser;
        public final DateTimeTextProvider provider;
        public final TextStyle textStyle;

        public TextPrinterParser(TemporalField temporalField, TextStyle textStyle2, DateTimeTextProvider dateTimeTextProvider) {
            this.field = temporalField;
            this.textStyle = textStyle2;
            this.provider = dateTimeTextProvider;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            String text = this.provider.getText(this.field, value.longValue(), this.textStyle, dateTimePrintContext.locale);
            if (text == null) {
                if (this.numberPrinterParser == null) {
                    this.numberPrinterParser = new NumberPrinterParser(this.field, 1, 19, SignStyle.NORMAL);
                }
                return this.numberPrinterParser.print(dateTimePrintContext, sb);
            }
            sb.append(text);
            return true;
        }

        public String toString() {
            if (this.textStyle == TextStyle.FULL) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Text(");
                outline15.append(this.field);
                outline15.append(")");
                return outline15.toString();
            }
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("Text(");
            outline152.append(this.field);
            outline152.append(",");
            outline152.append(this.textStyle);
            outline152.append(")");
            return outline152.toString();
        }
    }

    public static final class ZoneIdPrinterParser implements DateTimePrinterParser {
        public final String description;
        public final TemporalQuery<ZoneId> query;

        public ZoneIdPrinterParser(TemporalQuery<ZoneId> temporalQuery, String str) {
            this.query = temporalQuery;
            this.description = str;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Object query2 = dateTimePrintContext.temporal.query(this.query);
            if (query2 == null && dateTimePrintContext.optional == 0) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Unable to extract value: ");
                outline15.append(dateTimePrintContext.temporal.getClass());
                throw new DateTimeException(outline15.toString());
            }
            ZoneId zoneId = (ZoneId) query2;
            if (zoneId == null) {
                return false;
            }
            sb.append(zoneId.getId());
            return true;
        }

        public String toString() {
            return this.description;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        FIELD_MAP = hashMap;
        hashMap.put('G', ChronoField.ERA);
        FIELD_MAP.put('y', ChronoField.YEAR_OF_ERA);
        FIELD_MAP.put('u', ChronoField.YEAR);
        FIELD_MAP.put('Q', IsoFields.QUARTER_OF_YEAR);
        FIELD_MAP.put('q', IsoFields.QUARTER_OF_YEAR);
        FIELD_MAP.put('M', ChronoField.MONTH_OF_YEAR);
        FIELD_MAP.put('L', ChronoField.MONTH_OF_YEAR);
        FIELD_MAP.put('D', ChronoField.DAY_OF_YEAR);
        FIELD_MAP.put('d', ChronoField.DAY_OF_MONTH);
        FIELD_MAP.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        FIELD_MAP.put('E', ChronoField.DAY_OF_WEEK);
        FIELD_MAP.put('c', ChronoField.DAY_OF_WEEK);
        FIELD_MAP.put('e', ChronoField.DAY_OF_WEEK);
        FIELD_MAP.put('a', ChronoField.AMPM_OF_DAY);
        FIELD_MAP.put('H', ChronoField.HOUR_OF_DAY);
        FIELD_MAP.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        FIELD_MAP.put('K', ChronoField.HOUR_OF_AMPM);
        FIELD_MAP.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        FIELD_MAP.put('m', ChronoField.MINUTE_OF_HOUR);
        FIELD_MAP.put('s', ChronoField.SECOND_OF_MINUTE);
        FIELD_MAP.put('S', ChronoField.NANO_OF_SECOND);
        FIELD_MAP.put('A', ChronoField.MILLI_OF_DAY);
        FIELD_MAP.put('n', ChronoField.NANO_OF_SECOND);
        FIELD_MAP.put('N', ChronoField.NANO_OF_DAY);
    }

    public DateTimeFormatterBuilder() {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = null;
        this.optional = false;
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter dateTimeFormatter) {
        PathParser.requireNonNull(dateTimeFormatter, "formatter");
        CompositePrinterParser compositePrinterParser = dateTimeFormatter.printerParser;
        if (compositePrinterParser.optional) {
            compositePrinterParser = new CompositePrinterParser(compositePrinterParser.printerParsers, false);
        }
        appendInternal(compositePrinterParser);
        return this;
    }

    public final int appendInternal(DateTimePrinterParser dateTimePrinterParser) {
        PathParser.requireNonNull(dateTimePrinterParser, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i = dateTimeFormatterBuilder.padNextWidth;
        if (i > 0) {
            PadPrinterParserDecorator padPrinterParserDecorator = new PadPrinterParserDecorator(dateTimePrinterParser, i, dateTimeFormatterBuilder.padNextChar);
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            dateTimeFormatterBuilder2.padNextWidth = 0;
            dateTimeFormatterBuilder2.padNextChar = 0;
            dateTimePrinterParser = padPrinterParserDecorator;
        }
        this.active.printerParsers.add(dateTimePrinterParser);
        DateTimeFormatterBuilder dateTimeFormatterBuilder3 = this.active;
        dateTimeFormatterBuilder3.valueParserIndex = -1;
        return dateTimeFormatterBuilder3.printerParsers.size() - 1;
    }

    public DateTimeFormatterBuilder appendLiteral(char c) {
        appendInternal(new CharLiteralPrinterParser(c));
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, Map<Long, String> map) {
        TextStyle textStyle = TextStyle.FULL;
        PathParser.requireNonNull(temporalField, "field");
        PathParser.requireNonNull(map, "textLookup");
        final SimpleDateTimeTextProvider.LocaleStore localeStore = new SimpleDateTimeTextProvider.LocaleStore(Collections.singletonMap(textStyle, new LinkedHashMap(map)));
        appendInternal(new TextPrinterParser(temporalField, textStyle, new DateTimeTextProvider(this) {
            /* class org.threeten.bp.format.DateTimeFormatterBuilder.AnonymousClass2 */

            @Override // org.threeten.bp.format.DateTimeTextProvider
            public String getText(TemporalField temporalField, long j, TextStyle textStyle, Locale locale) {
                Map<Long, String> map = localeStore.valueTextMap.get(textStyle);
                if (map != null) {
                    return map.get(Long.valueOf(j));
                }
                return null;
            }
        }));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i) {
        PathParser.requireNonNull(temporalField, "field");
        if (i < 1 || i > 19) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline4("The width must be from 1 to 19 inclusive but was ", i));
        }
        appendValue(new NumberPrinterParser(temporalField, i, i, SignStyle.NOT_NEGATIVE));
        return this;
    }

    public DateTimeFormatterBuilder optionalEnd() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        if (dateTimeFormatterBuilder.parent != null) {
            if (dateTimeFormatterBuilder.printerParsers.size() > 0) {
                DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
                CompositePrinterParser compositePrinterParser = new CompositePrinterParser(dateTimeFormatterBuilder2.printerParsers, dateTimeFormatterBuilder2.optional);
                this.active = this.active.parent;
                appendInternal(compositePrinterParser);
            } else {
                this.active = this.active.parent;
            }
            return this;
        }
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    public DateTimeFormatterBuilder optionalStart() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        this.active = new DateTimeFormatterBuilder(dateTimeFormatterBuilder, true);
        return this;
    }

    public DateTimeFormatter toFormatter() {
        Locale locale = Locale.getDefault();
        PathParser.requireNonNull(locale, "locale");
        while (this.active.parent != null) {
            optionalEnd();
        }
        return new DateTimeFormatter(new CompositePrinterParser(this.printerParsers, false), locale, DecimalStyle.STANDARD, ResolverStyle.SMART, null, null, null);
    }

    public DateTimeFormatterBuilder appendLiteral(String str) {
        PathParser.requireNonNull(str, "literal");
        if (str.length() > 0) {
            if (str.length() == 1) {
                appendInternal(new CharLiteralPrinterParser(str.charAt(0)));
            } else {
                appendInternal(new StringLiteralPrinterParser(str));
            }
        }
        return this;
    }

    public static final class CompositePrinterParser implements DateTimePrinterParser {
        public final boolean optional;
        public final DateTimePrinterParser[] printerParsers;

        public CompositePrinterParser(List<DateTimePrinterParser> list, boolean z) {
            this.printerParsers = (DateTimePrinterParser[]) list.toArray(new DateTimePrinterParser[list.size()]);
            this.optional = z;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (this.optional) {
                dateTimePrintContext.optional++;
            }
            try {
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    if (!dateTimePrinterParser.print(dateTimePrintContext, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.optional) {
                    dateTimePrintContext.endOptional();
                }
                return true;
            } finally {
                if (this.optional) {
                    dateTimePrintContext.endOptional();
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.printerParsers != null) {
                sb.append(this.optional ? "[" : "(");
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    sb.append(dateTimePrinterParser);
                }
                sb.append(this.optional ? "]" : ")");
            }
            return sb.toString();
        }

        public CompositePrinterParser(DateTimePrinterParser[] dateTimePrinterParserArr, boolean z) {
            this.printerParsers = dateTimePrinterParserArr;
            this.optional = z;
        }
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i, int i2, SignStyle signStyle) {
        if (i == i2 && signStyle == SignStyle.NOT_NEGATIVE) {
            appendValue(temporalField, i2);
            return this;
        }
        PathParser.requireNonNull(temporalField, "field");
        PathParser.requireNonNull(signStyle, "signStyle");
        if (i < 1 || i > 19) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline4("The minimum width must be from 1 to 19 inclusive but was ", i));
        } else if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline4("The maximum width must be from 1 to 19 inclusive but was ", i2));
        } else if (i2 >= i) {
            appendValue(new NumberPrinterParser(temporalField, i, i2, signStyle));
            return this;
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
        }
    }

    public static class NumberPrinterParser implements DateTimePrinterParser {
        public static final int[] EXCEED_POINTS = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, NetworkingModule.CHUNK_TIMEOUT_NS, 1000000000};
        public final TemporalField field;
        public final int maxWidth;
        public final int minWidth;
        public final SignStyle signStyle;
        public final int subsequentWidth;

        public NumberPrinterParser(TemporalField temporalField, int i, int i2, SignStyle signStyle2) {
            this.field = temporalField;
            this.minWidth = i;
            this.maxWidth = i2;
            this.signStyle = signStyle2;
            this.subsequentWidth = 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
            if (r4 != 4) goto L_0x0092;
         */
        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            String str;
            int i;
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            long longValue = value.longValue();
            DecimalStyle decimalStyle = dateTimePrintContext.symbols;
            if (longValue == Long.MIN_VALUE) {
                str = "9223372036854775808";
            } else {
                str = Long.toString(Math.abs(longValue));
            }
            if (str.length() <= this.maxWidth) {
                String convertNumberToI18N = decimalStyle.convertNumberToI18N(str);
                if (longValue >= 0) {
                    int ordinal = this.signStyle.ordinal();
                    if (ordinal == 1) {
                        sb.append(decimalStyle.positiveSign);
                    } else if (ordinal == 4 && (i = this.minWidth) < 19 && longValue >= ((long) EXCEED_POINTS[i])) {
                        sb.append(decimalStyle.positiveSign);
                    }
                } else {
                    int ordinal2 = this.signStyle.ordinal();
                    if (!(ordinal2 == 0 || ordinal2 == 1)) {
                        if (ordinal2 == 3) {
                            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Field ");
                            outline15.append(this.field);
                            outline15.append(" cannot be printed as the value ");
                            outline15.append(longValue);
                            outline15.append(" cannot be negative according to the SignStyle");
                            throw new DateTimeException(outline15.toString());
                        }
                    }
                    sb.append(decimalStyle.negativeSign);
                }
                for (int i2 = 0; i2 < this.minWidth - convertNumberToI18N.length(); i2++) {
                    sb.append(decimalStyle.zeroDigit);
                }
                sb.append(convertNumberToI18N);
                return true;
            }
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("Field ");
            outline152.append(this.field);
            outline152.append(" cannot be printed as the value ");
            outline152.append(longValue);
            outline152.append(" exceeds the maximum print width of ");
            outline152.append(this.maxWidth);
            throw new DateTimeException(outline152.toString());
        }

        public String toString() {
            if (this.minWidth == 1 && this.maxWidth == 19 && this.signStyle == SignStyle.NORMAL) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Value(");
                outline15.append(this.field);
                outline15.append(")");
                return outline15.toString();
            } else if (this.minWidth == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE) {
                StringBuilder outline152 = GeneratedOutlineSupport.outline15("Value(");
                outline152.append(this.field);
                outline152.append(",");
                return GeneratedOutlineSupport.outline11(outline152, this.minWidth, ")");
            } else {
                StringBuilder outline153 = GeneratedOutlineSupport.outline15("Value(");
                outline153.append(this.field);
                outline153.append(",");
                outline153.append(this.minWidth);
                outline153.append(",");
                outline153.append(this.maxWidth);
                outline153.append(",");
                outline153.append(this.signStyle);
                outline153.append(")");
                return outline153.toString();
            }
        }

        public NumberPrinterParser withFixedWidth() {
            if (this.subsequentWidth == -1) {
                return this;
            }
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, -1);
        }

        public NumberPrinterParser(TemporalField temporalField, int i, int i2, SignStyle signStyle2, int i3) {
            this.field = temporalField;
            this.minWidth = i;
            this.maxWidth = i2;
            this.signStyle = signStyle2;
            this.subsequentWidth = i3;
        }
    }

    public DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z) {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = dateTimeFormatterBuilder;
        this.optional = z;
    }

    public DateTimeFormatter toFormatter(ResolverStyle resolverStyle) {
        DateTimeFormatter formatter = toFormatter();
        PathParser.requireNonNull(resolverStyle, "resolverStyle");
        return PathParser.equals1(formatter.resolverStyle, resolverStyle) ? formatter : new DateTimeFormatter(formatter.printerParser, formatter.locale, formatter.decimalStyle, resolverStyle, formatter.resolverFields, formatter.chrono, formatter.zone);
    }

    public final DateTimeFormatterBuilder appendValue(NumberPrinterParser numberPrinterParser) {
        NumberPrinterParser numberPrinterParser2;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i = dateTimeFormatterBuilder.valueParserIndex;
        if (i < 0 || !(dateTimeFormatterBuilder.printerParsers.get(i) instanceof NumberPrinterParser)) {
            this.active.valueParserIndex = appendInternal(numberPrinterParser);
        } else {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            int i2 = dateTimeFormatterBuilder2.valueParserIndex;
            NumberPrinterParser numberPrinterParser3 = (NumberPrinterParser) dateTimeFormatterBuilder2.printerParsers.get(i2);
            int i3 = numberPrinterParser.minWidth;
            int i4 = numberPrinterParser.maxWidth;
            if (i3 == i4 && numberPrinterParser.signStyle == SignStyle.NOT_NEGATIVE) {
                numberPrinterParser2 = new NumberPrinterParser(numberPrinterParser3.field, numberPrinterParser3.minWidth, numberPrinterParser3.maxWidth, numberPrinterParser3.signStyle, numberPrinterParser3.subsequentWidth + i4);
                appendInternal(numberPrinterParser.withFixedWidth());
                this.active.valueParserIndex = i2;
            } else {
                numberPrinterParser2 = numberPrinterParser3.withFixedWidth();
                this.active.valueParserIndex = appendInternal(numberPrinterParser);
            }
            this.active.printerParsers.set(i2, numberPrinterParser2);
        }
        return this;
    }
}
