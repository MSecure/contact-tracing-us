package com.facebook.react.modules.core;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ChoreographerCompat;
import java.util.ArrayDeque;

public class ReactChoreographer {
    public static ReactChoreographer sInstance;
    public final ArrayDeque<ChoreographerCompat.FrameCallback>[] mCallbackQueues;
    public final Object mCallbackQueuesLock = new Object();
    public volatile ChoreographerCompat mChoreographer;
    public boolean mHasPostedCallback;
    public final ReactChoreographerDispatcher mReactChoreographerDispatcher;
    public int mTotalCallbacks;

    public enum CallbackType {
        PERF_MARKERS(0),
        DISPATCH_UI(1),
        NATIVE_ANIMATED_MODULE(2),
        TIMERS_EVENTS(3),
        IDLE_EVENT(4);
        
        public final int mOrder;

        /* access modifiers changed from: public */
        CallbackType(int i) {
            this.mOrder = i;
        }
    }

    public class ReactChoreographerDispatcher extends ChoreographerCompat.FrameCallback {
        public ReactChoreographerDispatcher(AnonymousClass1 r2) {
        }

        @Override // com.facebook.react.modules.core.ChoreographerCompat.FrameCallback
        public void doFrame(long j) {
            synchronized (ReactChoreographer.this.mCallbackQueuesLock) {
                ReactChoreographer.this.mHasPostedCallback = false;
                for (int i = 0; i < ReactChoreographer.this.mCallbackQueues.length; i++) {
                    ArrayDeque<ChoreographerCompat.FrameCallback> arrayDeque = ReactChoreographer.this.mCallbackQueues[i];
                    int size = arrayDeque.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ChoreographerCompat.FrameCallback pollFirst = arrayDeque.pollFirst();
                        if (pollFirst != null) {
                            pollFirst.doFrame(j);
                            ReactChoreographer reactChoreographer = ReactChoreographer.this;
                            reactChoreographer.mTotalCallbacks--;
                        } else {
                            FLog.e("ReactNative", "Tried to execute non-existent frame callback");
                        }
                    }
                }
                ReactChoreographer.this.maybeRemoveFrameCallback();
            }
        }
    }

    public ReactChoreographer() {
        int i = 0;
        this.mTotalCallbacks = 0;
        this.mHasPostedCallback = false;
        this.mReactChoreographerDispatcher = new ReactChoreographerDispatcher(null);
        this.mCallbackQueues = new ArrayDeque[CallbackType.values().length];
        while (true) {
            ArrayDeque<ChoreographerCompat.FrameCallback>[] arrayDequeArr = this.mCallbackQueues;
            if (i < arrayDequeArr.length) {
                arrayDequeArr[i] = new ArrayDeque<>();
                i++;
            } else {
                UiThreadUtil.runOnUiThread(new Runnable(null) {
                    /* class com.facebook.react.modules.core.ReactChoreographer.AnonymousClass2 */

                    public void run() {
                        synchronized (ReactChoreographer.class) {
                            if (ReactChoreographer.this.mChoreographer == null) {
                                ReactChoreographer reactChoreographer = ReactChoreographer.this;
                                UiThreadUtil.assertOnUiThread();
                                if (ChoreographerCompat.sInstance == null) {
                                    ChoreographerCompat.sInstance = new ChoreographerCompat();
                                }
                                reactChoreographer.mChoreographer = ChoreographerCompat.sInstance;
                            }
                        }
                        Runnable runnable = r3;
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
                return;
            }
        }
    }

    public static ReactChoreographer getInstance() {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(sInstance, "ReactChoreographer needs to be initialized.");
        return sInstance;
    }

    public final void maybeRemoveFrameCallback() {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(this.mTotalCallbacks >= 0);
        if (this.mTotalCallbacks == 0 && this.mHasPostedCallback) {
            if (this.mChoreographer != null) {
                ChoreographerCompat choreographerCompat = this.mChoreographer;
                ReactChoreographerDispatcher reactChoreographerDispatcher = this.mReactChoreographerDispatcher;
                if (choreographerCompat != null) {
                    if (reactChoreographerDispatcher.mFrameCallback == null) {
                        reactChoreographerDispatcher.mFrameCallback = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: IPUT  
                              (wrap: com.facebook.react.modules.core.ChoreographerCompat$FrameCallback$1 : 0x0023: CONSTRUCTOR  (r3v1 com.facebook.react.modules.core.ChoreographerCompat$FrameCallback$1) = (r2v0 'reactChoreographerDispatcher' com.facebook.react.modules.core.ReactChoreographer$ReactChoreographerDispatcher) call: com.facebook.react.modules.core.ChoreographerCompat.FrameCallback.1.<init>(com.facebook.react.modules.core.ChoreographerCompat$FrameCallback):void type: CONSTRUCTOR)
                              (r2v0 'reactChoreographerDispatcher' com.facebook.react.modules.core.ReactChoreographer$ReactChoreographerDispatcher)
                             com.facebook.react.modules.core.ChoreographerCompat.FrameCallback.mFrameCallback android.view.Choreographer$FrameCallback in method: com.facebook.react.modules.core.ReactChoreographer.maybeRemoveFrameCallback():void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0023: CONSTRUCTOR  (r3v1 com.facebook.react.modules.core.ChoreographerCompat$FrameCallback$1) = (r2v0 'reactChoreographerDispatcher' com.facebook.react.modules.core.ReactChoreographer$ReactChoreographerDispatcher) call: com.facebook.react.modules.core.ChoreographerCompat.FrameCallback.1.<init>(com.facebook.react.modules.core.ChoreographerCompat$FrameCallback):void type: CONSTRUCTOR in method: com.facebook.react.modules.core.ReactChoreographer.maybeRemoveFrameCallback():void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 36 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.react.modules.core.ChoreographerCompat, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 40 more
                            */
                        /*
                            this = this;
                            int r0 = r4.mTotalCallbacks
                            r1 = 0
                            if (r0 < 0) goto L_0x0007
                            r0 = 1
                            goto L_0x0008
                        L_0x0007:
                            r0 = r1
                        L_0x0008:
                            androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(r0)
                            int r0 = r4.mTotalCallbacks
                            if (r0 != 0) goto L_0x0034
                            boolean r0 = r4.mHasPostedCallback
                            if (r0 == 0) goto L_0x0034
                            com.facebook.react.modules.core.ChoreographerCompat r0 = r4.mChoreographer
                            if (r0 == 0) goto L_0x0032
                            com.facebook.react.modules.core.ChoreographerCompat r0 = r4.mChoreographer
                            com.facebook.react.modules.core.ReactChoreographer$ReactChoreographerDispatcher r2 = r4.mReactChoreographerDispatcher
                            if (r0 == 0) goto L_0x0030
                            android.view.Choreographer$FrameCallback r3 = r2.mFrameCallback
                            if (r3 != 0) goto L_0x0028
                            com.facebook.react.modules.core.ChoreographerCompat$FrameCallback$1 r3 = new com.facebook.react.modules.core.ChoreographerCompat$FrameCallback$1
                            r3.<init>()
                            r2.mFrameCallback = r3
                        L_0x0028:
                            android.view.Choreographer$FrameCallback r2 = r2.mFrameCallback
                            android.view.Choreographer r0 = r0.mChoreographer
                            r0.removeFrameCallback(r2)
                            goto L_0x0032
                        L_0x0030:
                            r0 = 0
                            throw r0
                        L_0x0032:
                            r4.mHasPostedCallback = r1
                        L_0x0034:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.core.ReactChoreographer.maybeRemoveFrameCallback():void");
                    }

                    public void postFrameCallback(CallbackType callbackType, ChoreographerCompat.FrameCallback frameCallback) {
                        synchronized (this.mCallbackQueuesLock) {
                            this.mCallbackQueues[callbackType.mOrder].addLast(frameCallback);
                            int i = this.mTotalCallbacks + 1;
                            this.mTotalCallbacks = i;
                            AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(i > 0);
                            if (!this.mHasPostedCallback) {
                                if (this.mChoreographer == null) {
                                    final AnonymousClass1 r3 = new Runnable() {
                                        /* class com.facebook.react.modules.core.ReactChoreographer.AnonymousClass1 */

                                        public void run() {
                                            ReactChoreographer reactChoreographer = ReactChoreographer.this;
                                            reactChoreographer.mChoreographer.postFrameCallback(reactChoreographer.mReactChoreographerDispatcher);
                                            reactChoreographer.mHasPostedCallback = true;
                                        }
                                    };
                                    UiThreadUtil.runOnUiThread(new Runnable() {
                                        /* class com.facebook.react.modules.core.ReactChoreographer.AnonymousClass2 */

                                        public void run() {
                                            synchronized (ReactChoreographer.class) {
                                                if (ReactChoreographer.this.mChoreographer == null) {
                                                    ReactChoreographer reactChoreographer = ReactChoreographer.this;
                                                    UiThreadUtil.assertOnUiThread();
                                                    if (ChoreographerCompat.sInstance == null) {
                                                        ChoreographerCompat.sInstance = new ChoreographerCompat();
                                                    }
                                                    reactChoreographer.mChoreographer = ChoreographerCompat.sInstance;
                                                }
                                            }
                                            Runnable runnable = r3;
                                            if (runnable != null) {
                                                runnable.run();
                                            }
                                        }
                                    });
                                } else {
                                    this.mChoreographer.postFrameCallback(this.mReactChoreographerDispatcher);
                                    this.mHasPostedCallback = true;
                                }
                            }
                        }
                    }

                    public void removeFrameCallback(CallbackType callbackType, ChoreographerCompat.FrameCallback frameCallback) {
                        synchronized (this.mCallbackQueuesLock) {
                            if (this.mCallbackQueues[callbackType.mOrder].removeFirstOccurrence(frameCallback)) {
                                this.mTotalCallbacks--;
                                maybeRemoveFrameCallback();
                            } else {
                                FLog.e("ReactNative", "Tried to remove non-existent frame callback");
                            }
                        }
                    }
                }
