package fa.training.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.models.Xe;

//Định nghĩa một interface XeService để quản lý các thao tác liên quan đến đối tượng Xe
public interface XeService {
	
	// Phương thức để lưu hoặc cập nhật thông tin của một đối tượng Xe
	void saveOrUpdate(Xe detail);

	// Phương thức để lấy danh sách tất cả các đối tượng Xe từ cơ sở dữ liệu
	List<Xe> findAll();

	// Phương thức để tìm một đối tượng Xe dựa trên id
	Xe findByID(String id);

	// Phương thức để xóa một đối tượng Xe dựa trên id
	void deleteById(String id);

	// Phương thức để lấy danh sách các đối tượng Xe theo trang từ cơ sở dữ liệu
	Page<Xe> findAll(Pageable pageable);

	// Phương thức để lấy danh sách các đối tượng Xe theo điều kiện tìm kiếm và phân trang
	Page<Xe> findAllWithSearch(String searchInput, Pageable pageable);

	// Phương thức để kiểm tra xem một đối tượng Xe có tồn tại trong cơ sở dữ liệu hay không dựa trên id
	boolean existByID(String id);
	
}

