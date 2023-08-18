package model;

import java.util.ArrayList;
import controller.ErrMsgLog;
import java.util.LinkedList;
import java.util.logging.Logger;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import model.Randomizer;
import model.Parent;

public class CollectionCreator {
	/**
	 * Метод класса для создания ArrayList из n*4 рандомных элементов
	 * @param n
	 * @return array
	 */
	
	public static ArrayList<Human> createArray(int n) {
		ArrayList array = new ArrayList();
		for (int i = 0; i < n; i++) {
			String s = Randomizer.getRandomSex();
			Student s1 = new Student(Randomizer.getRandomWord(), Randomizer.getRandomAge(), s, Randomizer.getRandomPatronymic(s),
					(float) Math.random() * 5);
			Parent p1 = new Parent(Randomizer.getRandomWord(), Randomizer.getRandomAge(), Randomizer.getRandomSex());
			Cool_parent c1 = new Cool_parent(Randomizer.getRandomWord(), Randomizer.getRandomAge(), Randomizer.getRandomSex(),(int) Math.random() * 10000);
			float m = (float) Math.random() * 5;
			s = Randomizer.getRandomSex();
			Botanic b1 = new Botanic(Randomizer.getRandomWord(), Randomizer.getRandomAge(), s, Randomizer.getRandomPatronymic(s), m, (int) Math.pow(10, (int) m));
			array.add(p1);
			array.add(s1);
			array.add(b1);
			array.add(c1);
		}
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
		return array;
	}
	
	/**
	 * Метод класса для создания Linkedlist из n*4 рандомных элементов
	 * @param n
	 * @return list
	 */
	
	public static LinkedList<Human> createLinkedList(int n) {
		LinkedList<Human> list= new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String s = Randomizer.getRandomSex();
			Student s1 = new Student(Randomizer.getRandomWord(), Randomizer.getRandomAge(), s, Randomizer.getRandomPatronymic(s),
					(float) Math.random() * 5);
			Parent p1 = new Parent(Randomizer.getRandomWord(), Randomizer.getRandomAge(), Randomizer.getRandomSex());
			Cool_parent c1 = new Cool_parent(Randomizer.getRandomWord(), Randomizer.getRandomAge(), Randomizer.getRandomSex(),
					(int) Math.random() * 10000);
			float m = (float) Math.random() * 5;
			s = Randomizer.getRandomSex();
			Botanic b1 = new Botanic(Randomizer.getRandomWord(), Randomizer.getRandomAge(), s, Randomizer.getRandomPatronymic(s), m,
					(int) Math.pow(10, (int) m));
			list.add(p1);
			list.add(s1);
			list.add(b1);
			list.add(c1);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}
	
