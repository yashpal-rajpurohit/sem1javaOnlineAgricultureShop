/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author albus
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.BrandFacadeREST.class);
        resources.add(service.CartFacadeREST.class);
        resources.add(service.CategoryFacadeREST.class);
        resources.add(service.CityFacadeREST.class);
        resources.add(service.ProductFacadeREST.class);
        resources.add(service.StateFacadeREST.class);
        resources.add(service.UserFacadeREST.class);
    }
    
}
