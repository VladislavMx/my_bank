abstract class BankAccount(
    val accountNumber: String,
    val ownerName: String,
    var balance: Double = 0.0,
    var transactions: MutableList<Transaction> = mutableListOf()
) {

    abstract fun executeTransaction(transaction: Transaction)

    fun printAccountInfo()
    {
        println("Номер карты: $accountNumber")
        println("Пользователь: $ownerName")
        println("Баланс: $balance")

        transactions.forEach { it.printTransactionInfo() } }

}
class SavingsAccount(accountNumber: String, ownerName: String) :
    BankAccount(accountNumber, ownerName)
{

    override fun executeTransaction(transaction: Transaction)
    {
        if (transaction is Withdrawal && balance - transaction.amount < 0)
        {

            println("Отмена, недостаточно средств")
        }
        else
        {
            transaction.execute(this)
            transactions.add(transaction)
        }
    }
}

class CheckingAccount(accountNumber: String, ownerName: String) :
    BankAccount(accountNumber, ownerName)
{

    override fun executeTransaction(transaction: Transaction)
    {
        transaction.execute(this)
        transactions.add(transaction)
    }
}