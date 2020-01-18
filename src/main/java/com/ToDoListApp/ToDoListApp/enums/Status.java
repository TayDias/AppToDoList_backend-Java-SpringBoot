package com.ToDoListApp.ToDoListApp.enums;

public enum Status {
    AFAZER(1, "A Fazer"),
    EMPROGRESSO(2, "Em Progresso"),
    FEITO(3, "Feito");

    private int codigo;
    private String descricao;

    Status(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getDescricao(){
        return descricao;
    }

    public static Status toEnum(Integer codigo){
        if (codigo == null){
            return null;
        }
        for (Status s: Status.values()){
            if (codigo.equals(s.getCodigo())){
                return s;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
