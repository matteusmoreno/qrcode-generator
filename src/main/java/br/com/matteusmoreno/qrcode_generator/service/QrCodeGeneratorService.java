package br.com.matteusmoreno.qrcode_generator.service;

import br.com.matteusmoreno.qrcode_generator.dto.QrCodeGenerateResponse;
import br.com.matteusmoreno.qrcode_generator.ports.StoragePort;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class QrCodeGeneratorService {
    private final StoragePort storagePort;

    public QrCodeGeneratorService(StoragePort storagePort) {
        this.storagePort = storagePort;
    }

    public QrCodeGenerateResponse generateAndUploadQrCode(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);
        byte[] pngQrCodeData = outputStream.toByteArray();

        String url = storagePort.uploadFile(pngQrCodeData, "qrcode" + LocalDateTime.now() + ".png", "image/png");

        return new QrCodeGenerateResponse(url);
    }
}
