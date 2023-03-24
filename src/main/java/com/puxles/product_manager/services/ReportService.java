package com.puxles.product_manager.services;

import com.puxles.product_manager.entities.Product;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.List;

public interface ReportService {
    byte[] generateXlsxReport(Font headers, Font body, List<String> headerString, List<Product> data, Workbook workbook) throws IOException;

}
