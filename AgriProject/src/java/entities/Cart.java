/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author albus
 */
@Entity
@Table(name = "cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
    , @NamedQuery(name = "Cart.findByCartId", query = "SELECT c FROM Cart c WHERE c.cartId = :cartId")
    , @NamedQuery(name = "Cart.findByCartDate", query = "SELECT c FROM Cart c WHERE c.cartDate = :cartDate")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cart_id")
    private Integer cartId;
    @Basic(optional = false)
    @Column(name = "cart_date")
    @Temporal(TemporalType.DATE)
    private Date cartDate;
    @JoinColumn(name = "cart_product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private Product cartProductId;
    @JoinColumn(name = "cart_user_id", referencedColumnName = "user_Id")
    @ManyToOne(optional = false)
    private User cartUserId;

    public Cart() {
    }

    public Cart(Integer cartId) {
        this.cartId = cartId;
    }

    public Cart(Integer cartId, Date cartDate) {
        this.cartId = cartId;
        this.cartDate = cartDate;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Date getCartDate() {
        return cartDate;
    }

    public void setCartDate(Date cartDate) {
        this.cartDate = cartDate;
    }

    public Product getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Product cartProductId) {
        this.cartProductId = cartProductId;
    }

    public User getCartUserId() {
        return cartUserId;
    }

    public void setCartUserId(User cartUserId) {
        this.cartUserId = cartUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartId != null ? cartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.cartId == null && other.cartId != null) || (this.cartId != null && !this.cartId.equals(other.cartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cart[ cartId=" + cartId + " ]";
    }
    
}
