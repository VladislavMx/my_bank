fun main() {
    val savingsAccount = SavingsAccount("123456789", "George Martin")
    val checkingAccount = CheckingAccount("4277 2595 1571 8132", "вфвыафы фвафыв")

    val depositTransaction = Deposit(500.0)
    val withdrawTransaction = Withdrawal(200.0)
    val transferTransaction = Transfer(100.0, savingsAccount)

    checkingAccount.executeTransaction(depositTransaction)
    checkingAccount.executeTransaction(withdrawTransaction)
    checkingAccount.executeTransaction(transferTransaction)

    savingsAccount.printAccountInfo()
    checkingAccount.printAccountInfo()
}