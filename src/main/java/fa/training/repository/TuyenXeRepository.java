package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.training.models.TuyenXe;

//Định nghĩa một interface TuyenXeRepository kế thừa từ JpaRepository,
//được sử dụng để thao tác với đối tượng TuyenXe trong cơ sở dữ liệu
public interface TuyenXeRepository extends JpaRepository<TuyenXe, String> {

}
