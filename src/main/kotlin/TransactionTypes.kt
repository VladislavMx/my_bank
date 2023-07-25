class Deposit(override val amount: Double) : Transaction {
    override fun execute(account: BankAccount) {
        account.balance += amount
    }

    override fun printTransactionInfo() {
        println("Deposit transaction: +$amount")
    }
}

class Withdrawal(override val amount: Double) : Transaction {
    override fun execute(account: BankAccount) {
        if (account.balance >= amount) {
            account.balance -= amount
        } else {
            println("Insufficient funds on the account")
        }
    }

    override fun printTransactionInfo() {
        println("Withdrawal transaction: -$amount")
    }
}

class Transfer(override val amount: Double, val targetAccount: BankAccount) : Transaction {
    override fun execute(account: BankAccount) {
        if (account.balance >= amount) {
            account.balance -= amount
            targetAccount.balance += amount
        } else {
            println("Insufficient funds on the account")
        }
    }

    override fun printTransactionInfo() {
        println("Transfer transaction: -$amount to ${targetAccount.accountNumber}")
    }
}