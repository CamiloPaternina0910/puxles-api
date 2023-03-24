package com.puxles.product_manager.utils.fonts;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

public interface FactoryFont {
    Font getFont(Workbook workbook);

}
