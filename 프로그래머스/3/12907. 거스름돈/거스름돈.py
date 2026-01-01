def solution(n, money):
    dp = [0] * (n + 1)
    dp[0] = 1
    
    for coin in reversed(money):
        for amount in range(coin, n + 1):
            dp[amount] += dp[amount - coin]
            dp[amount] %= 1000000007

    return dp[n]