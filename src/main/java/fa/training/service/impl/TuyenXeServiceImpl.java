/**
 * 
 */
package fa.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.repository.TuyenXeRepository;
import fa.training.service.TuyenXeService;

//Đánh dấu lớp này là một service trong ứng dụng Spring
@Service
public class TuyenXeServiceImpl implements TuyenXeService {
	// Tự động inject TuyenXeRepository để thực hiện các thao tác liên quan đến TuyenXe
	@Autowired
	TuyenXeRepository repository;

	// Phương thức kiểm tra xem có tồn tại một đối tượng KhuDoThi trong cơ sở dữ liệu dựa trên id hay không
	@Override
	public boolean existByID(String id) {
		// Sử dụng phương thức existsById của repository để kiểm tra xem đối tượng có tồn tại không
		return repository.existsById(id);
	}
}
