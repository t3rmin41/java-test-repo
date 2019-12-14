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
    }

}
