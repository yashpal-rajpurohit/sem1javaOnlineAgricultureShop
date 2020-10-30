/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import clients.BrandClient;
import clients.CategoryClient;
import clients.ProductClient;
import entities.Brand;
import entities.Category;
import entities.Product;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author albus
 */
@Named(value = "productManagedBean")
@RequestScoped
public class productManagedBean {
    int productid,brandid,categoryid;
    long productprice;
     private Part image;

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }
   
    
    String productdesc, productimg, productname;
    
    Response rs;
    ProductClient pclient;
    CategoryClient cclient;
    BrandClient bclient;
    GenericType<Category> onecategory;
    GenericType<Brand> onebrand;
    GenericType<Product> oneproduct;
    
      Collection<Product> products;
    GenericType<Collection<Product>> gproducts;
   
 String path;
 

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public long getProductprice() {
        return productprice;
    }

    public void setProductprice(long productprice) {
        this.productprice = productprice;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public String getProductimg() {
        return productimg;
    }

    public void setProductimg(String productimg) {
        this.productimg = productimg;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
    
    
    /**
     * Creates a new instance of productManagedBean
     */
    public productManagedBean() {
         pclient= new ProductClient();
         bclient = new BrandClient();
         cclient = new CategoryClient();
         onecategory= new GenericType<Category>() {};
         onebrand= new GenericType<Brand>() {};
         oneproduct= new GenericType<Product>() {};
         
          products = new ArrayList<Product>();
          gproducts = new GenericType<Collection<Product>>() {};
       
    
    }
    
    public String addData()
    {
        try{
           // double random = Math.random();
            InputStream in=image.getInputStream();
            
            File f=new File("C://Users/albus/Documents/NetBeansProjects/AgriProject/web/images/"+image.getSubmittedFileName());
            f.createNewFile();
            FileOutputStream out=new FileOutputStream(f);
            
            byte[] buffer=new byte[1024];
            int length;
            
            while((length=in.read(buffer))>0){
                out.write(buffer, 0, length);
            }
            
            out.close();
            in.close();
             path = f.getAbsolutePath();
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", f.getAbsolutePath());
          //  upladed=true;
          productimg = "../images/" + image.getSubmittedFileName();  
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        Product p = new Product();
        p.setProductName(productname);
        
        p.setProductPrice(productprice);
        p.setProductDesc(productdesc);
        p.setProductImg(productimg);
       Category c = new Category();
       rs =cclient.find_XML(Response.class,Integer.toString(categoryid));
       c =(Category) rs.readEntity(onecategory);
     
       p.setProductCategoryId(c);
       
       Brand b = new Brand();
       rs =bclient.find_XML(Response.class,Integer.toString(brandid));
       b =(Brand) rs.readEntity(onebrand);
     
       p.setProductBrandId(b);
       
       
       pclient.create_XML(p);
        
       return "product.xhtml?faces-redirect=true";
        
    }
     public Collection<Product> getAllProducts()
    { 
        rs = pclient.findAll_XML(Response.class);
        products = rs.readEntity(gproducts);       
      
        return products;
  
    }
      public String deletedata(int id,String prodimg)
    {
        String fullpath = "C://Users/albus/Documents/NetBeansProjects/AgriProject/web";
       String imgname = prodimg.substring(2);
       
        File myObj = new File(fullpath + imgname);
        myObj.delete();
        
        String myid= Integer.toString(id);
       // System.out.print(myid);
        pclient.remove(myid);        
       return "product.xhtml?faces-redirect=true";

   }

    
}
