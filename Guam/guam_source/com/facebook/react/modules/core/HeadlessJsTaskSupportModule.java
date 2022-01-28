package com.facebook.react.modules.core;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = HeadlessJsTaskSupportModule.NAME)
public class HeadlessJsTaskSupportModule extends NativeHeadlessJsTaskSupportSpec {
    public static final String NAME = "HeadlessJsTaskSupport";

    public HeadlessJsTaskSupportModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec
    public void notifyTaskFinished(double d) {
        int i = (int) d;
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
        if (instance.isTaskRunning(i)) {
            instance.finishTask(i);
            return;
        }
        FLog.w(HeadlessJsTaskSupportModule.class, "Tried to finish non-active task with id %d. Did it time out?", Integer.valueOf(i));
    }

    @Override // com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec
    public void notifyTaskRetry(double d, Promise promise) {
        int i = (int) d;
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
        boolean z = false;
        if (instance.isTaskRunning(i)) {
            synchronized (instance) {
                HeadlessJsTaskConfig headlessJsTaskConfig = instance.mActiveTaskConfigs.get(Integer.valueOf(i));
                AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(headlessJsTaskConfig != null, "Tried to retrieve non-existent task config with id " + i + ".");
                HeadlessJsTaskRetryPolicy headlessJsTaskRetryPolicy = headlessJsTaskConfig.mRetryPolicy;
                if (headlessJsTaskRetryPolicy.canRetry()) {
                    Runnable runnable = instance.mTaskTimeouts.get(i);
                    if (runnable != null) {
                        instance.mHandler.removeCallbacks(runnable);
                        instance.mTaskTimeouts.remove(i);
                    }
                    UiThreadUtil.runOnUiThread(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0076: INVOKE  
                          (wrap: com.facebook.react.jstasks.HeadlessJsTaskContext$1 : 0x006e: CONSTRUCTOR  (r0v5 com.facebook.react.jstasks.HeadlessJsTaskContext$1) = 
                          (r13v1 'instance' com.facebook.react.jstasks.HeadlessJsTaskContext)
                          (wrap: com.facebook.react.jstasks.HeadlessJsTaskConfig : 0x0069: CONSTRUCTOR  (r1v5 com.facebook.react.jstasks.HeadlessJsTaskConfig) = 
                          (wrap: java.lang.String : 0x005c: IGET  (r5v2 java.lang.String) = (r0v4 'headlessJsTaskConfig' com.facebook.react.jstasks.HeadlessJsTaskConfig) com.facebook.react.jstasks.HeadlessJsTaskConfig.mTaskKey java.lang.String)
                          (wrap: com.facebook.react.bridge.WritableMap : 0x005e: IGET  (r6v0 com.facebook.react.bridge.WritableMap) = (r0v4 'headlessJsTaskConfig' com.facebook.react.jstasks.HeadlessJsTaskConfig) com.facebook.react.jstasks.HeadlessJsTaskConfig.mData com.facebook.react.bridge.WritableMap)
                          (wrap: long : 0x0060: IGET  (r7v0 long) = (r0v4 'headlessJsTaskConfig' com.facebook.react.jstasks.HeadlessJsTaskConfig) com.facebook.react.jstasks.HeadlessJsTaskConfig.mTimeout long)
                          (wrap: boolean : 0x0062: IGET  (r9v0 boolean) = (r0v4 'headlessJsTaskConfig' com.facebook.react.jstasks.HeadlessJsTaskConfig) com.facebook.react.jstasks.HeadlessJsTaskConfig.mAllowedInForeground boolean)
                          (wrap: com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy : 0x0064: INVOKE  (r10v0 com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy) = (r3v2 'headlessJsTaskRetryPolicy' com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy) type: INTERFACE call: com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy.update():com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy)
                         call: com.facebook.react.jstasks.HeadlessJsTaskConfig.<init>(java.lang.String, com.facebook.react.bridge.WritableMap, long, boolean, com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy):void type: CONSTRUCTOR)
                          (r12v1 'i' int)
                         call: com.facebook.react.jstasks.HeadlessJsTaskContext.1.<init>(com.facebook.react.jstasks.HeadlessJsTaskContext, com.facebook.react.jstasks.HeadlessJsTaskConfig, int):void type: CONSTRUCTOR)
                          (wrap: long : 0x0075: CAST (r3v3 long) = (long) (wrap: int : 0x0071: INVOKE  (r12v6 int) = (r3v2 'headlessJsTaskRetryPolicy' com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy) type: INTERFACE call: com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy.getDelay():int))
                         type: STATIC call: com.facebook.react.bridge.UiThreadUtil.runOnUiThread(java.lang.Runnable, long):void in method: com.facebook.react.modules.core.HeadlessJsTaskSupportModule.notifyTaskRetry(double, com.facebook.react.bridge.Promise):void, file: classes.dex
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
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:249)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:71)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006e: CONSTRUCTOR  (r0v5 com.facebook.react.jstasks.HeadlessJsTaskContext$1) = 
                          (r13v1 'instance' com.facebook.react.jstasks.HeadlessJsTaskContext)
                          (wrap: com.facebook.react.jstasks.HeadlessJsTaskConfig : 0x0069: CONSTRUCTOR  (r1v5 com.facebook.react.jstasks.HeadlessJsTaskConfig) = 
                          (wrap: java.lang.String : 0x005c: IGET  (r5v2 java.lang.String) = (r0v4 'headlessJsTaskConfig' com.facebook.react.jstasks.HeadlessJsTaskConfig) com.facebook.react.jstasks.HeadlessJsTaskConfig.mTaskKey java.lang.String)
                          (wrap: com.facebook.react.bridge.WritableMap : 0x005e: IGET  (r6v0 com.facebook.react.bridge.WritableMap) = (r0v4 'headlessJsTaskConfig' com.facebook.react.jstasks.HeadlessJsTaskConfig) com.facebook.react.jstasks.HeadlessJsTaskConfig.mData com.facebook.react.bridge.WritableMap)
                          (wrap: long : 0x0060: IGET  (r7v0 long) = (r0v4 'headlessJsTaskConfig' com.facebook.react.jstasks.HeadlessJsTaskConfig) com.facebook.react.jstasks.HeadlessJsTaskConfig.mTimeout long)
                          (wrap: boolean : 0x0062: IGET  (r9v0 boolean) = (r0v4 'headlessJsTaskConfig' com.facebook.react.jstasks.HeadlessJsTaskConfig) com.facebook.react.jstasks.HeadlessJsTaskConfig.mAllowedInForeground boolean)
                          (wrap: com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy : 0x0064: INVOKE  (r10v0 com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy) = (r3v2 'headlessJsTaskRetryPolicy' com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy) type: INTERFACE call: com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy.update():com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy)
                         call: com.facebook.react.jstasks.HeadlessJsTaskConfig.<init>(java.lang.String, com.facebook.react.bridge.WritableMap, long, boolean, com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy):void type: CONSTRUCTOR)
                          (r12v1 'i' int)
                         call: com.facebook.react.jstasks.HeadlessJsTaskContext.1.<init>(com.facebook.react.jstasks.HeadlessJsTaskContext, com.facebook.react.jstasks.HeadlessJsTaskConfig, int):void type: CONSTRUCTOR in method: com.facebook.react.modules.core.HeadlessJsTaskSupportModule.notifyTaskRetry(double, com.facebook.react.bridge.Promise):void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 33 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.react.jstasks.HeadlessJsTaskContext, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 39 more
                        */
                    /*
                    // Method dump skipped, instructions count: 155
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.core.HeadlessJsTaskSupportModule.notifyTaskRetry(double, com.facebook.react.bridge.Promise):void");
                }
            }
