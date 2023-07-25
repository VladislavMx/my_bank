interface Transaction {
    val amount: Double

    fun execute(account: BankAccount)

    fun printTransactionInfo()
}