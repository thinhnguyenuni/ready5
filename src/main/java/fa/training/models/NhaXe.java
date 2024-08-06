package fa.training.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class NhaXe {

	@Id
	private String maNhaXe;
	private String tenNhaXe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate namThanhLap;
	
	@OneToMany(mappedBy = "nhaXe",cascade = CascadeType.ALL)
	private List<Xe> listNhaXe;

	public NhaXe() {
	}

	public NhaXe(String maNhaXe, String tenNhaXe, LocalDate namThanhLap) {
		this.maNhaXe = maNhaXe;
		this.tenNhaXe = tenNhaXe;
		this.namThanhLap = namThanhLap;
	}

	public String getMaNhaXe() {
		return maNhaXe;
	}

	public void setMaNhaXe(String maNhaXe) {
		this.maNhaXe = maNhaXe;
	}

	public String getTenNhaXe() {
		return tenNhaXe;
	}

	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}

	public LocalDate getNamThanhLap() {
		return namThanhLap;
	}

	public void setNamThanhLap(LocalDate namThanhLap) {
		this.namThanhLap = namThanhLap;
	}
	
	
	
	
}
