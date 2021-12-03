package f.b.a.e.k;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import f.b.a.e.p.l;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class a0 implements f<Long> {
    public static final Parcelable.Creator<a0> CREATOR = new b();
    public Long b;

    public class a extends d {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ y f2830h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, a aVar, y yVar) {
            super(str, dateFormat, textInputLayout, aVar);
            this.f2830h = yVar;
        }

        @Override // f.b.a.e.k.d
        public void a(Long l2) {
            if (l2 == null) {
                a0.this.b = null;
            } else {
                a0.this.b = Long.valueOf(l2.longValue());
            }
            this.f2830h.b(a0.this.b);
        }
    }

    public static class b implements Parcelable.Creator<a0> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public a0 createFromParcel(Parcel parcel) {
            a0 a0Var = new a0();
            a0Var.b = (Long) parcel.readValue(Long.class.getClassLoader());
            return a0Var;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public a0[] newArray(int i2) {
            return new a0[i2];
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // f.b.a.e.k.f
    public Long a() {
        return this.b;
    }

    @Override // f.b.a.e.k.f
    public String b(Context context) {
        Resources resources = context.getResources();
        Long l2 = this.b;
        if (l2 == null) {
            return resources.getString(R$string.mtrl_picker_date_header_unselected);
        }
        String L0 = f.b.a.c.b.o.b.L0(l2.longValue());
        return resources.getString(R$string.mtrl_picker_date_header_selected, L0);
    }

    @Override // f.b.a.e.k.f
    public int c(Context context) {
        return f.b.a.c.b.o.b.j1(context, R$attr.materialCalendarTheme, q.class.getCanonicalName());
    }

    public void d(Object obj) {
        Long l2 = (Long) obj;
        this.b = l2 == null ? null : Long.valueOf(d0.a(l2.longValue()));
    }

    public int describeContents() {
        return 0;
    }

    @Override // f.b.a.e.k.f
    public Collection<e.i.h.a<Long, Long>> e() {
        return new ArrayList();
    }

    @Override // f.b.a.e.k.f
    public boolean h() {
        return this.b != null;
    }

    @Override // f.b.a.e.k.f
    public void i(long j2) {
        this.b = Long.valueOf(j2);
    }

    @Override // f.b.a.e.k.f
    public View l(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, a aVar, y<Long> yVar) {
        View inflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R$id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        String str = Build.MANUFACTURER;
        Locale locale = Locale.ENGLISH;
        if (str.toLowerCase(locale).equals("lge") || str.toLowerCase(locale).equals("samsung")) {
            editText.setInputType(17);
        }
        AtomicReference<c0> atomicReference = d0.a;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(d0.e());
        simpleDateFormat.setLenient(false);
        Resources resources = inflate.getResources();
        String replaceAll = simpleDateFormat.toLocalizedPattern().replaceAll("d", resources.getString(R$string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(R$string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(R$string.mtrl_picker_text_input_year_abbr));
        textInputLayout.setPlaceholderText(replaceAll);
        Long l2 = this.b;
        if (l2 != null) {
            editText.setText(simpleDateFormat.format(l2));
        }
        editText.addTextChangedListener(new a(replaceAll, simpleDateFormat, textInputLayout, aVar, yVar));
        editText.requestFocus();
        editText.post(new l(editText));
        return inflate;
    }

    @Override // f.b.a.e.k.f
    public Collection<Long> m() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.b;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.b);
    }
}
