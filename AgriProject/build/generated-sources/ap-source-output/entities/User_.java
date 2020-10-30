package entities;

import entities.Cart;
import entities.City;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-29T10:48:55")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile CollectionAttribute<User, Cart> cartCollection;
    public static volatile SingularAttribute<User, String> userMname;
    public static volatile SingularAttribute<User, String> userLname;
    public static volatile SingularAttribute<User, String> userPassword;
    public static volatile SingularAttribute<User, Date> userDob;
    public static volatile SingularAttribute<User, String> userPhoneno;
    public static volatile SingularAttribute<User, String> userEmail;
    public static volatile SingularAttribute<User, String> userGender;
    public static volatile SingularAttribute<User, Integer> userType;
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile SingularAttribute<User, City> userCityId;
    public static volatile SingularAttribute<User, String> userFname;

}