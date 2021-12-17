package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenThreePiecesOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("4sfe", "DressWhite"));
        orders.add(new Order("5zfe", "DressBlack"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
        assertThat(map.get("4sfe"), is(new Order("4sfe", "DressWhite")));
        assertThat(map.get("5zfe"), is(new Order("5zfe", "DressBlack")));
    }

    @Test
    public void whenThreePiecesOrderWithDuplicate() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("4sfe", "DressWhite"));
        orders.add(new Order("5zfe", "DressBlack"));
        orders.add(new Order("3sfe", "DressMini"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "DressMini")));
        assertThat(map.get("4sfe"), is(new Order("4sfe", "DressWhite")));
        assertThat(map.get("5zfe"), is(new Order("5zfe", "DressBlack")));
    }
}