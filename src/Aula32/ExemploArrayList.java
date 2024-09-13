package Aula32;

import java.util.ArrayList;
import java.util.List;

public class ExemploArrayList {
    public static void main (String[]args){
        ArrayList<String> Lista = new ArrayList<>();

        Lista.add("A");
        Lista.add("C");
        Lista.add("D");
        Lista.add("E");
        Lista.add("C");
        Lista.add("F");
        Lista.add(1,"B");
        System.out.println("A lista tem um 'A'"+Lista.contains("A"));
        System.out.println("A lista tem um 'B' "+Lista.contains("B"));
        System.out.println(Lista);
        System.out.println("O tamanho da lista é "+Lista.size());
        System.out.println("A posição de 'C' na lista é "+Lista.indexOf("C"));
        System.out.println("A posição de 'c' na lista é "+Lista.lastIndexOf("C"));
        System.out.println("O elemento da posição 4 é "+Lista.get(4));
        Lista.clear();
        System.out.println("A lista está vazia: "+Lista.isEmpty());
        System.out.println(Lista);
    }
}
