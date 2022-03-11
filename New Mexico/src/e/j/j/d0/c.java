package e.j.j.d0;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import e.j.j.d0.f;
import e.j.j.e;
import e.j.j.v;
/* loaded from: classes.dex */
public class c extends InputConnectionWrapper {
    public final /* synthetic */ e a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(InputConnection inputConnection, boolean z, e eVar) {
        super(inputConnection, z);
        this.a = eVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z;
        Throwable th;
        ResultReceiver resultReceiver;
        e eVar = this.a;
        int i2 = 0;
        if (bundle != null) {
            if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
                z = false;
            } else if (TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
                z = true;
            }
            try {
                resultReceiver = (ResultReceiver) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER");
                try {
                    Uri uri = (Uri) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI");
                    ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION");
                    Uri uri2 = (Uri) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI");
                    int i3 = bundle.getInt(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS");
                    Bundle bundle2 = (Bundle) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS");
                    if (!(uri == null || clipDescription == null)) {
                        int i4 = Build.VERSION.SDK_INT;
                        f.c aVar = i4 >= 25 ? new f.a(uri, clipDescription, uri2) : new f.b(uri, clipDescription, uri2);
                        d dVar = (d) eVar;
                        if (i4 >= 25 && (i3 & 1) != 0) {
                            try {
                                aVar.a();
                                InputContentInfo inputContentInfo = (InputContentInfo) aVar.d();
                                bundle2 = bundle2 == null ? new Bundle() : new Bundle(bundle2);
                                bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
                            } catch (Exception unused) {
                            }
                        }
                        e.a aVar2 = new e.a(new ClipData(aVar.c(), new ClipData.Item(aVar.e())), 2);
                        aVar2.f1635d = aVar.b();
                        aVar2.f1636e = bundle2;
                        if (v.q(dVar.a, new e(aVar2)) == null) {
                            i2 = 1;
                        }
                    }
                    if (resultReceiver != null) {
                        resultReceiver.send(i2, null);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (resultReceiver != null) {
                        resultReceiver.send(0, null);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                resultReceiver = null;
            }
        }
        if (i2 != 0) {
            return true;
        }
        return super.performPrivateCommand(str, bundle);
    }
}
