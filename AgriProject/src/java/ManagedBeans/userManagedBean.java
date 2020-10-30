/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import clients.CityClient;
import clients.UserClient;
import entities.Brand;
import entities.City;
import entities.User;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author albus
 */
@Named(value = "userManagedBean")
@RequestScoped
public class userManagedBean {

    /**
     * Creates a new instance of userManagedBean
     */
    int userid,usercityid,usertype;
    String fname,mname,lname,phoneno,email,password;
    Date dob;
    String gender;
    
     GenericType<City> onecity;
     UserClient uclient;
     CityClient cclient;
     Response rs;
   

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUsercityid() {
        return usercityid;
    }

    public void setUsercityid(int usercityid) {
        this.usercityid = usercityid;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public userManagedBean() {
        uclient= new UserClient();
         cclient = new CityClient();
          onecity= new GenericType<City>() {};
        
         
    }
         public String addData()
    {
        
        User u = new User();
        u.setUserFname(fname);
        u.setUserMname(mname);
        u.setUserLname(lname);
        u.setUserEmail(email);
        u.setUserDob(dob);
        u.setUserGender(gender);
        u.setUserPassword(password);
        u.setUserType(2);
        u.setUserPhoneno(phoneno);
        
        
       City c = new City();
       rs =cclient.find_XML(Response.class,Integer.toString(usercityid));
       c =(City) rs.readEntity(onecity);
     
       u.setUserCityId(c);
       uclient.create_XML(u);
        
       return "login.xhtml?faces-redirect=true";
        
    }
    
}
