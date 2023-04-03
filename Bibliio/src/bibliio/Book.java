/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliio;

/**
 *
 * @author Red
 */
public class Book {
    private String titre;
    private String categorie;
    private String isbn;
    private String nomAuteur;
    private String prenomAuteur;
    private String code;
    public Book(String isbn, String titre, String categorie,
                 String nomAuteur, String prenomAuteur) {
        this.titre = titre;
        this.categorie = categorie;
        this.isbn = isbn;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
        this.code = calculCode();
    }

    public void setTitre(String valeur) {
        titre = valeur;
    }
    public void setCategorie(String valeur) {
        categorie = valeur;
    }
    public void setIsbn(String valeur) {
        isbn = valeur;
    }
    public void setNomAuteur(String valeur) {
        nomAuteur = valeur;
    }
    public void setPrenomAuteur(String valeur) {
        prenomAuteur = valeur;
    }

    public String getTitre() {
        return titre;
    }
    public String getCategorie() {
        return categorie;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getNomAuteur() {
        return nomAuteur;
    }
    public String getPrenomAuteur() {
        return prenomAuteur;
    }

    public String getCode() {
        code = calculCode(); 
        return code;
    }
    private String calculCode() {
        String debutNom;
        String debutPrenom;
        String debutCategorie;
        int longueurIsbn;
        String finIsbn;
        debutNom = nomAuteur.substring(0, 2);
        debutPrenom = prenomAuteur.substring(0, 2);
        debutCategorie = categorie.substring(0, 2);
        longueurIsbn = isbn.length();
        finIsbn = isbn.substring((longueurIsbn - 2),
                longueurIsbn);
        return debutNom + debutPrenom + debutCategorie + finIsbn;
    }
}
