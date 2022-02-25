package e.i.i;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import e.i.i.w.b;
import e.i.i.w.c;
import e.i.i.w.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    public static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();
    public final View.AccessibilityDelegate a;
    public final View.AccessibilityDelegate b;

    /* renamed from: e.i.i.a$a  reason: collision with other inner class name */
    public static final class C0034a extends View.AccessibilityDelegate {
        public final a a;

        public C0034a(a aVar) {
            this.a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            c b = this.a.b(view);
            if (b != null) {
                return (AccessibilityNodeProvider) b.a;
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.c(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            int i2;
            b bVar = new b(accessibilityNodeInfo);
            AtomicInteger atomicInteger = l.a;
            Boolean bool = (Boolean) new m(R$id.tag_screen_reader_focusable, Boolean.class, 28).c(view);
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            int i3 = Build.VERSION.SDK_INT;
            boolean z = true;
            if (i3 >= 28) {
                bVar.a.setScreenReaderFocusable(booleanValue);
            } else {
                bVar.h(1, booleanValue);
            }
            Boolean bool2 = (Boolean) new p(R$id.tag_accessibility_heading, Boolean.class, 28).c(view);
            boolean booleanValue2 = bool2 == null ? false : bool2.booleanValue();
            if (i3 >= 28) {
                bVar.a.setHeading(booleanValue2);
            } else {
                bVar.h(2, booleanValue2);
            }
            CharSequence charSequence = (CharSequence) new n(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28).c(view);
            AccessibilityNodeInfo accessibilityNodeInfo2 = bVar.a;
            if (i3 >= 28) {
                accessibilityNodeInfo2.setPaneTitle(charSequence);
            } else {
                accessibilityNodeInfo2.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
            }
            CharSequence charSequence2 = (CharSequence) new o(R$id.tag_state_description, CharSequence.class, 64, 30).c(view);
            if (i3 < 30 && !Build.VERSION.CODENAME.equals("R")) {
                z = false;
            }
            if (z) {
                bVar.a.setStateDescription(charSequence2);
            } else {
                bVar.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence2);
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
                    for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                        if (((WeakReference) sparseArray.valueAt(i4)).get() == null) {
                            arrayList.add(Integer.valueOf(i4));
                        }
                    }
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        sparseArray.remove(((Integer) arrayList.get(i5)).intValue());
                    }
                }
                ClickableSpan[] d2 = b.d(text);
                if (d2 != null && d2.length > 0) {
                    bVar.f().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.accessibility_action_clickable_span);
                    int i6 = R$id.tag_accessibility_clickable_spans;
                    SparseArray sparseArray2 = (SparseArray) view.getTag(i6);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        view.setTag(i6, sparseArray2);
                    }
                    for (int i7 = 0; i7 < d2.length; i7++) {
                        ClickableSpan clickableSpan = d2[i7];
                        int i8 = 0;
                        while (true) {
                            if (i8 >= sparseArray2.size()) {
                                i2 = b.f1484d;
                                b.f1484d = i2 + 1;
                                break;
                            } else if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i8)).get())) {
                                i2 = sparseArray2.keyAt(i8);
                                break;
                            } else {
                                i8++;
                            }
                        }
                        sparseArray2.put(i2, new WeakReference(d2[i7]));
                        ClickableSpan clickableSpan2 = d2[i7];
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
            for (int i9 = 0; i9 < list.size(); i9++) {
                bVar.a((b.a) list.get(i9));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.e(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.f(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.a.g(view, i2, bundle);
        }

        public void sendAccessibilityEvent(View view, int i2) {
            this.a.h(view, i2);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.i(view, accessibilityEvent);
        }
    }

    public a() {
        this.a = c;
        this.b = new C0034a(this);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.a = accessibilityDelegate;
        this.b = new C0034a(this);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public c b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new c(accessibilityNodeProvider);
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

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0072  */
    public boolean g(View view, int i2, Bundle bundle) {
        boolean z;
        WeakReference weakReference;
        boolean z2;
        d.a aVar;
        Exception e2;
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
            b.a aVar2 = (b.a) list.get(i3);
            if (aVar2.a() != i2) {
                i3++;
            } else if (aVar2.f1493d != null) {
                d.a aVar3 = null;
                Class<? extends d.a> cls = aVar2.c;
                if (cls != null) {
                    try {
                        aVar = (d.a) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        try {
                            Objects.requireNonNull(aVar);
                        } catch (Exception e3) {
                            e2 = e3;
                        }
                    } catch (Exception e4) {
                        aVar = null;
                        e2 = e4;
                        Class<? extends d.a> cls2 = aVar2.c;
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e2);
                        aVar3 = aVar;
                        z = aVar2.f1493d.a(view, aVar3);
                        if (!z) {
                        }
                        return z ? z : z;
                    }
                    aVar3 = aVar;
                }
                z = aVar2.f1493d.a(view, aVar3);
            }
        }
        z = false;
        if (!z) {
            z = this.a.performAccessibilityAction(view, i2, bundle);
        }
        if (z && i2 == R$id.accessibility_action_clickable_span) {
            int i4 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
            SparseArray sparseArray = (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
            if (!(sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i4)) == null)) {
                ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
                if (clickableSpan != null) {
                    ClickableSpan[] d2 = b.d(view.createAccessibilityNodeInfo().getText());
                    int i5 = 0;
                    while (true) {
                        if (d2 == null || i5 >= d2.length) {
                            break;
                        } else if (clickableSpan.equals(d2[i5])) {
                            z2 = true;
                            break;
                        } else {
                            i5++;
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
    }

    public void h(View view, int i2) {
        this.a.sendAccessibilityEvent(view, i2);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
