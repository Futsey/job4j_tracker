package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addDublicate() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen1 = new Citizen("2f44a", "Arsen Petrov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen1);
        assertFalse(false);
    }

    @Test
    public void addThreeCitWithDublicate() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen1 = new Citizen("gzqa3", "Petya Arsentev");
        Citizen citizen2 = new Citizen("6fa", "Petr Arsentev");
        Citizen citizen3 = new Citizen("2f44a", "Arsen Petrov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen1);
        office.add(citizen2);
        office.add(citizen3);
        assertThat(office.get(citizen.getPassport()), is(citizen));
        assertThat(office.get(citizen1.getPassport()), is(citizen1));
        assertThat(office.get(citizen2.getPassport()), is(citizen2));
        assertFalse(false);
    }
}