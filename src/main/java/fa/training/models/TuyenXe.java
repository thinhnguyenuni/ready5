package fa.training.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TuyenXe {

	@Id
	private String maTuyen;
	private String tenTuyen;
	private Double donGia;
	
	@OneToMany(mappedBy = "tuyenXe",cascade = CascadeType.ALL)
	private List<LichTrinh> listTuyenXe;

	public TuyenXe() {
	}

	public TuyenXe(String maTuyen, String tenTuyen, Double donGia) {
		this.maTuyen = maTuyen;
		this.tenTuyen = tenTuyen;
		this.donGia = donGia;
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

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}
	
	
	
}
