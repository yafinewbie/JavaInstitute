package models;

import java.util.Date;

public class Siswa {

	private String namaPeserta;
	private String email;
	private Date tglLahir;
	private String noTlpnPeserta;
	private String level;
	
	public Siswa(String namaPeserta, String email, Date tglLahir, String noTlpnPeserta, String level) {
		super();
		this.namaPeserta = namaPeserta;
		this.email = email;
		this.tglLahir = tglLahir;
		this.noTlpnPeserta = noTlpnPeserta;
		this.level = level;
	}

	public String getNamaPeserta() {
		return namaPeserta;
	}

	public void setNamaPeserta(String namaPeserta) {
		this.namaPeserta = namaPeserta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTglLahir() {
		return tglLahir;
	}

	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}

	public String getNoTlpnPeserta() {
		return noTlpnPeserta;
	}

	public void setNoTlpnPeserta(String noTlpnPeserta) {
		this.noTlpnPeserta = noTlpnPeserta;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	

}
