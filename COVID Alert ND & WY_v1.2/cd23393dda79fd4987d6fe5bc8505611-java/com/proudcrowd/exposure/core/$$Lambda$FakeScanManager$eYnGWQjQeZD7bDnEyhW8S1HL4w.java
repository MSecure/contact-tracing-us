package com.proudcrowd.exposure.core;

import androidx.work.ListenableWorker;
import com.google.common.base.Function;

/* renamed from: com.proudcrowd.exposure.core.-$$Lambda$FakeScanManager$eYnGWQjQeZD7bDnEyhW8S1HL-4w  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$FakeScanManager$eYnGWQjQeZD7bDnEyhW8S1HL4w implements Function {
    public static final /* synthetic */ $$Lambda$FakeScanManager$eYnGWQjQeZD7bDnEyhW8S1HL4w INSTANCE = new $$Lambda$FakeScanManager$eYnGWQjQeZD7bDnEyhW8S1HL4w();

    private /* synthetic */ $$Lambda$FakeScanManager$eYnGWQjQeZD7bDnEyhW8S1HL4w() {
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        return ListenableWorker.Result.failure();
    }
}
