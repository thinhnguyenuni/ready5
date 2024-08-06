package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.training.models.NhaXe;

//Định nghĩa một interface NhaXeRepository kế thừa từ JpaRepository,
//được sử dụng để thao tác với đối tượng NhaXe trong cơ sở dữ liệu
public interface NhaXeRepository extends JpaRepository<NhaXe, String> {

}

