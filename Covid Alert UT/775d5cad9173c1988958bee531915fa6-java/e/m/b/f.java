package e.m.b;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import e.b.a.m;
import e.m.a.e;
import java.util.Objects;

public final class f {
    public final b a;

    public static class a extends b {
        public final TextView a;
        public final d b;
        public boolean c = true;

        public a(TextView textView) {
            this.a = textView;
            this.b = new d(textView);
        }

        @Override // e.m.b.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            if (!this.c) {
                SparseArray sparseArray = new SparseArray(1);
                for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
                    if (inputFilterArr[i2] instanceof d) {
                        sparseArray.put(i2, inputFilterArr[i2]);
                    }
                }
                if (sparseArray.size() == 0) {
                    return inputFilterArr;
                }
                int length = inputFilterArr.length;
                InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length - sparseArray.size())];
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    if (sparseArray.indexOfKey(i4) < 0) {
                        inputFilterArr2[i3] = inputFilterArr[i4];
                        i3++;
                    }
                }
                return inputFilterArr2;
            }
            int length2 = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr3 = new InputFilter[(inputFilterArr.length + 1)];
            System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
            inputFilterArr3[length2] = this.b;
            return inputFilterArr3;
        }

        @Override // e.m.b.f.b
        public boolean b() {
            return this.c;
        }

        @Override // e.m.b.f.b
        public void c(boolean z) {
            if (z) {
                this.a.setTransformationMethod(e(this.a.getTransformationMethod()));
            }
        }

        @Override // e.m.b.f.b
        public void d(boolean z) {
            this.c = z;
            this.a.setTransformationMethod(e(this.a.getTransformationMethod()));
            this.a.setFilters(a(this.a.getFilters()));
        }

        @Override // e.m.b.f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            return this.c ? (!(transformationMethod instanceof h) && !(transformationMethod instanceof PasswordTransformationMethod)) ? new h(transformationMethod) : transformationMethod : transformationMethod instanceof h ? ((h) transformationMethod).b : transformationMethod;
        }
    }

    public static class b {
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public void c(boolean z) {
            throw null;
        }

        public void d(boolean z) {
            throw null;
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            throw null;
        }
    }

    public static class c extends b {
        public final a a;

        public c(TextView textView) {
            this.a = new a(textView);
        }

        @Override // e.m.b.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.a.a(inputFilterArr);
        }

        @Override // e.m.b.f.b
        public boolean b() {
            return this.a.c;
        }

        @Override // e.m.b.f.b
        public void c(boolean z) {
            if (!f()) {
                a aVar = this.a;
                Objects.requireNonNull(aVar);
                if (z) {
                    aVar.a.setTransformationMethod(aVar.e(aVar.a.getTransformationMethod()));
                }
            }
        }

        @Override // e.m.b.f.b
        public void d(boolean z) {
            if (f()) {
                this.a.c = z;
            } else {
                this.a.d(z);
            }
        }

        @Override // e.m.b.f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.a.e(transformationMethod);
        }

        public final boolean f() {
            return !e.c();
        }
    }

    public f(TextView textView, boolean z) {
        m.e.q(textView, "textView cannot be null");
        this.a = !z ? new c(textView) : new a(textView);
    }
}
