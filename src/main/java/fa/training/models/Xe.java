package fa.training.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Xe {

	@Id
	private String maXe;
	private String hangSanXuat;

	@ManyToOne(fetch = FetchType.LAZY)
	private LoaiXe loaiXe;

	private String bienSoXe;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate hanDangKiem;

	@ManyToOne(fetch = FetchType.LAZY)
	private NhaXe nhaXe;

	@OneToMany(mappedBy = "lichTrinhPK.xe", cascade = CascadeType.ALL)
	private List<LichTrinh> listXe;

	public Xe() {
	}

	public Xe(String maXe, String hangSanXuat, LoaiXe loaiXe, String bienSoXe, LocalDate hanDangKiem, NhaXe nhaXe,
			List<LichTrinh> listXe) {
		this.maXe = maXe;
		this.hangSanXuat = hangSanXuat;
		this.loaiXe = loaiXe;
		this.bienSoXe = bienSoXe;
		this.hanDangKiem = hanDangKiem;
		this.nhaXe = nhaXe;
		this.listXe = listXe;
	}

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}

	public String getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public LoaiXe getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(LoaiXe loaiXe) {
		this.loaiXe = loaiXe;
	}

	public String getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}

	public LocalDate getHanDangKiem() {
		return hanDangKiem;
	}

	public void setHanDangKiem(LocalDate hanDangKiem) {
		this.hanDangKiem = hanDangKiem;
	}

	public NhaXe getNhaXe() {
		return nhaXe;
	}

	public void setNhaXe(NhaXe nhaXe) {
		this.nhaXe = nhaXe;
	}

	public List<LichTrinh> getListXe() {
		return listXe;
	}

	public void setListXe(List<LichTrinh> listXe) {
		this.listXe = listXe;
	}

	@Override
	public String toString() {
		return "Xe [maXe=" + maXe + ", hangSanXuat=" + hangSanXuat + ", bienSoXe=" + bienSoXe
				+ ", hanDangKiem=" + hanDangKiem + "]";
	}

}
