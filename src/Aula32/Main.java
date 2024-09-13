package Aula32;

public class Main {
    public static void main (String[]args){
        Lista<String> l1 = new Lista(10);
        l1.Adiciona("A");
        l1.Adiciona("C");
        l1.Adiciona("D");
        l1.Adiciona("E");
        System.out.println(l1);
        l1.Adiciona(1,"B");
        System.out.println(l1);

        System.out.println("Elemento da posição 2 "+l1.obter(2));

        try{
            System.out.println("Elemento na posição -1"+l1.obter(-1));
        } catch(IllegalArgumentException e){
            System.out.println(e.toString());
        }
        System.out.println("Posição do elemento 'C' é "+l1.posicaoDe("C"));
        System.out.println("Posição do elemento 'c' é "+l1.posicaoDe("c"));
        l1.Adiciona("F");
        l1.Adiciona("G");
        l1.Adiciona("H");
        l1.Adiciona("I");
        l1.Adiciona("J");
        System.out.println(l1);
        System.out.println("Removendo o elemento 4 da lista "+l1.Remove(4));
        System.out.println(l1);
    }
}
