abstract class BankAccount(
    val accountNumber: String,
    val ownerName: String,
    var balance: Double = 0.0,
    var transactions: MutableList<Transaction> = mutableListOf()
) {

    abstract fun executeTransaction(transaction: Transaction)

    fun printAccountInfo()
    {
        println("Account number: $accountNumber")
        println("Owner: $ownerName")
        println("Current balance: $balance")
        transactions.forEach { it.printTransactionInfo() }
    }

}
class SavingsAccount(accountNumber: String, ownerName: String) :
    BankAccount(accountNumber, ownerName)
{

    override fun executeTransaction(transaction: Transaction)
    {
        if (transaction is Withdrawal && balance - transaction.amount < 0)
        {
            println("Withdrawal transaction cancelled. Insufficient funds on the account.")
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