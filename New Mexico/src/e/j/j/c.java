package e.j.j;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import e.j.j.c0.b;
import e.j.j.c0.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class c {
    public static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();
    public final View.AccessibilityDelegate a;
    public final View.AccessibilityDelegate b;

    /* loaded from: classes.dex */
    public static final class a extends View.AccessibilityDelegate {
        public final c a;

        public a(c cVar) {
            this.a = cVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            e.j.j.c0.c b = this.a.b(view);
            if (b != null) {
                return (AccessibilityNodeProvider) b.a;
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            int i2;
            b bVar = new b(accessibilityNodeInfo);
            AtomicInteger atomicInteger = v.a;
            Boolean d2 = new r(R$id.tag_screen_reader_focusable, Boolean.class, 28).d(view);
            boolean z = true;
            boolean z2 = d2 != null && d2.booleanValue();
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28) {
                bVar.a.setScreenReaderFocusable(z2);
            } else {
                bVar.h(1, z2);
            }
            Boolean d3 = new u(R$id.tag_accessibility_heading, Boolean.class, 28).d(view);
            boolean z3 = d3 != null && d3.booleanValue();
            if (i3 >= 28) {
                bVar.a.setHeading(z3);
            } else {
                bVar.h(2, z3);
            }
            CharSequence i4 = v.i(view);
            AccessibilityNodeInfo accessibilityNodeInfo2 = bVar.a;
            if (i3 >= 28) {
                accessibilityNodeInfo2.setPaneTitle(i4);
            } else {
                accessibilityNodeInfo2.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", i4);
            }
            CharSequence d4 = new t(R$id.tag_state_description, CharSequence.class, 64, 30).d(view);
            if (i3 < 30) {
                z = false;
            }
            if (z) {
                bVar.a.setStateDescription(d4);
            } else {
                bVar.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", d4);
            }
            this.a.d(view, bVar);
            CharSequence text = accessibilityNodeInfo.getText();
            if (i3 < 26) {
                bVar.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
                bVar.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
                bVar.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
                bVar.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
                SparseArray sparseArray = (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
                if (sparseArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < sparseArray.size(); i5++) {
                        if (((WeakReference) sparseArray.valueAt(i5)).get() == null) {
                            arrayList.add(Integer.valueOf(i5));
                        }
                    }
                    for (int i6 = 0; i6 < arrayList.size(); i6++) {
                        sparseArray.remove(((Integer) arrayList.get(i6)).intValue());
                    }
                }
                ClickableSpan[] d5 = b.d(text);
                if (d5 != null && d5.length > 0) {
                    bVar.f().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.accessibility_action_clickable_span);
                    int i7 = R$id.tag_accessibility_clickable_spans;
                    SparseArray sparseArray2 = (SparseArray) view.getTag(i7);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        view.setTag(i7, sparseArray2);
                    }
                    for (int i8 = 0; i8 < d5.length; i8++) {
                        ClickableSpan clickableSpan = d5[i8];
                        int i9 = 0;
                        while (true) {
                            if (i9 >= sparseArray2.size()) {
                                i2 = b.f1623d;
                                b.f1623d = i2 + 1;
                                break;
                            } else if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i9)).get())) {
                                i2 = sparseArray2.keyAt(i9);
                                break;
                            } else {
                                i9++;
                            }
                        }
                        sparseArray2.put(i2, new WeakReference(d5[i8]));
                        ClickableSpan clickableSpan2 = d5[i8];
                        Spanned spanned = (Spanned) text;
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                        bVar.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i2));
                    }
                }
            }
            List list = (List) view.getTag(R$id.tag_accessibility_actions);
            if (list == null) {
                list = Collections.emptyList();
            }
            for (int i10 = 0; i10 < list.size(); i10++) {
                bVar.a((b.a) list.get(i10));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.e(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.f(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.a.g(view, i2, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i2) {
            this.a.h(view, i2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.i(view, accessibilityEvent);
        }
    }

    public c() {
        this.a = c;
        this.b = new a(this);
    }

    public c(View.AccessibilityDelegate accessibilityDelegate) {
        this.a = accessibilityDelegate;
        this.b = new a(this);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public e.j.j.c0.c b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new e.j.j.c0.c(accessibilityNodeProvider);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i2, Bundle bundle) {
        boolean z;
        WeakReference weakReference;
        boolean z2;
        List list = (List) view.getTag(R$id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        boolean z3 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                break;
            }
            b.a aVar = (b.a) list.get(i3);
            if (aVar.a() != i2) {
                i3++;
            } else if (aVar.f1632d != null) {
                d.a aVar2 = null;
                Class<? extends d.a> cls = aVar.c;
                if (cls != null) {
                    try {
                        d.a aVar3 = (d.a) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        try {
                            Objects.requireNonNull(aVar3);
                        } catch (Exception unused) {
                        }
                        aVar2 = aVar3;
                    } catch (Exception unused2) {
                    }
                }
                z = aVar.f1632d.a(view, aVar2);
            }
        }
        z = false;
        if (!z) {
            z = this.a.performAccessibilityAction(view, i2, bundle);
        }
        if (z || i2 != R$id.accessibility_action_clickable_span) {
            return z;
        }
        int i4 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
        if (!(sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i4)) == null)) {
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (clickableSpan != null) {
                ClickableSpan[] d2 = b.d(view.createAccessibilityNodeInfo().getText());
                int i5 = 0;
                while (d2 != null && i5 < d2.length) {
                    if (clickableSpan.equals(d2[i5])) {
                        z2 = true;
                        break;
                    }
                    i5++;
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

    public void h(View view, int i2) {
        this.a.sendAccessibilityEvent(view, i2);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
