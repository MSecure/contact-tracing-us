package org.threeten.bp.format;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.temporal.TemporalField;

public abstract class DateTimeTextProvider {
    static {
        new AtomicReference();
    }

    public abstract String getText(TemporalField temporalField, long j, TextStyle textStyle, Locale locale);
}
