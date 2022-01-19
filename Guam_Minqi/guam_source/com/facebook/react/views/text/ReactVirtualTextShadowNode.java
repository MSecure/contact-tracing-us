package com.facebook.react.views.text;

public class ReactVirtualTextShadowNode extends ReactBaseTextShadowNode {
    public ReactVirtualTextShadowNode() {
        super(null);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public boolean isVirtual() {
        return true;
    }
}
