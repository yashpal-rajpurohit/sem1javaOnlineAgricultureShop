/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import clients.StateClient;
import java.util.Collection;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import entities.State;
import java.util.ArrayList;

/**
 *
 * @author albus
 */
@Named(value = "stateManagedBean")
@RequestScoped
public class stateManagedBean {

    /**
     * Creates a new instance of stateManagedBean
     */
     int stateid;
    String statename;
         StateClient client;
    Response rs;
    Collection<State> states;
    GenericType<Collection<State>> gstates;
    GenericType<State> onestate;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();


    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }
    
   
    public stateManagedBean() {
        
         client =new StateClient();
          states = new ArrayList<State>();
          gstates = new GenericType<Collection<State>>() {};
         getAllStates();
          onestate= new GenericType<State>() {};
 

    }
    public String addData()
    {
        
         State s = new State();
         s.setStateName(statename);
         client.create_JSON(s);
         
        
        return "state.xhtml?faces-redirect=true";
        
    }
    public Collection<State> getAllStates()
    { 
        rs = client.findAll_XML(Response.class);
            states = rs.readEntity(gstates);
            
    
        return states;
  
    }

    public String editdata(int id)
    {
      State s = new State();
       String myid = Integer.toString(id);
       rs =client.find_XML(Response.class,myid);
       
       s =(State) rs.readEntity(onestate);
       sessionMap.put("selectedstate", s);
        
       return "stateedit.xhtml?faces-redirect=true";
//        
    }
  public String updatedata(State s)
  {
//        
        client.edit_JSON(s,Integer.toString((s.getStateId())));
//            
        return "state.xhtml?faces-redirect=true";
  }
    public String deletedata(int id)
    {
        String myid= Integer.toString(id);
       // System.out.print(myid);
        client.remove(myid);        
       return "state.xhtml?faces-redirect=true";

   }
    
}
