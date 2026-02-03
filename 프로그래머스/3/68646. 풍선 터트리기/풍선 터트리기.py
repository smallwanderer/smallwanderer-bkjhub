def solution(a):
    n = len(a)
    if n <= 2:
        return n

    answer = set()
    INF = float("INF")
    left_min, right_min = INF, INF
    for i in range(n):
        # left
        left = a[i]
        if left < left_min:
            answer.add(left)
            left_min = left
        
        # right
        right = a[n-i-1]
        if right < right_min:
            answer.add(right)
            right_min = right

    return len(answer)