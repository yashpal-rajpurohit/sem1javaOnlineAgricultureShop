/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import clients.BrandClient;
import entities.Brand;
import entities.User;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author albus
 */
@Named(value = "brandManagedBean")
@SessionScoped
public class BrandManagedBean implements Serializable {

    /**
     * Creates a new instance of BrandManagedBean
     */
    String brandname;
    int brandid;
  //  List<Brand> brands;
    Response rs;
    Collection<Brand> brands;
   GenericType<Collection<Brand>> gbrands;
    GenericType<Brand> onebrand;
   BrandClient client;
      private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    User u =new User();
 

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

//    public Collection<Brand> getBrands() {
//        return brands;
//    }
//
//    public void setBrands(Collection<Brand> brands) {
//        this.brands = brands;
//    }
//
//    
    public BrandManagedBean() throws IOException {
        
//         u  = (User)sessionMap.get("currentuser");
//        if(u.getUserId() >0)
//        {
//       
        client =new BrandClient();
          brands = new ArrayList<Brand>();
          gbrands = new GenericType<Collection<Brand>>() {};
          getAllBrands();
          onebrand = new GenericType<Brand>() {};
//        }
//         else{
//              FacesContext context = FacesContext.getCurrentInstance();
//    context.getExternalContext().redirect("../login.xhtml");
//      
       // }
       
    }
     public String addData()
    {
     //   return brandname;
        Brand brand = new Brand();
        brand.setBrandName(brandname);
       
       client.create_XML(brand);
       
       return "brand.xhtml?faces-redirect=true";
        
    }
     public Collection<Brand> getAllBrands()
    {
        rs = client.findAll_XML(Response.class);
            brands = rs.readEntity(gbrands);
            
    
        return brands;
    }
     public String editdata(int id)
    {
       Brand b = new Brand();
       String myid = Integer.toString(id);
       rs =client.find_JSON(Response.class,myid);
       b =(Brand) rs.readEntity(onebrand);
       sessionMap.put("selectedbrand", b);
        
       return "brandedit.xhtml?faces-redirect=true";
        
    }
     public String updatedata(Brand b)
    {
        
        client.edit_JSON(b,Integer.toString(b.getBrandId()));
            
        return "brand.xhtml?faces-redirect=true";
    }
    public String deletedata(int id)
    {
        String myid= Integer.toString(id);
       // System.out.print(myid);
        client.remove(myid);
        return "brand.xhtml?faces-redirect=true";
    }

    
}
