package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {

    private static final String ANOTHER_ANIMAL = "Cold-blooded creature";
    private static final String EXCEPTION = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private static final String FAMILY_NAMES = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";


    @Test
    public void getFamilyTest(){
        Animal animal = new Animal();
        String actualName = animal.getFamily();
        assertTrue(FAMILY_NAMES.equals(actualName));
    }

    @Test
    public void getFoodToUnknownAnimalExceptionTest() {
        Animal animal = new Animal();
        try {
            animal.getFood(ANOTHER_ANIMAL);
        } catch (Exception e) {
            String exception = e.getMessage();
            assertTrue(EXCEPTION.equals(exception));
        }
    }

    @Mock
    Animal animal;

    @Test
    public void getFoodToUnknownAnimalExceptionTest2() throws Exception {
        animal.getFood("Травоядное");
        Mockito.verify(animal).getFood(Mockito.anyString());
    }
}