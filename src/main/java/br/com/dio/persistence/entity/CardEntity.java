package br.com.dio.persistence.entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class CardEntity {

    private Long id;
    @NotBlank(message = "O título do card não pode ser vazio")
    @Size(max = 100, message = "O título do card deve ter no máximo 100 caracteres")
    private String title;


    @Size(max = 500, message = "A descrição do card deve ter no máximo 500 caracteres")
    private String description;
    private BoardColumnEntity boardColumn = new BoardColumnEntity();

}
