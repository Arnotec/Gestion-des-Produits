package org.arnotec.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Categorie implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(length=70)
	private String nomCategorie;
	@OneToMany(mappedBy="categorie", fetch=FetchType.LAZY)
	private Collection<Produit> produits;
	
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}
	

}
