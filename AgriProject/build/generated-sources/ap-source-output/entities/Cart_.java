package entities;

import entities.Product;
import entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-29T10:48:55")
@StaticMetamodel(Cart.class)
public class Cart_ { 

    public static volatile SingularAttribute<Cart, Product> cartProductId;
    public static volatile SingularAttribute<Cart, Date> cartDate;
    public static volatile SingularAttribute<Cart, Integer> cartId;
    public static volatile SingularAttribute<Cart, User> cartUserId;

}