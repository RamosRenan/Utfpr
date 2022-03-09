package com.example.crud.crudcidades.visao;

public final class Cidade {

    private long id;
    private final String name;
    private final String state;

    // valores provisorios para os campos do form
    private final String nameEx;
    private final String stateEx;

    public Cidade(String name, String state, String nameEx, String stateEx)
    {
        this.name = name;
        this.state = state;

        this.nameEx = "nome ex";
        this.stateEx = "estado ex";
    }

    public String getName()
    {
        return this.name;
    }

    public String getState()
    {
        return this.state;
    }

    public String getNameEx()
    {
        return this.nameEx;
    }

    public String getStateEx()
    {
        return this.stateEx;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getId()
    {
        return id;
    }

}
