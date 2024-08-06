package fa.training.service;

//Định nghĩa một interface TuyenXeService để quản lý các thao tác liên quan đến đối tượng TuyenXe
public interface TuyenXeService {
	
	// Phương thức để kiểm tra xem có tồn tại một đối tượng KhuDoThi trong cơ sở dữ liệu dựa trên id hay không
	boolean existByID(String id);
}

