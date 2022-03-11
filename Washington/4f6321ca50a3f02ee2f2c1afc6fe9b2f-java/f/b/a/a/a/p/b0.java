package f.b.a.a.a.p;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import e.p.r;

public final /* synthetic */ class b0 implements r {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;
    public final /* synthetic */ TextView c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f2174d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewSwitcher f2175e;

    public /* synthetic */ b0(View view, View view2, TextView textView, EditText editText, ViewSwitcher viewSwitcher) {
        this.a = view;
        this.b = view2;
        this.c = textView;
        this.f2174d = editText;
        this.f2175e = viewSwitcher;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        View view = this.a;
        View view2 = this.b;
        TextView textView = this.c;
        EditText editText = this.f2174d;
        ViewSwitcher viewSwitcher = this.f2175e;
        String str = (String) obj;
        int i2 = l3.a0;
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(8);
            return;
        }
        view2.setVisibility(8);
        view.setVisibility(0);
        textView.setText(str);
        editText.setEnabled(true);
        viewSwitcher.setDisplayedChild(0);
    }
}
