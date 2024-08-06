jQuery(function() {

	// Gán một trình xử lý sự kiện "change" cho phần tử có id là "pageSizeSelect"
	$("#pageSizeSelect").on("change", function() {
		// Lấy giá trị hiện tại của phần tử select (số lượng mục trên một trang)
		let pageSize = $(this).val();

		// Lấy giá trị hiện tại của input có tên "search" (từ khóa tìm kiếm)
		let search = $("input[name='search']").val();

		// Thực hiện điều hướng lại trang với các tham số query mới: pageSize và search
		// window.location.href thay đổi URL của trang để gửi yêu cầu HTTP GET mới
		window.location.href = "list?pageSize=" + pageSize + "&search=" + search;
	});


	// Gán một trình xử lý sự kiện "change" cho phần tử có id là "pageSizeSelect2"
	$("#pageSizeSelect2").on("change", function() {
		// Lấy giá trị hiện tại của phần tử select (số lượng mục trên một trang)
		let pageSize = $(this).val();

		// Lấy giá trị hiện tại của input có tên "search" (từ khóa tìm kiếm)
		let search = $("input[name='search']").val();

		// Thực hiện điều hướng lại trang với các tham số query mới: pageSize và search
		// window.location.href thay đổi URL của trang để gửi yêu cầu HTTP GET mới
		window.location.href = "money?pageSize=" + pageSize + "&search=" + search;
	});


});