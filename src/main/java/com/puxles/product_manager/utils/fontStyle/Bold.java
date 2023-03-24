package com.puxles.product_manager.utils.fontStyle;

import org.apache.poi.ss.usermodel.Font;

public class Bold implements FontStyle {
    @Override
    public void getFontWithStyle(Font font) {
        font.setBold(true);
    }
}
