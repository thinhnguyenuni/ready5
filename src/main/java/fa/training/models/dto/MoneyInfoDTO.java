package fa.training.models.dto;

public class MoneyInfoDTO{

	private String maNhaXe;
	private Double donGia;
	private Integer soLuongHanhKhach;
	private Double tongTien;

	public MoneyInfoDTO() {
	}

	public MoneyInfoDTO(String maNhaXe, Double donGia, Integer soLuongHanhKhach) {
		this.maNhaXe = maNhaXe;
		this.donGia = donGia;
		this.soLuongHanhKhach = soLuongHanhKhach;
	}

	public String getMaNhaXe() {
		return maNhaXe;
	}

	public void setMaNhaXe(String maNhaXe) {
		this.maNhaXe = maNhaXe;
	}

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	public Integer getSoLuongHanhKhach() {
		return soLuongHanhKhach;
	}

	public void setSoLuongHanhKhach(Integer soLuongHanhKhach) {
		this.soLuongHanhKhach = soLuongHanhKhach;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}

}
