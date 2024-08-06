package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.models.Xe;
import fa.training.repository.XeRepository;
import fa.training.service.XeService;

//Đánh dấu lớp này là một service trong ứng dụng Spring
@Service
public class XeServiceImpl implements XeService {
	// Tự động inject XeRepository để thực hiện các thao tác liên quan đến Xe
	@Autowired
	private XeRepository repository;

	// Phương thức để lưu hoặc cập nhật thông tin của một mẫu đất
	@Override
	public void saveOrUpdate(Xe mauDat) {
		// Kiểm tra nếu mẫu đất là null thì in ra thông báo và trở về
		if (mauDat == null) {
			System.out.println("Không khởi tạo được đối tượng");
			return;
		}
		// Lưu hoặc cập nhật thông tin của mẫu đất vào cơ sở dữ liệu
		repository.save(mauDat);
	}

	// Phương thức để lấy danh sách tất cả các mẫu đất từ cơ sở dữ liệu
	@Override
	public List<Xe> findAll() {
		// Lấy danh sách tất cả các mẫu đất từ repository
		List<Xe> list = repository.findAll();
		// Kiểm tra nếu danh sách rỗng thì in ra thông báo và trả về null
		if (list.isEmpty()) {
			System.out.println("Danh sách trống");
			return null;
		}
		// Trả về danh sách mẫu đất
		return list;
	}

	// Phương thức để tìm một mẫu đất dựa trên id
	@Override
	public Xe findByID(String id) {
		// Tìm và trả về mẫu đất dựa trên id, hoặc trả về null nếu không tìm thấy
		return repository.findById(id).orElse(null);
	}

	// Phương thức để xóa một mẫu đất dựa trên id
	@Override
	public void deleteById(String id) {
		// Xóa mẫu đất dựa trên id
		repository.deleteById(id);
	}

	// Phương thức để lấy danh sách các mẫu đất theo trang từ cơ sở dữ liệu
	@Override
	public Page<Xe> findAll(Pageable pageable) {
		// Lấy danh sách các mẫu đất theo trang từ repository
		return repository.findAll(pageable);
	}

	// Phương thức để lấy danh sách các mẫu đất theo điều kiện tìm kiếm và phân trang
	@Override
	public Page<Xe> findAllWithSearch(String searchInput, Pageable pageable) {
		// Lấy danh sách các mẫu đất theo điều kiện tìm kiếm và phân trang từ repository
		return repository.findAllWithSearch(searchInput, pageable);
	}

	// Phương thức để kiểm tra xem một mẫu đất có tồn tại trong cơ sở dữ liệu hay không dựa trên id
	@Override
	public boolean existByID(String id) {
		// Sử dụng phương thức existsById của repository để kiểm tra xem mẫu đất có tồn tại không
		return repository.existsById(id);
	}
}
