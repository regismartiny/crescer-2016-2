package br.com.cwi.crescer.exfilmesaula5.Converters;


import br.com.cwi.crescer.exfilmesaula5.ElencoBean;
import br.com.cwi.crescer.exfilmesaula5.GeneroBean;
import br.com.cwi.crescer.exfilmesaula5.ManualCDILookup;
import br.com.cwi.crescer.exfilmesaula5.entity.Genero;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;

@FacesConverter(value = "generoConverter", forClass = Genero.class)
public class GeneroConverter extends ManualCDILookup implements javax.faces.convert.Converter {

    @EJB
    GeneroBean generoBean;
            
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            try {
                Long id = Long.valueOf(value);
                
                GeneroBean generoBean = getFacadeWithJNDI(GeneroBean.class);
                Genero genero = generoBean.find(id);
                return genero;
            } catch(NumberFormatException e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão", "Gênero inválido.");
                FacesContext.getCurrentInstance().addMessage(null, fm);
                throw new ConverterException(fm);
            }catch (NamingException ex) {
                Logger.getLogger(ElencoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && (o instanceof Genero)) {
            return String.valueOf(((Genero)o).getIdGenero());
        }

        return null;
    }

}