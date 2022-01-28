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

public abstract class d extends j {
    public final TextInputLayout b;
    public final DateFormat c;

    /* renamed from: d  reason: collision with root package name */
    public final a f2896d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2897e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f2898f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f2899g;

    public class a implements Runnable {
        public final /* synthetic */ String b;

        public a(String str) {
            this.b = str;
        }

        public void run() {
            d dVar = d.this;
            TextInputLayout textInputLayout = dVar.b;
            DateFormat dateFormat = dVar.c;
            Context context = textInputLayout.getContext();
            String string = context.getString(R$string.mtrl_picker_invalid_format);
            String format = String.format(context.getString(R$string.mtrl_picker_invalid_format_use), this.b);
            String format2 = String.format(context.getString(R$string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(d0.f().getTimeInMillis())));
            textInputLayout.setError(string + "\n" + format + "\n" + format2);
            ((a0.a) d.this).f2886h.a();
        }
    }

    public d(String str, DateFormat dateFormat, TextInputLayout textInputLayout, a aVar) {
        this.c = dateFormat;
        this.b = textInputLayout;
        this.f2896d = aVar;
        this.f2897e = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
        this.f2898f = new a(str);
    }

    public abstract void a(Long l2);

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a A[Catch:{ ParseException -> 0x0073 }] */
    @Override // f.b.a.e.q.j
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.b.removeCallbacks(this.f2898f);
        this.b.removeCallbacks(this.f2899g);
        this.b.setError(null);
        a(null);
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                Date parse = this.c.parse(charSequence.toString());
                this.b.setError(null);
                long time = parse.getTime();
                if (this.f2896d.f2879d.f(time)) {
                    a aVar = this.f2896d;
                    boolean z = true;
                    if (aVar.b.t(1) <= time) {
                        u uVar = aVar.c;
                        if (time <= uVar.t(uVar.f2906f)) {
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
                this.f2899g = eVar;
                this.b.postDelayed(eVar, 1000);
            } catch (ParseException unused) {
                this.b.postDelayed(this.f2898f, 1000);
            }
        }
    }
}
