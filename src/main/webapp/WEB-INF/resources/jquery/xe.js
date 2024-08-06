jQuery(function() {
	$('.select2').select2();
	$("button[type='reset']").on("click", function() {
		$("span[id*='errors']").text("");
		$("div[class*='error']").text("");
		$(this).closest("form").find("input").removeAttr("value");
	});
	const input_maxe = $("#input_maxe");
	const input_hangSanXuat = $("#input_hangSanXuat");
	const input_maloaixe = $("#input_maloaixe");
	const input_bienSoXe = $("#input_bienSoXe");
	const input_hanDangKiem = $("#input_hanDangKiem");
	const input_manhaXe = $("#input_manhaXe");

	const error_maxe = $("#error_maxe");
	const error_hangSanXuat = $("#error_hangSanXuat");
	const error_loaixe = $("#error_loaixe");
	const error_bienSoXe = $("#error_bienSoXe");
	const error_hanDangKiem = $("#error_hanDangKiem");
	const error_nhaXe = $("#error_nhaXe");

	const idRegEx = /^MD\d{3}$/;
	const maChuSoHuuRegEx = /^KH\d{3}$/;
	const maDoThiRegEx = /^KDT\d{2}$/;
	const numberRegEx = /^[1-9]\d*$/;
	/* const phoneRegEx = /^(090|091|\(84\)\+90|\(84\)\+91)\d{7}$/;
	 const emailRegEx = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;*/
	$("#inputForm").on("submit", function(e) {
		e.preventDefault();
		if (
			!validateMaXe(input_maxe) |
			!validateHangSanXuat(input_hangSanXuat) |
			!validateMaLoaiXe(input_maloaixe) |
			!validateBienSoXe(input_bienSoXe) |
			!validateHanDangKiem(input_hanDangKiem) |
			!validateMaNhaXe(input_manhaXe) 
		) {
			return;
		}
		this.submit();
	});

	function validateMaXe(selector) {
		const value = selector.val().trim();
		if (value == "") {
			error_maxe.text("Trường không được để trống");
			return false;
		}
		error_maxe.text("");
		return true;
	}

	function validateHangSanXuat(selector) {
		const value = selector.val().trim();
		if (value == "") {
			error_hangSanXuat.text("Trường không được để trống");
			return false;
		}
	
		error_hangSanXuat.text("");
		return true;
	}

	function validateMaLoaiXe(selector) {
		const value = selector.val().trim();
		if (value == "") {
			error_loaixe.text("Trường không được để trống");
			return false;
		}

		error_loaixe.text("");
		return true;
	}

	function validateBienSoXe(selector) {
		const value = selector.val().trim();
		if (value == "") {
			error_bienSoXe.text("Trường không được để trống");
			return false;
		}

		error_bienSoXe.text("");
		return true;
	}

	function validateHanDangKiem(selector) {
		const value = selector.val().trim();
		if (value == "") {
			error_hanDangKiem.text("Trường không được để trống");
			return false;
		}

		error_hanDangKiem.text("");
		return true;
	}
	function validateMaNhaXe(selector) {
		const value = selector.val().trim();
		if (value == "") {
			error_nhaXe.text("Trường không được để trống");
			return false;
		}

		error_nhaXe.text("");
		return true;
	}

	function validateNumber(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorNumber.text("Trường không được để trống");
			return false;
		}
		if (!numberRegEx.test(value)) {
			errorNumber.text("Số mẫu đất phải là số nguyên dương");
			return false;
		}
		errorNumber.text("");
		return true;
	}

	function validateName(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorName.text("Trường không được để trống");
			return false;
		}
		errorName.text("");
		return true;
	}

	function validateDate(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorDate.text("Trường không được để trống");
			return false;
		}
		const inputDate = new Date(selector.val().trim());
		const currentDate = new Date();
		currentDate.setHours(7, 0, 0, 0);
		if (currentDate < inputDate) {
			errorDate.text("Ngày không được lớn hơn ngày hiện tại");
			return false;
		}
		errorDate.text("");
		return true;
	}

});