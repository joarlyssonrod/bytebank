fun main() {
    println("Bem vindo ao Bytebank")
    val contaAlex = Conta()
    contaAlex.titular = "Alex"
    contaAlex.numero = 1000
    contaAlex.setSaldo(200.0)

    val contaFran = Conta()
    contaFran.titular = "Fran"
    contaFran.numero = 1001
    contaFran.setSaldo(300.0)

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.getSaldo())

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.getSaldo())

    println("depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.getSaldo())

    println("depositando na conta da Fran")
    contaFran.deposita(70.0)
    println(contaFran.getSaldo())

    println("---------------------------------------------")

    println("Sacando o valor na conta de Alex")
    contaAlex.saca(250.0)
    println(contaAlex.getSaldo())

    println("Sacando o valor na conta da Fran")
    contaFran.saca(380.0)
    println(contaFran.getSaldo())

    println("---------------------------------------------")
    println("Transferindo valor da conta de Fran para Alex")
    if (contaFran.transfere(400.0, contaAlex)) {
        println("Transferencia realizada com sucesso.")
        println("O novo saldo de Alex - ${contaAlex.getSaldo()}")
        println("O novo saldo da Fran - ${contaFran.getSaldo()}")
    } else {
        println("Falha na transferencia! Nao houve alteracao nos saldos.")
        println("O saldo de Alex - ${contaAlex.getSaldo()}")
        println("O saldo da Fran - ${contaFran.getSaldo()}")
    }
}


class Conta {
    var titular = ""
    var numero = 0
    private var saldo = 0.0

    fun deposita(valor: Double) {
        this.saldo += valor
    }

    fun saca(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        } else {
            println("Nao foi possivel sacar o valor solicitado! Saldo disponivel é R$ ${this.saldo}")
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        return if (this.saldo >= valor) {
            this.saldo -= valor
            destino.saldo += valor
            true
        } else {
            false
        }
    }

    fun getSaldo(): Double {
        return saldo
    }

    fun setSaldo(valor: Double) {
        if (valor > 0) {
            saldo = valor
        }
    }
}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta()
    contaJoao.titular = "João"
    var contaMaria = Conta()
    contaMaria.titular = "Maria"
    contaJoao.titular = "João"

    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")

    println(contaJoao)
    println(contaMaria)
}

fun testaLacos() {
    var i = 0
    while (i < 5) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
        i++
    }

    for (i in 5 downTo 1) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }

    when {
        saldo > 0.0 -> println("conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println("conta é negativa")
    }
}