package main;

public class FacebookProfil extends ProfilNaSocijalnojMrezi {
	
	
	private String id;
	private String ime;
	private String status;
	
	
	FacebookProfil(String[] podaci) {
		
		super(Integer.parseInt(podaci[2].trim()));
		
		this.id = podaci[0].trim();
		this.ime = podaci[1].trim();
		this.status = podaci.length == 4 ? podaci[3].trim() : "";
	}
	

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) 					return true;
		if (obj == null) 					return false;
		if (getClass() != obj.getClass()) 	return false;
		
		FacebookProfil other = (FacebookProfil) obj;
		
		if (id != other.id) return false;
		
		return true;
	}

	
	public void setId(String id) {
		this.id = id;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "FacebookProfil [id=" + id + ", ime=" + ime + ", status=" + status + "]";
	}
}
