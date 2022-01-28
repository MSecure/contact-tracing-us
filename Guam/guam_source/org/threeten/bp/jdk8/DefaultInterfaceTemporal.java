package org.threeten.bp.jdk8;

import androidx.recyclerview.widget.RecyclerView;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalUnit;

public abstract class DefaultInterfaceTemporal extends DefaultInterfaceTemporalAccessor implements Temporal {
    @Override // org.threeten.bp.temporal.Temporal
    public Temporal minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(RecyclerView.FOREVER_NS, temporalUnit).plus(1, temporalUnit) : plus(-j, temporalUnit);
    }
}
