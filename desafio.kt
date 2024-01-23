enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(
    val nome: String,
    val duracao: Int = 60,
    val descricao: String,
)

class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: MutableList<ConteudoEducacional> = mutableListOf()
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo '${conteudo.nome}' adicionado à formação $nome.")
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
        println("Conteúdo '${conteudo.nome}' removido da formação $nome.")
    }

    fun exibirDetalhes() {
        println("Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos:")
        for (conteudo in conteudos) {
            println(" - ${conteudo.nome} (${conteudo.duracao} minutos) - ${conteudo.descricao} ")
        }
        println("Inscritos:")
        for (inscrito in inscritos) {
            println(" - ${inscrito.nome} ")
        }
    }
}

fun main() {
    // Criando  usuários e conteúdos educacionais como base
    val usuario1 = Usuario("Felipe")
    val usuario2 = Usuario("Sadrak")

    val conteudo1 = ConteudoEducacional("Introdução ao Python", 90, "Conceitos básicos de Python")
    val conteudo2 = ConteudoEducacional("Python Avançado", 200, "Tópicos avançados de Python")

    // Criando uma formação e adicionando conteúdos
    val formacaoKotlin = Formacao("Formação Python", Nivel.INTERMEDIARIO)
    formacaoKotlin.adicionarConteudo(conteudo1)
    formacaoKotlin.adicionarConteudo(conteudo2)

    // Matriculando usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    // Exibindo detalhes da formação
    formacaoKotlin.exibirDetalhes()
}