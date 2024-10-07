package com.java.ecommerce.dto.request.endereco;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEnderecoParams {
    @NotNull(message = "O cep do endereço é obrigatório")
    private String cep;

    @NotNull(message = "A rua do endereço é obrigatória")
    private String rua;

    @NotNull(message = "O número do endereço é obrigatório")
    private Integer numero;

    @NotNull(message = "O bairro do endereço é obrigatório")
    private String bairro;

    @NotNull(message = "O complemento do endereço é obrigatório")
    private String complemento;

    @NotNull(message = "A cidade do endereço é obrigatória")
    private String cidade;

    @NotNull(message = "O estado do endereço é obrigatório")
    private String estado;
}
