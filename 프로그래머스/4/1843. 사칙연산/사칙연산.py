def solution(arr):
    num_arr = [int(x) for x in arr if x.isdigit()]
    sign = {"+": 1, "-": -1}

    n = len(num_arr)
    INF = 10 ** 18

    dp_min = [[INF] * n for _ in range(n)]
    dp_max = [[-INF] * n for _ in range(n)]

    for i in range(n):
        dp_min[i][i] = dp_max[i][i] = num_arr[i]
    
    for length in range(2, n+1):
        for l in range(0, n-length+1):
            r = l + length - 1
            for k in range(l, r):
                if arr[k*2+1] == "+":
                    dp_max[l][r] = max(dp_max[l][r], dp_max[l][k] + dp_max[k+1][r])
                    dp_min[l][r] = min(dp_min[l][r], dp_min[l][k] + dp_min[k+1][r])
                else:
                    dp_max[l][r] = max(dp_max[l][r], dp_max[l][k] - dp_min[k+1][r])
                    dp_min[l][r] = min(dp_min[l][r], dp_min[l][k] - dp_max[k+1][r])
            
            # print(l, r)
            # for i in dp_max:
            #     for j in i:
            #         print(j if j != -INF else "INF", end="\t")
            #     print()

    return dp_max[0][n-1]