package f.b.a.e.l;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import f.b.a.e.l.a0;
import f.b.a.e.q.j;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
/* loaded from: classes.dex */
public abstract class d extends j {
    public final TextInputLayout b;
    public final DateFormat c;

    /* renamed from: d */
    public final a f2938d;

    /* renamed from: e */
    public final String f2939e;

    /* renamed from: f */
    public final Runnable f2940f;

    /* renamed from: g */
    public Runnable f2941g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ String b;

        public a(String str) {
            d.this = r1;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            TextInputLayout textInputLayout = dVar.b;
            DateFormat dateFormat = dVar.c;
            Context context = textInputLayout.getContext();
            String string = context.getString(R$string.mtrl_picker_invalid_format);
            String format = String.format(context.getString(R$string.mtrl_picker_invalid_format_use), this.b);
            String format2 = String.format(context.getString(R$string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(d0.f().getTimeInMillis())));
            textInputLayout.setError(string + "\n" + format + "\n" + format2);
            ((a0.a) d.this).f2928h.a();
        }
    }

    public d(String str, DateFormat dateFormat, TextInputLayout textInputLayout, a aVar) {
        this.c = dateFormat;
        this.b = textInputLayout;
        this.f2938d = aVar;
        this.f2939e = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
        this.f2940f = new a(str);
    }

    public abstract void a(Long l2);

    /* JADX WARN: Removed duplicated region for block: B:15:0x005a A[Catch: ParseException -> 0x0073, TryCatch #0 {ParseException -> 0x0073, blocks: (B:6:0x0020, B:8:0x003d, B:10:0x004a, B:15:0x005a, B:17:0x0066), top: B:20:0x0020 }] */
    @Override // f.b.a.e.q.j, android.text.TextWatcher
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.b.removeCallbacks(this.f2940f);
        this.b.removeCallbacks(this.f2941g);
        this.b.setError(null);
        a(null);
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                Date parse = this.c.parse(charSequence.toString());
                this.b.setError(null);
                long time = parse.getTime();
                if (this.f2938d.f2921d.f(time)) {
                    a aVar = this.f2938d;
                    boolean z = true;
                    if (aVar.b.t(1) <= time) {
                        u uVar = aVar.c;
                        if (time <= uVar.t(uVar.f2948f)) {
                            if (z) {
                                a(Long.valueOf(parse.getTime()));
                                return;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
                e eVar = new e(this, time);
                this.f2941g = eVar;
                this.b.postDelayed(eVar, 1000);
            } catch (ParseException unused) {
                this.b.postDelayed(this.f2940f, 1000);
            }
        }
    }
}
