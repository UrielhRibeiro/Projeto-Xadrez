package projeto.xadrez.Enum;

public enum MenuOptions {
    Jogadores(1), Pecas(2), Fechar(3);

    private final int valor;

    MenuOptions(int valorOpcao){
        valor = valorOpcao;
    }

    public int getValor(){
        return valor;
    }
}
