package br.com.casadocodigo.seed.autor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {
    private String tipo;
    Map<String, String> detalhes;
}
