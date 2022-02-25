package f.b.a.a.a.i;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import f.a.a.a.a;
import java.util.Objects;

public final /* synthetic */ class f implements View.OnClickListener {
    public final /* synthetic */ l b;

    public /* synthetic */ f(l lVar) {
        this.b = lVar;
    }

    public final void onClick(View view) {
        l lVar = this.b;
        Objects.requireNonNull(lVar);
        String charSequence = ((TextView) view).getText().toString();
        if (!charSequence.startsWith("http://") && !charSequence.startsWith("https://")) {
            charSequence = a.t("https://", charSequence);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(charSequence));
            lVar.w0(intent);
        } catch (Exception e2) {
            Log.e("ExposureHomeFragment", "Exception while launching ACTION_VIEW with URL " + charSequence, e2);
        }
    }
}
