package org.matomo.sdk.dispatcher;

import org.matomo.sdk.Matomo;

public class PacketFactory {
    public static final String TAG = Matomo.tag(PacketFactory.class);
    public final String mApiUrl;

    public PacketFactory(String str) {
        this.mApiUrl = str;
    }

    public final Packet buildPacketForGet(Event event) {
        if (event.mQuery.isEmpty()) {
            return null;
        }
        return new Packet(this.mApiUrl + event);
    }
}
