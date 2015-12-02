package gui.panels;

/**
 * Created by JeCisC on 02/12/2015.
 */
public class AnnuaireButtonsBar extends AbstractButtonBar {

    public AnnuaireButtonsBar() {
        super();
    }

    public void initButtons() {
        createButton("Ajouter", "Je permet d'ajouter un bouton à une entrée.", "add");
        createButton("Supprimer", "Je permet de supprimer une entrée.", "delete");
        createButton("Nettoyer", "Je permet de vider les champs.", "clean");
    }

}
