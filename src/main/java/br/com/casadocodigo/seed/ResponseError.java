package br.com.casadocodigo.seed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {
    private String tipoErro;
    Map<String, String> detalhes;
}
