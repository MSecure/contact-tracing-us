package b.i.d;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1018a;

    /* renamed from: b  reason: collision with root package name */
    public final Intent f1019b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f1020c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f1021d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f1022e;
    public ArrayList<Uri> f;

    public m(Context context, ComponentName componentName) {
        if (context != null) {
            this.f1018a = context;
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.f1019b = action;
            action.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            this.f1019b.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            this.f1019b.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", componentName);
            this.f1019b.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", componentName);
            this.f1019b.addFlags(524288);
            return;
        }
        throw null;
    }

    public static m b(Activity activity) {
        if (activity != null) {
            return new m(activity, activity.getComponentName());
        }
        throw null;
    }

    public final void a(String str, ArrayList<String> arrayList) {
        String[] stringArrayExtra = this.f1019b.getStringArrayExtra(str);
        int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
        String[] strArr = new String[(arrayList.size() + length)];
        arrayList.toArray(strArr);
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
        }
        this.f1019b.putExtra(str, strArr);
    }

    public m c(String str) {
        this.f1019b.putExtra("android.intent.extra.SUBJECT", str);
        return this;
    }

    public m d(CharSequence charSequence) {
        this.f1019b.putExtra("android.intent.extra.TEXT", charSequence);
        return this;
    }

    public m e(String str) {
        this.f1019b.setType(str);
        return this;
    }

    public void f() {
        Context context = this.f1018a;
        ArrayList<String> arrayList = this.f1020c;
        if (arrayList != null) {
            a("android.intent.extra.EMAIL", arrayList);
            this.f1020c = null;
        }
        ArrayList<String> arrayList2 = this.f1021d;
        if (arrayList2 != null) {
            a("android.intent.extra.CC", arrayList2);
            this.f1021d = null;
        }
        ArrayList<String> arrayList3 = this.f1022e;
        if (arrayList3 != null) {
            a("android.intent.extra.BCC", arrayList3);
            this.f1022e = null;
        }
        ArrayList<Uri> arrayList4 = this.f;
        boolean z = true;
        if (arrayList4 == null || arrayList4.size() <= 1) {
            z = false;
        }
        boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.f1019b.getAction());
        if (!z && equals) {
            this.f1019b.setAction("android.intent.action.SEND");
            ArrayList<Uri> arrayList5 = this.f;
            if (arrayList5 == null || arrayList5.isEmpty()) {
                this.f1019b.removeExtra("android.intent.extra.STREAM");
            } else {
                this.f1019b.putExtra("android.intent.extra.STREAM", this.f.get(0));
            }
            this.f = null;
        }
        if (z && !equals) {
            this.f1019b.setAction("android.intent.action.SEND_MULTIPLE");
            ArrayList<Uri> arrayList6 = this.f;
            if (arrayList6 == null || arrayList6.isEmpty()) {
                this.f1019b.removeExtra("android.intent.extra.STREAM");
            } else {
                this.f1019b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f);
            }
        }
        context.startActivity(Intent.createChooser(this.f1019b, null));
    }
}
