def solution(matrix_sizes):
    N = len(matrix_sizes)
    INF = 10 ** 18
    dp = [[0] * N for _ in range(N)]

    for length in range(2, N+1):
        for i in range(0, N-length+1):
            j = i + length - 1
            best = INF

            for k in range(i, j):
                cost = (
                    dp[i][k] + dp[k+1][j]
                    + matrix_sizes[i][0] * matrix_sizes[k][1] * matrix_sizes[j][1]
                )
                if cost < best:
                    best = cost

            dp[i][j] = best
            
    return dp[0][N-1]