public record Conteudo(String title, String urlImagem, String urlImagem2, double avaliacao, String copyright) {

    public Conteudo(String title, String urlImagem, String copyright) {
        this(title, urlImagem, null, 0, copyright);
    }

    public Conteudo(String title, String urlImagem, double avaliacao) {
        this(title, urlImagem, null, avaliacao, null);
    }

    public Conteudo(String title, String urlImagem, String urlImagem2, double avaliacao) {
        this(title, urlImagem, urlImagem2, 0, null);
    }

}
