package gov.nc.dhhs.exposurenotification.notify;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
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
import b.l.d.q;
import b.n.y;
import c.a.a.a.a;
import c.a.b.p;
import c.a.b.x.h;
import d.a.a.a.h.l;
import e.c.a.s;
import e.c.a.u.c;
import e.c.a.u.k;
import gov.nc.dhhs.exposurenotification.BuildConfig;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.otpview.OtpView;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import gov.nc.dhhs.exposurenotification.utils.CustomUtility;
import java.io.BufferedReader;
import java.io.DataInputStream;
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
    public static final String TAG = "ShareExposureEditFrag";
    public static final c formatter = c.b(k.MEDIUM);
    public static int retries;
    public static StringBuilder server = new StringBuilder(BuildConfig.NCS_PIN_URI);
    public TextWatcher mPinEntryWatcher = new TextWatcher() {
        /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisEditFragment.AnonymousClass4 */

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
                    str = ncsConnector(i);
                    i++;
                } catch (SocketTimeoutException e2) {
                    CustomUtility.customLogger("A_CW_ERROR Timeout while NCDHHS pin verification : " + e2.getStackTrace());
                    e2.printStackTrace();
                    i++;
                    str = BuildConfig.VERBOSE_LOGGING;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    CustomUtility.customLogger("A_CW_ERROR Error during NCDHHS pin verification : " + e3.getStackTrace());
                    i = 4;
                    str = BuildConfig.VERBOSE_LOGGING;
                }
            }
            this.prog.dismiss();
            return str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00fc, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00fd, code lost:
            if (r1 != null) goto L_0x00ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0103, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0104, code lost:
            r5.addSuppressed(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0107, code lost:
            throw r0;
         */
        public String ncsConnector(int i) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pin", ShareDiagnosisEditFragment.this.pincode);
            ShareDiagnosisEditFragment.server.toString();
            CustomUtility.customLogger("pinverification server address " + ShareDiagnosisEditFragment.server.toString());
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(ShareDiagnosisEditFragment.server.toString() + "/api/verify/verify_pin").openConnection();
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpsURLConnection.setRequestProperty("Accept", "application/json");
            String jSONObject2 = jSONObject.toString();
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            byte[] bytes = jSONObject2.getBytes(h.PROTOCOL_CHARSET);
            outputStream.write(bytes, 0, bytes.length);
            outputStream.close();
            int responseCode = httpsURLConnection.getResponseCode();
            DataInputStream dataInputStream = new DataInputStream(httpsURLConnection.getInputStream());
            if (responseCode != 200) {
                return BuildConfig.VERBOSE_LOGGING;
            }
            StringBuilder g = a.g("NCS, Connect response code is 200 for PIN : ");
            g.append(ShareDiagnosisEditFragment.this.pincode);
            CustomUtility.customLogger(g.toString());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            JSONObject jSONObject3 = new JSONObject(sb.toString());
            Boolean valueOf = Boolean.valueOf(jSONObject3.getBoolean("action_success"));
            if (valueOf.booleanValue()) {
                CustomUtility.customLogger("NCS PIN response success");
                return jSONObject3.getString("token");
            }
            StringBuilder g2 = a.g("NCS PIN response Failure for PIN : ");
            g2.append(ShareDiagnosisEditFragment.this.pincode);
            g2.append("is :: ");
            g2.append(valueOf);
            CustomUtility.customLogger(g2.toString());
            return BuildConfig.VERBOSE_LOGGING;
        }

        public void onPostExecute(String str) {
            final e eVar;
            DialogInterface.OnClickListener onClickListener;
            if ("RETRIES_EXHAUSTED".equalsIgnoreCase(str) || (ShareDiagnosisEditFragment.retries >= 3 && BuildConfig.VERBOSE_LOGGING.equalsIgnoreCase(str))) {
                this.prog.dismiss();
                new ExposureNotificationSharedPreferences(ShareDiagnosisEditFragment.this.getContext().getApplicationContext()).setLastRetryTimeInMillis(Long.valueOf(System.currentTimeMillis()));
                eVar = new e.a(ShareDiagnosisEditFragment.this.getActivity()).a();
                eVar.f(ShareDiagnosisEditFragment.this.getString(R.string.max_retries_exhausted_message_text));
                eVar.setCancelable(false);
                onClickListener = new DialogInterface.OnClickListener() {
                    /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisEditFragment.newVerificationMethod.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        ShareDiagnosisEditFragment.this.pincodeEdittext.setText("");
                        eVar.dismiss();
                        ShareDiagnosisEditFragment.this.requireActivity().finish();
                    }
                };
            } else if (BuildConfig.VERBOSE_LOGGING.equalsIgnoreCase(str)) {
                StringBuilder g = a.g("Failure response dialog shown for PIN : ");
                g.append(ShareDiagnosisEditFragment.this.pincode);
                CustomUtility.customLogger(g.toString());
                eVar = new e.a(ShareDiagnosisEditFragment.this.getActivity()).a();
                eVar.setTitle(ShareDiagnosisEditFragment.this.getString(R.string.incorrect_pin_title_text));
                eVar.f(ShareDiagnosisEditFragment.this.getString(R.string.incorrect_pin_message_text));
                eVar.setCancelable(false);
                onClickListener = new DialogInterface.OnClickListener() {
                    /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisEditFragment.newVerificationMethod.AnonymousClass2 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        ShareDiagnosisEditFragment.this.pincodeEdittext.setText("");
                        eVar.dismiss();
                    }
                };
            } else if (!"Error".equalsIgnoreCase(str)) {
                CustomUtility.customLogger("A_CW_91002 - A PIN was successfully verified.");
                int unused = ShareDiagnosisEditFragment.retries = 0;
                ShareDiagnosisEditFragment.this.shareDiagnosisViewModel.setTestIdentifier(ShareDiagnosisEditFragment.this.pincodeEdittext.getText().toString());
                new ExposureNotificationSharedPreferences(ShareDiagnosisEditFragment.this.getContext().getApplicationContext()).setPinToken(str);
                String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault()).format(new Date());
                ShareDiagnosisViewModel shareDiagnosisViewModel = ShareDiagnosisEditFragment.this.shareDiagnosisViewModel;
                c cVar = c.l;
                c.b.a.a.c.n.c.T1(cVar, "formatter");
                shareDiagnosisViewModel.onTestTimestampChanged((s) cVar.c(format, s.f5007e));
                q parentFragmentManager = ShareDiagnosisEditFragment.this.getParentFragmentManager();
                if (parentFragmentManager != null) {
                    b.l.d.a aVar = new b.l.d.a(parentFragmentManager);
                    aVar.i(R.id.share_exposure_fragment, new ShareDiagnosisOnsetDateFragment(), ShareDiagnosisActivity.SHARE_EXPOSURE_FRAGMENT_TAG);
                    aVar.c(null);
                    aVar.f = 4097;
                    aVar.d();
                    return;
                }
                throw null;
            } else {
                return;
            }
            eVar.e(-2, "OK", onClickListener);
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

    private void navigateUp() {
        getParentFragmentManager().Z();
    }

    public /* synthetic */ void d(View view) {
        navigateUp();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_edit, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
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
            /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisEditFragment.AnonymousClass1 */

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
            /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisEditFragment.AnonymousClass2 */

            public void onClick(View view) {
                ShareDiagnosisEditFragment shareDiagnosisEditFragment = ShareDiagnosisEditFragment.this;
                shareDiagnosisEditFragment.pincode = shareDiagnosisEditFragment.pincodeEdittext.getText().toString().trim();
                new newVerificationMethod().execute(new Void[0]);
            }
        });
        View findViewById = view.findViewById(16908332);
        findViewById.setContentDescription(getString(R.string.back_btn_content_description));
        findViewById.setOnClickListener(new l(this));
        long currentTimeMillis = 600000 - (System.currentTimeMillis() - new ExposureNotificationSharedPreferences(getContext().getApplicationContext()).getLastRetryTimeInMillis(0L).longValue());
        if (currentTimeMillis > 1000 && currentTimeMillis < 600000) {
            final TextView textView = (TextView) view.findViewById(R.id.wait_if_retry_exhausted);
            textView.setVisibility(0);
            new CountDownTimer(currentTimeMillis, 1000) {
                /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisEditFragment.AnonymousClass3 */

                public void onFinish() {
                    textView.setVisibility(8);
                    ShareDiagnosisEditFragment.this.pincodeEdittext.setEnabled(true);
                    int unused = ShareDiagnosisEditFragment.retries = 0;
                }

                public void onTick(long j) {
                    String str;
                    StringBuilder sb;
                    TextView textView;
                    int i = (int) (j / 60000);
                    int i2 = (int) ((j / 1000) % 60);
                    String str2 = i2 < 10 ? ":0" : ":";
                    ShareDiagnosisEditFragment.this.pincodeEdittext.setEnabled(false);
                    if (Locale.getDefault().getLanguage() == "es") {
                        textView = textView;
                        sb = new StringBuilder();
                        sb.append("Espera ");
                        sb.append(i);
                        sb.append(str2);
                        sb.append(i2);
                        str = " minuto(s) antes de volver a intentar.";
                    } else {
                        textView = textView;
                        sb = new StringBuilder();
                        sb.append("Please wait for ");
                        sb.append(i);
                        sb.append(str2);
                        sb.append(i2);
                        str = " before retry.";
                    }
                    sb.append(str);
                    textView.setText(sb.toString());
                    textView.setTextColor(-65536);
                }
            }.start();
        }
    }
}
