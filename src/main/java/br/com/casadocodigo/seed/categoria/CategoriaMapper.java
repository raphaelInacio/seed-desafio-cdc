package br.com.casadocodigo.seed.categoria;

public class CategoriaMapper {
    public static Categoria mapperToModel(CategoriaRequest request) {
        return new Categoria(request.getNome());
    }
}
