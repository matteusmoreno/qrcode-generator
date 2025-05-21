# QRCode Generator API

This is a simple RESTful API built with **Spring Boot** that generates a **QR Code** from text and uploads it to an **AWS S3** bucket. The resulting QR code is accessible via a public URL returned in the response.

## 🧩 Features

- ✅ Generate QR codes from any text
- ☁️ Upload PNG images directly to AWS S3
- 🔗 Return a public URL for each generated QR code
- 🐳 Dockerized for easy deployment
- 📄 OpenAPI documentation available via Swagger UI

---

## 🚀 Technologies

- Java 21
- Spring Boot 3.4.5
- ZXing (QR Code generation)
- AWS S3 SDK (v2)
- Docker + Docker Compose
- SpringDoc OpenAPI

---

## 📦 Docker

### 🛠 Build the Docker image

```bash
docker build -t matteusmoreno/qrcode-generator:1.0.1 .
````

### ▶️ Run with Docker Compose

```bash
docker-compose up -d
```

Ensure the `.env` file exists with your AWS credentials and environment variables:

```env
AWS_ACCESS_KEY_ID=your_aws_access_key_id
AWS_SECRET_ACCESS_KEY=your_aws_secret_access_key
AWS_S3_BUCKET_NAME=qrcode-storage-matteus-moreno
AWS_S3_BUCKET_REGION=us-east-2
```

---

## 📬 API Usage

### Generate QR Code

**Endpoint:** `POST /qrcode`

**Request Body:**

```json
{
  "text": "https://yourwebsite.com"
}
```

**Response:**

```json
{
  "url": "https://qrcode-storage-matteus-moreno.s3.us-east-2.amazonaws.com/qrcode2025-05-21T16:30:00.png"
}
```

---

## 📚 Documentation

Once the application is running, you can access the Swagger UI:

> [http://localhost:8282/swagger-ui/index.html](http://localhost:8282/swagger-ui.html)

---

## 📁 Project Structure

```
src/
├── controller/
│   └── QrCodeController.java
├── dto/
│   ├── QrCodeGenerateRequest.java
│   └── QrCodeGenerateResponse.java
├── infrastruct/
│   └── S3StorageAdapter.java
├── ports/
│   └── StoragePort.java
└── service/
    └── QrCodeGeneratorService.java
```

---

## 📸 Example

Generate a QR Code and get a public URL pointing to the image hosted in your S3 bucket:

![Example QR](https://qrcode-storage-matteus-moreno.s3.us-east-2.amazonaws.com/example.png)

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---


