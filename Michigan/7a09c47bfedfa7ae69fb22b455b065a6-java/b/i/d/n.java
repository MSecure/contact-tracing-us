package b.i.d;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1713a;

    /* renamed from: b  reason: collision with root package name */
    public final Intent f1714b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f1715c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f1716d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f1717e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Uri> f1718f;

    public n(Context context, ComponentName componentName) {
        if (context != null) {
            this.f1713a = context;
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.f1714b = action;
            action.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            this.f1714b.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            this.f1714b.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", componentName);
            this.f1714b.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", componentName);
            this.f1714b.addFlags(524288);
            return;
        }
        throw null;
    }

    public static n b(Activity activity) {
        if (activity != null) {
            return new n(activity, activity.getComponentName());
        }
        throw null;
    }

    public final void a(String str, ArrayList<String> arrayList) {
        String[] stringArrayExtra = this.f1714b.getStringArrayExtra(str);
        int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
        String[] strArr = new String[(arrayList.size() + length)];
        arrayList.toArray(strArr);
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
        }
        this.f1714b.putExtra(str, strArr);
    }

    public n c(CharSequence charSequence) {
        this.f1714b.putExtra("android.intent.extra.TEXT", charSequence);
        return this;
    }

    public n d(String str) {
        this.f1714b.setType(str);
        return this;
    }

    public void e() {
        Context context = this.f1713a;
        ArrayList<String> arrayList = this.f1715c;
        if (arrayList != null) {
            a("android.intent.extra.EMAIL", arrayList);
            this.f1715c = null;
        }
        ArrayList<String> arrayList2 = this.f1716d;
        if (arrayList2 != null) {
            a("android.intent.extra.CC", arrayList2);
            this.f1716d = null;
        }
        ArrayList<String> arrayList3 = this.f1717e;
        if (arrayList3 != null) {
            a("android.intent.extra.BCC", arrayList3);
            this.f1717e = null;
        }
        ArrayList<Uri> arrayList4 = this.f1718f;
        boolean z = true;
        if (arrayList4 == null || arrayList4.size() <= 1) {
            z = false;
        }
        boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.f1714b.getAction());
        if (!z && equals) {
            this.f1714b.setAction("android.intent.action.SEND");
            ArrayList<Uri> arrayList5 = this.f1718f;
            if (arrayList5 == null || arrayList5.isEmpty()) {
                this.f1714b.removeExtra("android.intent.extra.STREAM");
            } else {
                this.f1714b.putExtra("android.intent.extra.STREAM", this.f1718f.get(0));
            }
            this.f1718f = null;
        }
        if (z && !equals) {
            this.f1714b.setAction("android.intent.action.SEND_MULTIPLE");
            ArrayList<Uri> arrayList6 = this.f1718f;
            if (arrayList6 == null || arrayList6.isEmpty()) {
                this.f1714b.removeExtra("android.intent.extra.STREAM");
            } else {
                this.f1714b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f1718f);
            }
        }
        context.startActivity(Intent.createChooser(this.f1714b, null));
    }
}
