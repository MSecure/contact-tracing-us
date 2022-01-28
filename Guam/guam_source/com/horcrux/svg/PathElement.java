package com.horcrux.svg;

/* compiled from: PathParser */
public class PathElement {
    public Point[] points;
    public ElementType type;

    public PathElement(ElementType elementType, Point[] pointArr) {
        this.type = elementType;
        this.points = pointArr;
    }
}
