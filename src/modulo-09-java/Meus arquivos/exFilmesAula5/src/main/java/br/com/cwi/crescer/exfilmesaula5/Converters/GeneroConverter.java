package br.com.cwi.crescer.exfilmesaula5.Converters;


import br.com.cwi.crescer.exfilmesaula5.GeneroBean;
import br.com.cwi.crescer.exfilmesaula5.entity.Genero;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "generoConverter", forClass = Genero.class)
public class GeneroConverter implements javax.faces.convert.Converter {

    @EJB
    GeneroBean generoBean;
            
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string != null && !string.isEmpty()) {
            return generoBean.findByDescription(string).get(0);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && (o instanceof Genero)) {
            return o.toString();
        }

        return null;
    }

}