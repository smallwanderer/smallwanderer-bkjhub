def solution(routes):
    answer = 0
    routes.sort(key= lambda x: (x[1]))
    print(routes)
    
    endpoint = -30001
    for e, x in routes:
        if e > endpoint:
            answer += 1;
            endpoint = x;
        
    return answer