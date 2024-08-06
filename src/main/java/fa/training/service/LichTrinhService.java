package fa.training.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.models.LichTrinh;
import fa.training.models.LichTrinhPK;
import fa.training.models.dto.MoneyInfoDTO;
import fa.training.models.dto.SumInfoDTO;

//Định nghĩa một interface LichTrinhService để quản lý các thao tác liên quan đến đối tượng LichTrinh
public interface LichTrinhService {

	// Phương thức để lưu hoặc cập nhật thông tin giao dịch
	void saveOrUpdate(LichTrinh giaoDich);

	// Phương thức để tìm kiếm các giao dịch với điều kiện tìm kiếm và phân trang
	Page<SumInfoDTO> findAllWithSearch(String searchInput, Pageable pageable);

	// Phương thức để tìm kiếm các giao dịch với điều kiện tìm kiếm và phân trang
	Page<MoneyInfoDTO> findAllWithSearchMoney(String searchInput, Pageable pageable);

	// Phương thức để tìm một giao dịch dựa trên id
	LichTrinh findById(LichTrinhPK id);

	// Phương thức để xóa một đối tượng HopDongBaoHiem dựa trên id
		void deleteById(LichTrinhPK id);
}
