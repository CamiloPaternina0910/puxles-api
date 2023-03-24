package com.puxles.product_manager.services;

import com.puxles.product_manager.entities.Product;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportServiceImp implements ReportService{
    @Override
    public byte[] generateXlsxReport(Font headers, Font body, List<String> headerString, List<Product> data, Workbook workbook) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Sheet sheet = workbook.createSheet("Puxles Report");
        writeHeaderWithStyleFont(headers, sheet, headerString);
        writeBodyWithStyleFont(body, sheet, data);
        workbook.write(out);
        out.close();
        workbook.close();

        return out.toByteArray();
    }

    private void writeHeaderWithStyleFont(Font font, Sheet sheet, List<String> data){
        Row row = sheet.createRow(0);

        for (int i = 0; i < data.size(); i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(data.get(i));
            cell.getCellStyle().setFont(font);
        }
    }

    private void writeBodyWithStyleFont(Font font, Sheet sheet, List<Product> data){

        Row row;

        for (int b = 0; b < data.size(); b++) {
            Product dat = data.get(b);
            row = sheet.createRow(b+1);
            for (int i = 1; i <= 4; i++) {
                Cell cellId = row.createCell(0);
                cellId.setCellValue(dat.getProductId() + "");
                cellId.getCellStyle().setFont(font);
                Cell cellName = row.createCell(1);
                cellName.setCellValue(dat.getName());
                cellName.getCellStyle().setFont(font);
                Cell cellPrice = row.createCell(2);
                cellPrice.setCellValue(dat.getPrice() + "");
                cellPrice.getCellStyle().setFont(font);
                Cell cellStock = row.createCell(3);
                cellStock.setCellValue(dat.getStock() + "");
                cellStock.getCellStyle().setFont(font);
            }
        }
    }
}
