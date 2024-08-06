package fa.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.training.models.LichTrinh;
import fa.training.models.LichTrinhPK;
import fa.training.models.dto.MoneyInfoDTO;
import fa.training.models.dto.SumInfoDTO;

//Định nghĩa một interface LichTrinhRepository kế thừa từ JpaRepository, 
//được sử dụng để thao tác với đối tượng LichTrinh trong cơ sở dữ liệu
public interface LichTrinhRepository extends JpaRepository<LichTrinh, LichTrinhPK> {

	// Định nghĩa một phương thức truy vấn tùy chỉnh sử dụng JPQL để lấy danh sách
	// các đối tượng SumInfoDTO
	@Query(value = "select new fa.training.models.dto.SumInfoDTO(x.maXe, x.bienSoXe, lt.taiXe, nx.tenNhaXe, tx.maTuyen, "
			+ "tx.tenTuyen, lt.lichTrinhPK.ngayXuatBen, lt.lichTrinhPK.gioXuatBen) " 
			+ "FROM LichTrinh lt "
			+ "LEFT JOIN lt.lichTrinhPK.xe x " 
			+ "LEFT JOIN x.nhaXe nx " 
			+ "LEFT JOIN lt.tuyenXe tx "
			+ "WHERE nx.tenNhaXe LIKE %?1%")

	// Phương thức này nhận vào một chuỗi tìm kiếm và một đối tượng Pageable để phục
	// vụ cho việc phân trang
	Page<SumInfoDTO> findAllWithSearch(String searchInput, Pageable pageable);

	// Định nghĩa một phương thức truy vấn tùy chỉnh sử dụng JPQL để lấy danh sách
	// các đối tượng SumInfoDTO
	@Query("SELECT new fa.training.models.dto.MoneyInfoDTO(nx.maNhaXe, tx.donGia, lt.soLuongHanhKhach) "
			+ "FROM LichTrinh lt " 
			+ "LEFT JOIN lt.lichTrinhPK.xe x " 
			+ "LEFT JOIN x.nhaXe nx "
			+ "LEFT JOIN lt.tuyenXe tx " 
			+ "WHERE nx.maNhaXe LIKE %?1% "
			+ "GROUP BY nx.maNhaXe, tx.donGia, lt.soLuongHanhKhach")
	// Phương thức này nhận vào một chuỗi tìm kiếm và một đối tượng Pageable để phục
	// vụ cho việc phân trang
	Page<MoneyInfoDTO> findAllWithSearchMoney(String searchInput, Pageable pageable);

}
