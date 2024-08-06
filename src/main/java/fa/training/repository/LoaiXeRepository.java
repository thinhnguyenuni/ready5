package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.training.models.LoaiXe;

//Định nghĩa một interface LoaiXeRepository kế thừa từ JpaRepository,
//được sử dụng để thao tác với đối tượng LoaiXe trong cơ sở dữ liệu
public interface LoaiXeRepository extends JpaRepository<LoaiXe, String> {

}
