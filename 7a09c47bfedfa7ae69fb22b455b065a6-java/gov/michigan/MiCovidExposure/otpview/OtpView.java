package gov.michigan.MiCovidExposure.otpview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import b.b.q.k;
import b.i.l.m;
import gov.michigan.MiCovidExposure.R;

public class OtpView extends k {
    public static final int BLINK = 500;
    public static final boolean DBG = false;
    public static final int DEFAULT_COUNT = 4;
    public static final int[] FILLED_STATE = {R.attr.state_filled};
    public static final InputFilter[] NO_FILTERS = new InputFilter[0];
    public static final int[] SELECTED_STATE = {16842913};
    public static final int VIEW_TYPE_LINE = 1;
    public static final int VIEW_TYPE_NONE = 2;
    public static final int VIEW_TYPE_RECTANGLE = 0;
    public final TextPaint animatorTextPaint;
    public Blink blink;
    public int cursorColor;
    public float cursorHeight;
    public int cursorLineColor;
    public int cursorWidth;
    public ValueAnimator defaultAddAnimator;
    public boolean drawCursor;
    public boolean hideLineWhenFilled;
    public boolean isAnimationEnable;
    public boolean isCursorVisible;
    public Drawable itemBackground;
    public int itemBackgroundResource;
    public final RectF itemBorderRect;
    public final PointF itemCenterPoint;
    public final RectF itemLineRect;
    public ColorStateList lineColor;
    public int lineWidth;
    public String maskingChar;
    public OnOtpCompletionListener onOtpCompletionListener;
    public int otpViewItemCount;
    public int otpViewItemHeight;
    public int otpViewItemRadius;
    public int otpViewItemSpacing;
    public int otpViewItemWidth;
    public final Paint paint;
    public final Path path;
    public boolean rtlTextDirection;
    public final Rect textRect;
    public int viewType;

    public class Blink implements Runnable {
        public boolean cancelled;

        public Blink() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void cancel() {
            if (!this.cancelled) {
                OtpView.this.removeCallbacks(this);
                this.cancelled = true;
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void unCancel() {
            this.cancelled = false;
        }

        public void run() {
            if (!this.cancelled) {
                OtpView.this.removeCallbacks(this);
                if (OtpView.this.shouldBlink()) {
                    OtpView otpView = OtpView.this;
                    otpView.invalidateCursor(!otpView.drawCursor);
                    OtpView.this.postDelayed(this, 500);
                }
            }
        }
    }

    public OtpView(Context context) {
        this(context, null);
    }

    public OtpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.otpViewStyle);
    }

