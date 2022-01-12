package com.bugsnag.android;

import com.bugsnag.android.StateEvent;
import com.bugsnag.android.ndk.NativeBridge;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class NdkPlugin implements Plugin {
    public static final Companion Companion = new Companion(null);
    public static final String LOAD_ERR_MSG;
    public final LibraryLoader loader = new LibraryLoader();
    public NativeBridge nativeBridge;

    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    private final native void disableCrashReporting();

    private final native void enableCrashReporting();

    @Override // com.bugsnag.android.Plugin
    public void load(Client client) {
        Intrinsics.checkParameterIsNotNull(client, "client");
        if (this.loader.loadLibrary("bugsnag-ndk", client, NdkPlugin$load$loaded$1.INSTANCE)) {
            if (this.nativeBridge == null) {
                NativeBridge nativeBridge2 = new NativeBridge();
                this.nativeBridge = nativeBridge2;
                client.registerObserver(nativeBridge2);
                ClientObservable clientObservable = client.clientObservable;
                ImmutableConfig immutableConfig = client.immutableConfig;
                if (clientObservable != null) {
                    Intrinsics.checkParameterIsNotNull(immutableConfig, "conf");
                    clientObservable.notifyObservers(new StateEvent.Install(immutableConfig.enabledErrorTypes.ndkCrashes, immutableConfig.appVersion, immutableConfig.buildUuid, immutableConfig.releaseStage));
                    try {
                        Async.EXECUTOR.execute(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0043: INVOKE  
                              (wrap: java.util.concurrent.ThreadPoolExecutor : 0x0041: SGET  (r1v4 java.util.concurrent.ThreadPoolExecutor) =  com.bugsnag.android.Async.EXECUTOR java.util.concurrent.ThreadPoolExecutor)
                              (wrap: com.bugsnag.android.Client$5 : 0x003e: CONSTRUCTOR  (r0v9 com.bugsnag.android.Client$5) = (r7v0 'client' com.bugsnag.android.Client) call: com.bugsnag.android.Client.5.<init>(com.bugsnag.android.Client):void type: CONSTRUCTOR)
                             type: VIRTUAL call: java.util.concurrent.ThreadPoolExecutor.execute(java.lang.Runnable):void in method: com.bugsnag.android.NdkPlugin.load(com.bugsnag.android.Client):void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003e: CONSTRUCTOR  (r0v9 com.bugsnag.android.Client$5) = (r7v0 'client' com.bugsnag.android.Client) call: com.bugsnag.android.Client.5.<init>(com.bugsnag.android.Client):void type: CONSTRUCTOR in method: com.bugsnag.android.NdkPlugin.load(com.bugsnag.android.Client):void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 36 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.bugsnag.android.Client, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 42 more
                            */
                        /*
                        // Method dump skipped, instructions count: 104
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.NdkPlugin.load(com.bugsnag.android.Client):void");
                    }

                    public void unload() {
                        disableCrashReporting();
                    }
                }
