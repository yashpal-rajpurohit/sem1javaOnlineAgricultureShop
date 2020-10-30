package entities;

import entities.Brand;
import entities.Cart;
import entities.Category;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-29T10:48:55")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile CollectionAttribute<Product, Cart> cartCollection;
    public static volatile SingularAttribute<Product, String> productDesc;
    public static volatile SingularAttribute<Product, Category> productCategoryId;
    public static volatile SingularAttribute<Product, Integer> productId;
    public static volatile SingularAttribute<Product, String> productImg;
    public static volatile SingularAttribute<Product, Brand> productBrandId;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, Long> productPrice;

}