    public OtpView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.animatorTextPaint = new TextPaint();
        this.cursorLineColor = -16777216;
        this.textRect = new Rect();
        this.itemBorderRect = new RectF();
        this.itemLineRect = new RectF();
        this.path = new Path();
        this.itemCenterPoint = new PointF();
        this.isAnimationEnable = false;
        Resources resources = getResources();
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.animatorTextPaint.set(getPaint());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.OtpView, i, 0);
        this.viewType = obtainStyledAttributes.getInt(15, 2);
        this.otpViewItemCount = obtainStyledAttributes.getInt(5, 4);
        this.otpViewItemHeight = (int) obtainStyledAttributes.getDimension(6, (float) resources.getDimensionPixelSize(R.dimen.otp_view_item_size));
        this.otpViewItemWidth = (int) obtainStyledAttributes.getDimension(9, (float) resources.getDimensionPixelSize(R.dimen.otp_view_item_size));
        this.otpViewItemSpacing = obtainStyledAttributes.getDimensionPixelSize(8, resources.getDimensionPixelSize(R.dimen.otp_view_item_spacing));
        this.otpViewItemRadius = (int) obtainStyledAttributes.getDimension(7, 0.0f);
        this.lineWidth = (int) obtainStyledAttributes.getDimension(11, (float) resources.getDimensionPixelSize(R.dimen.otp_view_item_line_width));
        this.lineColor = obtainStyledAttributes.getColorStateList(10);
        this.isCursorVisible = obtainStyledAttributes.getBoolean(1, true);
        this.cursorColor = obtainStyledAttributes.getColor(2, getCurrentTextColor());
        this.cursorWidth = obtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(R.dimen.otp_view_cursor_width));
        this.itemBackground = obtainStyledAttributes.getDrawable(0);
        this.hideLineWhenFilled = obtainStyledAttributes.getBoolean(4, false);
        this.rtlTextDirection = obtainStyledAttributes.getBoolean(13, false);
        this.maskingChar = obtainStyledAttributes.getString(12);
        obtainStyledAttributes.recycle();
        ColorStateList colorStateList = this.lineColor;
        if (colorStateList != null) {
            this.cursorLineColor = colorStateList.getDefaultColor();
        }
        updateCursorHeight();
        checkItemRadius();
        setMaxLength(this.otpViewItemCount);
        this.paint.setStrokeWidth((float) this.lineWidth);
        setupAnimator();
        super.setCursorVisible(false);
        setTextIsSelectable(false);
    }

    private void checkItemRadius() {
        int i = this.viewType;
        if (i == 1) {
            if (((float) this.otpViewItemRadius) > ((float) this.lineWidth) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than lineWidth when viewType is line");
            }
        } else if (i == 0) {
            if (((float) this.otpViewItemRadius) > ((float) this.otpViewItemWidth) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than itemWidth");
            }
        }
    }

    private int dpToPx() {
        return (int) ((getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
    }

    private void drawAnchorLine(Canvas canvas) {
        PointF pointF = this.itemCenterPoint;
        float f2 = pointF.x;
        float f3 = pointF.y;
        this.paint.setStrokeWidth(1.0f);
        float strokeWidth = f2 - (this.paint.getStrokeWidth() / 2.0f);
        float strokeWidth2 = f3 - (this.paint.getStrokeWidth() / 2.0f);
        this.path.reset();
        this.path.moveTo(strokeWidth, this.itemBorderRect.top);
        Path path2 = this.path;
        RectF rectF = this.itemBorderRect;
        path2.lineTo(strokeWidth, Math.abs(rectF.height()) + rectF.top);
        canvas.drawPath(this.path, this.paint);
        this.path.reset();
        this.path.moveTo(this.itemBorderRect.left, strokeWidth2);
        Path path3 = this.path;
        RectF rectF2 = this.itemBorderRect;
        path3.lineTo(Math.abs(rectF2.width()) + rectF2.left, strokeWidth2);
        canvas.drawPath(this.path, this.paint);
        this.path.reset();
        this.paint.setStrokeWidth((float) this.lineWidth);
    }

    private void drawCircle(Canvas canvas, int i) {
        Paint paintByIndex = getPaintByIndex(i);
        PointF pointF = this.itemCenterPoint;
        float f2 = pointF.x;
        float f3 = pointF.y;
        if (!this.rtlTextDirection || (this.otpViewItemCount - i) - getHint().length() <= 0) {
            canvas.drawCircle(f2, f3, paintByIndex.getTextSize() / 2.0f, paintByIndex);
        }
    }

    private void drawCursor(Canvas canvas) {
        if (this.drawCursor) {
            PointF pointF = this.itemCenterPoint;
            float f2 = pointF.x;
            float f3 = pointF.y - (this.cursorHeight / 2.0f);
            int color = this.paint.getColor();
            float strokeWidth = this.paint.getStrokeWidth();
            this.paint.setColor(this.cursorColor);
            this.paint.setStrokeWidth((float) this.cursorWidth);
            canvas.drawLine(f2, f3, f2, f3 + this.cursorHeight, this.paint);
            this.paint.setColor(color);
            this.paint.setStrokeWidth(strokeWidth);
        }
    }

    private void drawHint(Canvas canvas, int i) {
        Paint paintByIndex = getPaintByIndex(i);
        paintByIndex.setColor(getCurrentHintTextColor());
        if (this.rtlTextDirection) {
            int length = (this.otpViewItemCount - i) - getHint().length();
            if (length <= 0) {
                drawTextAtBox(canvas, paintByIndex, getHint(), Math.abs(length));
                return;
            }
            return;
        }
        drawTextAtBox(canvas, paintByIndex, getHint(), i);
    }

    private void drawInput(Canvas canvas, int i) {
        if (this.maskingChar != null && (isNumberInputType(getInputType()) || isPasswordInputType(getInputType()))) {
            drawMaskingText(canvas, i, Character.toString(this.maskingChar.charAt(0)));
        } else if (isPasswordInputType(getInputType())) {
            drawCircle(canvas, i);
        } else {
            drawText(canvas, i);
        }
    }

    private void drawItemBackground(Canvas canvas, int[] iArr) {
        if (this.itemBackground != null) {
            float f2 = ((float) this.lineWidth) / 2.0f;
            this.itemBackground.setBounds(Math.round(this.itemBorderRect.left - f2), Math.round(this.itemBorderRect.top - f2), Math.round(this.itemBorderRect.right + f2), Math.round(this.itemBorderRect.bottom + f2));
            if (this.viewType != 2) {
                Drawable drawable = this.itemBackground;
                if (iArr == null) {
                    iArr = getDrawableState();
                }
                drawable.setState(iArr);
            }
            this.itemBackground.draw(canvas);
        }
    }

    private void drawMaskingText(Canvas canvas, int i, String str) {
        Paint paintByIndex = getPaintByIndex(i);
        paintByIndex.setColor(getCurrentTextColor());
        if (this.rtlTextDirection) {
            int i2 = this.otpViewItemCount - i;
            if (getText() != null) {
                i2 -= getText().length();
            }
            if (i2 <= 0 && getText() != null) {
                drawTextAtBox(canvas, paintByIndex, getText().toString().replaceAll(".", str), Math.abs(i2));
            }
        } else if (getText() != null) {
            drawTextAtBox(canvas, paintByIndex, getText().toString().replaceAll(".", str), i);
        }
    }

    private void drawOtpBox(Canvas canvas, int i) {
        if (getText() == null || !this.hideLineWhenFilled || i >= getText().length()) {
            canvas.drawPath(this.path, this.paint);
        }
    }

    private void drawOtpLine(Canvas canvas, int i) {
        boolean z;
        boolean z2;
        int i2;
        if (getText() == null || !this.hideLineWhenFilled || i >= getText().length()) {
            if (this.otpViewItemSpacing != 0 || (i2 = this.otpViewItemCount) <= 1) {
                z2 = true;
            } else {
                if (i == 0) {
                    z = false;
                    z2 = true;
                } else {
                    z2 = false;
                    if (i == i2 - 1) {
                        z = true;
                    }
                }
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setStrokeWidth(((float) this.lineWidth) / 10.0f);
                float f2 = ((float) this.lineWidth) / 2.0f;
                RectF rectF = this.itemLineRect;
                RectF rectF2 = this.itemBorderRect;
                float f3 = rectF2.bottom;
                rectF.set(rectF2.left - f2, f3 - f2, rectF2.right + f2, f3 + f2);
                RectF rectF3 = this.itemLineRect;
                int i3 = this.otpViewItemRadius;
                updateRoundRectPath(rectF3, (float) i3, (float) i3, z2, z);
                canvas.drawPath(this.path, this.paint);
            }
            z = z2;
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setStrokeWidth(((float) this.lineWidth) / 10.0f);
            float f22 = ((float) this.lineWidth) / 2.0f;
            RectF rectF4 = this.itemLineRect;
            RectF rectF22 = this.itemBorderRect;
            float f32 = rectF22.bottom;
            rectF4.set(rectF22.left - f22, f32 - f22, rectF22.right + f22, f32 + f22);
            RectF rectF32 = this.itemLineRect;
            int i32 = this.otpViewItemRadius;
            updateRoundRectPath(rectF32, (float) i32, (float) i32, z2, z);
            canvas.drawPath(this.path, this.paint);
        }
    }

    private void drawOtpView(Canvas canvas) {
        int length = this.rtlTextDirection ? this.otpViewItemCount - 1 : getText() != null ? getText().length() : 0;
        int i = 0;
        while (i < this.otpViewItemCount) {
            boolean z = isFocused() && length == i;
            int[] iArr = null;
            if (i < length) {
                iArr = FILLED_STATE;
            } else if (z) {
                iArr = SELECTED_STATE;
            }
            this.paint.setColor(iArr != null ? getLineColorForState(iArr) : this.cursorLineColor);
            updateItemRectF(i);
            updateCenterPoint();
            canvas.save();
            if (this.viewType == 0) {
                updateOtpViewBoxPath(i);
                canvas.clipPath(this.path);
            }
            drawItemBackground(canvas, iArr);
            canvas.restore();
            if (z) {
                drawCursor(canvas);
            }
            int i2 = this.viewType;
            if (i2 == 0) {
                drawOtpBox(canvas, i);
            } else if (i2 == 1) {
                drawOtpLine(canvas, i);
            }
            if (this.rtlTextDirection) {
                if (getText().length() < this.otpViewItemCount - i) {
                    if (!TextUtils.isEmpty(getHint())) {
                        if (getHint().length() != this.otpViewItemCount) {
                        }
                        drawHint(canvas, i);
                    }
                    i++;
                }
            } else if (getText().length() <= i) {
                if (!TextUtils.isEmpty(getHint())) {
                    if (getHint().length() != this.otpViewItemCount) {
                    }
                    drawHint(canvas, i);
                }
                i++;
            }
            drawInput(canvas, i);
            i++;
        }
        if (isFocused() && getText() != null && getText().length() != this.otpViewItemCount && this.viewType == 0) {
            int length2 = getText().length();
            updateItemRectF(length2);
            updateCenterPoint();
            updateOtpViewBoxPath(length2);
            this.paint.setColor(getLineColorForState(SELECTED_STATE));
            drawOtpBox(canvas, length2);
        }
    }

    private void drawText(Canvas canvas, int i) {
        Paint paintByIndex = getPaintByIndex(i);
        paintByIndex.setColor(getCurrentTextColor());
        if (this.rtlTextDirection) {
            int i2 = this.otpViewItemCount - i;
            if (getText() != null) {
                i2 -= getText().length();
            }
            if (i2 <= 0 && getText() != null) {
                drawTextAtBox(canvas, paintByIndex, getText(), Math.abs(i2));
            }
        } else if (getText() != null) {
            drawTextAtBox(canvas, paintByIndex, getText(), i);
        }
    }

    private void drawTextAtBox(Canvas canvas, Paint paint2, CharSequence charSequence, int i) {
        int i2 = i + 1;
        paint2.getTextBounds(charSequence.toString(), i, i2, this.textRect);
        PointF pointF = this.itemCenterPoint;
        float f2 = pointF.x;
        float f3 = pointF.y;
        float abs = f2 - (Math.abs((float) this.textRect.width()) / 2.0f);
        Rect rect = this.textRect;
        canvas.drawText(charSequence, i, i2, abs - ((float) rect.left), ((Math.abs((float) rect.height()) / 2.0f) + f3) - ((float) this.textRect.bottom), paint2);
    }

    private int getLineColorForState(int... iArr) {
        ColorStateList colorStateList = this.lineColor;
        return colorStateList != null ? colorStateList.getColorForState(iArr, this.cursorLineColor) : this.cursorLineColor;
    }

    private Paint getPaintByIndex(int i) {
        if (getText() == null || !this.isAnimationEnable || i != getText().length() - 1) {
            return getPaint();
        }
        this.animatorTextPaint.setColor(getPaint().getColor());
        return this.animatorTextPaint;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void invalidateCursor(boolean z) {
        if (this.drawCursor != z) {
            this.drawCursor = z;
            invalidate();
        }
    }

    public static boolean isNumberInputType(int i) {
        return i == 2;
    }

    public static boolean isPasswordInputType(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    private void makeBlink() {
        if (shouldBlink()) {
            if (this.blink == null) {
                this.blink = new Blink();
            }
            removeCallbacks(this.blink);
            this.drawCursor = false;
            postDelayed(this.blink, 500);
            return;
        }
        Blink blink2 = this.blink;
        if (blink2 != null) {
            removeCallbacks(blink2);
        }
    }

    private void moveSelectionToEnd() {
        if (getText() != null) {
            setSelection(getText().length());
        }
    }

    private void resumeBlink() {
        Blink blink2 = this.blink;
        if (blink2 != null) {
            blink2.unCancel();
            makeBlink();
        }
    }

    private void setMaxLength(int i) {
        setFilters(i >= 0 ? new InputFilter[]{new InputFilter.LengthFilter(i)} : NO_FILTERS);
    }

    private void setupAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.5f, 1.0f);
        this.defaultAddAnimator = ofFloat;
        ofFloat.setDuration(150L);
        this.defaultAddAnimator.setInterpolator(new DecelerateInterpolator());
        this.defaultAddAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class gov.michigan.MiCovidExposure.otpview.OtpView.AnonymousClass1 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OtpView.this.animatorTextPaint.setTextSize(OtpView.this.getTextSize() * floatValue);
                OtpView.this.animatorTextPaint.setAlpha((int) (255.0f * floatValue));
                OtpView.this.postInvalidate();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean shouldBlink() {
        return isCursorVisible() && isFocused();
    }

    private void suspendBlink() {
        Blink blink2 = this.blink;
        if (blink2 != null) {
            blink2.cancel();
            invalidateCursor(false);
        }
    }

    private void updateCenterPoint() {
        RectF rectF = this.itemBorderRect;
        float abs = (Math.abs(rectF.width()) / 2.0f) + rectF.left;
        RectF rectF2 = this.itemBorderRect;
        float f2 = rectF2.top;
        this.itemCenterPoint.set(abs, (Math.abs(rectF2.height()) / 2.0f) + f2);
    }

    private void updateColors() {
        ColorStateList colorStateList = this.lineColor;
        boolean z = false;
        int colorForState = colorStateList != null ? colorStateList.getColorForState(getDrawableState(), 0) : getCurrentTextColor();
        if (colorForState != this.cursorLineColor) {
            this.cursorLineColor = colorForState;
            z = true;
        }
        if (z) {
            invalidate();
        }
    }

    private void updateCursorHeight() {
        float dpToPx = (float) (dpToPx() * 2);
        this.cursorHeight = ((float) this.otpViewItemHeight) - getTextSize() > dpToPx ? getTextSize() + dpToPx : getTextSize();
    }

    private void updateItemRectF(int i) {
        float f2 = ((float) this.lineWidth) / 2.0f;
        int t = m.t(this) + getScrollX();
        int i2 = this.otpViewItemSpacing;
        float f3 = ((float) (((this.otpViewItemWidth + i2) * i) + t)) + f2;
        if (i2 == 0 && i > 0) {
            f3 -= (float) (this.lineWidth * i);
        }
        float f4 = (((float) this.otpViewItemWidth) + f3) - ((float) this.lineWidth);
        float paddingTop = ((float) (getPaddingTop() + getScrollY())) + f2;
        this.itemBorderRect.set(f3, paddingTop, f4, (((float) this.otpViewItemHeight) + paddingTop) - ((float) this.lineWidth));
    }

    private void updateOtpViewBoxPath(int i) {
        boolean z;
        boolean z2;
        if (this.otpViewItemSpacing != 0) {
            z2 = true;
            z = true;
        } else {
            boolean z3 = i == 0 && i != this.otpViewItemCount - 1;
            if (i != this.otpViewItemCount - 1 || i == 0) {
                z2 = z3;
                z = false;
            } else {
                z2 = z3;
                z = true;
            }
        }
        RectF rectF = this.itemBorderRect;
        int i2 = this.otpViewItemRadius;
        updateRoundRectPath(rectF, (float) i2, (float) i2, z2, z);
    }

    private void updatePaints() {
        this.paint.setColor(this.cursorLineColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth((float) this.lineWidth);
        getPaint().setColor(getCurrentTextColor());
    }

    private void updateRoundRectPath(RectF rectF, float f2, float f3, boolean z, boolean z2) {
        updateRoundRectPath(rectF, f2, f3, z, z2, z2, z);
    }

    private void updateRoundRectPath(RectF rectF, float f2, float f3, boolean z, boolean z2, boolean z3, boolean z4) {
        this.path.reset();
        float f4 = rectF.left;
        float f5 = rectF.top;
        float f6 = (rectF.right - f4) - (f2 * 2.0f);
        float f7 = (rectF.bottom - f5) - (2.0f * f3);
        this.path.moveTo(f4, f5 + f3);
        if (z) {
            float f8 = -f3;
            this.path.rQuadTo(0.0f, f8, f2, f8);
        } else {
            this.path.rLineTo(0.0f, -f3);
            this.path.rLineTo(f2, 0.0f);
        }
        this.path.rLineTo(f6, 0.0f);
        Path path2 = this.path;
        if (z2) {
            path2.rQuadTo(f2, 0.0f, f2, f3);
        } else {
            path2.rLineTo(f2, 0.0f);
            this.path.rLineTo(0.0f, f3);
        }
        this.path.rLineTo(0.0f, f7);
        Path path3 = this.path;
        if (z3) {
            path3.rQuadTo(0.0f, f3, -f2, f3);
        } else {
            path3.rLineTo(0.0f, f3);
            this.path.rLineTo(-f2, 0.0f);
        }
        this.path.rLineTo(-f6, 0.0f);
        Path path4 = this.path;
        float f9 = -f2;
        if (z4) {
            path4.rQuadTo(f9, 0.0f, f9, -f3);
        } else {
            path4.rLineTo(f9, 0.0f);
            this.path.rLineTo(0.0f, -f3);
        }
        this.path.rLineTo(0.0f, -f7);
        this.path.close();
    }

    @Override // b.b.q.k
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.lineColor;
        if (colorStateList == null || colorStateList.isStateful()) {
            updateColors();
        }
    }

    public int getCurrentLineColor() {
        return this.cursorLineColor;
    }

    public int getCursorColor() {
        return this.cursorColor;
    }

    public int getCursorWidth() {
        return this.cursorWidth;
    }

    public MovementMethod getDefaultMovementMethod() {
        return DefaultMovementMethod.getInstance();
    }

    public int getItemCount() {
        return this.otpViewItemCount;
    }

    public int getItemHeight() {
        return this.otpViewItemHeight;
    }

    public int getItemRadius() {
        return this.otpViewItemRadius;
    }

    public int getItemSpacing() {
        return this.otpViewItemSpacing;
    }

    public int getItemWidth() {
        return this.otpViewItemWidth;
    }

    public ColorStateList getLineColors() {
        return this.lineColor;
    }

    public int getLineWidth() {
        return this.lineWidth;
    }

    public String getMaskingChar() {
        return this.maskingChar;
    }

    public boolean isCursorVisible() {
        return this.isCursorVisible;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeBlink();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        suspendBlink();
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        updatePaints();
        drawOtpView(canvas);
        canvas.restore();
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            moveSelectionToEnd();
            makeBlink();
        }
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.otpViewItemHeight;
        if (mode != 1073741824) {
            int i4 = this.otpViewItemCount;
            size = getPaddingStart() + m.s(this) + (i4 * this.otpViewItemWidth) + ((i4 - 1) * this.otpViewItemSpacing);
            if (this.otpViewItemSpacing == 0) {
                size -= (this.otpViewItemCount - 1) * this.lineWidth;
            }
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingTop() + i3 + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (i == 1) {
            resumeBlink();
        } else if (i == 0) {
            suspendBlink();
        }
    }

    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (getText() != null && i2 != getText().length()) {
            moveSelectionToEnd();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ValueAnimator valueAnimator;
        OnOtpCompletionListener onOtpCompletionListener2;
        if (i != charSequence.length()) {
            moveSelectionToEnd();
        }
        if (charSequence.length() == this.otpViewItemCount && (onOtpCompletionListener2 = this.onOtpCompletionListener) != null) {
            onOtpCompletionListener2.onOtpCompleted(charSequence.toString());
        }
        makeBlink();
        if (this.isAnimationEnable) {
            if ((i3 - i2 > 0) && (valueAnimator = this.defaultAddAnimator) != null) {
                valueAnimator.end();
                this.defaultAddAnimator.start();
            }
        }
    }

    public void setAnimationEnable(boolean z) {
        this.isAnimationEnable = z;
    }

    public void setCursorColor(int i) {
        this.cursorColor = i;
        if (isCursorVisible()) {
            invalidateCursor(true);
        }
    }

    public void setCursorVisible(boolean z) {
        if (this.isCursorVisible != z) {
            this.isCursorVisible = z;
            invalidateCursor(z);
            makeBlink();
        }
    }

    public void setCursorWidth(int i) {
        this.cursorWidth = i;
        if (isCursorVisible()) {
            invalidateCursor(true);
        }
    }

    public void setHideLineWhenFilled(boolean z) {
        this.hideLineWhenFilled = z;
    }

    public void setItemBackground(Drawable drawable) {
        this.itemBackgroundResource = 0;
        this.itemBackground = drawable;
        invalidate();
    }

    public void setItemBackgroundColor(int i) {
        Drawable drawable = this.itemBackground;
        if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable.mutate()).setColor(i);
            this.itemBackgroundResource = 0;
            return;
        }
        setItemBackground(new ColorDrawable(i));
    }

    public void setItemBackgroundResources(int i) {
        if (i == 0 || this.itemBackgroundResource == i) {
            Drawable drawable = getResources().getDrawable(i, getContext().getTheme());
            this.itemBackground = drawable;
            setItemBackground(drawable);
            this.itemBackgroundResource = i;
        }
    }

    public void setItemCount(int i) {
        this.otpViewItemCount = i;
        setMaxLength(i);
        requestLayout();
    }

    public void setItemHeight(int i) {
        this.otpViewItemHeight = i;
        updateCursorHeight();
        requestLayout();
    }

    public void setItemRadius(int i) {
        this.otpViewItemRadius = i;
        checkItemRadius();
        requestLayout();
    }

    public void setItemSpacing(int i) {
        this.otpViewItemSpacing = i;
        requestLayout();
    }

    public void setItemWidth(int i) {
        this.otpViewItemWidth = i;
        checkItemRadius();
        requestLayout();
    }

    public void setLineColor(int i) {
        this.lineColor = ColorStateList.valueOf(i);
        updateColors();
    }

    public void setLineColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.lineColor = colorStateList;
            updateColors();
            return;
        }
        throw new IllegalArgumentException("Color cannot be null");
    }

    public void setLineWidth(int i) {
        this.lineWidth = i;
        checkItemRadius();
        requestLayout();
    }

    public void setMaskingChar(String str) {
        this.maskingChar = str;
        requestLayout();
    }

    public void setOtpCompletionListener(OnOtpCompletionListener onOtpCompletionListener2) {
        this.onOtpCompletionListener = onOtpCompletionListener2;
    }

    public void setTextSize(float f2) {
        super.setTextSize(f2);
        updateCursorHeight();
    }

    public void setTextSize(int i, float f2) {
        super.setTextSize(i, f2);
        updateCursorHeight();
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        TextPaint textPaint = this.animatorTextPaint;
        if (textPaint != null) {
            textPaint.set(getPaint());
        }
    }

    public void setTypeface(Typeface typeface, int i) {
        super.setTypeface(typeface, i);
    }
}
