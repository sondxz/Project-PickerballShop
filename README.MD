# Spring Boot MVC Base Project (Java 17)

## 📌 Giới thiệu

Đây là **base project Spring Boot MVC** được xây dựng bằng **Java 17** và **Maven**, dùng làm nền tảng cho:

* Học Spring Boot / Spring MVC
* Làm bài tập, đồ án môn học
* Phát triển các ứng dụng web theo mô hình MVC

Project được khởi tạo từ **Spring Initializr** và chuẩn hóa lại cấu trúc theo thực tế doanh nghiệp.

---

## 🛠️ Công nghệ sử dụng

* **Java**: 17
* **Spring Boot**: 3.x
* **Build Tool**: Maven
* **IDE khuyên dùng**: IntelliJ IDEA / VS Code

---

## 📁 Cấu trúc dự án

```
src
 ├─ main
 │  ├─ java
 │  │  └─ vn.hoangson.pickerballshop
 │  │     ├─ PickerballApplication.java
 │  │     ├─ controller
 │  │     ├─ service
 │  │     │  └─ impl
 │  │     ├─ repository
 │  │     └─ domain
 │  │        └─ entity
 │  └─ resources
 │     └─ application.properties
 └─ test
    ├─ java
    │  └─ vn.hoangson.pickerballshop
    │     ├─ PickerballshopApplicationTests.java
```

---

## ▶️ Chạy dự án

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Linux / MacOS

```bash
./mvnw spring-boot:run
```

Truy cập:

```
http://localhost:8080
```

---

## 🎯 Mục tiêu
* Làm base project cho Spring MVC
* Dễ mở rộng thêm:

  * Controller
  * Service
  * Repository
  * View (Thymeleaf)
* Phù hợp cho sinh viên học Spring Boot

  * CRUD
  * MVC (Controller – Service – Repository)
  * Kết nối Database (MySQL / PostgreSQL)
  * Authentication & Authorization (sau này)

---

## 👤 Tác giả

* **Hoàng Sơn**
* Sinh viên CNTT
* Định hướng: Java Backend / Spring Boot Developer

---

