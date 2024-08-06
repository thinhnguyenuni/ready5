package fa.training.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

@Entity
//@AssociationOverrides({ @AssociationOverride(name = "lichTrinhPK.xe", joinColumns = @JoinColumn(name = "maXe")),
//		@AssociationOverride(name = "lichTrinhPK.ngayXuatBen", joinColumns = @JoinColumn(name = "ngayXuatBen")),
//		@AssociationOverride(name = "lichTrinhPK.gioXuatBen", joinColumns = @JoinColumn(name = "gioXuatBen")) })
public class LichTrinh {

	@EmbeddedId
	@Valid
	private LichTrinhPK lichTrinhPK;

	private String taiXe;

	@ManyToOne(fetch = FetchType.LAZY)
	private TuyenXe tuyenXe;

	private Integer soLuongHanhKhach;

	public LichTrinh() {
	}

	public LichTrinh(@Valid LichTrinhPK lichTrinhPK, String taiXe, TuyenXe tuyenXe, Integer soLuongHanhKhach) {
		this.lichTrinhPK = lichTrinhPK;
		this.taiXe = taiXe;
		this.tuyenXe = tuyenXe;
		this.soLuongHanhKhach = soLuongHanhKhach;
	}

	public LichTrinhPK getLichTrinhPK() {
		return lichTrinhPK;
	}

	public void setLichTrinhPK(LichTrinhPK lichTrinhPK) {
		this.lichTrinhPK = lichTrinhPK;
	}

	public String getTaiXe() {
		return taiXe;
	}

	public void setTaiXe(String taiXe) {
		this.taiXe = taiXe;
	}

	public TuyenXe getTuyenXe() {
		return tuyenXe;
	}

	public void setTuyenXe(TuyenXe tuyenXe) {
		this.tuyenXe = tuyenXe;
	}

	public Integer getSoLuongHanhKhach() {
		return soLuongHanhKhach;
	}

	public void setSoLuongHanhKhach(Integer soLuongHanhKhach) {
		this.soLuongHanhKhach = soLuongHanhKhach;
	}

}
