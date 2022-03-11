package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;
import e.b.f.o;
import e.j.j.v;
/* loaded from: classes.dex */
public class CheckableImageButton extends o implements Checkable {

    /* renamed from: h */
    public static final int[] f583h = {16842912};

    /* renamed from: e */
    public boolean f584e;

    /* renamed from: f */
    public boolean f585f = true;

    /* renamed from: g */
    public boolean f586g = true;

    /* loaded from: classes.dex */
    public static class a extends e.l.a.a {
        public static final Parcelable.Creator<a> CREATOR = new C0007a();

        /* renamed from: d */
        public boolean f587d;

        /* renamed from: com.google.android.material.internal.CheckableImageButton$a$a */
        /* loaded from: classes.dex */
        public static class C0007a implements Parcelable.ClassLoaderCreator<a> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new a[i2];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f587d = parcel.readInt() != 1 ? false : true;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // e.l.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            parcel.writeInt(this.f587d ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R$attr.imageButtonStyle);
        v.u(this, new f.b.a.e.q.a(this));
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f584e;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        if (!this.f584e) {
            return super.onCreateDrawableState(i2);
        }
        int[] iArr = f583h;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i2 + iArr.length), iArr);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.b);
        setChecked(aVar.f587d);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f587d = this.f584e;
        return aVar;
    }

    public void setCheckable(boolean z) {
        if (this.f585f != z) {
            this.f585f = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f585f && this.f584e != z) {
            this.f584e = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z) {
        this.f586g = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.f586g) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f584e);
    }
}
