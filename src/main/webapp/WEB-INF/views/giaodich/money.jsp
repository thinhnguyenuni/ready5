<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row d-flex justify-content-center">
	<div class="col-md-12">
		<h2 class="col-12 text-center text-success text-uppercase mb-3">Tổng
			tiền thu nhập</h2>
		<div class="col-12 d-flex justify-content-center">
			<a href="${pageContext.request.contextPath}/xe/create"
				class="btn btn-success">Nhập xe</a>
		</div>
		<div class="col-12">
			<!-- Dòng 5: Phần tìm kiếm và nút tìm kiếm -->
			<div class="row d-flex justify-content-end">
				<form action="money" method="get" class="w-25">
					<!-- Dòng 6: Form tìm kiếm -->
					<input type="hidden" name="pageSize" value="${pageSize}">
					<!-- Dòng 7: Trường ẩn lưu kích thước trang -->
					<div class="search input-group">

						<!-- Dòng 8: Input nhập thông tin tìm kiếm -->
						<input type="text" name="search"
							class="form-control search-input border-success"
							placeholder="Nhập mã mẫu đất" autocomplete="off"
							value="${search}">
						<!-- Dòng 9: Nút tìm kiếm -->
						<button class="btn btn-outline-success search-btn" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</form>
				<!-- Dòng 10: Icon tìm kiếm -->
				<i class="far fa-search"></i>
			</div>
			<!-- Dòng 11: Bảng hiển thị thông tin giao dịch -->
			<div class="table-responsive">
				<table id="listTable"
					class="table table-hover table-striped table-content">
					<thead>
						<!-- Dòng 12: Tiêu đề các cột -->
						<tr>
							<th>Nhà xe</th>
							<th>Đơn giá</th>
							<th>Số hành khách</th>
							<th>Tổng tiền</th>

							<th></th>
						</tr>
					</thead>
					<tbody>
						<!-- Dòng 13-36: Vòng lặp để hiển thị thông tin giao dịch -->
						<c:forEach var="moneyInfo" items="${moneyInfos}" varStatus="status">
							<tr>
								<td>${moneyInfo.maNhaXe}</td>
								<td>${moneyInfo.donGia}</td>
								<td>${moneyInfo.soLuongHanhKhach}</td>
								<td>${moneyInfo.tongTien}</td>
								<td></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class=row>
				<!-- Dòng 37-52: Hiển thị phân trang -->
				<div class="col-5">
					<!-- Dòng 37-47: Dropdown chọn số lượng dòng trên mỗi trang -->
					<div class="input-group mb-3">
						<label for="pageSizeSelect2">Show </label> <select
							class="select mx-2 rounded px-1" id="pageSizeSelect2">
							<!-- Dòng 39-45: Hiển thị danh sách kích thước trang và đánh dấu kích thước đang chọn -->
							<c:forEach var="page" items="${pageSizes}">
								<c:if test="${page == pageSize }">
									<option value="${page}" selected="selected">${page}</option>
								</c:if>
								<c:if test="${page != pageSize }">
									<option value="${page}">${page}</option>
								</c:if>

							</c:forEach>
						</select> <label for="pageSizeSelect2"> rows per page </label>
					</div>
					<div class="fw-bold">
						Total: <span class="text-success"> ${totalRows} </span> rows
					</div>
				</div>
				<!-- Dòng 48-52: Hiển thị nút Previous và Next -->
				<ul class="col-7 pagination d-flex justify-content-end">
					<c:if test="${pageNumber > 1}">
						<li class="page-item"><a class="page-link"
							href="money?pageNumber=${pageNumber-1}&pageSize=${pageSize}&search=${search}">Previous</a></li>
					</c:if>
					<c:forEach begin="1" end="${totalPages}" var="i">
						<c:choose>
							<c:when test="${pageNumber eq i}">
								<li class="page-item"><a
									class="page-link active text-white"> ${i} </a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="money?pageNumber=${i}&pageSize=${pageSize}&search=${search}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${pageNumber lt totalPages}">
						<li class="page-item"><a class="page-link"
							href="money?pageNumber=${pageNumber+1}&pageSize=${pageSize}&search=${search}">Next</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>