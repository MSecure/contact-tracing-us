package com.proudcrowd.exposure.core;

import com.google.common.base.Function;
import com.proudcrowd.exposure.storage.WatermarkUrlEntity;

/* renamed from: com.proudcrowd.exposure.core.-$$Lambda$ScanManager$BlmL16y3-wyhp0lfWsHkn8QZ7E8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ScanManager$BlmL16y3wyhp0lfWsHkn8QZ7E8 implements Function {
    public static final /* synthetic */ $$Lambda$ScanManager$BlmL16y3wyhp0lfWsHkn8QZ7E8 INSTANCE = new $$Lambda$ScanManager$BlmL16y3wyhp0lfWsHkn8QZ7E8();

    private /* synthetic */ $$Lambda$ScanManager$BlmL16y3wyhp0lfWsHkn8QZ7E8() {
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return ((WatermarkUrlEntity) obj).getUrlFragment();
    }
}
