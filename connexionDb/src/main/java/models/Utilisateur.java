package models;

public class Utilisateur {
	
	private int id;
	private String email;
	private String tel;
	
	public Utilisateur(int id, String email, String tel){
		this.id = id;
		this.email = email;
		this.tel = tel;	
	}
	
	public int getId(){
		return id;
	}
	public String getEmail(){
		return email;
	}
	public String getTel() {
		return tel;
	}
	
}
