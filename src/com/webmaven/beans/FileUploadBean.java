package com.webmaven.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "fileUploadBean")
@ViewScoped
public class FileUploadBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UploadedFile archivo;
	private String destino = "F:\\tmp\\";
	
	
	public UploadedFile getArchivo() {
		return archivo;
	}


	public void setArchivo(UploadedFile archivo) {
		this.archivo = archivo;
	}


	public void fileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        archivo = event.getFile();
        try {
        	copiarArchivo(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void copiarArchivo(String fileName, InputStream in) {
        try {
           
           
             // write the inputStream to a FileOutputStream
        	FileOutputStream out = new FileOutputStream(new File(destino + fileName));
           
             int read = 0;
             byte[] bytes = new byte[1024];
           
             while ((read = in.read(bytes)) != -1) {
                 out.write(bytes, 0, read);
             }
           
             in.close();
             out.flush();
             out.close();
             System.out.println("Nuevo archivo creado!");
             } catch (IOException e) {
             System.out.println(e.getMessage());
             }
 }
	

}
