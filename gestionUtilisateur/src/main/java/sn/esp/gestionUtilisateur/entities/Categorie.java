package sn.esp.gestionUtilisateur.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategorie")
    private Long  idcategorie;

    private String libelle;

    public Categorie(Long idcategorie, String libelle) {
        this.idcategorie = idcategorie;
        this.libelle = libelle;
    }

    public Categorie() {
    }

    public Long getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Long idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
