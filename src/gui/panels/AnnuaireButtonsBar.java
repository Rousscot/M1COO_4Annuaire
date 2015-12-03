package gui.panels;

/**
 * Created by JeCisC on 02/12/2015.
 */
public class AnnuaireButtonsBar extends AbstractButtonBar {

    public AnnuaireButtonsBar() {
        super();
    }

    public void initButtons() {
        createButton("Ajouter", "Je permets d'ajouter une entrée à un Annuaire.", "add");
        createButton("Supprimer", "Je permets de supprimer une entrée.", "delete");
        createButton("Nettoyer", "Je permets de vider les champs.", "clean");
    }

}
