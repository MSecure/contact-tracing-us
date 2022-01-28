package gov.michigan.MiCovidExposure.notify;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import b.b.k.e;
import b.b.q.w;
import b.l.d.z;
import b.o.y;
import b.x.t;
import c.a.a.a.a;
import c.a.b.p;
import c.a.b.x.h;
import e.a.a.f.l;
import g.b.a.s;
import g.b.a.u.c;
import g.b.a.u.k;
import gov.michigan.MiCovidExposure.BuildConfig;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.otpview.OtpView;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
import gov.michigan.MiCovidExposure.utils.CustomUtility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

public class ShareDiagnosisEditFragment extends Fragment {
    public static String API_KEY = null;
    public static final String TAG = "ShareExposureEditFrag";
    public static final c formatter = c.b(k.MEDIUM);
    public static int retries;
    public TextWatcher mPinEntryWatcher = new TextWatcher() {
        /* class gov.michigan.MiCovidExposure.notify.ShareDiagnosisEditFragment.AnonymousClass4 */

        public void afterTextChanged(Editable editable) {
            ShareDiagnosisEditFragment.this.nextButton.setEnabled(editable.length() == 8);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public w month_spinner;
    public Button nextButton;
    public String pincode;
    public OtpView pincodeEdittext;
    public p queue;
    public String selectedMonth = "";
    public ShareDiagnosisViewModel shareDiagnosisViewModel;

    public final class newVerificationMethod extends AsyncTask<Void, Void, String> {
        public ProgressDialog prog;

        public newVerificationMethod() {
            this.prog = new ProgressDialog(ShareDiagnosisEditFragment.this.getActivity());
        }

        public String doInBackground(Void... voidArr) {
            ShareDiagnosisEditFragment.retries++;
            if (ShareDiagnosisEditFragment.retries > 3) {
                return "RETRIES_EXHAUSTED";
            }
            int i = 0;
            String str = "";
            while (i < 3 && ("".equalsIgnoreCase(str) || str == null)) {
                try {
                    str = miConnector(i);
                    i++;
                } catch (SocketTimeoutException e2) {
                    CustomUtility.customLogger("A_CW_ERROR Timeout while MDHHS pin verification : " + e2.getStackTrace());
                    e2.printStackTrace();
                    i++;
                    str = BuildConfig.VERBOSE_LOGGING;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    CustomUtility.customLogger("A_CW_ERROR Error during MDHHS pin verification : " + e3.getStackTrace());
                    i = 4;
                    str = BuildConfig.VERBOSE_LOGGING;
                }
            }
            this.prog.dismiss();
            return str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e9, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ea, code lost:
            if (r1 != null) goto L_0x00ec;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f0, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f1, code lost:
            r8.addSuppressed(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f4, code lost:
            throw r0;
         */
        public String miConnector(int i) {
            String str;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(BuildConfig.MI_X_API_KEY_URL).openConnection();
            httpsURLConnection.setRequestMethod("POST");
            StringBuffer stringBuffer = new StringBuffer();
            if (httpsURLConnection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                bufferedReader.close();
                str = "";
            } else {
                str = BuildConfig.VERBOSE_LOGGING;
            }
            ShareDiagnosisEditFragment.API_KEY = stringBuffer.toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pin", ShareDiagnosisEditFragment.this.pincode);
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(ShareDiagnosisEditFragment.this.getString(R.string.mi_pin_uri)).openConnection();
            httpsURLConnection2.setRequestMethod("POST");
            httpsURLConnection2.setRequestProperty("Accept", "*/*");
            httpsURLConnection2.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection2.setRequestProperty("X-API-KEY", ShareDiagnosisEditFragment.API_KEY);
            String jSONObject2 = jSONObject.toString();
            OutputStream outputStream = httpsURLConnection2.getOutputStream();
            byte[] bytes = jSONObject2.getBytes(h.PROTOCOL_CHARSET);
            outputStream.write(bytes, 0, bytes.length);
            outputStream.close();
            if (httpsURLConnection2.getResponseCode() == 200) {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpsURLConnection2.getInputStream()));
                while (true) {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        JSONObject jSONObject3 = new JSONObject(readLine2);
                        str = jSONObject3.getString("action_success").equalsIgnoreCase("true") ? jSONObject3.getString("token") : BuildConfig.VERBOSE_LOGGING;
                    } else {
                        httpsURLConnection2.disconnect();
                        return str;
                    }
                }
            } else {
                StringBuilder h = a.h("Failed : HTTP error code : ");
                h.append(httpsURLConnection2.getResponseCode());
                throw new RuntimeException(h.toString());
            }
        }

        public void onPostExecute(String str) {
            final e eVar;
            DialogInterface.OnClickListener onClickListener;
            String str2;
            if ("RETRIES_EXHAUSTED".equalsIgnoreCase(str) || (ShareDiagnosisEditFragment.retries >= 3 && BuildConfig.VERBOSE_LOGGING.equalsIgnoreCase(str))) {
                this.prog.dismiss();
                new ExposureNotificationSharedPreferences(ShareDiagnosisEditFragment.this.getContext().getApplicationContext()).setLastRetryTimeInMillis(Long.valueOf(System.currentTimeMillis()));
                eVar = new e.a(ShareDiagnosisEditFragment.this.getActivity()).a();
                eVar.setTitle(ShareDiagnosisEditFragment.this.getString(R.string.max_retries_exhausted_title_text));
                eVar.f(ShareDiagnosisEditFragment.this.getString(R.string.max_retries_exhausted_message_text));
                eVar.setCancelable(false);
                str2 = ShareDiagnosisEditFragment.this.getString(R.string.stop_notif_ok);
                onClickListener = new DialogInterface.OnClickListener() {
                    /* class gov.michigan.MiCovidExposure.notify.ShareDiagnosisEditFragment.newVerificationMethod.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        ShareDiagnosisEditFragment.this.pincodeEdittext.setText("");
                        eVar.dismiss();
                        ShareDiagnosisEditFragment.this.requireActivity().finish();
                    }
                };
            } else if (BuildConfig.VERBOSE_LOGGING.equalsIgnoreCase(str)) {
                StringBuilder h = a.h("Failure response dialog shown for PIN : ");
                h.append(ShareDiagnosisEditFragment.this.pincode);
                CustomUtility.customLogger(h.toString());
                eVar = new e.a(ShareDiagnosisEditFragment.this.getActivity()).a();
                eVar.setTitle(ShareDiagnosisEditFragment.this.getString(R.string.incorrect_pin_title_text));
                eVar.f(ShareDiagnosisEditFragment.this.getString(R.string.incorrect_pin_message_text));
                eVar.setCancelable(false);
                str2 = ShareDiagnosisEditFragment.this.getString(R.string.stop_notif_ok);
                onClickListener = new DialogInterface.OnClickListener() {
                    /* class gov.michigan.MiCovidExposure.notify.ShareDiagnosisEditFragment.newVerificationMethod.AnonymousClass2 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        ShareDiagnosisEditFragment.this.pincodeEdittext.setText("");
                        eVar.dismiss();
                    }
                };
            } else if (!"Error".equalsIgnoreCase(str)) {
                CustomUtility.customLogger("A_CW_91002");
                if (new ExposureNotificationSharedPreferences(ShareDiagnosisEditFragment.this.getContext().getApplicationContext()).gethasEverReceivedNotification(false)) {
                    CustomUtility.customLogger("A_CW_91202");
                }
                int unused = ShareDiagnosisEditFragment.retries = 0;
                ShareDiagnosisEditFragment.this.shareDiagnosisViewModel.setTestIdentifier(ShareDiagnosisEditFragment.this.pincodeEdittext.getText().toString());
                new ExposureNotificationSharedPreferences(ShareDiagnosisEditFragment.this.getContext().getApplicationContext()).setPinToken(str);
                String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault()).format(new Date());
                if (Locale.getDefault().getLanguage().equals("ar")) {
                    format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH).format(new Date());
                }
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisEditFragment.this.shareDiagnosisViewModel;
                c cVar = c.l;
                t.y2(cVar, "formatter");
                shareDiagnosisViewModel.onTestTimestampChanged((s) cVar.c(format, s.f6452e));
                z parentFragmentManager = ShareDiagnosisEditFragment.this.getParentFragmentManager();
                if (parentFragmentManager != null) {
                    b.l.d.a aVar = new b.l.d.a(parentFragmentManager);
                    aVar.h(R.id.share_exposure_fragment, new ShareDiagnosisOnsetDateFragment(), ShareDiagnosisActivity.SHARE_EXPOSURE_FRAGMENT_TAG);
                    aVar.c(null);
                    aVar.f2040f = 4097;
                    aVar.d();
                    return;
                }
                throw null;
            } else {
                return;
            }
            eVar.e(-2, str2, onClickListener);
            eVar.show();
        }

        public void onPreExecute() {
            super.onPreExecute();
            this.prog.setMessage(ShareDiagnosisEditFragment.this.getString(R.string.verifying));
            this.prog.setCancelable(false);
            this.prog.setIndeterminate(true);
            this.prog.setProgressStyle(0);
            this.prog.show();
        }
    }

    private void cancelAction() {
        requireActivity().finish();
    }

    private void navigateUp() {
        getParentFragmentManager().Y();
    }

    public /* synthetic */ void d(View view) {
        cancelAction();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_edit, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ((TextView) view.findViewById(R.id.verify_test_desc)).setMovementMethod(LinkMovementMethod.getInstance());
        this.shareDiagnosisViewModel = (ShareDiagnosisViewModel) new y(getActivity()).a(ShareDiagnosisViewModel.class);
        OtpView otpView = (OtpView) view.findViewById(R.id.otp_view);
        this.pincodeEdittext = otpView;
        otpView.requestFocus();
        this.pincodeEdittext.addTextChangedListener(this.mPinEntryWatcher);
        final String string = getString(R.string.pin_less_than_6_digits);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.pincodeEdittext.setItemWidth(displayMetrics.widthPixels / 12);
        this.pincodeEdittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class gov.michigan.MiCovidExposure.notify.ShareDiagnosisEditFragment.AnonymousClass1 */

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((keyEvent != null && keyEvent.getKeyCode() == 66) || i == 6) {
                    if (ShareDiagnosisEditFragment.this.pincodeEdittext.getText().toString() == null || ShareDiagnosisEditFragment.this.pincodeEdittext.getText().toString().isEmpty() || ShareDiagnosisEditFragment.this.pincodeEdittext.getText().toString().length() != 8) {
                        Toast.makeText(ShareDiagnosisEditFragment.this.getActivity(), string, 0).show();
                    } else {
                        ShareDiagnosisEditFragment shareDiagnosisEditFragment = ShareDiagnosisEditFragment.this;
                        shareDiagnosisEditFragment.pincode = shareDiagnosisEditFragment.pincodeEdittext.getText().toString().trim();
                        new newVerificationMethod().execute(new Void[0]);
                    }
                }
                return false;
            }
        });
        Button button = (Button) view.findViewById(R.id.share_next_button);
        this.nextButton = button;
        button.setEnabled(false);
        this.nextButton.setOnClickListener(new View.OnClickListener() {
            /* class gov.michigan.MiCovidExposure.notify.ShareDiagnosisEditFragment.AnonymousClass2 */

            public void onClick(View view) {
                ShareDiagnosisEditFragment shareDiagnosisEditFragment = ShareDiagnosisEditFragment.this;
                shareDiagnosisEditFragment.pincode = shareDiagnosisEditFragment.pincodeEdittext.getText().toString().trim();
                new newVerificationMethod().execute(new Void[0]);
            }
        });
        View findViewById = view.findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.navigate_up));
        findViewById.setOnClickListener(new l(this));
        long currentTimeMillis = 600000 - (System.currentTimeMillis() - new ExposureNotificationSharedPreferences(getContext().getApplicationContext()).getLastRetryTimeInMillis(0L).longValue());
        if (currentTimeMillis > 1000 && currentTimeMillis < 600000) {
            final TextView textView = (TextView) view.findViewById(R.id.wait_if_retry_exhausted);
            textView.setVisibility(0);
            new CountDownTimer(currentTimeMillis, 1000) {
                /* class gov.michigan.MiCovidExposure.notify.ShareDiagnosisEditFragment.AnonymousClass3 */

                public void onFinish() {
                    textView.setVisibility(8);
                    ShareDiagnosisEditFragment.this.pincodeEdittext.setEnabled(true);
                    int unused = ShareDiagnosisEditFragment.retries = 0;
                }

                public void onTick(long j) {
                    int i = (int) (j / 60000);
                    int i2 = (int) ((j / 1000) % 60);
                    String str = i2 < 10 ? ":0" : ":";
                    ShareDiagnosisEditFragment.this.pincodeEdittext.setEnabled(false);
                    if (Locale.getDefault().getLanguage().equals("en")) {
                        TextView textView = textView;
                        textView.setText("Please wait for " + i + str + i2 + " minutes before retry.");
                    }
                    if (Locale.getDefault().getLanguage().equals("es")) {
                        TextView textView2 = textView;
                        textView2.setText("Por favor espere " + i + str + i2 + " minutos antes de reintentar.");
                    }
                    if (Locale.getDefault().getLanguage().equals("ar")) {
                        TextView textView3 = textView;
                        textView3.setText("من فضلك انتظر " + i + str + i2 + " قبل إعادة المحاولة.");
                    }
                    textView.setTextColor(-65536);
                }
            }.start();
        }
    }
}
