/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import entities.Cart;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author albus
 */
@Named(value = "cartManagedBean")
@RequestScoped
public class CartManagedBean {

    int cartid,userid,productid;
    Date cartdate;

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public Date getCartdate() {
        return cartdate;
    }

    public void setCartdate(Date cartdate) {
        this.cartdate = cartdate;
    }
    
    /**
     * Creates a new instance of CartManagedBean
     */
    public CartManagedBean() {
        
    }
      public String addData()
    {
       // cartdate = D
//        Cart c = new Cart();
//        c.setCartDate(cartdate);
     //   return brandname;
//        Brand brand = new Brand();
//        brand.setBrandName(brandname);
//       
//       client.create_XML(brand);
//       
       return "our-product.xhtml?faces-redirect=true";
        
    }
   
    
}
