package com.engeto.orders;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private int numberOfTable;
    private LocalDate dateOrder;
    private boolean isPaidByCard;
    private Food food;
    private ArrayList<Order> listOfOrder;
    private Order order;
    private int soldItem[] = new int[5];

    private ArrayList<Food> listOfFood;

    public Order(int orderNumber, int numberOfTable, LocalDate dateOrder, boolean isPaidByCard) {
        this.orderNumber = orderNumber;
        this.numberOfTable = numberOfTable;
        this.dateOrder = dateOrder;
        this.isPaidByCard = isPaidByCard;
        //this.food = food;
        listOfFood = new ArrayList<Food>();
        listOfOrder = new ArrayList<Order>();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getNumberOfTable() {
        return numberOfTable;
    }

    public void setNumberOfTable(int numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public boolean isPaidByCard() {
        return isPaidByCard;
    }

    public void setPaidByCard(boolean paidByCard) {
        isPaidByCard = paidByCard;
    }

    public void addFood(Food newFood) {
        listOfFood.add(newFood);
    }

    public double getFoodPrice(Food food) {
        return food.getPrice();
    }

    public double getTotalPriceOfFood(double price) {
        return getFoodPrice(food);
    }

    public int numberOfOrders(ArrayList<Order> listOfOrder) {
        int numOrders = 0;
        for (int i = 0; i < listOfOrder.size(); i++) {
            numOrders = numOrders + 1;
        }
        return numOrders;
    }

    public double totalPrice(ArrayList<Order> orders) {
        double priceFood = 0;
        double totalPrice = 0;
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i);

            for (int j = 0; j < listOfFood.size(); j++) {
                priceFood = priceFood + listOfFood.get(j).getPrice();
            }
            totalPrice = totalPrice + priceFood;
            priceFood = 0;
        }
        return totalPrice;
    }

    public int[] itemsSold(ArrayList<Order> orders) {
        double priceFood = 0;
        int countGulas = 0, countSvickova = 0, countSpagety = 0, countRajska = 0, countRizotto = 0;

        int[] items = new int[5];
        //int[] itemsTotal = new int[5];
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i);

            for (int j = 0; j < orders.get(i).listOfFood.size(); j++) {

                if (orders.get(i).listOfFood.get(j).getName() == "Gulaš") {
                    items[0] = countGulas = countGulas + 1;
                }
                if (orders.get(i).listOfFood.get(j).getName() == "Svíčková") {
                    items[1] = countSvickova = countSvickova + 1;
                }
                if (orders.get(i).listOfFood.get(j).getName() == "Rajská") {
                    items[2] = countRajska = countRajska + 1;
                }
                if (orders.get(i).listOfFood.get(j).getName() == "Rizotto") {
                    items[3] = countRizotto = countRizotto + 1;
                }
                if (orders.get(i).listOfFood.get(j).getName() == "Špagety") {
                    items[4] = countSpagety = countSpagety + 1;
                }
            }
        }
        return items;
    }
    public double[] totalPriceAtTable(ArrayList<Order> orders) {
        double[] priceAtTable = new double[3];

        for (int i = 0; i < orders.size(); i++) {
            orders.get(i);

            for (int j = 0; j < orders.get(i).listOfFood.size(); j++) {
                if (orders.get(i).numberOfTable == 1) {
                    priceAtTable[0] = priceAtTable[0] + orders.get(i).listOfFood.get(j).getPrice();
                }
                if (orders.get(i).numberOfTable == 2) {
                    priceAtTable[1] = priceAtTable[1] + orders.get(i).listOfFood.get(j).getPrice();
                }
                if (orders.get(i).numberOfTable == 3) {
                    priceAtTable[2] = priceAtTable[2] + orders.get(i).listOfFood.get(j).getPrice();
                }
            }

        }
        return priceAtTable;
    }


}