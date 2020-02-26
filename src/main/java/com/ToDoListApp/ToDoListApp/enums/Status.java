package com.ToDoListApp.ToDoListApp.enums;

public enum Status {
    AFAZER(0, "A Fazer"),
    EMPROGRESSO(1, "Em Progresso"),
    FEITO(2, "Feito");

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

    public static String toEnum(Integer codigo){
        if (codigo == null){
            return null;
        }
        for (Status s: Status.values()){
            if (codigo.equals(s.getCodigo())){
                return s.getDescricao();
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
