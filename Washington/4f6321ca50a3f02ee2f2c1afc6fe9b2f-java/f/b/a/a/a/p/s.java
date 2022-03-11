package f.b.a.a.a.p;

import android.view.View;
import android.widget.Button;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.r;
import f.b.a.a.a.w.b0;
import java.util.Objects;

public final /* synthetic */ class s implements r {
    public final /* synthetic */ j3 a;
    public final /* synthetic */ Button b;
    public final /* synthetic */ ShareDiagnosisViewModel c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f2188d;

    public /* synthetic */ s(j3 j3Var, Button button, ShareDiagnosisViewModel shareDiagnosisViewModel, View view) {
        this.a = j3Var;
        this.b = button;
        this.c = shareDiagnosisViewModel;
        this.f2188d = view;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        j3 j3Var = this.a;
        Button button = this.b;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.c;
        View view = this.f2188d;
        b0 b0Var = (b0) obj;
        Objects.requireNonNull(j3Var);
        button.setOnClickListener(new v(j3Var, shareDiagnosisViewModel, b0Var));
        view.setOnClickListener(new r(j3Var, b0Var, shareDiagnosisViewModel));
    }
}
