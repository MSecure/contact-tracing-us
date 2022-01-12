package org.matomo.sdk.dispatcher;

import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import org.matomo.sdk.Matomo;

public class DefaultPacketSender implements PacketSender {
    public static final String TAG = Matomo.tag(DefaultPacketSender.class);
    public boolean mGzip = false;
    public long mTimeout = WebsocketJavaScriptExecutor.CONNECT_TIMEOUT_MS;
}
