class Deposit(override val amount: Double) : Transaction
{
    override fun execute(account: BankAccount)
    {

        account.balance += amount
    }

    override fun printTransactionInfo() {
        println("Транзакция: +$amount")
    }
}

class Withdrawal(override val amount: Double) : Transaction {
    override fun execute(account: BankAccount)
    {
        if (account.balance >= amount)
        {
            account.balance -= amount

        }
        else {
            println("error")
        }
    }

    override fun printTransactionInfo() {
        println("Выведено средств: $amount")
    }
}

class Transfer(override val amount: Double, val targetAccount: BankAccount) : Transaction
{
    override fun execute(account: BankAccount)
    {
        if (account.balance >= amount)
        {
            account.balance -= amount
            targetAccount.balance += amount
        }
        else {
            println("error")
        }
    }

    override fun printTransactionInfo()
    {
        println("Перевод на сумму: $amount на ${targetAccount.accountNumber}")
    }
}