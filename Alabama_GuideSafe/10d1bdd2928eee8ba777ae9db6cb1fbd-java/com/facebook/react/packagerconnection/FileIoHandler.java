package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.packagerconnection.JSPackagerClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class FileIoHandler implements Runnable {
    public static final String TAG = JSPackagerClient.class.getSimpleName();
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    public int mNextHandle = 1;
    public final Map<Integer, TtlFileInputStream> mOpenFiles = new HashMap();
    public final Map<String, RequestHandler> mRequestHandlers;

    public static class TtlFileInputStream {
        public final FileInputStream mStream;
        public long mTtl = (System.currentTimeMillis() + 30000);

        public TtlFileInputStream(String str) throws FileNotFoundException {
            this.mStream = new FileInputStream(str);
        }
    }

    public FileIoHandler() {
        HashMap hashMap = new HashMap();
        this.mRequestHandlers = hashMap;
        hashMap.put("fopen", new RequestOnlyHandler() {
            /* class com.facebook.react.packagerconnection.FileIoHandler.AnonymousClass1 */

            @Override // com.facebook.react.packagerconnection.RequestHandler, com.facebook.react.packagerconnection.RequestOnlyHandler
            public void onRequest(Object obj, Responder responder) {
                synchronized (FileIoHandler.this.mOpenFiles) {
                    try {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null) {
                            String optString = jSONObject.optString("mode");
                            if (optString != null) {
                                String optString2 = jSONObject.optString("filename");
                                if (optString2 == null) {
                                    throw new Exception("missing params.filename");
                                } else if (optString.equals("r")) {
                                    ((JSPackagerClient.ResponderImpl) responder).respond(Integer.valueOf(FileIoHandler.access$100(FileIoHandler.this, optString2)));
                                } else {
                                    throw new IllegalArgumentException("unsupported mode: " + optString);
                                }
                            } else {
                                throw new Exception("missing params.mode");
                            }
                        } else {
                            throw new Exception("params must be an object { mode: string, filename: string }");
                        }
                    } catch (Exception e) {
                        ((JSPackagerClient.ResponderImpl) responder).error(e.toString());
                    }
                }
            }
        });
        this.mRequestHandlers.put("fclose", new RequestOnlyHandler() {
            /* class com.facebook.react.packagerconnection.FileIoHandler.AnonymousClass2 */

            @Override // com.facebook.react.packagerconnection.RequestHandler, com.facebook.react.packagerconnection.RequestOnlyHandler
            public void onRequest(Object obj, Responder responder) {
                synchronized (FileIoHandler.this.mOpenFiles) {
                    try {
                        if (obj instanceof Number) {
                            TtlFileInputStream ttlFileInputStream = FileIoHandler.this.mOpenFiles.get(Integer.valueOf(((Integer) obj).intValue()));
                            if (ttlFileInputStream != null) {
                                FileIoHandler.this.mOpenFiles.remove(Integer.valueOf(((Integer) obj).intValue()));
                                ttlFileInputStream.mStream.close();
                                ((JSPackagerClient.ResponderImpl) responder).respond("");
                            } else {
                                throw new Exception("invalid file handle, it might have timed out");
                            }
                        } else {
                            throw new Exception("params must be a file handle");
                        }
                    } catch (Exception e) {
                        ((JSPackagerClient.ResponderImpl) responder).error(e.toString());
                    }
                }
            }
        });
        this.mRequestHandlers.put("fread", new RequestOnlyHandler() {
            /* class com.facebook.react.packagerconnection.FileIoHandler.AnonymousClass3 */

            @Override // com.facebook.react.packagerconnection.RequestHandler, com.facebook.react.packagerconnection.RequestOnlyHandler
            public void onRequest(Object obj, Responder responder) {
                synchronized (FileIoHandler.this.mOpenFiles) {
                    try {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null) {
                            int optInt = jSONObject.optInt(PromiseImpl.STACK_FRAME_KEY_FILE);
                            if (optInt != 0) {
                                int optInt2 = jSONObject.optInt("size");
                                if (optInt2 != 0) {
                                    TtlFileInputStream ttlFileInputStream = FileIoHandler.this.mOpenFiles.get(Integer.valueOf(optInt));
                                    if (ttlFileInputStream != null) {
                                        ttlFileInputStream.mTtl = System.currentTimeMillis() + 30000;
                                        byte[] bArr = new byte[optInt2];
                                        ((JSPackagerClient.ResponderImpl) responder).respond(Base64.encodeToString(bArr, 0, ttlFileInputStream.mStream.read(bArr), 0));
                                    } else {
                                        throw new Exception("invalid file handle, it might have timed out");
                                    }
                                } else {
                                    throw new Exception("invalid or missing read size");
                                }
                            } else {
                                throw new Exception("invalid or missing file handle");
                            }
                        } else {
                            throw new Exception("params must be an object { file: handle, size: number }");
                        }
                    } catch (Exception e) {
                        ((JSPackagerClient.ResponderImpl) responder).error(e.toString());
                    }
                }
            }
        });
    }

    public static int access$100(FileIoHandler fileIoHandler, String str) throws FileNotFoundException {
        int i = fileIoHandler.mNextHandle;
        fileIoHandler.mNextHandle = i + 1;
        fileIoHandler.mOpenFiles.put(Integer.valueOf(i), new TtlFileInputStream(str));
        if (fileIoHandler.mOpenFiles.size() == 1) {
            fileIoHandler.mHandler.postDelayed(fileIoHandler, 30000);
        }
        return i;
    }

    public void run() {
        synchronized (this.mOpenFiles) {
            Iterator<TtlFileInputStream> it = this.mOpenFiles.values().iterator();
            while (it.hasNext()) {
                TtlFileInputStream next = it.next();
                if (next != null) {
                    if (System.currentTimeMillis() >= next.mTtl) {
                        it.remove();
                        try {
                            next.mStream.close();
                        } catch (IOException e) {
                            String str = TAG;
                            FLog.e(str, "closing expired file failed: " + e.toString());
                        }
                    }
                } else {
                    throw null;
                }
            }
            if (!this.mOpenFiles.isEmpty()) {
                this.mHandler.postDelayed(this, 30000);
            }
        }
    }
}
