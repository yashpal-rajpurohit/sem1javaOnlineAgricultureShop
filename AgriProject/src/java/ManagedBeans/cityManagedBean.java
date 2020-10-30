/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import clients.CityClient;
import clients.StateClient;
import entities.City;
import entities.State;
import entities.User;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;



/**
 *
 * @author albus
 */
@Named(value = "cityManagedBean")
@SessionScoped
public class cityManagedBean implements Serializable {
    int cityId,stateId;
    String cityName;
    StateClient sclient;
    Response rs;
    GenericType<State> onestate;
    CityClient client;
        
    
     Collection<City> cities;
    GenericType<Collection<City>> gcities;
    GenericType<City> oneCity;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    User u =new User();
  

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    /**
     * Creates a new instance of cityManagedBean
     */
    public cityManagedBean() throws IOException {
//        u  = (User)sessionMap.get("currentuser");
//        if(u.getUserId() >0)
//        {
           sclient= new StateClient();
        onestate = new GenericType<State>() {};
        client = new CityClient();
        
    
          cities = new ArrayList<City>();
          gcities = new GenericType<Collection<City>>() {};
         getAllCities();
          oneCity= new GenericType<City>() {};
//        }
//        else{
//              FacesContext context = FacesContext.getCurrentInstance();
//    context.getExternalContext().redirect("../login.xhtml");
//      
//        }
//        
    }
     public String addData()
    {
        
        City c = new City();
        c.setCityName(cityName);
        
       State s = new State();
       rs =sclient.find_XML(Response.class,Integer.toString(stateId));
       s =(State) rs.readEntity(onestate);
     
       c.setStateId(s);
       client.create_XML(c);
        
       return "city.xhtml?faces-redirect=true";
        
    }
     public Collection<City> getAllCities()
    { 
        
        rs = client.findAll_XML(Response.class);
        cities = rs.readEntity(gcities);       
        return cities;
     
    }
   
    public String deletedata(int id)
    {
        String myid= Integer.toString(id);
       // System.out.print(myid);
        client.remove(myid);        
       return "city.xhtml?faces-redirect=true";

   }
}
