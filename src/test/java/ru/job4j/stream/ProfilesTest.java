package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenTestMethodCollect() {
        Address first = new Address("City1", "Street1", 1, 1);
        Address second = new Address("City2", "Street2", 2, 2);
        Address third = new Address("City3", "Street3", 3, 3);
        List<Profile> profiles = Arrays.asList(
                new Profile(first),
                new Profile(second),
                new Profile(third)
        );
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = Arrays.asList(first, second, third);
        assertEquals(expected, result);
    }

    @Test
    public void whenTestMethodCollectAgain() {
        Address first = new Address("Moscow", "Lenina", 1, 1);
        Address second = new Address("Tarko-City", "Lenina", 12, 23);
        Address third = new Address("New Urengoy", "Popova", 33, 8);
        Address fourth = new Address("New Urengoy", "Lenina", 19, 66);
        Address fifth = new Address("Noyabrsk", "Octyabrskaya", 12, 21);
        Address sixth = new Address("Uzhgorod", "Truda", 17, 26);
        Address seventh = new Address("Omsk", "50 let USSR", 2, 12);
        List<Profile> profiles = Arrays.asList(
                new Profile(first),
                new Profile(second),
                new Profile(third),
                new Profile(fourth),
                new Profile(fifth),
                new Profile(sixth),
                new Profile(seventh)
        );
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = Arrays.asList(first, second, third, fourth, fifth, sixth, seventh);
        assertEquals(expected, result);
    }

    @Test
    public void whenTestMethodCollectSortWithoutDuplicate() {
        Address first = new Address("City1", "Street1", 1, 1);
        Address second = new Address("City2", "Street2", 2, 2);
        Address third = new Address("City3", "Street3", 3, 3);
        Address fourth = new Address("City1", "Street1", 1, 1);
        Address fifth = new Address("City2", "Street2", 2, 2);
        Address seventh = new Address("City3", "Street3", 3, 3);
        List<Profile> profiles = Arrays.asList(
                new Profile(second),
                new Profile(fourth),
                new Profile(fifth),
                new Profile(first),
                new Profile(seventh),
                new Profile(third)
        );
        List<Address> result = Profiles.collectSortWithoutDuplicate(profiles);
        List<Address> expected = Arrays.asList(first, second, third);
        assertEquals(expected, result);
    }
}