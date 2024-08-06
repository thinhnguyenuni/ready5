package fa.training.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LoaiXe {

	@Id
	private String maLoaiXe;
	private String moTa;
	private int soLuongChoNgoi;
	
	@OneToMany(mappedBy = "loaiXe",cascade = CascadeType.ALL)
	private List<Xe> listXe;

	
	public LoaiXe() {
	}

	public LoaiXe(String maLoaiXe, String moTa, int soLuongChoNgoi) {
		this.maLoaiXe = maLoaiXe;
		this.moTa = moTa;
		this.soLuongChoNgoi = soLuongChoNgoi;
	}

	public String getMaLoaiXe() {
		return maLoaiXe;
	}

	public void setMaLoaiXe(String maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getSoLuongChoNgoi() {
		return soLuongChoNgoi;
	}

	public void setSoLuongChoNgoi(int soLuongChoNgoi) {
		this.soLuongChoNgoi = soLuongChoNgoi;
	}
	
	
}
