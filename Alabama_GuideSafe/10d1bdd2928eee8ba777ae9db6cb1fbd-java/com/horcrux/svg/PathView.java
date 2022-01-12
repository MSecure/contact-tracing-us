package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
public class PathView extends RenderableView {
    public Path mPath = new Path();

    public PathView(ReactContext reactContext) {
        super(reactContext);
        MoreExecutors.mScale = this.mScale;
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView
    public Path getPath(Canvas canvas, Paint paint) {
        return this.mPath;
    }

    @ReactProp(name = "d")
    public void setD(String str) {
        boolean z;
        boolean z2;
        MoreExecutors.elements = new ArrayList<>();
        Path path = new Path();
        MoreExecutors.mPath = path;
        if (str != null) {
            MoreExecutors.l = str.length();
            MoreExecutors.s = str;
            MoreExecutors.i = 0;
            float f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            MoreExecutors.mPenX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            MoreExecutors.mPenY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            MoreExecutors.mPivotX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            MoreExecutors.mPivotY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            MoreExecutors.mPenDownX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            MoreExecutors.mPenDownY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            MoreExecutors.mPenDown = false;
            char c = ' ';
            while (MoreExecutors.i < MoreExecutors.l) {
                MoreExecutors.skip_spaces();
                if (MoreExecutors.i >= MoreExecutors.l) {
                    path = MoreExecutors.mPath;
                } else {
                    boolean z3 = c != ' ';
                    char charAt = MoreExecutors.s.charAt(MoreExecutors.i);
                    if (z3 || charAt == 'M' || charAt == 'm') {
                        switch (charAt) {
                            case 'A':
                            case 'C':
                            case 'H':
                            case 'L':
                            case 'M':
                            case 'Q':
                            case 'S':
                            case 'T':
                            case 'V':
                            case 'Z':
                            case 'a':
                            case 'c':
                            case 'h':
                            case 'l':
                            case 'm':
                            case 'q':
                            case 's':
                            case 't':
                            case 'v':
                            case 'z':
                                z = true;
                                break;
                            default:
                                z = false;
                                break;
                        }
                        if (z) {
                            MoreExecutors.i++;
                            z2 = false;
                            c = charAt;
                        } else {
                            if (!((charAt >= '0' && charAt <= '9') || charAt == '.' || charAt == '-' || charAt == '+') || !z3) {
                                throw new Error(String.format("Unexpected character '%c' (i=%d, s=%s)", Character.valueOf(charAt), Integer.valueOf(MoreExecutors.i), MoreExecutors.s));
                            } else if (c == 'Z' || c == 'z') {
                                throw new Error(String.format("Unexpected number after 'z' (s=%s)", MoreExecutors.s));
                            } else if (c == 'M' || c == 'm') {
                                c = Character.isUpperCase(c) ? 'L' : 'l';
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        }
                        boolean isUpperCase = Character.isUpperCase(c);
                        switch (c) {
                            case 'A':
                                MoreExecutors.arcTo(MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number(), MoreExecutors.parse_flag(), MoreExecutors.parse_flag(), MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number());
                                break;
                            case 'C':
                                float parse_list_number = MoreExecutors.parse_list_number();
                                float parse_list_number2 = MoreExecutors.parse_list_number();
                                float parse_list_number3 = MoreExecutors.parse_list_number();
                                float parse_list_number4 = MoreExecutors.parse_list_number();
                                float parse_list_number5 = MoreExecutors.parse_list_number();
                                float parse_list_number6 = MoreExecutors.parse_list_number();
                                MoreExecutors.mPivotX = parse_list_number3;
                                MoreExecutors.mPivotY = parse_list_number4;
                                MoreExecutors.cubicTo(parse_list_number, parse_list_number2, parse_list_number3, parse_list_number4, parse_list_number5, parse_list_number6);
                                break;
                            case 'H':
                                MoreExecutors.lineTo(MoreExecutors.parse_list_number(), MoreExecutors.mPenY);
                                break;
                            case 'L':
                                MoreExecutors.lineTo(MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number());
                                break;
                            case 'M':
                                MoreExecutors.moveTo(MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number());
                                break;
                            case 'Q':
                                MoreExecutors.quadraticBezierCurveTo(MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number());
                                break;
                            case 'S':
                                MoreExecutors.smoothCurveTo(MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number());
                                break;
                            case 'T':
                                MoreExecutors.smoothQuadraticBezierCurveTo(MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number());
                                break;
                            case 'V':
                                MoreExecutors.lineTo(MoreExecutors.mPenX, MoreExecutors.parse_list_number());
                                break;
                            case 'Z':
                            case 'z':
                                if (MoreExecutors.mPenDown) {
                                    MoreExecutors.mPenX = MoreExecutors.mPenDownX;
                                    MoreExecutors.mPenY = MoreExecutors.mPenDownY;
                                    MoreExecutors.mPenDown = false;
                                    MoreExecutors.mPath.close();
                                    MoreExecutors.elements.add(new PathElement(ElementType.kCGPathElementCloseSubpath, new Point[]{new Point((double) MoreExecutors.mPenX, (double) MoreExecutors.mPenY)}));
                                    break;
                                }
                                break;
                            case 'a':
                                MoreExecutors.arcTo(MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number(), MoreExecutors.parse_flag(), MoreExecutors.parse_flag(), MoreExecutors.parse_list_number() + MoreExecutors.mPenX, MoreExecutors.parse_list_number() + MoreExecutors.mPenY);
                                break;
                            case 'c':
                                float parse_list_number7 = MoreExecutors.parse_list_number();
                                float parse_list_number8 = MoreExecutors.parse_list_number();
                                float parse_list_number9 = MoreExecutors.parse_list_number();
                                float parse_list_number10 = MoreExecutors.parse_list_number();
                                float parse_list_number11 = MoreExecutors.parse_list_number();
                                float parse_list_number12 = MoreExecutors.parse_list_number();
                                float f2 = MoreExecutors.mPenX;
                                float f3 = parse_list_number7 + f2;
                                float f4 = MoreExecutors.mPenY;
                                float f5 = parse_list_number9 + f2;
                                float f6 = parse_list_number10 + f4;
                                MoreExecutors.mPivotX = f5;
                                MoreExecutors.mPivotY = f6;
                                MoreExecutors.cubicTo(f3, parse_list_number8 + f4, f5, f6, parse_list_number11 + f2, parse_list_number12 + f4);
                                break;
                            case 'h':
                                MoreExecutors.line(MoreExecutors.parse_list_number(), f);
                                break;
                            case 'l':
                                MoreExecutors.line(MoreExecutors.parse_list_number(), MoreExecutors.parse_list_number());
                                break;
                            case 'm':
                                MoreExecutors.moveTo(MoreExecutors.parse_list_number() + MoreExecutors.mPenX, MoreExecutors.parse_list_number() + MoreExecutors.mPenY);
                                break;
                            case 'q':
                                float parse_list_number13 = MoreExecutors.parse_list_number();
                                float parse_list_number14 = MoreExecutors.parse_list_number();
                                float parse_list_number15 = MoreExecutors.parse_list_number();
                                float parse_list_number16 = MoreExecutors.parse_list_number();
                                float f7 = MoreExecutors.mPenX;
                                float f8 = MoreExecutors.mPenY;
                                MoreExecutors.quadraticBezierCurveTo(parse_list_number13 + f7, parse_list_number14 + f8, parse_list_number15 + f7, parse_list_number16 + f8);
                                break;
                            case 's':
                                float parse_list_number17 = MoreExecutors.parse_list_number();
                                float parse_list_number18 = MoreExecutors.parse_list_number();
                                float parse_list_number19 = MoreExecutors.parse_list_number();
                                float parse_list_number20 = MoreExecutors.parse_list_number();
                                float f9 = MoreExecutors.mPenX;
                                float f10 = MoreExecutors.mPenY;
                                MoreExecutors.smoothCurveTo(parse_list_number17 + f9, parse_list_number18 + f10, parse_list_number19 + f9, parse_list_number20 + f10);
                                break;
                            case 't':
                                MoreExecutors.smoothQuadraticBezierCurveTo(MoreExecutors.parse_list_number() + MoreExecutors.mPenX, MoreExecutors.parse_list_number() + MoreExecutors.mPenY);
                                break;
                            case 'v':
                                MoreExecutors.line(f, MoreExecutors.parse_list_number());
                                break;
                            default:
                                throw new Error(String.format("Unexpected comand '%c' (s=%s)", Character.valueOf(c), MoreExecutors.s));
                        }
                        if (z2) {
                            c = isUpperCase ? 'M' : 'm';
                        }
                        f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                    } else {
                        throw new Error(String.format("Unexpected character '%c' (i=%d, s=%s)", Character.valueOf(charAt), Integer.valueOf(MoreExecutors.i), MoreExecutors.s));
                    }
                }
            }
            path = MoreExecutors.mPath;
        }
        this.mPath = path;
        this.elements = MoreExecutors.elements;
        invalidate();
    }
}
