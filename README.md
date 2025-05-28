# Bai-thuc-hanh-3
## Giới thiệu
Một ứng dụng mô phỏng giao diện website bán sản phẩm được xây dựng bằng Java Swing, với bố cục chia hai phần:
- **Bên trái:** Hiển thị chi tiết sản phẩm đã chọn.
- **Bên phải:** Danh sách các sản phẩm, có thể cuộn và chọn được.
## Cấu trúc thư mục
```
Bai-thuc-hanh-3
├── public
│ ├── images 
  │ ├── img1.png
  │ ├── img2.png
  │ ├── img3.png
  │ ├── img4.png
  │ ├── img5.png
  │ └── img6.png
│ └── sample.png
├── src
    ├── Product.java  //lớp lưu thông tin sản phẩm
    ├── ProductCard.java  //Thành phần giao diện của từng sản phẩm ở danh sách sản phẩm
    ├── ProductWeb.java  //Main UI ứng dụng
    └── WrapLayout.java  //Layout tùy biến giúp tự động xuống dòng
├── assignment.ipynb  //Đề bài
└── README.md
```
## Công nghệ sử dụng
- Java SE 8+
- Java Swing
- `BoxLayout`, `WrapLayout`, `JScrollPane`
## Giao diện mẫu
![image](https://github.com/user-attachments/assets/f89ec56e-cbad-4162-9f93-d7ab3d41ac1a)
## WrapLayout là gì?
`WrapLayout.java` là một layout tự tùy chỉnh kế thừa từ `FlowLayout`, cho phép các component tự động **xuống dòng** nếu không đủ chiều ngang. Điều này giúp đảm bảo rằng các thẻ sản phẩm không bị kéo dãn chiều rộng và luôn giữ kích thước cố định, rất phù hợp với UI dạng grid co giãn.
Nguồn tham khảo: [`https://tips4java.wordpress.com/2008/11/06/wrap-layout/`](https://tips4java.wordpress.com/2008/11/06/wrap-layout/)

#### 22521641 - Nguyễn Đăng Hương Uyên - IE303.P22.1
