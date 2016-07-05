package com.webmaven.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "areaBean")
@ViewScoped
public class AreaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String nombreJefe;
	private String areaSuperior;	
	
	private Map<String,String> nombreJefes;
	private Map<String,String> areaSuperiores;
	
    @PostConstruct
    public void init() {
        
	 nombreJefes  = new HashMap<String, String>();
	 nombreJefes.put("Jose Bello", "1");
	 nombreJefes.put("rodo Bolson", "9");
	 nombreJefes.put("Rene Iguita", "13");
	 nombreJefes.put("Jorge Middleton", "6");

	 areaSuperiores  = new HashMap<String, String>();
	 areaSuperiores.put("Economia", "1");
	 areaSuperiores.put("Subastas", "2");
	 areaSuperiores.put("Aseo", "3");
	 areaSuperiores.put("Reclamos", "4");
	 
    }
	    
		public void save() {
		    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido " + nombre ));
		    this.resetFail();
		}
	
	    public void update() {
	        addMessage("Success", "Data updated");
	    }
	     
	    public void delete() {
	        addMessage("Success", "Data deleted");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	    
		public void reset() {
			RequestContext.getCurrentInstance().reset("areaform:panel");
		}
	    public void resetFail() {
	        this.nombre = null;
	        this.nombreJefe = null;
	        this.areaSuperior = null;
	        this.reset();
	        
	    }

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getNombreJefe() {
			return nombreJefe;
		}

		public void setNombreJefe(String nombreJefe) {
			this.nombreJefe = nombreJefe;
		}

		public String getAreaSuperior() {
			return areaSuperior;
		}

		public void setAreaSuperior(String areaSuperior) {
			this.areaSuperior = areaSuperior;
		}

		public Map<String, String> getNombreJefes() {
			return nombreJefes;
		}

		public void setNombreJefes(Map<String, String> nombreJefes) {
			this.nombreJefes = nombreJefes;
		}

		public Map<String, String> getAreaSuperiores() {
			return areaSuperiores;
		}

		public void setAreaSuperiores(Map<String, String> areaSuperiores) {
			this.areaSuperiores = areaSuperiores;
		}
	    
}
