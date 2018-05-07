package org.arnotec;

import java.util.List;

import org.arnotec.dao.CategorieRepository;
import org.arnotec.dao.ProduitRepository;
import org.arnotec.entities.Categorie;
import org.arnotec.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestProdApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GestProdApplication.class, args);
		ProduitRepository produitDao = ctx.getBean(ProduitRepository.class);
		CategorieRepository categorieDao = ctx.getBean(CategorieRepository.class);
		
		Categorie c1 = new Categorie("Ordinateurs");
		Categorie c2 = new Categorie("Imprimantes");
		Categorie c3 = new Categorie("Scanners");
		
		categorieDao.save(c1);
		categorieDao.save(c2);
		categorieDao.save(c3);
		
		produitDao.save(new Produit("HP 8542", 5000, 7, c1));
		produitDao.save(new Produit("LX 2047", 900, 5, c3));
		produitDao.save(new Produit("DELL 6300", 8000, 3, c2));
		
		List<Produit> produits = produitDao.findByMC("%H%");
		for(Produit p:produits) {
			System.out.println("Des "+p.getDesignation());
			System.out.println("Prix "+p.getPrix());
			System.out.println("Qte "+p.getQuantite());
		}
	}
}
