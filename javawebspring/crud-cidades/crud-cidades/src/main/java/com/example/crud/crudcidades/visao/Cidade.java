package com.example.crud.crudcidades.visao;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public final class Cidade {

    @NonNull()
    @Min(0)
    private Long id = 0L;

    @NotBlank(message = "{app.name.notempty}")
    @NotEmpty(message = "{app.name.notempty}")
    @NotNull(message = "{app.name.notempty}")
    @Size(min = 2, max = 50, message = "{app.name.notempty}")
    private final String name;

    @NotNull
    @NotEmpty
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

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

}
