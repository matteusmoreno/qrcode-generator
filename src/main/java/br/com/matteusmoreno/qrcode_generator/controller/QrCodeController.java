package br.com.matteusmoreno.qrcode_generator.controller;

import br.com.matteusmoreno.qrcode_generator.dto.QrCodeGenerateRequest;
import br.com.matteusmoreno.qrcode_generator.dto.QrCodeGenerateResponse;
import br.com.matteusmoreno.qrcode_generator.service.QrCodeGeneratorService;
import com.google.zxing.WriterException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generateQrCode(@RequestBody QrCodeGenerateRequest request) throws IOException, WriterException {
        QrCodeGenerateResponse response = qrCodeGeneratorService.generateAndUploadQrCode(request.text());
        return ResponseEntity.ok(response);
    }
}
