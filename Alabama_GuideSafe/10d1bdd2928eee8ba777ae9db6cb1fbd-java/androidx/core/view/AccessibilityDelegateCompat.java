package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class AccessibilityDelegateCompat {
    public static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    public final View.AccessibilityDelegate mBridge;
    public final View.AccessibilityDelegate mOriginalDelegate;

    public static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
        public final AccessibilityDelegateCompat mCompat;

        public AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            this.mCompat = accessibilityDelegateCompat;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProviderCompat accessibilityNodeProvider = this.mCompat.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.mProvider;
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            boolean z;
            int i;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
            boolean isScreenReaderFocusable = ViewCompat.isScreenReaderFocusable(view);
            if (Build.VERSION.SDK_INT >= 28) {
                accessibilityNodeInfoCompat.mInfo.setScreenReaderFocusable(isScreenReaderFocusable);
            } else {
                accessibilityNodeInfoCompat.setBooleanProperty(1, isScreenReaderFocusable);
            }
            Boolean bool = (Boolean) 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002a: CHECK_CAST (r3v3 'bool' java.lang.Boolean) = (java.lang.Boolean) (wrap: java.lang.Object : 0x0026: INVOKE  (r3v2 java.lang.Object) = 
                  (wrap: androidx.core.view.ViewCompat$5 : 0x0023: CONSTRUCTOR  (r3v1 androidx.core.view.ViewCompat$5) = 
                  (wrap: int : 0x001f: SGET  (r4v1 int) =  androidx.core.R$id.tag_accessibility_heading int)
                  (wrap: java.lang.Class : 0x0021: CONST_CLASS   java.lang.Boolean.class)
                  (28 int)
                 call: androidx.core.view.ViewCompat.5.<init>(int, java.lang.Class, int):void type: CONSTRUCTOR)
                  (r18v0 'view' android.view.View)
                 type: VIRTUAL call: androidx.core.view.ViewCompat.AccessibilityViewProperty.get(android.view.View):java.lang.Object) in method: androidx.core.view.AccessibilityDelegateCompat.AccessibilityDelegateAdapter.onInitializeAccessibilityNodeInfo(android.view.View, android.view.accessibility.AccessibilityNodeInfo):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: INVOKE  (r3v2 java.lang.Object) = 
                  (wrap: androidx.core.view.ViewCompat$5 : 0x0023: CONSTRUCTOR  (r3v1 androidx.core.view.ViewCompat$5) = 
                  (wrap: int : 0x001f: SGET  (r4v1 int) =  androidx.core.R$id.tag_accessibility_heading int)
                  (wrap: java.lang.Class : 0x0021: CONST_CLASS   java.lang.Boolean.class)
                  (28 int)
                 call: androidx.core.view.ViewCompat.5.<init>(int, java.lang.Class, int):void type: CONSTRUCTOR)
                  (r18v0 'view' android.view.View)
                 type: VIRTUAL call: androidx.core.view.ViewCompat.AccessibilityViewProperty.get(android.view.View):java.lang.Object in method: androidx.core.view.AccessibilityDelegateCompat.AccessibilityDelegateAdapter.onInitializeAccessibilityNodeInfo(android.view.View, android.view.accessibility.AccessibilityNodeInfo):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:290)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0023: CONSTRUCTOR  (r3v1 androidx.core.view.ViewCompat$5) = 
                  (wrap: int : 0x001f: SGET  (r4v1 int) =  androidx.core.R$id.tag_accessibility_heading int)
                  (wrap: java.lang.Class : 0x0021: CONST_CLASS   java.lang.Boolean.class)
                  (28 int)
                 call: androidx.core.view.ViewCompat.5.<init>(int, java.lang.Class, int):void type: CONSTRUCTOR in method: androidx.core.view.AccessibilityDelegateCompat.AccessibilityDelegateAdapter.onInitializeAccessibilityNodeInfo(android.view.View, android.view.accessibility.AccessibilityNodeInfo):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 18 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.core.view.ViewCompat, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 24 more
                */
            /*
            // Method dump skipped, instructions count: 425
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.AccessibilityDelegateCompat.AccessibilityDelegateAdapter.onInitializeAccessibilityNodeInfo(android.view.View, android.view.accessibility.AccessibilityNodeInfo):void");
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.mCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.mCompat.performAccessibilityAction(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.mCompat.sendAccessibilityEvent(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    public AccessibilityDelegateCompat() {
        this.mOriginalDelegate = DEFAULT_DELEGATE;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        boolean z;
        WeakReference weakReference;
        boolean z2;
        String str;
        List list = (List) view.getTag(R$id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        boolean z3 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                break;
            }
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = (AccessibilityNodeInfoCompat.AccessibilityActionCompat) list.get(i2);
            if (accessibilityActionCompat.getId() != i) {
                i2++;
            } else if (accessibilityActionCompat.mCommand != null) {
                Class<? extends AccessibilityViewCommand.CommandArguments> cls = accessibilityActionCompat.mViewCommandArgumentClass;
                if (cls != null) {
                    try {
                        ((AccessibilityViewCommand.CommandArguments) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).mBundle = bundle;
                    } catch (Exception e) {
                        Class<? extends AccessibilityViewCommand.CommandArguments> cls2 = accessibilityActionCompat.mViewCommandArgumentClass;
                        if (cls2 == null) {
                            str = "null";
                        } else {
                            str = cls2.getName();
                        }
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + str, e);
                    }
                }
                BottomSheetBehavior.AnonymousClass4 r0 = (BottomSheetBehavior.AnonymousClass4) accessibilityActionCompat.mCommand;
                BottomSheetBehavior.this.setState(r4);
                z = true;
            }
        }
        z = false;
        if (!z) {
            z = this.mOriginalDelegate.performAccessibilityAction(view, i, bundle);
        }
        if (z || i != R$id.accessibility_action_clickable_span) {
            return z;
        }
        int i3 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
        if (!(sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i3)) == null)) {
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (clickableSpan != null) {
                ClickableSpan[] clickableSpans = AccessibilityNodeInfoCompat.getClickableSpans(view.createAccessibilityNodeInfo().getText());
                int i4 = 0;
                while (true) {
                    if (clickableSpans == null || i4 >= clickableSpans.length) {
                        break;
                    } else if (clickableSpan.equals(clickableSpans[i4])) {
                        z2 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            z2 = false;
            if (z2) {
                clickableSpan.onClick(view);
                z3 = true;
            }
        }
        return z3;
    }

    public void sendAccessibilityEvent(View view, int i) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }
}
