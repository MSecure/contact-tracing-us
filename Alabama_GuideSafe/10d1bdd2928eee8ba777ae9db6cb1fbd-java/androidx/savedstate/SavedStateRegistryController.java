package androidx.savedstate;

import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;

public final class SavedStateRegistryController {
    public final SavedStateRegistryOwner mOwner;
    public final SavedStateRegistry mRegistry = new SavedStateRegistry();

    public SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.mOwner = savedStateRegistryOwner;
    }

    public void performRestore(Bundle bundle) {
        Lifecycle lifecycle = this.mOwner.getLifecycle();
        if (((LifecycleRegistry) lifecycle).mState == Lifecycle.State.INITIALIZED) {
            lifecycle.addObserver(new Recreator(this.mOwner));
            SavedStateRegistry savedStateRegistry = this.mRegistry;
            if (!savedStateRegistry.mRestored) {
                if (bundle != null) {
                    savedStateRegistry.mRestoredState = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                lifecycle.addObserver(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002e: INVOKE  
                      (r0v1 'lifecycle' androidx.lifecycle.Lifecycle)
                      (wrap: androidx.savedstate.SavedStateRegistry$1 : 0x002b: CONSTRUCTOR  (r4v3 androidx.savedstate.SavedStateRegistry$1) = (r1v4 'savedStateRegistry' androidx.savedstate.SavedStateRegistry) call: androidx.savedstate.SavedStateRegistry.1.<init>(androidx.savedstate.SavedStateRegistry):void type: CONSTRUCTOR)
                     type: VIRTUAL call: androidx.lifecycle.Lifecycle.addObserver(androidx.lifecycle.LifecycleObserver):void in method: androidx.savedstate.SavedStateRegistryController.performRestore(android.os.Bundle):void, file: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002b: CONSTRUCTOR  (r4v3 androidx.savedstate.SavedStateRegistry$1) = (r1v4 'savedStateRegistry' androidx.savedstate.SavedStateRegistry) call: androidx.savedstate.SavedStateRegistry.1.<init>(androidx.savedstate.SavedStateRegistry):void type: CONSTRUCTOR in method: androidx.savedstate.SavedStateRegistryController.performRestore(android.os.Bundle):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 28 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.savedstate.SavedStateRegistry, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 34 more
                    */
                /*
                    this = this;
                    androidx.savedstate.SavedStateRegistryOwner r0 = r3.mOwner
                    androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
                    r1 = r0
                    androidx.lifecycle.LifecycleRegistry r1 = (androidx.lifecycle.LifecycleRegistry) r1
                    androidx.lifecycle.Lifecycle$State r1 = r1.mState
                    androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.INITIALIZED
                    if (r1 != r2) goto L_0x003d
                    androidx.savedstate.Recreator r1 = new androidx.savedstate.Recreator
                    androidx.savedstate.SavedStateRegistryOwner r2 = r3.mOwner
                    r1.<init>(r2)
                    r0.addObserver(r1)
                    androidx.savedstate.SavedStateRegistry r1 = r3.mRegistry
                    boolean r2 = r1.mRestored
                    if (r2 != 0) goto L_0x0035
                    if (r4 == 0) goto L_0x0029
                    java.lang.String r2 = "androidx.lifecycle.BundlableSavedStateRegistry.key"
                    android.os.Bundle r4 = r4.getBundle(r2)
                    r1.mRestoredState = r4
                L_0x0029:
                    androidx.savedstate.SavedStateRegistry$1 r4 = new androidx.savedstate.SavedStateRegistry$1
                    r4.<init>()
                    r0.addObserver(r4)
                    r4 = 1
                    r1.mRestored = r4
                    return
                L_0x0035:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r0 = "SavedStateRegistry was already restored."
                    r4.<init>(r0)
                    throw r4
                L_0x003d:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r0 = "Restarter must be created only during owner's initialization stage"
                    r4.<init>(r0)
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.savedstate.SavedStateRegistryController.performRestore(android.os.Bundle):void");
            }

            public void performSave(Bundle bundle) {
                SavedStateRegistry savedStateRegistry = this.mRegistry;
                if (savedStateRegistry != null) {
                    Bundle bundle2 = new Bundle();
                    Bundle bundle3 = savedStateRegistry.mRestoredState;
                    if (bundle3 != null) {
                        bundle2.putAll(bundle3);
                    }
                    SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = savedStateRegistry.mComponents.iteratorWithAdditions();
                    while (iteratorWithAdditions.hasNext()) {
                        Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
                        bundle2.putBundle((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
                    }
                    bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
                    return;
                }
                throw null;
            }
        }
