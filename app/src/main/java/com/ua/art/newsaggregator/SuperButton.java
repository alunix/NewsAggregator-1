package com.ua.art.newsaggregator;

import android.content.Context;
import android.widget.Button;

public class SuperButton extends Button {
    private boolean superPressureBtn = false;

    public SuperButton(Context context) {
        super(context);
    }

    public boolean getSuperPressureBtn() {
        return superPressureBtn;
    }

    public void setSuperPressureBtn(boolean superPressureBtn) {
        this.superPressureBtn = superPressureBtn;
    }
}
