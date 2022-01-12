package com.facebook.react.devsupport;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$id;
import com.facebook.react.R$layout;
import com.facebook.react.R$style;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.StackFrame;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

public class RedBoxDialog extends Dialog implements AdapterView.OnItemClickListener {
    public boolean isReporting = false;
    public final DevSupportManager mDevSupportManager;
    public Button mDismissButton;
    public final DoubleTapReloadRecognizer mDoubleTapReloadRecognizer;
    public View mLineSeparator;
    public ProgressBar mLoadingIndicator;
    public final RedBoxHandler mRedBoxHandler;
    public Button mReloadJsButton;
    public Button mReportButton;
    public View.OnClickListener mReportButtonOnClickListener = new View.OnClickListener() {
        /* class com.facebook.react.devsupport.RedBoxDialog.AnonymousClass2 */

        public void onClick(View view) {
            if (RedBoxDialog.this.mRedBoxHandler != null && RedBoxDialog.this.mRedBoxHandler.isReportEnabled() && !RedBoxDialog.this.isReporting) {
                RedBoxDialog.this.isReporting = true;
                TextView textView = RedBoxDialog.this.mReportTextView;
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(textView);
                textView.setText("Reporting...");
                TextView textView2 = RedBoxDialog.this.mReportTextView;
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(textView2);
                textView2.setVisibility(0);
                ProgressBar progressBar = RedBoxDialog.this.mLoadingIndicator;
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(progressBar);
                progressBar.setVisibility(0);
                View view2 = RedBoxDialog.this.mLineSeparator;
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(view2);
                view2.setVisibility(0);
                Button button = RedBoxDialog.this.mReportButton;
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(button);
                button.setEnabled(false);
                String lastErrorTitle = RedBoxDialog.this.mDevSupportManager.getLastErrorTitle();
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(lastErrorTitle);
                String str = lastErrorTitle;
                StackFrame[] lastErrorStack = RedBoxDialog.this.mDevSupportManager.getLastErrorStack();
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(lastErrorStack);
                String sourceUrl = RedBoxDialog.this.mDevSupportManager.getSourceUrl();
                RedBoxHandler redBoxHandler = RedBoxDialog.this.mRedBoxHandler;
                Context context = view.getContext();
                RedBoxHandler.ReportCompletedListener reportCompletedListener = RedBoxDialog.this.mReportCompletedListener;
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reportCompletedListener);
                redBoxHandler.reportRedbox(context, str, lastErrorStack, sourceUrl, reportCompletedListener);
            }
        }
    };
    public RedBoxHandler.ReportCompletedListener mReportCompletedListener = new RedBoxHandler.ReportCompletedListener() {
        /* class com.facebook.react.devsupport.RedBoxDialog.AnonymousClass1 */

        @Override // com.facebook.react.devsupport.RedBoxHandler.ReportCompletedListener
        public void onReportError(SpannedString spannedString) {
            RedBoxDialog.this.isReporting = false;
            Button button = RedBoxDialog.this.mReportButton;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(button);
            button.setEnabled(true);
            ProgressBar progressBar = RedBoxDialog.this.mLoadingIndicator;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(progressBar);
            progressBar.setVisibility(8);
            TextView textView = RedBoxDialog.this.mReportTextView;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(textView);
            textView.setText(spannedString);
        }

        @Override // com.facebook.react.devsupport.RedBoxHandler.ReportCompletedListener
        public void onReportSuccess(SpannedString spannedString) {
            RedBoxDialog.this.isReporting = false;
            Button button = RedBoxDialog.this.mReportButton;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(button);
            button.setEnabled(true);
            ProgressBar progressBar = RedBoxDialog.this.mLoadingIndicator;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(progressBar);
            progressBar.setVisibility(8);
            TextView textView = RedBoxDialog.this.mReportTextView;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(textView);
            textView.setText(spannedString);
        }
    };
    public TextView mReportTextView;
    public ListView mStackView;

    public static class OpenStackFrameTask extends AsyncTask<StackFrame, Void, Void> {
        public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        public final DevSupportManager mDevSupportManager;

        public static JSONObject stackFrameToJson(StackFrame stackFrame) {
            return new JSONObject(AppCompatDelegateImpl.ConfigurationImplApi17.of(PromiseImpl.STACK_FRAME_KEY_FILE, stackFrame.getFile(), PromiseImpl.STACK_FRAME_KEY_METHOD_NAME, stackFrame.getMethod(), "lineNumber", Integer.valueOf(stackFrame.getLine()), StackTraceHelper.COLUMN_KEY, Integer.valueOf(stackFrame.getColumn())));
        }

        public OpenStackFrameTask(DevSupportManager devSupportManager) {
            this.mDevSupportManager = devSupportManager;
        }

        public Void doInBackground(StackFrame... stackFrameArr) {
            try {
                String uri = Uri.parse(this.mDevSupportManager.getSourceUrl()).buildUpon().path("/open-stack-frame").query(null).build().toString();
                OkHttpClient okHttpClient = new OkHttpClient();
                for (StackFrame stackFrame : stackFrameArr) {
                    okHttpClient.newCall(new Request.Builder().url(uri).post(RequestBody.create(JSON, stackFrameToJson(stackFrame).toString())).build()).execute();
                }
            } catch (Exception e) {
                FLog.e("ReactNative", "Could not open stack frame", e);
            }
            return null;
        }
    }

    public static class StackAdapter extends BaseAdapter {
        public static final int VIEW_TYPE_COUNT = 2;
        public static final int VIEW_TYPE_STACKFRAME = 1;
        public static final int VIEW_TYPE_TITLE = 0;
        public final StackFrame[] mStack;
        public final String mTitle;

        public static class FrameViewHolder {
            public final TextView mFileView;
            public final TextView mMethodView;

            public FrameViewHolder(View view) {
                this.mMethodView = (TextView) view.findViewById(R$id.rn_frame_method);
                this.mFileView = (TextView) view.findViewById(R$id.rn_frame_file);
            }
        }

        public StackAdapter(String str, StackFrame[] stackFrameArr) {
            this.mTitle = str;
            this.mStack = stackFrameArr;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(str);
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mStack);
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public int getCount() {
            return this.mStack.length + 1;
        }

        public Object getItem(int i) {
            return i == 0 ? this.mTitle : this.mStack[i - 1];
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView;
            if (i == 0) {
                if (view != null) {
                    textView = (TextView) view;
                } else {
                    textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.redbox_item_title, viewGroup, false);
                }
                String str = this.mTitle;
                if (str == null) {
                    str = "<unknown title>";
                }
                textView.setText(str.replaceAll("\\x1b\\[[0-9;]*m", ""));
                return textView;
            }
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.redbox_item_frame, viewGroup, false);
                view.setTag(new FrameViewHolder(view));
            }
            StackFrame stackFrame = this.mStack[i - 1];
            FrameViewHolder frameViewHolder = (FrameViewHolder) view.getTag();
            frameViewHolder.mMethodView.setText(stackFrame.getMethod());
            frameViewHolder.mFileView.setText(StackTraceHelper.formatFrameSource(stackFrame));
            frameViewHolder.mMethodView.setTextColor(stackFrame.isCollapsed() ? -5592406 : -1);
            frameViewHolder.mFileView.setTextColor(stackFrame.isCollapsed() ? -8355712 : -5000269);
            return view;
        }

        public int getViewTypeCount() {
            return 2;
        }

        public boolean isEnabled(int i) {
            return i > 0;
        }
    }

    public RedBoxDialog(Context context, DevSupportManager devSupportManager, RedBoxHandler redBoxHandler) {
        super(context, R$style.Theme_Catalyst_RedBox);
        requestWindowFeature(1);
        setContentView(R$layout.redbox_view);
        this.mDevSupportManager = devSupportManager;
        this.mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
        this.mRedBoxHandler = redBoxHandler;
        ListView listView = (ListView) findViewById(R$id.rn_redbox_stack);
        this.mStackView = listView;
        listView.setOnItemClickListener(this);
        Button button = (Button) findViewById(R$id.rn_redbox_reload_button);
        this.mReloadJsButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.facebook.react.devsupport.RedBoxDialog.AnonymousClass3 */

            public void onClick(View view) {
                RedBoxDialog.this.mDevSupportManager.handleReloadJS();
            }
        });
        Button button2 = (Button) findViewById(R$id.rn_redbox_dismiss_button);
        this.mDismissButton = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            /* class com.facebook.react.devsupport.RedBoxDialog.AnonymousClass4 */

            public void onClick(View view) {
                RedBoxDialog.this.dismiss();
            }
        });
        RedBoxHandler redBoxHandler2 = this.mRedBoxHandler;
        if (redBoxHandler2 != null && redBoxHandler2.isReportEnabled()) {
            this.mLoadingIndicator = (ProgressBar) findViewById(R$id.rn_redbox_loading_indicator);
            this.mLineSeparator = findViewById(R$id.rn_redbox_line_separator);
            TextView textView = (TextView) findViewById(R$id.rn_redbox_report_label);
            this.mReportTextView = textView;
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            this.mReportTextView.setHighlightColor(0);
            Button button3 = (Button) findViewById(R$id.rn_redbox_report_button);
            this.mReportButton = button3;
            button3.setOnClickListener(this.mReportButtonOnClickListener);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        new OpenStackFrameTask(this.mDevSupportManager).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (StackFrame) this.mStackView.getAdapter().getItem(i));
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82) {
            this.mDevSupportManager.showDevOptionsDialog();
            return true;
        }
        if (this.mDoubleTapReloadRecognizer.didDoubleTapR(i, getCurrentFocus())) {
            this.mDevSupportManager.handleReloadJS();
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void resetReporting() {
        RedBoxHandler redBoxHandler = this.mRedBoxHandler;
        if (redBoxHandler != null && redBoxHandler.isReportEnabled()) {
            this.isReporting = false;
            TextView textView = this.mReportTextView;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(textView);
            textView.setVisibility(8);
            ProgressBar progressBar = this.mLoadingIndicator;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(progressBar);
            progressBar.setVisibility(8);
            View view = this.mLineSeparator;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(view);
            view.setVisibility(8);
            Button button = this.mReportButton;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(button);
            button.setVisibility(0);
            Button button2 = this.mReportButton;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(button2);
            button2.setEnabled(true);
        }
    }

    public void setExceptionDetails(String str, StackFrame[] stackFrameArr) {
        this.mStackView.setAdapter((ListAdapter) new StackAdapter(str, stackFrameArr));
    }
}
