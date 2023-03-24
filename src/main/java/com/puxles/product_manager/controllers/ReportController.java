package com.puxles.product_manager.controllers;

import com.puxles.product_manager.services.ProductService;
import com.puxles.product_manager.services.ReportService;
import com.puxles.product_manager.utils.fonts.Arial;
import com.puxles.product_manager.utils.fonts.TimesNewRoman;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/report")
@CrossOrigin("*")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/get")
    public ResponseEntity<byte[]> download(HttpServletResponse response) throws IOException, ExecutionException, InterruptedException {
        Workbook workbook = new XSSFWorkbook();
        String[] head = {"Product id", "Product name", "Product price", "Product stock"};
        byte[] data = reportService.generateXlsxReport(new TimesNewRoman().getFont(workbook), new Arial().getFont(workbook), List.of(head), productService.findAll(), workbook);
        return createResponse("report.xlsx", data);
    }

    private ResponseEntity<byte[]> createResponse(String fileName, byte[] report){
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .body(report);
    }
}
