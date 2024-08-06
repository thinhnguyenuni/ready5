<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row w-100 d-flex justify-content-center">
	<div class="col-sm-12 col-md-6 bg-custom p-3 rounded">
		<div class="col-12 text-uppercase h2 text-center text-success ">Cập
			nhật giao dịch</div>
		<div class="p-4">
			<form:form
				action="${pageContext.request.contextPath}/giaodich/create"
				method="post" modelAttribute="lichtrinh" id="inputForm_lichtrinh">
				<!-- Dòng 1: Bắt đầu một form với các thuộc tính định danh -->
				<div class="form-group row">
					<!-- Dòng 2-11: Ô nhập dữ liệu cho Mã giao dịch -->
					<form:label path="lichTrinhPK.xe.maXe" for="inputID"
						class="col-sm-3 col-form-label">Mã xe</form:label>
					<!-- Dòng 3: Nhãn cho ô nhập -->
					<div class="col">
						<!-- Dòng 4: Ô nhập dữ liệu -->
						<form:input path="lichTrinhPK.xe.maXe" type="text" class="form-control"
							id="inputID" placeholder=""  />
						<!-- Dòng 5: Hiển thị lỗi (nếu có) -->
						<form:errors path="lichTrinhPK.xe.maXe" />
						<!-- Dòng 6: Hiển thị thông báo lỗi -->
						<div class="error text-danger" id="errorID"></div>
					</div>
				</div>
				<!-- Dòng 7-29: Tương tự cho các trường dữ liệu khác -->
				<div class="form-group row mt-3">
					<form:label path="taiXe" for="inputMaKhachHang"
						class="col-sm-3 col-form-label">Tên tài xế</form:label>
					<div class="col">
						<form:input path="taiXe" type="text" class="form-control"
							id="inputMaKhachHang" placeholder="" />
						<form:errors path="taiXe" />
						<div class="error text-danger" id="errorMaKhachHang"></div>
					</div>
				</div>
				<!-- Dòng 30-52: Tương tự cho các trường dữ liệu còn lại -->
				<div class="form-group row mt-3">
					<form:label path="tuyenXe.maTuyen" for="inputMaMauDat"
						class="col-sm-3 col-form-label">Mã tuyến xe</form:label>
					<div class="col">
						<form:input path="tuyenXe.maTuyen" type="text"
							class="form-control" id="inputMaMauDat" placeholder="" />
						<form:errors path="tuyenXe.maTuyen" />
						<div class="error text-danger" id="errorMaMauDat"></div>
					</div>
				</div>
				<!-- Dòng 53-75: Tương tự cho các trường dữ liệu còn lại -->
				<div class="form-group row mt-3">
					<form:label path="lichTrinhPK.ngayXuatBen" for="inputPrice"
						class="col-sm-3 col-form-label">Ngày xuất bến</form:label>
					<div class="col">
						<form:input path="lichTrinhPK.ngayXuatBen" type="date" class="form-control"
							id="inputPrice" placeholder="" />
						<form:errors path="lichTrinhPK.ngayXuatBen" />
						<div class="error text-danger" id="errorPrice"></div>
					</div>
				</div>
				<!-- Dòng 76-98: Tương tự cho các trường dữ liệu còn lại -->
				<!-- (lichTrinhPK.gioXuatBen, ngayDatCoc, ngayThanhToan, method, status) -->
				<div class="form-group row mt-3">
					<form:label path="lichTrinhPK.gioXuatBen" for="inputTienDatCoc"
						class="col-sm-3 col-form-label">Giờ xuất bến</form:label>
					<div class="col">
						<form:input path="lichTrinhPK.gioXuatBen" type="time" class="form-control"
							id="inputTienDatCoc" placeholder="Tiền đặt cọc" />
						<form:errors path="lichTrinhPK.gioXuatBen" />
						<div class="error text-danger" id="errorTienDatCoc"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="soLuongHanhKhach" for="inputTienDatCoc"
						class="col-sm-3 col-form-label">Số lượng hành khách</form:label>
					<div class="col">
						<form:input path="soLuongHanhKhach" type="number" class="form-control"
							id="inputTienDatCoc" placeholder="" />
						<form:errors path="soLuongHanhKhach" />
						<div class="error text-danger" id="errorTienDatCoc"></div>
					</div>
				</div>
				<!-- Dòng 99-121: Tương tự cho các trường dữ liệu còn lại -->
				<!-- (ngayDatCoc, ngayThanhToan, method, status) -->
				<!-- Dòng 122-134: Nút Reset, Nút Submit và Nút Hủy -->
				<div class="form-group row mt-3">
					<div class="col"></div>
					<!-- Dòng 123-133: Nút điều chỉnh và xác nhận thay đổi -->
					<div class="col-sm-12 col-md-6 mr-2 d-flex justify-content-end">
						<!-- Dòng 124: Nút Reset để xóa dữ liệu đã nhập -->
						<button type="reset" class="btn btn-success">Reset</button>
						<!-- Dòng 125: Nút Submit để cập nhật dữ liệu -->
						<button type="submit" class="btn btn-success mx-3">Add</button>
						<!-- Dòng 126: Nút Hủy để quay lại trang chủ -->
						<a href="${pageContext.request.contextPath}/home"
							class="btn btn-danger">Cancel</a>
					</div>
				</div>
			</form:form>

		</div>
	</div>
</div>



