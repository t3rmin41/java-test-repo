package com.simple.test;

import com.simple.Car;
import com.simple.cars.Dodge;
import org.junit.jupiter.api.Test;

public class InstanceTest {

    private interface Animal {
        Double getAge();

        Animal setAge(Double age);
    }

    private class Dog implements Animal {
        private Double age = 0.0;

        @Override
        public Double getAge() {
            return this.age;
        }

        @Override
        public Animal setAge(Double age) {
            this.age = age;
            return this;
        }
    }

    @Test
    public void testAnimalIsInstance() {
        Animal dog = new Dog().setAge(2.5);

        if (dog instanceof Animal) {
            System.out.println("The age of the dog is " + dog.getAge() + " years");
        }

    }

    @Test
    public void testCarIsInstance() {
        Car dodge = new Dodge();

        if (dodge instanceof Car) {
            System.out.println("The car manufacturer is " + dodge.getManufacturer() +
                               " with maximum speed " + dodge.getMaxSpeed() + "/" + dodge.getSpeedUnits());
        }

    }

}
