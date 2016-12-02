package br.com.cwi.crescer.exfilmesaula5.Converters;

import br.com.cwi.crescer.exfilmesaula5.ElencoBean;
import br.com.cwi.crescer.exfilmesaula5.ManualCDILookup;
import br.com.cwi.crescer.exfilmesaula5.entity.Elenco;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;

//@ManagedBean
//@Named
@FacesConverter(value = "elencoConverter", forClass = Elenco.class)
public class ElencoConverter extends ManualCDILookup implements javax.faces.convert.Converter {

    //@EJB
    //ElencoBean elencoBean;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            try {
                Long id = Long.valueOf(value);
                
                ElencoBean elencoBean = null;
                elencoBean = getFacadeWithJNDI(ElencoBean.class);

                Elenco elenco = elencoBean.find(id);
                return elenco;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão", "Elenco inválido."));
            }catch (NamingException ex) {
                Logger.getLogger(ElencoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && (o instanceof Elenco)) {
            return String.valueOf(((Elenco)o).getIdElenco());
        }

        return null;
    }

}
