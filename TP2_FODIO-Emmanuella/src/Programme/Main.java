package Programme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.time.LocalDate;

public class Main {
	
    public static  Scanner taper = new Scanner(System.in);
    public static  LocalDate todaysDate = LocalDate.now();
    public static List<Joueur> listJoueur=new ArrayList<Joueur>();


    public static void programme(){
        try {
            int choix;      
            do {
            		menu();
                  
                    choix = taper.nextInt();

                    if (choix == 1) {
                    Joueur j=new Joueur( );
               	     System.out.println("entrer le nom du joueur ");
               	     String nom=taper.next();
               	     
               	     j.setNom(nom);
               	     
               	     System.out.println("entrer le prénom du joueur ");
               	     String prenom=taper.next();
               		
               	     j.setPrenom(prenom);
               	     
               	     System.out.println("entrer le point du joueur ");
               	     int note=taper.nextInt();
               		
               	     j.setPoint(note);
               	     String numl=nom+todaysDate;
               	    
               	     j.setNumLicence(numl);
               	     
               	     AjoutJoueur(j);
                    }
                    
                    else if(choix==2) {
                    	AfficherJoueur();
                    }
                    
                    else if(choix==3) {
                    	 Joueur j=new Joueur( );
                    		
                    	 System.out.println("Entrer le matricule du joueur a supprimer ");
        			  	 String id=taper.next();
                     	 j.setNumLicence(id);
        			  	 
                     	 System.out.println("entrer le nom du joueur ");
                  	     String nom=taper.next();
                  	     
                  	     j.setNom(nom);
                  	     
                  	     System.out.println("entrer le prénom du joueur ");
                  	     String prenom=taper.next();
                  		
                  	     j.setPrenom(prenom);
                  	     
                  	     System.out.println("entrer le point du joueur ");
                  	     int note=taper.nextInt();
                  		
                  	     j.setPoint(note);
                  	    
                    	 UpdateJoueur(j,id);
                    }	
                    
                    else if(choix==4) {
                    	
       			  	    System.out.println("Entrer le matricule du joueur a supprimer ");
       			  	    String id=taper.next();
                    	Joueur j=new Joueur();
                    	j.setNumLicence(id);
                    	DeleteJoueur(j);
                    }
                    
                    else if(choix==5) {
                    	sortir();
                    }
                   
    
            }while(choix!=6);
            
        } catch (Exception e) {
           System.out.println("entrer un chiffre entre 1 et 5 svp :)");
        }
      
        
    }
	public static void main(String [] args) {
		
		programme();
		
	}
	
	
	
	public static void sortir(){
        System.out.println(" merci revenez plutard !!! ");
        System.exit(0);
    }
    
    public static void menu(){
        System.out.println("1. Créer un joueur");
        System.out.println("2. Afficher les joueurs");
        System.out.println("3. Modifier un joueur");
        System.out.println("4. Supprimer un joueur");
        System.out.println("5. partir ");
        System.out.print("Votre choix : ");
    }
    
    
    public static Joueur AjoutJoueur(Joueur j) {
    	try (Connection connection=(Connection) ObjetConnection.getConnection();){
    		
    		 PreparedStatement pst=connection.prepareStatement("insert into joueur(nom,prenom,num_licence,point) values(?,?,?,?)");
	 		 pst.setString(1,j.getNom());
	 		 pst.setString(2,j.getPrenom());
	 		 pst.setString(3,j.getNumLicence());
	 		 pst.setInt(4,j.getPoint());
	 		 int x =pst.executeUpdate();
	 		 pst.close();
	 		 connection.close();
	 		 if(x==1) {
	 			System.out.println("Insertion réussi ");
	 		 }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	 return j;
    }
    
    public static Joueur UpdateJoueur(Joueur j,String numMatricule) {
    	
    	try (Connection connection=(Connection) ObjetConnection.getConnection();){
    		 PreparedStatement pst=connection.prepareStatement("update joueur set nom=?,prenom=?,point=? where num_licence=?");    	
    		 pst.setString(1, j.getNom());
	 		 pst.setString(2, j.getPrenom());
	 		 pst.setInt(3, j.getPoint());
	 		 pst.setString(4, j.getNumLicence());
	 		 pst.addBatch();
	 		 int[] x=pst.executeBatch();
	 		 
	 		 for(int i:x) {
	 			 if(i==1) {
	 	 			System.out.println("les données on été mis a jour");
	 	 		}
	 			
	 		 }
	 		 
	 		
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	 return j;
    }
    
    public static List <Joueur> AfficherJoueur() {
    	
    	try (Connection connection=(Connection) ObjetConnection.getConnection();){
    		
    		 PreparedStatement pst=connection.prepareStatement("select * from joueur");
	 		 ResultSet res= pst.executeQuery();
	 		 
	 		while(res.next()) {
	 			 System.out.println("Nom: "+res.getString(2)+ " Prenom:  "+ res.getString(3)+" Num: "+res.getString(4)+" Point "+res.getString(5));
	 		}
	 	
	 		 res.close();
	 		 pst.close();
	 		 connection.close();
		} catch (Exception e) {
			
		}
    	
    	return listJoueur;
    }
    
    public static Boolean DeleteJoueur(Joueur j) {
    	
    	try (Connection connection=(Connection) ObjetConnection.getConnection();){
    		
    		PreparedStatement pst=connection.prepareStatement("delete from joueur where num_licence=?");
	 		 pst.setString(1, j.getNumLicence());
	 		 int x=pst.executeUpdate();
	 		 if(x==1) {
	 			System.out.println("Donnée effacer ");
	 			return true;
	 		 }
	 		 else {
	 			 
	 			System.out.println("Aucun joueur avec ce numéro de licence ");
	 			return false;
	 		 }
	 	
		} catch (Exception e) {
			
		}
    	
    	return false;
    }
    
	
    
		

}
