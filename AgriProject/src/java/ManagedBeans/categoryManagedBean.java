/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import clients.CategoryClient;
import entities.Category;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author albus
 */
@Named(value = "categoryManagedBean")
@RequestScoped
public class categoryManagedBean {

    int categoryid;
    String categoryname;
    
    Response rs;
    Collection<Category> categories;
    GenericType<Collection<Category>> gcategories;
    GenericType<Category> onecategory;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    CategoryClient client;


    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
    
    /**
     * Creates a new instance of categoryManagedBean
     */
    public categoryManagedBean() {
        client =new CategoryClient();
          categories = new ArrayList<Category>();
          gcategories = new GenericType<Collection<Category>>() {};
          getAllCategories();
          onecategory = new GenericType<Category>() {};
    
    }
     public String addCategory()
    {
        Category category = new Category();
        category.setCategoryName(categoryname);
        
        client.create_XML(category);
        
        
        return "category.xhtml?faces-redirect=true";
    }
    public Collection<Category> getAllCategories()
    {
        rs = client.findAll_XML(Response.class);
            categories = rs.readEntity(gcategories);
            
    
        return categories;
    }
    public String editdata(int id)
    {
       Category newCategory = new Category();
        String myid = Integer.toString(id);
       rs =client.find_JSON(Response.class,myid);
       newCategory =(Category) rs.readEntity(onecategory);
       sessionMap.put("selectedcategory",newCategory);
        
       return "categoryedit.xhtml?faces-redirect=true";
        
    }
    public String updatedata(Category c)
    {
        
        client.edit_JSON(c,Integer.toString(c.getCategoryId()));
            
        return "category.xhtml?faces-redirect=true";
    }
    public String deletedata(int id)
    {
        String myid= Integer.toString(id);
       // System.out.print(myid);
        client.remove(myid);
        
        
        return "category.xhtml?faces-redirect=true";
        
    
    }
   
}
