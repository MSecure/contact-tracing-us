package b.b.q;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public TextView f972a;

    /* renamed from: b  reason: collision with root package name */
    public TextClassifier f973b;

    public x(TextView textView) {
        this.f972a = textView;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f973b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f972a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }
}
