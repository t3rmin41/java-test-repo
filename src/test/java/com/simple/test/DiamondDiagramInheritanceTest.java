package com.simple.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DiamondDiagramInheritanceTest {

/*  Inheritance "diamond" diagram

      DoughFactory
    /            \
  Pizza           OrganicDoughFactory
    \            /
     OrganicPizza

*/

    public interface DoughFactory {
        default String getDough() {
            return  "insecticide treated wheat dough";
        }
    }

    public interface OrganicDoughFactory extends DoughFactory {
//    public interface OrganicDoughFactory { // creates compile-time error: class OrganicPizza inherits unrelated defaults for getDough from types Pizza and OrganicDoughFactory
        default String getDough() {
            return "pure untreated wheat dough";
        }
    }

    public interface Pizza extends DoughFactory {
        default void orderPizza(List<String> toppings) {
            System.out.println("Getting dough");
            String dough = getDough();
            System.out.println("Making pie with " + dough);
            for (String topping: toppings) {
                System.out.println("Adding: " + topping);
            }
        }
    }

    public interface OrganicPizza extends Pizza, OrganicDoughFactory {
    }

    public class OrganicPizzaOrder implements OrganicPizza {
    }

    public class PizzaOrder implements Pizza {
    }

    @Test
    public void testDiamondDiagramInheritance() {
        new PizzaOrder().orderPizza(Arrays.asList("Pepperoni", "Bell Pepper"));
        System.out.println();
        new OrganicPizzaOrder().orderPizza(Arrays.asList("Sausage", "Mushroom"));
        // prints "Making pie with pure untreated wheat dough" though inherits from 'Pizza' which inherits from 'DoughFactory'
        // which should print "insecticide treated wheat dough" because of "getDough()" call in Pizza. Why is that?
        // It's because inherited call to overridden method "get_dough" is determined by OrganicPizza inherited types (not by Pizza's parent as intuitively many would think), and if
        // the direct parent (in this case - OrganicPizza direct parent OrganicDoughFactory) has the method of the same contract
        // [signature = method name and types parameters, contract = access modifier + return type + signature]
        // then get_dough() will be called from direct parent
    }

}
