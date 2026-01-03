import sys
input = sys.stdin.readline

def greedy_coin_change(n, coins):
    coins.sort(reverse=True)

    count = 0
    for coin in coins:
        if n == 0:
            break
        count += n // coin
        n %= coin
        
    return count

n, k = map(int, input().strip().split())
coins = [int(input().strip()) for _ in range(n)]
print(greedy_coin_change(k, coins))
