package com.engeto.orders;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

      public static void main(String[] args) {
	// write your code here

        Food food1 = new Food("Gulaš",98.00, 1);
        Food food2 = new Food("Svíčková", 120.00,1);
        Food food3 = new Food("Rajská",110.00,1);
        Food food4 = new Food("Rizotto", 80,1);
        Food food5 = new Food("Špagety",95.00,1);
        ArrayList<Order> orderList= new ArrayList<Order>();

        Order order1 = new Order(1,1,LocalDate.of(2021,02,12),false);
        order1.addFood(food1);
        order1.addFood(food2);
        order1.addFood(food4);
        order1.addFood(food5);

        Order order2 = new Order(2,2,LocalDate.of(2021,02,12),true);
        order2.addFood(food3);
        order2.addFood(food4);
        order2.addFood(food5);

        Order order3 = new Order(3,3,LocalDate.of(2021,02,12),true);
        order3.addFood(food1);
        order3.addFood(food2);
        order3.addFood(food3);
        order3.addFood(food4);
        order3.addFood(food5);

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        System.out.println("Počet objednávek je " + order1.numberOfOrders(orderList));
        System.out.println("Celková útrata je: " + order1.totalPrice(orderList));
        int[] sold = new int[5];
        sold= order1.itemsSold(orderList);
        System.out.println("Guláš: " +sold[0]);
        System.out.println("Svíčková: " +sold[1]);
        System.out.println("Rajská: " +sold[2]);
        System.out.println("Rizotto: " +sold[3]);
        System.out.println("Spagety: " +sold[4]);

        double[]soldAtTable = new double[5];
        soldAtTable = order1.totalPriceAtTable(orderList);
        System.out.println("Útrata u stolu 1: " + soldAtTable[0]);
        System.out.println("Útrata u stolu 2: " + soldAtTable[1]);
        System.out.println("Útrata u stolu 3: " + soldAtTable[2]);















      }
}
