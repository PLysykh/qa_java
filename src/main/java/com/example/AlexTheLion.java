package com.example;

import java.util.List;

public class AlexTheLion extends Lion{

    private String habitat = "Нью-Йоркский зоопарк";
    private List<String> acquaintance = List.of("Марти", "Глория", "Мелман");

    public AlexTheLion(Feline feline) throws Exception {
        super("Самец", feline);
    }

    public List<String> getFriends(){
        return acquaintance;
    }

    public String getPlaceOfLiving(){
        return habitat;
    }

    @Override
    public int getKittens(){
        return 0;
    }
}