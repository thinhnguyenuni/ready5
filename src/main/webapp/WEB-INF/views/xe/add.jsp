<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row w-100 d-flex justify-content-center">
	<div class="col-sm-12 col-md-6 bg-custom p-3 rounded">
		<div class="col-12 text-uppercase h2 text-center text-success ">Nhập xe</div>
		<div class="p-4">
			<form:form action="${pageContext.request.contextPath}/xe/create"
				method="post" modelAttribute="xe" id="inputForm">
				<div class="form-group row">
					<form:label path="maXe" for="input_maxe"
						class="col-sm-3 col-form-label">Mã xe</form:label>
					<div class="col">
						<form:input path="maXe" type="text" class="form-control"
							id="input_maxe" placeholder="Mã xe (MXxxx)" autocomplete="off" />
						<form:errors path="maXe" />
						<div class="error text-danger" id="error_maxe"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="hangSanXuat" for="input_hangSanXuat"
						class="col-sm-3 col-form-label">Hãng sản xuất</form:label>
					<div class="col">
						<form:input path="hangSanXuat" type="text" class="form-control"
							id="input_hangSanXuat" placeholder="" autocomplete="off" />
						<form:errors path="hangSanXuat" />
						<div class="error text-danger" id="error_hangSanXuat"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="loaiXe.maLoaiXe" for="input_maloaixe"
						class="col-sm-3 col-form-label">Mã Loại xe</form:label>
					<div class="col">
						<form:input path="loaiXe.maLoaiXe" type="text"
							class="form-control" id="input_maloaixe" placeholder=""
							autocomplete="off" />
						<form:errors path="loaiXe.maLoaiXe" />
						<div class="error text-danger" id="error_loaixe"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="bienSoXe" for="input_bienSoXe"
						class="col-sm-3 col-form-label">Biển số xe</form:label>
					<div class="col">
						<form:input path="bienSoXe" type="text" class="form-control"
							id="input_bienSoXe" placeholder="" autocomplete="off" />
						<form:errors path="bienSoXe" />
						<div class="error text-danger" id="error_bienSoXe"></div>

					</div>
				</div>

				<div class="form-group row mt-3">
					<form:label path="hanDangKiem" for="input_hanDangKiem"
						class="col-sm-3 col-form-label">Hạn đăng kiểm</form:label>
					<div class="col">
						<form:input path="hanDangKiem" type="date" class="form-control"
							id="input_hanDangKiem" placeholder="" autocomplete="off" />
						<form:errors path="hanDangKiem" />
						<div class="error text-danger" id="error_hanDangKiem"></div>

					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="nhaXe.maNhaXe" for="input_manhaXe"
						class="col-sm-3 col-form-label">Mã Nhà xe</form:label>
					<div class="col">
						<form:input path="nhaXe.maNhaXe" type="text"
							class="form-control" id="input_manhaXe" placeholder=""
							autocomplete="off" />
						<form:errors path="nhaXe.maNhaXe" />
						<div class="error text-danger" id="error_nhaXe"></div>

					</div>
				</div>

				<div class="form-group row mt-3">
					<div class="col"></div>
					<div class="col-sm-12 col-md-6 mr-2 d-flex justify-content-end">
						<button type="reset" class="btn btn-success">Reset</button>
						<button type="submit" class="btn btn-success mx-3">Add</button>
						<a href="${pageContext.request.contextPath}/home"
							class="btn btn-danger">Cancel</a>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>




