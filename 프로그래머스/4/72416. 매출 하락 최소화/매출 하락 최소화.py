def solution(sales, links):
    n = len(sales)
    tree = [[] for _ in range(n + 1)]
    has_parent = [False] * (n + 1)

    for a, b in links:
        tree[a].append(b)
        has_parent[b] = True

    root = 1
    for i in range(1, n + 1):
        if not has_parent[i]:
            root = i
            break

    INF = 10**18
    dp = [[0, 0] for _ in range(n + 1)]

    def dfs(node):
        if not tree[node]:
            dp[node][0] = 0
            dp[node][1] = sales[node - 1]
            return

        child_sum = 0
        extra = INF

        for child in tree[node]:
            dfs(child)
            m = min(dp[child][0], dp[child][1])
            child_sum += m
            extra = min(extra, dp[child][1] - m)

        dp[node][1] = sales[node - 1] + child_sum
        dp[node][0] = child_sum + extra

    dfs(root)
    return min(dp[root][0], dp[root][1])