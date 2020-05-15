package com.imobile3.groovypayments.utils;

import com.imobile3.groovypayments.data.entities.CartEntity;
import com.imobile3.groovypayments.data.entities.CartProductEntity;
import com.imobile3.groovypayments.data.entities.ProductEntity;
import com.imobile3.groovypayments.data.entities.ProductTaxJunctionEntity;
import com.imobile3.groovypayments.data.entities.TaxEntity;
import com.imobile3.groovypayments.data.entities.UserEntity;
import com.imobile3.groovypayments.data.enums.GroovyColor;
import com.imobile3.groovypayments.data.enums.GroovyIcon;
import com.imobile3.groovypayments.data.utils.CartBuilder;
import com.imobile3.groovypayments.data.utils.CartProductBuilder;
import com.imobile3.groovypayments.data.utils.ProductBuilder;
import com.imobile3.groovypayments.data.utils.TaxBuilder;
import com.imobile3.groovypayments.data.utils.UserBuilder;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MockDataHelper {

    private static MockDataHelper instance = null;

    private MockDataHelper() {
    }

    public static MockDataHelper getInstance() {
        if (instance == null) {
            synchronized (MockDataHelper.class) {
                if (instance == null)
                    instance = new MockDataHelper();

            }
        }
        return instance;
    }

    public List<ProductEntity> getMockProducts() {
        return Arrays.asList(
                ProductBuilder.build(101L,
                        "Tasty Chicken Sandwich",
                        "Chicken, lettuce, tomato and mayo",
                        750L, 200L,
                        GroovyIcon.Sandwich, GroovyColor.Yellow),

                ProductBuilder.build(102L,
                        "Android T-Shirt",
                        "Your favorite little green Android",
                        2000L, 200L,
                        GroovyIcon.TShirt, GroovyColor.Green),

                ProductBuilder.build(103L,
                        "Coffee Mug",
                        "Greatest mug for coffee and drinks",
                        400L, 20L,
                        GroovyIcon.CoffeeMug, GroovyColor.Blue),

                ProductBuilder.build(104L,
                        "Hot Sandwich",
                        "Made from fresh ingredients",
                        440L, 25L,
                        GroovyIcon.Sandwich, GroovyColor.Orange)

        );
    }

    public List<UserEntity> getMockUserEntity() {
        return Arrays.asList(
                UserBuilder.build(
                        1,
                        "John",
                        "Smith",
                        "jsmith",
                        "jsmith@groovy.com",
                        "password"),
                UserBuilder.build(
                        2,
                        "Jane",
                        "Smith",
                        "jasmith",
                        "jasmith@groovy.com",
                        "password"));
    }

    public List<CartProductEntity> getMockCartProductEntity() {
        return Arrays.asList(
                CartProductBuilder.build(1, 1, "Cart Product 1",
                        1, 1),
                CartProductBuilder.build(2, 2, "Cart Product 2",
                        2, 2));
    }

    public List<CartEntity> getMockCartEntity() {
        return Arrays.asList(
                CartBuilder.build(1, new Date()),
                CartBuilder.build(2, new Date(), 10, 1, 11));
    }

    public List<TaxEntity> getMockTaxEntity() {
        return Arrays.asList(
                TaxBuilder.build(101L,
                        "Florida State Sales Tax",
                        "0.06"),
                TaxBuilder.build(102L,
                        "Florida Local Sales Tax",
                        "0.025"));
    }

    public List<ProductTaxJunctionEntity> getMockProductTaxJunctionEntity() {
        ProductTaxJunctionEntity productTaxJunctionEntity = new ProductTaxJunctionEntity();
        productTaxJunctionEntity.setProductId(101L);
        productTaxJunctionEntity.setTaxId(101L);
        return Arrays.asList(productTaxJunctionEntity);

    }
}
