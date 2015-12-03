package gui.panels;

/**
 * Created by JeCisC on 02/12/2015.
 */
public class EntryButtonsBar extends AbstractButtonBar {

    public EntryButtonsBar() {
        super();
    }

    public void initButtons() {
        createButton("Ajouter", "Je permets d'ajouter un Numero à une entrée.", "add");
        createButton("Supprimer", "Je permets de supprimer un numéro.", "delete");
        createButton("Nettoyer", "Je permets de vider les champs.", "clean");
    }

}
