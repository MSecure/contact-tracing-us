package c.b.a.a.e.c;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;

public final /* synthetic */ class v7 implements NfcAdapter.ReaderCallback {

    /* renamed from: a  reason: collision with root package name */
    public final s7 f2779a;

    public v7(s7 s7Var) {
        this.f2779a = s7Var;
    }

    public final void onTagDiscovered(Tag tag) {
        s7 s7Var = this.f2779a;
        if (s7Var != null) {
            Intent intent = new Intent("android.nfc.action.TAG_DISCOVERED");
            intent.setPackage("com.google.android.gms");
            intent.putExtra("android.nfc.extra.TAG", tag);
            s7Var.f2720a.sendBroadcast(intent);
            return;
        }
        throw null;
    }
}
