package com.webmaven.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import com.webmaven.entity.Usuario;

import org.primefaces.context.RequestContext;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String login;
	private String area;
	private String usualterno;
	private int activo;
	
	private List<Usuario> usuarios;
    private Usuario selectedUsuario;
    private List<Usuario> selectedUsuarios;
    

    private Map<String,String> areas;
    private Map<String,String> usuariosAlternos;
	
	    @PostConstruct
	    public void init() {
	        usuarios = createUsuarios(100);
	        
	        areas  = new HashMap<String, String>();
	        areas.put("Finanzas", "Finanzas");
	        areas.put("Area 51", "Area 51");
	        areas.put("Economia", "Economia");
	        areas.put("Aduana", "Aduana");
	        areas.put("Informatica", "Informatica");
	        areas.put("Servicios", "Servicios");
	        
	        usuariosAlternos  = new HashMap<String, String>();
	        usuariosAlternos.put("Jose Bello", "1");
	        usuariosAlternos.put("rodo Bolson", "9");
	        usuariosAlternos.put("Rene Iguita", "13");
	        usuariosAlternos.put("Jorge Middleton", "6");

	    }
	    
	    
	public List<Usuario> createUsuarios(int size) {
		List<Usuario> list = new ArrayList<Usuario>();
		for (int i = 0; i < size; i++) {
			list.add(new Usuario(getRandomNum(), getRandomNombre(), getRandomLogin(), getRandomArea(), getRandomusuariosinternos()));
		}

		return list;
	}
	
	 private int getRandomNum() {
	        return (int) (Math.random() * 50 + 1);
	    }
	 
    private String getRandomNombre() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
    
    private String getRandomLogin() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
	  
    
    private String getRandomArea() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private String getRandomusuariosinternos() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
	   
	  
	public void save() {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido " + nombre ));
	    this.resetFail();
	}
     
    public void update() {
      	RequestContext context = RequestContext.getCurrentInstance();
      	context.execute("PF('usuarioDialog').hide();");
      	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro actualizado con exito " + selectedUsuario.getNum() ));
    }
     
    public void delete() {
    	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado " + selectedUsuario.getNum() ));
    }

     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
	public void reset() {
		RequestContext.getCurrentInstance().reset("formUsuario:panel");
	}
    public void resetFail() {
        this.nombre = null;
        this.login = null;
        this.area = null;
        this.usualterno = null;
        this.reset();
        
    }

    
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}


	public String getUsualterno() {
		return usualterno;
	}

	public void setUsualterno(String usualterno) {
		this.usualterno = usualterno;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

	public List<Usuario> getSelectedUsuarios() {
		return selectedUsuarios;
	}

	public void setSelectedUsuarios(List<Usuario> selectedUsuarios) {
		this.selectedUsuarios = selectedUsuarios;
	}

	public Map<String, String> getAreas() {
		return areas;
	}


	public void setAreas(Map<String, String> areas) {
		this.areas = areas;
	}


	public Map<String, String> getUsuariosAlternos() {
		return usuariosAlternos;
	}


	public void setUsuariosAlternos(Map<String, String> usuariosAlternos) {
		this.usuariosAlternos = usuariosAlternos;
	}


	


    
    
     

}
