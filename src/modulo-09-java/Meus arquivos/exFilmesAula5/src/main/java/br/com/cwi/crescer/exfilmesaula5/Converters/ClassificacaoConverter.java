package br.com.cwi.crescer.exfilmesaula5.Converters;

import br.com.cwi.crescer.exfilmesaula5.ClassificacaoBean;
import br.com.cwi.crescer.exfilmesaula5.ManualCDILookup;
import br.com.cwi.crescer.exfilmesaula5.entity.Classificacao;
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
@FacesConverter(value = "classificacaoConverter", forClass = Classificacao.class)
public class ClassificacaoConverter extends ManualCDILookup implements javax.faces.convert.Converter {

    //@EJB
    //ElencoBean elencoBean;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            try {
                Long id = Long.valueOf(value);
                
                ClassificacaoBean classificacaoBean = null;
                classificacaoBean = getFacadeWithJNDI(ClassificacaoBean.class);

                Classificacao classificacao = classificacaoBean.find(id);
                return classificacao;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão", "Elenco inválido."));
            }catch (NamingException ex) {
                Logger.getLogger(ClassificacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && (o instanceof Classificacao)) {
            Classificacao c = (Classificacao)o;
            return String.valueOf(c.getIdClassificacao());
        }

        return null;
    }

}
