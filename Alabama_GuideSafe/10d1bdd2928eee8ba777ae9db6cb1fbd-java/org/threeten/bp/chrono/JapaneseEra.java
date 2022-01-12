package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.jdk8.DefaultInterfaceEra;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

public final class JapaneseEra extends DefaultInterfaceEra implements Serializable {
    public static final JapaneseEra HEISEI = new JapaneseEra(2, LocalDate.of(1989, 1, 8), "Heisei");
    public static final AtomicReference<JapaneseEra[]> KNOWN_ERAS;
    public static final JapaneseEra MEIJI = new JapaneseEra(-1, LocalDate.of(1868, 9, 8), "Meiji");
    public static final JapaneseEra REIWA;
    public static final JapaneseEra SHOWA = new JapaneseEra(1, LocalDate.of(1926, 12, 25), "Showa");
    public static final JapaneseEra TAISHO = new JapaneseEra(0, LocalDate.of(1912, 7, 30), "Taisho");
    public final int eraValue;
    public final transient String name;
    public final transient LocalDate since;

    static {
        JapaneseEra japaneseEra = new JapaneseEra(3, LocalDate.of(2019, 5, 1), "Reiwa");
        REIWA = japaneseEra;
        KNOWN_ERAS = new AtomicReference<>(new JapaneseEra[]{MEIJI, TAISHO, SHOWA, HEISEI, japaneseEra});
    }

    public JapaneseEra(int i, LocalDate localDate, String str) {
        this.eraValue = i;
        this.since = localDate;
        this.name = str;
    }

    public static JapaneseEra from(LocalDate localDate) {
        if (!localDate.isBefore(MEIJI.since)) {
            JapaneseEra[] japaneseEraArr = KNOWN_ERAS.get();
            for (int length = japaneseEraArr.length - 1; length >= 0; length--) {
                JapaneseEra japaneseEra = japaneseEraArr[length];
                if (localDate.compareTo((ChronoLocalDate) japaneseEra.since) >= 0) {
                    return japaneseEra;
                }
            }
            return null;
        }
        throw new DateTimeException("Date too early: " + localDate);
    }

    public static JapaneseEra of(int i) {
        JapaneseEra[] japaneseEraArr = KNOWN_ERAS.get();
        if (i >= MEIJI.eraValue && i <= japaneseEraArr[japaneseEraArr.length - 1].eraValue) {
            return japaneseEraArr[i + 1];
        }
        throw new DateTimeException("japaneseEra is invalid");
    }

    public static JapaneseEra readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        try {
            return of(this.eraValue);
        } catch (DateTimeException e) {
            InvalidObjectException invalidObjectException = new InvalidObjectException("Invalid era");
            invalidObjectException.initCause(e);
            throw invalidObjectException;
        }
    }

    public static JapaneseEra[] values() {
        JapaneseEra[] japaneseEraArr = KNOWN_ERAS.get();
        return (JapaneseEra[]) Arrays.copyOf(japaneseEraArr, japaneseEraArr.length);
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    public LocalDate endDate() {
        int i = this.eraValue + 1;
        JapaneseEra[] values = values();
        if (i >= values.length - 1) {
            return LocalDate.MAX;
        }
        return values[i + 1].since.plusDays(-1);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return JapaneseChronology.INSTANCE.range(ChronoField.ERA);
        }
        return super.range(temporalField);
    }

    public String toString() {
        return this.name;
    }
}
