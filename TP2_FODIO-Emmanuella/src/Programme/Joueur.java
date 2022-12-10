package Programme;

public class Joueur {
	
	private String nom;
	private String prenom;
	private String numLicence;
	private int point=0;
	
	
	public Joueur(String nom, String prenom, String numLicence, int point) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numLicence = numLicence;
		this.point = point;
	}
	
	public Joueur() {}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumLicence() {
		return numLicence;
	}
	public void setNumLicence(String numLicence) {
		this.numLicence = numLicence;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	

	

}