	/**
     * Метод для создания списка
     * @param capacity начальный размер списка
     * @return список с заданным начальным размером с элементами типа Human
     */
    public static ArrayList<Human> createArrayList(int capacity){
        return new ArrayList<Human>(capacity);
    }
    /**
     * Метод для создания LinkedList
     * @return LinkedList с элементами типа Human
     */
    public static LinkedList<Human> createLinkedList(){
        return new LinkedList<Human>();
    }
    /**
     * Метод для заполнения ArrayList
     * @param array ArrayList с элементами типа Human
     * @param capacity кол-во объектов, которое будет добавлено в LinkedList
     * @return заполненный LinkedList
     */
    public static ArrayList<Human> fullArrayList(ArrayList<Human> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            list.add(i, createHuman());
        }
        return list;
    }
    /**
     * Метод для заполнения LinkedList
     * @param list LinkedList с элементами типа Human
     * @param capacity кол-во объектов, которое будет добавлено в LinkedList
     * @return заполненный LinkedList
     */
    public static LinkedList<Human> fullLinkedList(LinkedList<Human> list, int capacity)
    {
        for(int i = 0; i < capacity; i++)
        {
            list.add(i, createHuman());
        }
        return list;
    }

    /**
     * Метод для создания тестовых объектов для дальнейшего заполнения ими коллекций
     * @return объект типа Human с случайно сгенерированным возрастом
     */
	public static Human createHuman(){
        return new Parent("TestName", (int)(Math.random()*71), "Male");
    }
	/**
     * Метод для замера времени добавления и удаления элементов в ArrayList
     * Автотест для ЛР3
     * @param cap 
     */
	public static void RunTimeList(int cap)
    {
        try {
            ArrayList<Human> listTest = model.CollectionCreator.createArrayList(cap);
            LocalTime startTime = LocalTime.now();
            switch (cap) {
                case (10) -> {
                    ErrMsgLog.errhnd = new FileHandler("src/controller/err_log10.txt", true);
                    ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
                    ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
                }
                case (100) -> {
                    ErrMsgLog.errhnd = new FileHandler("src/controller/err_log100.txt", true);
                    ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
                    ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
                }
                case (1000) -> {
                    ErrMsgLog.errhnd = new FileHandler("src/controller/err_log1000.txt", true);
                    ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
                    ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
                }
                case (10000) -> {
                    ErrMsgLog.errhnd = new FileHandler("src/controller/err_log10000.txt", true);
                    ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
                    ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
                }
                case (100000) -> {
                    ErrMsgLog.errhnd = new FileHandler("src/controller/err_log100000.txt", true);
                    ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
                    ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
                }
            }
            int addCount = 0;
            int deleteCount = 0;
            long addCountTime = 0;
            long deleteCountTime = 0;
            int totalCount = 0;
            long totalTime = 0;
            try {
                for (int i = 0; i < cap; i++) {
                    long start = System.nanoTime();
                    listTest.add(model.CollectionCreator.createHuman());
                    long finish = System.nanoTime();
                    long res = finish - start;
                    addCountTime += res;
                    addCount++;
                    totalCount++;
                    totalTime += res;
                    ErrMsgLog.log_test.info("\nadd, ID = " + i + ", " + res);
                }
                System.out.println("\n");
                for (int i = 0; i < cap / 10; i++) {
                    long start = System.nanoTime();
                    int randomIndex = (int) (Math.random() * (cap - 1 - i));
                    listTest.remove(randomIndex);
                    long finish = System.nanoTime();
                    long res = finish - start;
                    deleteCountTime += res;
                    deleteCount++;
                    totalCount++;
                    totalTime += res;
                    ErrMsgLog.log_test.info("\nremove, ID = " + randomIndex + ", " + res);
                    //System.out.println(1/0);
                }
            } catch (Exception error) {
                ErrMsgLog.addErrWithLog(error);
            }
            LocalTime endTime = LocalTime.now();
            ErrMsgLog.log_test.info("\n\nStart program: " + startTime.format(DateTimeFormatter.ofPattern("H:mm:ss")) + "\nTotal Time = " + totalTime +
                    "\nTotal Count = " + totalCount +
                    "\nTotal MedianTime = " + totalTime / totalCount +
                    "\nAddTotal Time = " + addCountTime +
                    "\nAddTotal Count = " + addCount +
                    "\nAddTotal MedianTime = " + addCountTime / addCount +
                    "\nRemoveTotal Time = " + deleteCountTime +
                    "\nRemoveTotal Count = " + deleteCount +
                    "\nRemoveTotal MedianTime = " + deleteCountTime / deleteCount + "\nFinish program: " + endTime.format(DateTimeFormatter.ofPattern("H:mm:ss")) + "\n");
        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            ErrMsgLog.log_test.removeHandler(ErrMsgLog.errhnd);
        }
    }
	
	 /**
     * Метод для замера времени добавления и удаления элементов в LinkedList
     * @param cap 
     */
    public static void RunTimeLinked(int cap)
    {
        try {
            LinkedList<Human> linkedTest = model.CollectionCreator.createLinkedList();
            LocalTime startTime = LocalTime.now();
            switch (cap) {
                case (10) -> {
                    ErrMsgLog.errhnd = new FileHandler("src/controller/err_linkedLog10.txt", true);
                    ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
                    ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
                }
                case (100) -> {
                    ErrMsgLog.errhnd = new FileHandler("src/controller/err_linkedLog100.txt", true);
                    ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
                    ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
                }
                case (1000) -> {
                    ErrMsgLog.errhnd = new FileHandler("src/controller/err_linkedLog1000.txt", true);
                    ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
                    ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
                }
                case (10000) -> {
                    ErrMsgLog.errhnd = new FileHandler("src/controller/err_linkedLog10000.txt", true);
                    ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
                    ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
                }
                case (100000) -> {
                    ErrMsgLog.errhnd = new FileHandler("src/controller/err_linkedLog100000.txt", true);
                    ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
                    ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
                }
            }
            int addCount = 0;
            int deleteCount = 0;
            long addCountTime = 0;
            long deleteCountTime = 0;
            int totalCount = 0;
            long totalTime = 0;
            try {
                for (int i = 0; i < cap; i++) {
                    long start = System.nanoTime();
                    linkedTest.add(model.CollectionCreator.createHuman());
                    long finish = System.nanoTime();
                    long res = finish - start;
                    addCountTime += res;
                    addCount++;
                    totalCount++;
                    totalTime += res;
                    ErrMsgLog.log_test.info("\nadd, ID = " + i + ", " + res);
                }
                for (int i = 0; i < cap / 10; i++) {
                    long start = System.nanoTime();
                    int randomIndex = (int) (Math.random() * (cap - 1 - i));
                    linkedTest.remove(randomIndex);
                    long finish = System.nanoTime();
                    long res = finish - start;
                    deleteCountTime += res;
                    deleteCount++;
                    totalCount++;
                    totalTime += res;
                    ErrMsgLog.log_test.info("\nremove, ID = " + randomIndex + ", " + res);
                }
                //throw new IOException();
            } catch(Exception error){
                ErrMsgLog.addErrWithLog(error);
            }
            LocalTime endTime = LocalTime.now();
            ErrMsgLog.log_test.info("\nStart program: " + startTime.format(DateTimeFormatter.ofPattern("H:mm:ss")) + "\n\nTotal Time = " + totalTime +
                    "\nTotal Count = " + totalCount +
                    "\nTotal MedianTime = " + totalTime / totalCount +
                    "\nAddTotal Time = " + addCountTime +
                    "\nAddTotal Count = " + addCount +
                    "\nAddTotal MedianTime = " + addCountTime / addCount +
                    "\nRemoveTotal Time = " + deleteCountTime +
                    "\nRemoveTotal Count = " + deleteCount +
                    "\nRemoveTotal MedianTime = " + deleteCountTime / deleteCount + "\nFinish program: " + endTime.format(DateTimeFormatter.ofPattern("H:mm:ss")));
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            ErrMsgLog.log_test.removeHandler(ErrMsgLog.errhnd);
        }
    }
	
}
