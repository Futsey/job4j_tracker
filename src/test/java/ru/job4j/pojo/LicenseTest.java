package ru.job4j.pojo;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.hamcrest.core.IsNot;
import org.junit.Test;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first, is(second));
    }

    @Test
    public void nonEqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("Audio");
        assertNotEquals(first, second);
    }

    @Test
    public void eqNameVideo() {
        License first = new License();
        first.setCode("video");
        License second = new License();
        second.setCode("video");
        assertThat(first, is(second));
    }
}