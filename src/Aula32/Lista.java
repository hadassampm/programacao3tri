package Aula32;

public class Lista<T>{
    private T [] elementos;
    private int tamanho;

    public Lista(int capacidade){
        elementos = (T[])new Object[capacidade];
        tamanho = 0;
    }
    public void Adiciona (T elemento){
        aumentaCapacidade();
            elementos[tamanho++] = elemento;
    }
    public T Remove (int posicao){
        if(posicao<0 || posicao>=tamanho)
            throw new IllegalArgumentException("Posição "+posicao+" é inválida");
        T elemento = elementos[posicao];
        for (int i=posicao; i<tamanho -1; i++){
            elementos[i] = elementos[i+1];
        }
        tamanho--;
        return elemento;
    }
    public String toString (){
        String retorno = "[";
        if(tamanho>0){
            for (int i=0;i<tamanho-1;i++){
                retorno += elementos[i]+", ";
            }
            retorno+=elementos[tamanho-1];
        }
        return retorno+"]";
    }
    public T obter(int posicao){
        if(posicao<0 || posicao>=tamanho)
            throw new IllegalArgumentException("Posição "+posicao+" é inválida");
        return elementos[posicao];
    }
    public void Adiciona (int posicao, T elemento){
        if(posicao<0 || posicao>=tamanho)
            throw new IllegalArgumentException("Posição "+posicao+" é inválida");
        aumentaCapacidade();
        for (int i = tamanho -1; i>=posicao; i--)
            elementos[i+1] = elementos[i];
        elementos[posicao] = elemento;
        tamanho ++;
    }
    public int posicaoDe (String elemento){
        for (int i=0; i<tamanho;i++)
            if(elementos[i].equals(elemento))
                return i;
        return -1;
    }
    private void aumentaCapacidade (){
        if(tamanho== elementos.length) {
            T[] aux = (T[])new Object[tamanho + 2];
           //System.out.println(elementos,0,aux,0,elementos.length);
            for (int i = 0; i<tamanho; i++)
                aux[i]= elementos[i];
            elementos = aux;
        }
    }

    public boolean contem(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public void limpar() {
        elementos = (T[]) new Object[elementos.length];
        tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int ultimaPosicaoElemento(T elemento) {
        int ultimaPosicao = -1;
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                ultimaPosicao = i;
            }
        }
        return ultimaPosicao;
    }

    public int tamanho() {
        return tamanho;
    }
}
