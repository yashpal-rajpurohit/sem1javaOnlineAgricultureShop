package entities;

import entities.City;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-29T10:48:55")
@StaticMetamodel(State.class)
public class State_ { 

    public static volatile SingularAttribute<State, String> stateName;
    public static volatile SingularAttribute<State, Integer> stateId;
    public static volatile CollectionAttribute<State, City> cityCollection;

}