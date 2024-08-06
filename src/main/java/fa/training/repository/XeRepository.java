package fa.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.training.models.Xe;

//Định nghĩa một interface XeRepository kế thừa từ JpaRepository,
//được sử dụng để thao tác với đối tượng Xe trong cơ sở dữ liệu
public interface XeRepository extends JpaRepository<Xe, String> {
	
	// Định nghĩa một phương thức truy vấn tùy chỉnh sử dụng JPQL để lấy danh sách các đối tượng Xe dựa trên một chuỗi tìm kiếm
	@Query(value = "select md From Xe md where md.maXe LIKE %?1%")
	
	// Phương thức này nhận vào một chuỗi tìm kiếm và một đối tượng Pageable để phục vụ cho việc phân trang
	Page<Xe> findAllWithSearch(String searchInput, Pageable pageable);
	
	
}

