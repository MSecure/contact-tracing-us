package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public final class ReconnectingWebSocket extends WebSocketListener {
    public boolean mClosed = false;
    public ConnectionCallback mConnectionCallback;
    public final Handler mHandler;
    public MessageCallback mMessageCallback;
    public boolean mSuppressConnectionErrors;
    public final String mUrl;
    public WebSocket mWebSocket;

    public interface ConnectionCallback {
        void onConnected();

        void onDisconnected();
    }

    public interface MessageCallback {
    }

    public ReconnectingWebSocket(String str, MessageCallback messageCallback, ConnectionCallback connectionCallback) {
        this.mUrl = str;
        this.mMessageCallback = messageCallback;
        this.mConnectionCallback = connectionCallback;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public void connect() {
        if (!this.mClosed) {
            new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(0, TimeUnit.MINUTES).build().newWebSocket(new Request.Builder().url(this.mUrl).build(), this);
            return;
        }
        throw new IllegalStateException("Can't connect closed client");
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onClosed(WebSocket webSocket, int i, String str) {
        this.mWebSocket = null;
        if (!this.mClosed) {
            if (this.mConnectionCallback != null) {
                this.mConnectionCallback.onDisconnected();
            }
            reconnect();
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onFailure(WebSocket webSocket, Throwable th, Response response) {
        if (this.mWebSocket != null) {
            FLog.e("ReconnectingWebSocket", "Error occurred, shutting down websocket connection: " + "Websocket exception", th);
            WebSocket webSocket2 = this.mWebSocket;
            if (webSocket2 != null) {
                try {
                    webSocket2.close(1000, "End of session");
                } catch (Exception unused) {
                }
                this.mWebSocket = null;
            }
        }
        if (!this.mClosed) {
            if (this.mConnectionCallback != null) {
                this.mConnectionCallback.onDisconnected();
            }
            reconnect();
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onMessage(WebSocket webSocket, String str) {
        if (this.mMessageCallback != null) {
            ((JSPackagerClient) this.mMessageCallback).onMessage(str);
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onOpen(WebSocket webSocket, Response response) {
        this.mWebSocket = webSocket;
        this.mSuppressConnectionErrors = false;
        if (this.mConnectionCallback != null) {
            this.mConnectionCallback.onConnected();
        }
    }

    public final void reconnect() {
        if (!this.mClosed) {
            if (!this.mSuppressConnectionErrors) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Couldn't connect to \"");
                outline15.append(this.mUrl);
                outline15.append("\", will silently retry");
                FLog.w("ReconnectingWebSocket", outline15.toString());
                this.mSuppressConnectionErrors = true;
            }
            this.mHandler.postDelayed(new Runnable() {
                /* class com.facebook.react.packagerconnection.ReconnectingWebSocket.AnonymousClass1 */

                public void run() {
                    ReconnectingWebSocket reconnectingWebSocket = ReconnectingWebSocket.this;
                    synchronized (reconnectingWebSocket) {
                        if (!reconnectingWebSocket.mClosed) {
                            reconnectingWebSocket.connect();
                        }
                    }
                }
            }, 2000);
            return;
        }
        throw new IllegalStateException("Can't reconnect closed client");
    }

    public synchronized void sendMessage(String str) throws IOException {
        if (this.mWebSocket != null) {
            this.mWebSocket.send(str);
        } else {
            throw new ClosedChannelException();
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onMessage(WebSocket webSocket, ByteString byteString) {
        if (this.mMessageCallback != null) {
            if (((JSPackagerClient) this.mMessageCallback) != null) {
                FLog.w("JSPackagerClient", "Websocket received message with payload of unexpected type binary");
            } else {
                throw null;
            }
        }
    }
}
