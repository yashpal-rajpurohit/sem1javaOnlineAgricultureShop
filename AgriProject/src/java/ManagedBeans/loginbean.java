/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import entities.User;
import java.io.Serializable;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.SessionMap;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author albus
 */
@Named(value = "loginbean")
@SessionScoped
public class loginbean  implements Serializable {
   String useremail,password;
    private Map<String,Object> sessionMap1 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();


    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public loginbean() {
    }
    
    public String validateUserLogin(){
    
            FacesContext context = FacesContext.getCurrentInstance();
            try{
                
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgriProjectPU");
            EntityManager em = emf.createEntityManager();
            User user = (User) em .createQuery( "SELECT u from User u where u.userEmail = :useremail and u.userPassword = :password").setParameter("useremail", useremail).setParameter("password", password).getSingleResult();
            
            if (user.getUserId() == null) {
              useremail = null;
                password = null;
            return "failure"; 
            }
            else
            {
                context.getExternalContext().getSessionMap().put("user", user);
                if(user.getUserId() >0 ){
                    if(user.getUserType() == 1)
                    {
                        return "/admin/brand.xhtml?faces-redirect=true";
                     }
                    if(user.getUserType() == 2)
                    {
                     return "/user/our-product.xhtml?faces-redirect=true";
                    }

                 }
            }
            }
            catch (NoResultException nre){
                  }
              return "login.xhtml?faces-redirect=true";
          
    }
    public String validateUserLogout(){
    
      
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "../login.xhtml?faces-redirect=true";
    }
    
}
