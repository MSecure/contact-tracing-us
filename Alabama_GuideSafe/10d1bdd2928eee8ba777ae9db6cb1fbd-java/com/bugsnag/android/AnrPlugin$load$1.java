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
        AnrPlugin.access$setClient$p(this.this$0, this.$client);
        AnrPlugin.access$enableAnrReporting(this.this$0, true);
        this.$client.logger.i("Initialised ANR Plugin");
    }
}
