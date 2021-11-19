package com.proudcrowd.exposure.core;

import com.google.common.base.Function;
import com.proudcrowd.exposure.storage.WatermarkUrlEntity;

/* renamed from: com.proudcrowd.exposure.core.-$$Lambda$ScanManager$sR3bWts6JLL8p9zroRw2kAYvnUk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ScanManager$sR3bWts6JLL8p9zroRw2kAYvnUk implements Function {
    public static final /* synthetic */ $$Lambda$ScanManager$sR3bWts6JLL8p9zroRw2kAYvnUk INSTANCE = new $$Lambda$ScanManager$sR3bWts6JLL8p9zroRw2kAYvnUk();

    private /* synthetic */ $$Lambda$ScanManager$sR3bWts6JLL8p9zroRw2kAYvnUk() {
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return WatermarkUrlEntity.create((String) obj);
    }
}
