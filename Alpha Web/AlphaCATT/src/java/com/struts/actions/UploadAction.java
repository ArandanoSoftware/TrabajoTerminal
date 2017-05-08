// Clase para subir el archivo Excel 
package com.struts.actions;

import java.io.File;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends  ActionSupport{
    private File file;
    private String contentType;
    private String filename;
    
    public void setUpload(File file) {
         this.file = file;
      }
 
      public void setUploadContentType(String contentType) {
         this.contentType = contentType;
      }
 
      public void setUploadFileName(String filename) {
         this.filename = filename;
      }
 
    @Override
      public String execute() {
         //...
         return SUCCESS;
      }
}
