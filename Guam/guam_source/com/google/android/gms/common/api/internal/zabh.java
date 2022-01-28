package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zabh implements Runnable {
    public final /* synthetic */ zabf zaa;

    public zabh(zabf zabf) {
        this.zaa = zabf;
    }

    public final void run() {
        Api.Client client = this.zaa.zaa.zac;
        client.disconnect(client.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
