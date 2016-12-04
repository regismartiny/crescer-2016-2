/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exfilmesaula5.converter;

import br.com.cwi.crescer.exfilmesaula5.entity.Ator;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author regis
 */
@FacesConverter("atorConverter") 
public class AtorConverter implements Converter { 
 
    @Override 
    public Object getAsObject(FacesContext context, UIComponent uIComponent, String value) { 
        if (value != null) { 
            return this.getInComponent(uIComponent, value); 
        } 
        return null; 
    } 
 
    @Override 
    public String getAsString(FacesContext context, UIComponent component, Object value) { 
        final Ator ator = (Ator) value; 
        if (ator != null) { 
            this.setInComponent(component, ator); 
            return ator.getIdAtor().toString(); 
        } 
        return null; 
    } 
 
    private void setInComponent(final UIComponent uIComponent, final Ator ator) { 
        Map<Long, Ator> atores; 
        atores = (Map<Long, Ator>) uIComponent.getAttributes().get("atores"); 
        if (atores == null) { 
            atores = new HashMap<>(); 
        } 
        atores.put(ator.getIdAtor(), ator); 
        uIComponent.getAttributes().put("atores", atores); 
    } 
 
    private Object getInComponent(UIComponent uIComponent, String value) throws NumberFormatException { 
        Map<Long, Ator> atores; 
        atores = (Map<Long, Ator>) uIComponent.getAttributes().get("atores"); 
        if (atores != null) { 
            return atores.get(Long.valueOf(value)); 
        } 
        return null; 
    } 
 
} 