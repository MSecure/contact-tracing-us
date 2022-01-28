package com.bugsnag.android;

/* compiled from: AnrPlugin.kt */
public final class AnrPlugin$load$1 implements Runnable {
    public final /* synthetic */ Client $client;
    public final /* synthetic */ AnrPlugin this$0;

    public AnrPlugin$load$1(AnrPlugin anrPlugin, Client client) {
        this.this$0 = anrPlugin;
        this.$client = client;
    }

    public final void run() {
        this.this$0.client = this.$client;
        this.this$0.enableAnrReporting(true);
        this.$client.logger.i("Initialised ANR Plugin");
    }
}
