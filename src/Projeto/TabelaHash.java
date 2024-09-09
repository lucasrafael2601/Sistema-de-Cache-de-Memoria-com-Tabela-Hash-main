package Projeto;

import java.util.LinkedList;

class Par<K, V> {
    K chave;
    V valor;

    public Par(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }
}

public class TabelaHash<K, V> {
    private int tamanho;
    private LinkedList<Par<K, V>>[] tabela;

    @SuppressWarnings("unchecked")
    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int calcularIndice(K chave) {
        return Math.abs(chave.hashCode() % tamanho);
    }

    public void inserir(K chave, V valor) {
        int indice = calcularIndice(chave);
        for (Par<K, V> par : tabela[indice]) {
            if (par.chave.equals(chave)) {
                par.valor = valor;
                return;
            }
        }
        tabela[indice].add(new Par<>(chave, valor));
    }

    public V buscar(K chave) {
        int indice = calcularIndice(chave);
        for (Par<K, V> par : tabela[indice]) {
            if (par.chave.equals(chave)) {
                return par.valor;
            }
        }
        return null;
    }

    public void remover(K chave) {
        int indice = calcularIndice(chave);
        tabela[indice].removeIf(par -> par.chave.equals(chave));
    }

    public void imprimirTabela() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Índice " + i + ": ");
            for (Par<K, V> par : tabela[i]) {
                System.out.print("[" + par.chave + ": " + par.valor + "] ");
            }
            System.out.println();
        }
    }
}
