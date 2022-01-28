package b.b.q;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public TextView f747a;

    /* renamed from: b  reason: collision with root package name */
    public TextClassifier f748b;

    public x(TextView textView) {
        this.f747a = textView;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f748b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f747a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }
}
