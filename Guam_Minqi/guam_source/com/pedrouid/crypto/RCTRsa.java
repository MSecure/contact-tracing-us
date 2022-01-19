package com.pedrouid.crypto;

import android.os.AsyncTask;
import android.util.Base64;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeMap;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import javax.crypto.Cipher;

public class RCTRsa extends ReactContextBaseJavaModule {
    public final ReactApplicationContext reactContext;

    public RCTRsa(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getAlgorithmFromHash(String str) {
        if (str.equals("Raw")) {
            return "NONEwithRSA";
        }
        if (str.equals("SHA1")) {
            return "SHA1withRSA";
        }
        if (str.equals("SHA224")) {
            return "SHA224withRSA";
        }
        if (str.equals("SHA256")) {
            return "SHA256withRSA";
        }
        if (str.equals("SHA384")) {
            return "SHA384withRSA";
        }
        return "SHA1withRSA";
    }

    @ReactMethod
    public void decrypt(final String str, final String str2, final Promise promise) {
        AsyncTask.execute(new Runnable(this) {
            /* class com.pedrouid.crypto.RCTRsa.AnonymousClass4 */

            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPrivateKey(str2);
                    byte[] decode = Base64.decode(str, 0);
                    Cipher instance = Cipher.getInstance("RSA/NONE/PKCS1Padding");
                    instance.init(2, rsa.privateKey);
                    promise.resolve(new String(instance.doFinal(decode), RSA.CharsetUTF_8));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void decrypt64(final String str, final String str2, final Promise promise) {
        AsyncTask.execute(new Runnable(this) {
            /* class com.pedrouid.crypto.RCTRsa.AnonymousClass5 */

            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPrivateKey(str2);
                    byte[] decode = Base64.decode(str, 0);
                    Cipher instance = Cipher.getInstance("RSA/NONE/PKCS1Padding");
                    instance.init(2, rsa.privateKey);
                    promise.resolve(Base64.encodeToString(instance.doFinal(decode), 0));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void encrypt(final String str, final String str2, final Promise promise) {
        AsyncTask.execute(new Runnable(this) {
            /* class com.pedrouid.crypto.RCTRsa.AnonymousClass2 */

            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPublicKey(str2);
                    byte[] bytes = str.getBytes(RSA.CharsetUTF_8);
                    Cipher instance = Cipher.getInstance("RSA/NONE/PKCS1Padding");
                    instance.init(1, rsa.publicKey);
                    promise.resolve(Base64.encodeToString(instance.doFinal(bytes), 0));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void encrypt64(final String str, final String str2, final Promise promise) {
        AsyncTask.execute(new Runnable(this) {
            /* class com.pedrouid.crypto.RCTRsa.AnonymousClass3 */

            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPublicKey(str2);
                    byte[] decode = Base64.decode(str, 0);
                    Cipher instance = Cipher.getInstance("RSA/NONE/PKCS1Padding");
                    instance.init(1, rsa.publicKey);
                    promise.resolve(Base64.encodeToString(instance.doFinal(decode), 0));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void generate(Promise promise) {
        generateKeys(2048, promise);
    }

    @ReactMethod
    public void generateKeys(final int i, final Promise promise) {
        AsyncTask.execute(new Runnable(this) {
            /* class com.pedrouid.crypto.RCTRsa.AnonymousClass1 */

            public void run() {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                try {
                    RSA rsa = new RSA();
                    rsa.generate(i);
                    writableNativeMap.putString("public", rsa.getPublicKey());
                    writableNativeMap.putString("private", rsa.getPrivateKey());
                    promise.resolve(writableNativeMap);
                } catch (NoSuchAlgorithmException e) {
                    promise.reject("Error", e.getMessage());
                } catch (Exception e2) {
                    promise.reject("Error", e2.getMessage());
                }
            }
        });
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTRsa";
    }

    @ReactMethod
    public void sign(final String str, final String str2, final String str3, final Promise promise) {
        AsyncTask.execute(new Runnable() {
            /* class com.pedrouid.crypto.RCTRsa.AnonymousClass6 */

            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPrivateKey(str2);
                    String str = str;
                    promise.resolve(rsa.sign(str.getBytes(RSA.CharsetUTF_8), RCTRsa.this.getAlgorithmFromHash(str3)));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void sign64(final String str, final String str2, final String str3, final Promise promise) {
        AsyncTask.execute(new Runnable() {
            /* class com.pedrouid.crypto.RCTRsa.AnonymousClass7 */

            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPrivateKey(str2);
                    String str = str;
                    promise.resolve(rsa.sign(Base64.decode(str, 0), RCTRsa.this.getAlgorithmFromHash(str3)));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void verify(final String str, final String str2, final String str3, final String str4, final Promise promise) {
        AsyncTask.execute(new Runnable() {
            /* class com.pedrouid.crypto.RCTRsa.AnonymousClass8 */

            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPublicKey(str3);
                    String str = str;
                    String str2 = str2;
                    String algorithmFromHash = RCTRsa.this.getAlgorithmFromHash(str4);
                    Signature.getInstance(algorithmFromHash).initVerify(rsa.publicKey);
                    byte[] bytes = str2.getBytes(RSA.CharsetUTF_8);
                    byte[] decode = Base64.decode(str, 0);
                    Signature instance = Signature.getInstance(algorithmFromHash);
                    instance.initVerify(rsa.publicKey);
                    instance.update(bytes);
                    promise.resolve(Boolean.valueOf(instance.verify(decode)));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void verify64(final String str, final String str2, final String str3, final String str4, final Promise promise) {
        AsyncTask.execute(new Runnable() {
            /* class com.pedrouid.crypto.RCTRsa.AnonymousClass9 */

            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPublicKey(str3);
                    String str = str;
                    String str2 = str2;
                    String algorithmFromHash = RCTRsa.this.getAlgorithmFromHash(str4);
                    Signature.getInstance(algorithmFromHash).initVerify(rsa.publicKey);
                    byte[] decode = Base64.decode(str2, 0);
                    byte[] decode2 = Base64.decode(str, 0);
                    Signature instance = Signature.getInstance(algorithmFromHash);
                    instance.initVerify(rsa.publicKey);
                    instance.update(decode);
                    promise.resolve(Boolean.valueOf(instance.verify(decode2)));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }
}
