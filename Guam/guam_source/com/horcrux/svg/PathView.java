package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
public class PathView extends RenderableView {
    public Path mPath = new Path();

    public PathView(ReactContext reactContext) {
        super(reactContext);
        PathParser.mScale = this.mScale;
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView
    public Path getPath(Canvas canvas, Paint paint) {
        return this.mPath;
    }

    @ReactProp(name = "d")
    public void setD(String str) {
        boolean z;
        boolean z2;
        PathParser.elements = new ArrayList<>();
        Path path = new Path();
        PathParser.mPath = path;
        if (str != null) {
            PathParser.l = str.length();
            PathParser.s = str;
            PathParser.i = 0;
            float f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            PathParser.mPenX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            PathParser.mPenY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            PathParser.mPivotX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            PathParser.mPivotY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            PathParser.mPenDownX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            PathParser.mPenDownY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            PathParser.mPenDown = false;
            char c = ' ';
            while (PathParser.i < PathParser.l) {
                PathParser.skip_spaces();
                if (PathParser.i >= PathParser.l) {
                    path = PathParser.mPath;
                } else {
                    boolean z3 = c != ' ';
                    char charAt = PathParser.s.charAt(PathParser.i);
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
                            PathParser.i++;
                            z2 = false;
                            c = charAt;
                        } else {
                            if (!((charAt >= '0' && charAt <= '9') || charAt == '.' || charAt == '-' || charAt == '+') || !z3) {
                                throw new Error(String.format("Unexpected character '%c' (i=%d, s=%s)", Character.valueOf(charAt), Integer.valueOf(PathParser.i), PathParser.s));
                            } else if (c == 'Z' || c == 'z') {
                                throw new Error(String.format("Unexpected number after 'z' (s=%s)", PathParser.s));
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
                                PathParser.arcTo(PathParser.parse_list_number(), PathParser.parse_list_number(), PathParser.parse_list_number(), PathParser.parse_flag(), PathParser.parse_flag(), PathParser.parse_list_number(), PathParser.parse_list_number());
                                break;
                            case 'C':
                                float parse_list_number = PathParser.parse_list_number();
                                float parse_list_number2 = PathParser.parse_list_number();
                                float parse_list_number3 = PathParser.parse_list_number();
                                float parse_list_number4 = PathParser.parse_list_number();
                                float parse_list_number5 = PathParser.parse_list_number();
                                float parse_list_number6 = PathParser.parse_list_number();
                                PathParser.mPivotX = parse_list_number3;
                                PathParser.mPivotY = parse_list_number4;
                                PathParser.cubicTo(parse_list_number, parse_list_number2, parse_list_number3, parse_list_number4, parse_list_number5, parse_list_number6);
                                break;
                            case 'H':
                                PathParser.lineTo(PathParser.parse_list_number(), PathParser.mPenY);
                                break;
                            case 'L':
                                PathParser.lineTo(PathParser.parse_list_number(), PathParser.parse_list_number());
                                break;
                            case 'M':
                                PathParser.moveTo(PathParser.parse_list_number(), PathParser.parse_list_number());
                                break;
                            case 'Q':
                                PathParser.quadraticBezierCurveTo(PathParser.parse_list_number(), PathParser.parse_list_number(), PathParser.parse_list_number(), PathParser.parse_list_number());
                                break;
                            case 'S':
                                PathParser.smoothCurveTo(PathParser.parse_list_number(), PathParser.parse_list_number(), PathParser.parse_list_number(), PathParser.parse_list_number());
                                break;
                            case 'T':
                                PathParser.smoothQuadraticBezierCurveTo(PathParser.parse_list_number(), PathParser.parse_list_number());
                                break;
                            case 'V':
                                PathParser.lineTo(PathParser.mPenX, PathParser.parse_list_number());
                                break;
                            case 'Z':
                            case 'z':
                                if (PathParser.mPenDown) {
                                    PathParser.mPenX = PathParser.mPenDownX;
                                    PathParser.mPenY = PathParser.mPenDownY;
                                    PathParser.mPenDown = false;
                                    PathParser.mPath.close();
                                    PathParser.elements.add(new PathElement(ElementType.kCGPathElementCloseSubpath, new Point[]{new Point((double) PathParser.mPenX, (double) PathParser.mPenY)}));
                                    break;
                                }
                                break;
                            case 'a':
                                PathParser.arcTo(PathParser.parse_list_number(), PathParser.parse_list_number(), PathParser.parse_list_number(), PathParser.parse_flag(), PathParser.parse_flag(), PathParser.parse_list_number() + PathParser.mPenX, PathParser.parse_list_number() + PathParser.mPenY);
                                break;
                            case 'c':
                                float parse_list_number7 = PathParser.parse_list_number();
                                float parse_list_number8 = PathParser.parse_list_number();
                                float parse_list_number9 = PathParser.parse_list_number();
                                float parse_list_number10 = PathParser.parse_list_number();
                                float parse_list_number11 = PathParser.parse_list_number();
                                float parse_list_number12 = PathParser.parse_list_number();
                                float f2 = PathParser.mPenX;
                                float f3 = parse_list_number7 + f2;
                                float f4 = PathParser.mPenY;
                                float f5 = parse_list_number9 + f2;
                                float f6 = parse_list_number10 + f4;
                                PathParser.mPivotX = f5;
                                PathParser.mPivotY = f6;
                                PathParser.cubicTo(f3, parse_list_number8 + f4, f5, f6, parse_list_number11 + f2, parse_list_number12 + f4);
                                break;
                            case 'h':
                                PathParser.line(PathParser.parse_list_number(), f);
                                break;
                            case 'l':
                                PathParser.line(PathParser.parse_list_number(), PathParser.parse_list_number());
                                break;
                            case 'm':
                                PathParser.moveTo(PathParser.parse_list_number() + PathParser.mPenX, PathParser.parse_list_number() + PathParser.mPenY);
                                break;
                            case 'q':
                                float parse_list_number13 = PathParser.parse_list_number();
                                float parse_list_number14 = PathParser.parse_list_number();
                                float parse_list_number15 = PathParser.parse_list_number();
                                float parse_list_number16 = PathParser.parse_list_number();
                                float f7 = PathParser.mPenX;
                                float f8 = PathParser.mPenY;
                                PathParser.quadraticBezierCurveTo(parse_list_number13 + f7, parse_list_number14 + f8, parse_list_number15 + f7, parse_list_number16 + f8);
                                break;
                            case 's':
                                float parse_list_number17 = PathParser.parse_list_number();
                                float parse_list_number18 = PathParser.parse_list_number();
                                float parse_list_number19 = PathParser.parse_list_number();
                                float parse_list_number20 = PathParser.parse_list_number();
                                float f9 = PathParser.mPenX;
                                float f10 = PathParser.mPenY;
                                PathParser.smoothCurveTo(parse_list_number17 + f9, parse_list_number18 + f10, parse_list_number19 + f9, parse_list_number20 + f10);
                                break;
                            case 't':
                                PathParser.smoothQuadraticBezierCurveTo(PathParser.parse_list_number() + PathParser.mPenX, PathParser.parse_list_number() + PathParser.mPenY);
                                break;
                            case 'v':
                                PathParser.line(f, PathParser.parse_list_number());
                                break;
                            default:
                                throw new Error(String.format("Unexpected comand '%c' (s=%s)", Character.valueOf(c), PathParser.s));
                        }
                        if (z2) {
                            c = isUpperCase ? 'M' : 'm';
                        }
                        f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                    } else {
                        throw new Error(String.format("Unexpected character '%c' (i=%d, s=%s)", Character.valueOf(charAt), Integer.valueOf(PathParser.i), PathParser.s));
                    }
                }
            }
            path = PathParser.mPath;
        }
        this.mPath = path;
        this.elements = PathParser.elements;
        invalidate();
    }
}
