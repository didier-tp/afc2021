package fr.afcepf.al35.tp.web.mvc.form;

import java.util.List;

import fr.afcepf.al35.tp.web.mvc.form.data.Commande;
import fr.afcepf.al35.tp.web.mvc.form.data.Produit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CommandeForm {
	Commande cmde;
	ThActions prodActions;
	
	public CommandeForm(Commande cmde){
		this.cmde = cmde;
		this.resetThActions();
	}
	

	public CommandeForm() {
		this(null);
	}
	
	public void resetThActions() {
		this.prodActions= new ThActions();
	}
	
	public void adjustCommandeFromThActions() {
		System.out.println("actionsOnProductsOfCmde="+this.getProdActions());
		//suppression des produits dont les ids ont été sélectionnés:
		String strIdsToDelete = this.getProdActions().getIdsToDelete().trim();
		if(strIdsToDelete!=null && !strIdsToDelete.isEmpty()) {
			String[] idsToDelete = strIdsToDelete.split(" ");
			List<Produit> listeProduits= this.getCmde().getProduits();
			for(int i=0;i<idsToDelete.length;i++) {
			    for(int j=listeProduits.size()-1;j>=0;j--) {
					Produit p = listeProduits.get(j);
					String idToDelete = idsToDelete[i];
					if(idToDelete.equals("null")) {
						if(p.getRef()==null)
							listeProduits.remove(p);
					}else {
						if(p.getRef()!=null && p.getRef() == Long.parseLong(idsToDelete[i])) {
							listeProduits.remove(p);
						}
					}
				}
			}
		}
		//ajout de nouveaux produits:
		int nbNew = this.getProdActions().getNbNew();
		if(nbNew>0) {
			for(int i=0;i<nbNew;i++) {
				this.getCmde().getProduits().add(new Produit());
			}
		}
		this.resetThActions();
	}



}
