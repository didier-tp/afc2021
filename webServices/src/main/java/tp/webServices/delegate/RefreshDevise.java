package tp.webServices.delegate;

import java.util.List;

import tp.webServices.entity.Devise;

public interface RefreshDevise {
    public List<Devise> retreiveRecentDeviseValues();
    public List<Devise> refreshDeviseValuesInDataBase();
}
