package br.com.casadocodigo.seed.autor;

public final class AutorMapper {
    public static Autor mapperToModel(AutorRequest request) {
        var autor = new Autor();
        autor.setNome(request.getNome());
        autor.setEmail(request.getEmail());
        autor.setDescricao(request.getDescricao());
        return autor;
    }
}
