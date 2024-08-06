package fa.training.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class LichTrinhPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	private Xe xe;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayXuatBen;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime gioXuatBen;

	public LichTrinhPK() {
	}

	public LichTrinhPK(Xe xe, LocalDate ngayXuatBen, LocalTime gioXuatBen) {
		this.xe = xe;
		this.ngayXuatBen = ngayXuatBen;
		this.gioXuatBen = gioXuatBen;
	}

	public Xe getXe() {
		return xe;
	}

	public void setXe(Xe xe) {
		this.xe = xe;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gioXuatBen, ngayXuatBen, xe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LichTrinhPK other = (LichTrinhPK) obj;
		return Objects.equals(gioXuatBen, other.gioXuatBen) && Objects.equals(ngayXuatBen, other.ngayXuatBen)
				&& Objects.equals(xe, other.xe);
	}

	@Override
	public String toString() {
		return "LichTrinhPK [xe=" + xe + ", ngayXuatBen=" + ngayXuatBen + ", gioXuatBen=" + gioXuatBen + "]";
	}

}
