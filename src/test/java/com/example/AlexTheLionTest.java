package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AlexTheLionTest {

    private AlexTheLion alexTheLion;
    private Feline feline;
    private final List<String> trueFriends = List.of("Марти", "Глория", "Мелман");
    private final String currentPlaceOfLiving = "Нью-Йоркский зоопарк";
    private final int alexKittensNumber = 0;


    @Test
    public void getFriendsTest() throws Exception {
        alexTheLion = new AlexTheLion(feline);
        List<String> listOfFriends = alexTheLion.getFriends();
        assertEquals(trueFriends, listOfFriends);
    }

    @Test
    public void getPlaceOfLivingTest() throws Exception{
        alexTheLion = new AlexTheLion(feline);
        String hypotheticalPlaceOfLiving = alexTheLion.getPlaceOfLiving();
        assertTrue(hypotheticalPlaceOfLiving.equals(currentPlaceOfLiving));
    }

    @Test
    public void getKittensTest() throws Exception{
        alexTheLion = new AlexTheLion(feline);
        int totalKittens = alexTheLion.getKittens();
        assertEquals(alexKittensNumber, totalKittens);
    }
}