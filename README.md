# Hướng dẫn cài đặt phần Backend của hệ thống EduPath
## Những công cụ cần thiết
1. **IntelliJ IDEA**: Tải IntelliJ IDEA [tại đây](https://www.jetbrains.com/idea/download/?section=windows)
2. **Hệ quản trị cơ sở dữ liệu Oracle** (khuyến nghị phiên bản 21c): [Tải Oracle 21c](https://www.oracle.com/database/technologies/oracle21c-windows-downloads.html)

## Các bước cài đặt
1. Mở Folder dự án EduPath, truy cập vào folder sâu nhất có tên **springboot-server**
2. Truy cập vào file /pom.xml và đợi cài đặt các dependencies
3. Truy cập vào file /src/main/resources/application.properties:
```bash
// Chỉnh sửa dòng orcl bằng Service Name hoặc SID của hệ quản trị Oracle
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/<service name hoặc SID>
```
```bash
// Nhập username của USER trong Oracle và password là mật khẩu của USER
spring.datasource.username=C##EDUPATH
spring.datasource.password=1234
```
4. Truy cập vào file /src/main/java/com/SpringbootServerApplication và chạy file này
5. Nếu Terminal hiển thị: *Started SpringbootServerApplication in 9.031 seconds* thì tức là Backend đã chạy thành công
