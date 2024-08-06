package fa.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.models.LichTrinh;
import fa.training.models.LichTrinhPK;
import fa.training.models.dto.MoneyInfoDTO;
import fa.training.models.dto.SumInfoDTO;
import fa.training.repository.LichTrinhRepository;
import fa.training.service.LichTrinhService;

//Đánh dấu lớp này là một service trong ứng dụng Spring
@Service
public class LichTrinhServiceImpl implements LichTrinhService {
	
	// Tự động inject LichTrinhRepository để thực hiện các thao tác liên quan đến
	// LichTrinh
	@Autowired
	private LichTrinhRepository repository;

	// Phương thức lưu hoặc cập nhật thông tin của một giao dịch
	@Override
	public void saveOrUpdate(LichTrinh giaoDich) {
		// Kiểm tra nếu giao dịch là null thì in ra thông báo và trở về
		if (giaoDich == null) {
			System.out.println("Không khởi tạo được đối tượng");
			return;
		}
		// Lưu hoặc cập nhật thông tin của giao dịch vào cơ sở dữ liệu
		repository.save(giaoDich);
	}

	// Phương thức tìm kiếm các giao dịch với điều kiện tìm kiếm và phân trang
	@Override
	public Page<SumInfoDTO> findAllWithSearch(String searchInput, Pageable pageable) {
		return repository.findAllWithSearch(searchInput, pageable);
	}

	@Override
	public Page<MoneyInfoDTO> findAllWithSearchMoney(String searchInput, Pageable pageable) {
	    // Tìm tất cả các đối tượng MoneyInfoDTO phù hợp với searchInput và phân trang theo pageable
	    Page<MoneyInfoDTO> moneyInfos = repository.findAllWithSearchMoney(searchInput, pageable);

	    // Kiểm tra nếu danh sách các đối tượng MoneyInfoDTO rỗng
	    if (moneyInfos.getContent().isEmpty()) {
	        return moneyInfos;  // Nếu rỗng, trả về ngay danh sách này
	    }

	    // Sử dụng phương thức map của Page để cập nhật giá trị tongTien cho từng đối tượng MoneyInfoDTO
	    moneyInfos = moneyInfos.map(sumInfo -> {
	        // Nếu DonGia và SoLuongHanhKhach không null, tính TongTien
	        if (sumInfo.getDonGia() != null && sumInfo.getSoLuongHanhKhach() != null) {
	            sumInfo.setTongTien(sumInfo.getDonGia() * sumInfo.getSoLuongHanhKhach());
	        } else {
	            sumInfo.setTongTien(0.0);  // Nếu một trong hai giá trị null, đặt TongTien là 0.0
	        }
	        return sumInfo;  // Trả về đối tượng MoneyInfoDTO đã được cập nhật
	    });

	    // Trả về danh sách các đối tượng MoneyInfoDTO đã được cập nhật
	    return moneyInfos;
	}

	// Phương thức tìm một giao dịch dựa trên id
	@Override
	public LichTrinh findById(LichTrinhPK id) {
		return repository.findById(id).orElse(null);
	}

	// Phương thức để xóa một mẫu đất dựa trên id
	@Override
	public void deleteById(LichTrinhPK id) {
		// Xóa mẫu đất dựa trên id
		repository.deleteById(id);;
	}
}
