package br.com.cwi.crescer.exfilmesaula5.Converters;


import br.com.cwi.crescer.exfilmesaula5.ElencoBean;
import br.com.cwi.crescer.exfilmesaula5.entity.Elenco;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "elencoConverter", forClass = Elenco.class)
public class ElencoConverter implements javax.faces.convert.Converter {

    @EJB
    ElencoBean elencoBean;
            
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string != null && !string.isEmpty()) {
            return elencoBean.findByName(string).get(0);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && (o instanceof Elenco)) {
            return o.toString();
        }

        return null;
    }

}