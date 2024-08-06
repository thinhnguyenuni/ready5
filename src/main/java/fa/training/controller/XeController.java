package fa.training.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.training.models.Xe;
import fa.training.service.NhaXeService;
import fa.training.service.XeService;

//Đánh dấu lớp này là một Controller trong Spring Framework và xác định route chính cho các phương thức trong Controller này
@Controller
@RequestMapping(value = "/xe")
public class XeController {

	// Autowired để Spring tự động inject các instance của các service
	@Autowired
	private XeService xeService;

	// Autowired để Spring tự động inject các instance của các service
	@Autowired
	private NhaXeService nhaXeService;

	// Danh sách các kích thước trang cho phân trang
	List<Integer> pageSizes = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 10));

	// Xử lý request GET đến đường dẫn "/xe/create"
	@GetMapping("/create")
	public String getXe(Model model) {
		// Thêm một đối tượng Xe mới vào Model để hiển thị trên view
		model.addAttribute("xe", new Xe());
		// Thêm các thông tin cần thiết vào Model
		model.addAttribute("urlPage", "/xe/add");
		model.addAttribute("jqPage", "xe");
		// Trả về đường dẫn của view cơ sở (base view)
		return "/base/view";
	}

	// Xử lý request POST đến đường dẫn "/xe/create"
	@PostMapping("/create")
	public String createXe(@ModelAttribute("xe") @Validated Xe xe, BindingResult result, Model model) {
		// Kiểm tra xem mã khu đô thị có tồn tại không, nếu không tồn tại thì reject giá
		// trị và thông báo lỗi
		if (!nhaXeService.existByID(xe.getNhaXe().getMaNhaXe())) {
			result.rejectValue("nhaXe.maNhaXe", "nhaXe.idInvalid", "Mã nhà xe thị này không tồn tại");
		}

//		Date dateOfBirth = user.getDateOfBirth();
//		Date toDay = new Date();
//		long daysBetween = Duration.between(toDay.toInstant(), dateOfBirth.toInstant()).toDays();
//		if (daysBetween > 30) {
//			model.addAttribute("birthDateError", "birthDate phai trong vong 30 ngay");
//			return "add-user";
//		}

		// Kiểm tra ngày kiểm định xe không được rỗng
		if (xe.getHanDangKiem() == null) {
			result.rejectValue("hanDangKiem", "date.error", "Ngày không được để trống");
		} else {
			// Kiểm tra hạn kiểm định có nhỏ hơn 30 ngày không
			LocalDate ngayHienTai = LocalDate.now();
			LocalDate hanKiemDinh = xe.getHanDangKiem();
			if (ngayHienTai.plusDays(30).isAfter(hanKiemDinh)) {
				// Nếu hạn kiểm định nhỏ hơn 30 ngày, thêm lỗi vào BindingResult
				result.rejectValue("hanDangKiem", "date.error",
						"Hạn kiểm định phải sau ít nhất 30 ngày từ ngày hiện tại");
			}
		}

		// Nếu có lỗi thì trả về view tạo mới mẫu đất
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/xe/add");
			model.addAttribute("jqPage", "xe");
			return "/base/view";
		}

		// Lưu hoặc cập nhật thông tin mẫu đất và chuyển hướng về danh sách giao dịch
		xeService.saveOrUpdate(xe);
		return "redirect:/giaodich/list";
	}
}
