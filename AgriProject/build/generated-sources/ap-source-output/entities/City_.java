package entities;

import entities.State;
import entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-29T10:48:55")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SingularAttribute<City, String> cityName;
    public static volatile CollectionAttribute<City, User> userCollection;
    public static volatile SingularAttribute<City, State> stateId;
    public static volatile SingularAttribute<City, Integer> cityId;

}