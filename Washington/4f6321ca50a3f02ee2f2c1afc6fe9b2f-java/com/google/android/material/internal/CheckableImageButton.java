package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;
import e.b.f.l;

public class CheckableImageButton extends l implements Checkable {

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f532g = {16842912};

    /* renamed from: d  reason: collision with root package name */
    public boolean f533d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f534e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f535f = true;

    public static class a extends e.k.a.a {
        public static final Parcelable.Creator<a> CREATOR = new C0006a();

        /* renamed from: d  reason: collision with root package name */
        public boolean f536d;

        /* renamed from: com.google.android.material.internal.CheckableImageButton$a$a  reason: collision with other inner class name */
        public static class C0006a implements Parcelable.ClassLoaderCreator<a> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new a[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f536d = parcel.readInt() != 1 ? false : true;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // e.k.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            parcel.writeInt(this.f536d ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R$attr.imageButtonStyle);
        e.i.i.l.r(this, new f.b.a.d.q.a(this));
    }

    public boolean isChecked() {
        return this.f533d;
    }

    public int[] onCreateDrawableState(int i2) {
        if (!this.f533d) {
            return super.onCreateDrawableState(i2);
        }
        int[] iArr = f532g;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i2 + iArr.length), iArr);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.b);
        setChecked(aVar.f536d);
    }

    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f536d = this.f533d;
        return aVar;
    }

    public void setCheckable(boolean z) {
        if (this.f534e != z) {
            this.f534e = z;
            sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean z) {
        if (this.f534e && this.f533d != z) {
            this.f533d = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z) {
        this.f535f = z;
    }

    public void setPressed(boolean z) {
        if (this.f535f) {
            super.setPressed(z);
        }
    }

    public void toggle() {
        setChecked(!this.f533d);
    }
}
