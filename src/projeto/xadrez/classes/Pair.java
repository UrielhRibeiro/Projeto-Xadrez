package projeto.xadrez.classes;

public class Pair <T1,T2>{
    public T1 v1;
    public T2 v2;

    // === Construtor ===
    public Pair(T1 v1, T2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    // === Métodos públicos ===
    // === Método para verificar se os dois objetos são iguais ===
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        if (!v1.equals(pair.v1)) // Se dois objetos Pair possuem os mesmos valores v1 e v2, então eles são considerados iguais.
            return false;
        return v2.equals(pair.v2);
    }
}

