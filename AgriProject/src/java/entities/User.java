/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author albus
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")
    , @NamedQuery(name = "User.findByUserFname", query = "SELECT u FROM User u WHERE u.userFname = :userFname")
    , @NamedQuery(name = "User.findByUserMname", query = "SELECT u FROM User u WHERE u.userMname = :userMname")
    , @NamedQuery(name = "User.findByUserLname", query = "SELECT u FROM User u WHERE u.userLname = :userLname")
    , @NamedQuery(name = "User.findByUserDob", query = "SELECT u FROM User u WHERE u.userDob = :userDob")
    , @NamedQuery(name = "User.findByUserPhoneno", query = "SELECT u FROM User u WHERE u.userPhoneno = :userPhoneno")
    , @NamedQuery(name = "User.findByUserEmail", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail")
    , @NamedQuery(name = "User.findByUserGender", query = "SELECT u FROM User u WHERE u.userGender = :userGender")
    , @NamedQuery(name = "User.findByUserType", query = "SELECT u FROM User u WHERE u.userType = :userType")
    , @NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.userPassword = :userPassword")})
public class User implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartUserId")
    private Collection<Cart> cartCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_Id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "user_fname")
    private String userFname;
    @Basic(optional = false)
    @Column(name = "user_mname")
    private String userMname;
    @Basic(optional = false)
    @Column(name = "user_lname")
    private String userLname;
    @Basic(optional = false)
    @Column(name = "user_dob")
    @Temporal(TemporalType.DATE)
    private Date userDob;
    @Basic(optional = false)
    @Column(name = "user_phoneno")
    private String userPhoneno;
    @Basic(optional = false)
    @Column(name = "user_email")
    private String userEmail;
    @Basic(optional = false)
    @Column(name = "user_gender")
    private String userGender;
    @Basic(optional = false)
    @Column(name = "user_type")
    private int userType;
    @Basic(optional = false)
    @Column(name = "user_password")
    private String userPassword;
    @JoinColumn(name = "user_city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City userCityId;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String userFname, String userMname, String userLname, Date userDob, String userPhoneno, String userEmail, String userGender, int userType, String userPassword) {
        this.userId = userId;
        this.userFname = userFname;
        this.userMname = userMname;
        this.userLname = userLname;
        this.userDob = userDob;
        this.userPhoneno = userPhoneno;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userType = userType;
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserMname() {
        return userMname;
    }

    public void setUserMname(String userMname) {
        this.userMname = userMname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public Date getUserDob() {
        return userDob;
    }

    public void setUserDob(Date userDob) {
        this.userDob = userDob;
    }

    public String getUserPhoneno() {
        return userPhoneno;
    }

    public void setUserPhoneno(String userPhoneno) {
        this.userPhoneno = userPhoneno;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public City getUserCityId() {
        return userCityId;
    }

    public void setUserCityId(City userCityId) {
        this.userCityId = userCityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ userId=" + userId + " ]";
    }

    @XmlTransient
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }
    
}
