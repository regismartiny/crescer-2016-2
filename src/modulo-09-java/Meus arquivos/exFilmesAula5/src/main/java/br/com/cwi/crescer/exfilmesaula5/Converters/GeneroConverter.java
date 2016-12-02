package br.com.cwi.crescer.exfilmesaula5.Converters;


import br.com.cwi.crescer.exfilmesaula5.GeneroBean;
import br.com.cwi.crescer.exfilmesaula5.entity.Genero;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

@ManagedBean
//@FacesConverter(value = "generoConverter", forClass = Genero.class)
@Named
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
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão", "Gênero inválido.");
                FacesContext.getCurrentInstance().addMessage(null, fm);
                throw new ConverterException(fm);
            }catch(Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão", e.getMessage());
                throw new ConverterException(fm);
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