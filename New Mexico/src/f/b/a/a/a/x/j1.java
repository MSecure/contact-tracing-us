package f.b.a.a.a.x;

import android.os.CountDownTimer;
import l.b.a.d;
/* loaded from: classes.dex */
public class j1 extends CountDownTimer {
    public final /* synthetic */ k1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(k1 k1Var, long j2, long j3) {
        super(j2, j3);
        this.a = k1Var;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        k1 k1Var = this.a;
        d dVar = k1.g0;
        k1Var.L0();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j2) {
    }
}
