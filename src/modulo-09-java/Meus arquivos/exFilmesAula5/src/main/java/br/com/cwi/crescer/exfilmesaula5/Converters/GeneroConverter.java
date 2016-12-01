package br.com.cwi.crescer.exfilmesaula5.Converters;


import br.com.cwi.crescer.exfilmesaula5.GeneroBean;
import br.com.cwi.crescer.exfilmesaula5.entity.Genero;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "generoConverter", forClass = Genero.class)
public class GeneroConverter implements javax.faces.convert.Converter {

    @EJB
    GeneroBean generoBean;
            
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            try {
                Long id = Long.parseLong(value);
                Genero genero = generoBean.find(id);
                return genero;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão", "Gênero inválido."));
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