package models;

public class Report {
	
	private String namaTutor;
	private Integer jumlah;
	
	public Report(String namaTutor, Integer jumlah) {
		super();
		this.namaTutor = namaTutor;
		this.jumlah = jumlah;
	}

	public String getNamaTutor() {
		return namaTutor;
	}

	public void setNamaTutor(String namaTutor) {
		this.namaTutor = namaTutor;
	}

	public Integer getJumlah() {
		return jumlah;
	}

	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}

	

}
