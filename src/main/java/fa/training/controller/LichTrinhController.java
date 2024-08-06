package fa.training.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.models.LichTrinh;
import fa.training.models.LichTrinhPK;
import fa.training.models.Xe;
import fa.training.models.dto.MoneyInfoDTO;
import fa.training.models.dto.SumInfoDTO;
import fa.training.service.LichTrinhService;
import fa.training.service.XeService;

//Đánh dấu lớp này là một Controller trong Spring Framework
@Controller
//Xác định route chính cho các phương thức trong Controller này
@RequestMapping(value = "/giaodich")
public class LichTrinhController {

	// Autowired để Spring tự động inject các instance của các service
	@Autowired
	private XeService xeService;

	@Autowired
	private LichTrinhService giaoDichService;

	// Danh sách các kích thước trang cho phân trang
	List<Integer> pageSizes = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 10));

	// Xử lý request GET đến đường dẫn "/giaodich/list"
	@GetMapping("/list")
	public String showAllLichTrinh(Model model,
			// RequestParam để lấy các tham số từ URL
			@RequestParam(name = "pageNumber", required = true, defaultValue = "1") int pageNumber,
			@RequestParam(name = "pageSize", required = true, defaultValue = "3") int pageSize,
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		// Tạo Pageable object để phục vụ cho việc phân trang
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		// Gọi service để lấy danh sách giao dịch theo các tham số truyền vào
		Page<SumInfoDTO> sumInfos = giaoDichService.findAllWithSearch(search.trim(), pageable);
		// Thêm các thông tin cần thiết vào Model để hiển thị trên view
		model.addAttribute("sumInfos", sumInfos.getContent());
		model.addAttribute("pageSizes", pageSizes);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRows", sumInfos.getTotalElements());
		model.addAttribute("totalPages", sumInfos.getTotalPages());
		model.addAttribute("search", search);
		model.addAttribute("urlPage", "/giaodich/list");
		model.addAttribute("jqPage", "list");
		// Trả về view cơ sở (base view)
		return "/base/view";
	}

	// Xử lý request GET đến đường dẫn "/xe/create"
	@GetMapping("/money")
	public String getMoney(Model model,
			// RequestParam để lấy các tham số từ URL
			@RequestParam(name = "pageNumber", required = true, defaultValue = "1") int pageNumber,
			@RequestParam(name = "pageSize", required = true, defaultValue = "10") int pageSize,
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		// Tạo Pageable object để phục vụ cho việc phân trang
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		// Gọi service để lấy danh sách giao dịch theo các tham số truyền vào
		Page<MoneyInfoDTO> sumInfos = giaoDichService.findAllWithSearchMoney(search.trim(), pageable);
		// Thêm các thông tin cần thiết vào Model để hiển thị trên view
		
		// Lấy danh sách các đối tượng MoneyInfoDTO từ sumInfos
		List<MoneyInfoDTO> content = sumInfos.getContent();

		// Tạo một danh sách mới content2 và sao chép toàn bộ phần tử từ content vào
		List<MoneyInfoDTO> content2 = new ArrayList<>(content);

		// Tạo một map với key là MaNhaXe và value là tổng TongTien của các MoneyInfoDTO có cùng MaNhaXe
		Map<String, Double> map = content2.stream()
		    .collect(Collectors.groupingBy(
		        MoneyInfoDTO::getMaNhaXe,             // Nhóm các phần tử theo MaNhaXe
		        Collectors.summingDouble(MoneyInfoDTO::getTongTien)  // Tính tổng TongTien cho từng nhóm
		    ));

		// In ra map kết quả
		System.out.println(map);

		// Duyệt qua từng entry trong map
		for (Map.Entry<String, Double> entry : map.entrySet()) {
		    String key = entry.getKey();    // Lấy key (MaNhaXe) từ entry
		    Double val = entry.getValue();  // Lấy value (TongTien) từ entry

		    // Tạo một đối tượng MoneyInfoDTO mới và gán giá trị key và val vào
		    MoneyInfoDTO dto = new MoneyInfoDTO();
		    dto.setMaNhaXe(key);
		    dto.setTongTien(val);

		    // Thêm đối tượng mới vào danh sách content2
		    content2.add(dto);
		}

		// Sắp xếp danh sách content2 theo MaNhaXe theo thứ tự tăng dần
		Collections.sort(content2, (x1, x2) -> x1.getMaNhaXe().compareTo(x2.getMaNhaXe()));

		model.addAttribute("moneyInfos", content2);
		model.addAttribute("pageSizes", pageSizes);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRows", sumInfos.getTotalElements());
		model.addAttribute("totalPages", sumInfos.getTotalPages());
		model.addAttribute("search", search);

		// Thêm các thông tin cần thiết vào Model
		model.addAttribute("urlPage", "/giaodich/money");
		model.addAttribute("jqPage", "money");
		// Trả về đường dẫn của view cơ sở (base view)
		return "/base/view";
	}

	// Xử lý request GET đến đường dẫn "/xe/create"
	@GetMapping("/create")
	public String getCreateLichTrinh(Model model) {
		// Thêm một đối tượng Xe mới vào Model để hiển thị trên view
		model.addAttribute("lichtrinh", new LichTrinh());
		// Thêm các thông tin cần thiết vào Model
		model.addAttribute("urlPage", "/giaodich/lichtrinh");
		model.addAttribute("jqPage", "lichtrinh");
		// Trả về đường dẫn của view cơ sở (base view)
		return "/base/view";
	}

	// Xử lý request POST đến đường dẫn "/xe/create"
	@PostMapping("/create")
	public String createLichTrinh(@ModelAttribute("lichtrinh") @Validated LichTrinh lichtrinh, BindingResult result,
			Model model) {

		// Lưu hoặc cập nhật thông tin mẫu đất và chuyển hướng về danh sách giao dịch
		giaoDichService.saveOrUpdate(lichtrinh);
		return "redirect:/giaodich/list";
	}

	// Xử lý request GET đến đường dẫn "/giaodich/update"
	@GetMapping("/update")
	public String getUpdateLichTrinh(@RequestParam(name = "id") String id, LichTrinhPK pk, Model model) {
		// Lấy thông tin giao dịch cần cập nhật và thêm vào Model
		Xe xe = xeService.findByID(id);
		System.out.println("XE : " + xe);
		System.out.println("XE : " + xe);

		LichTrinh lt = giaoDichService.findById(pk);
		System.out.println("LichTrinhPK : " + pk);
		System.out.println("LichTrinhPK : " + lt);
		model.addAttribute("giaodich", lt);
		model.addAttribute("urlPage", "/giaodich/update");
		// Trả về view cơ sở (base view)
		return "/base/view";
	}

	// Xử lý request POST đến đường dẫn "/giaodich/update"
	@PostMapping("/update")
	public String updateLichTrinh(@ModelAttribute("giaodich") @Validated LichTrinh giaoDich, BindingResult result,
			Model model) {
		// Kiểm tra xem có trùng mã khách hàng hay không, nếu có thì reject giá trị và
		// thông báo lỗi

		// Nếu có lỗi thì trả về view cập nhật
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/giaodich/update");
			return "/base/view";
		}

		// Lưu hoặc cập nhật thông tin giao dịch và chuyển hướng về danh sách giao dịch
		giaoDichService.saveOrUpdate(giaoDich);
		return "redirect:/giaodich/list";
	}

	// Xử lý request GET đến đường dẫn "/giaodich/delete/{id}"
	
	// http://localhost:8080/SPRING_MAU1_3/giaodich/delete/X003/2024-05-25/22:57
//	@GetMapping("/delete/{idMa}/{idNgay}/{idGio}")
//	public String deleteDetail(
//	@PathVariable(name = "idMa") String maXe,
//	@PathVariable(name = "idNgay")  @DateTimeFormat(...)(LocalDate ngayXuatBen,
//	@PathVariable(name = "idGio") @DateTimeFormat(...) LocalDate gioXuatBen,
//	Model model) {
		
	// http://localhost:8080/SPRING_MAU1_3/giaodich/delete?xe.maXe=X003&ngayXuatBen=2024-05-25&gioXuatBen=22:57
	@GetMapping("/delete")
	public String deleteDetail(/* @RequestParam */ LichTrinhPK pk, Model model) {
		// Xóa thông tin mẫu đất với id được cung cấp và chuyển hướng về danh sách mẫu
		// đất
		giaoDichService.deleteById(pk);
		return "redirect:/giaodich/list";
	}
}
