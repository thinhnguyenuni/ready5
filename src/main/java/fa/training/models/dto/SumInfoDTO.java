package fa.training.models.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class SumInfoDTO {
	private String maXe;
	private String bienSoXe;
	private String taiXe;
	private String tenNhaXe;
	private String maTuyen;
	private String tenTuyen;
	private LocalDate ngayXuatBen;
	private LocalTime gioXuatBen;

	public SumInfoDTO() {
	}

	public SumInfoDTO(String maXe, String bienSoXe, String taiXe, String tenNhaXe, String maTuyen, String tenTuyen,
			LocalDate ngayXuatBen, LocalTime gioXuatBen) {
		this.maXe = maXe;
		this.bienSoXe = bienSoXe;
		this.taiXe = taiXe;
		this.tenNhaXe = tenNhaXe;
		this.maTuyen = maTuyen;
		this.tenTuyen = tenTuyen;
		this.ngayXuatBen = ngayXuatBen;
		this.gioXuatBen = gioXuatBen;
	}

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}

	public String getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}

	public String getTaiXe() {
		return taiXe;
	}

	public void setTaiXe(String taiXe) {
		this.taiXe = taiXe;
	}

	public String getTenNhaXe() {
		return tenNhaXe;
	}

	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}

	public String getMaTuyen() {
		return maTuyen;
	}

	public void setMaTuyen(String maTuyen) {
		this.maTuyen = maTuyen;
	}

	public String getTenTuyen() {
		return tenTuyen;
	}

	public void setTenTuyen(String tenTuyen) {
		this.tenTuyen = tenTuyen;
	}

	public LocalDate getNgayXuatBen() {
		return ngayXuatBen;
	}

	public void setNgayXuatBen(LocalDate ngayXuatBen) {
		this.ngayXuatBen = ngayXuatBen;
	}

	public LocalTime getGioXuatBen() {
		return gioXuatBen;
	}

	public void setGioXuatBen(LocalTime gioXuatBen) {
		this.gioXuatBen = gioXuatBen;
	}

}
