package com.facebook.react.modules.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactContext;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ForwardingCookieHandler extends CookieHandler {
    public final ReactContext mContext;
    public CookieManager mCookieManager;
    public final CookieSaver mCookieSaver = new CookieSaver();

    public class CookieSaver {
        public final Handler mHandler;

        public CookieSaver() {
            this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback(ForwardingCookieHandler.this) {
                /* class com.facebook.react.modules.network.ForwardingCookieHandler.CookieSaver.AnonymousClass1 */

                public boolean handleMessage(Message message) {
                    if (message.what != 1) {
                        return false;
                    }
                    CookieSaver.this.persistCookies();
                    return true;
                }
            });
        }

        public void persistCookies() {
            this.mHandler.removeMessages(1);
            ForwardingCookieHandler forwardingCookieHandler = ForwardingCookieHandler.this;
            AnonymousClass2 r1 = new Runnable() {
                /* class com.facebook.react.modules.network.ForwardingCookieHandler.CookieSaver.AnonymousClass2 */

                public void run() {
                    ForwardingCookieHandler.access$200();
                    CookieManager cookieManager = ForwardingCookieHandler.this.getCookieManager();
                    if (cookieManager != null) {
                        cookieManager.flush();
                    }
                }
            };
            if (forwardingCookieHandler != null) {
                new GuardedAsyncTask<Void, Void>(forwardingCookieHandler, forwardingCookieHandler.mContext, r1) {
                    /* class com.facebook.react.modules.network.ForwardingCookieHandler.AnonymousClass4 */
                    public final /* synthetic */ Runnable val$runnable;

                    {
                        this.val$runnable = r3;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                    @Override // com.facebook.react.bridge.GuardedAsyncTask
                    public void doInBackgroundGuarded(Void[] voidArr) {
                        this.val$runnable.run();
                    }
                }.execute(new Void[0]);
                return;
            }
            throw null;
        }
    }

    public ForwardingCookieHandler(ReactContext reactContext) {
        this.mContext = reactContext;
    }

    public static /* synthetic */ boolean access$200() {
        return false;
    }

    @Override // java.net.CookieHandler
    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException {
        CookieManager cookieManager = getCookieManager();
        if (cookieManager == null) {
            return Collections.emptyMap();
        }
        String cookie = cookieManager.getCookie(uri.toString());
        if (TextUtils.isEmpty(cookie)) {
            return Collections.emptyMap();
        }
        return Collections.singletonMap("Cookie", Collections.singletonList(cookie));
    }

    public final CookieManager getCookieManager() {
        if (this.mCookieManager == null) {
            try {
                this.mCookieManager = CookieManager.getInstance();
            } catch (IllegalArgumentException unused) {
                return null;
            } catch (Exception e) {
                if (e.getMessage() != null && e.getClass().getCanonicalName().equals("android.webkit.WebViewFactory.MissingWebViewPackageException")) {
                    return null;
                }
                throw e;
            }
        }
        return this.mCookieManager;
    }

    @Override // java.net.CookieHandler
    public void put(URI uri, Map<String, List<String>> map) throws IOException {
        String uri2 = uri.toString();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                if (key.equalsIgnoreCase("Set-cookie") || key.equalsIgnoreCase("Set-cookie2")) {
                    List<String> value = entry.getValue();
                    CookieManager cookieManager = getCookieManager();
                    if (cookieManager == null) {
                        continue;
                    } else {
                        for (String str : value) {
                            CookieManager cookieManager2 = getCookieManager();
                            if (cookieManager2 != null) {
                                cookieManager2.setCookie(uri2, str, null);
                            }
                        }
                        cookieManager.flush();
                        if (this.mCookieSaver == null) {
                            throw null;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
