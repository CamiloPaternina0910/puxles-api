package com.puxles.product_manager.utils.fonts;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

public class Arial implements FactoryFont{
    @Override
    public Font getFont(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName("Arial");
        return font;
    }


}
