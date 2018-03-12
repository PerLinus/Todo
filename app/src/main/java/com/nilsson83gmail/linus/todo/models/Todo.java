package com.nilsson83gmail.linus.todo.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s060qm on 3/7/2018.
 */

public class Todo {

    private String name;
    private List<String> todoList;
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();


    public Todo(String name, List<String> todoList) {
        this.name = name;
        this.todoList = todoList;
        list1.add("Måla");
        list1.add("Slipa");
        list1.add("Spika");
        list1.add("Skruva");
        list1.add("Bygga");

        list2.add("Plugga");
        list2.add("Städa");
        list2.add("Spela");
        list2.add("Betala räkningar");
        list2.add("Diska");
        list2.add("Programmera");
        list2.add("Kolla mejl");
        list2.add("Ringa mamma");
        list2.add("Ringa pappa");
        list2.add("Läsa bok");
        list2.add("Ta en promenad");
        list2.add("Sova lite");
        list2.add("Tvätta");
        list2.add("Dricka vatten");
        list2.add("Kolla avtal");
        list2.add("Baka");
        list2.add("Laga mat");
        list2.add("Handla");
        list2.add("Uppdatera datorn");
        list2.add("skaffa jobb");

    }



    public static final Todo[] toDos = {
            new Todo("Ska göra", new ArrayList<String>())
    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<String> todoList) {
        this.todoList = todoList;
    }
}
