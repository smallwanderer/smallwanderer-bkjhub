def solution(n, t, m, timetable):
    new_time = []
    for time in timetable:
        new_time.append(time_to_min(time))
    new_time.sort()
    print(new_time)

    N = len(new_time)
    bus = time_to_min("09:00")
    answer = 0
    idx = 0
    # i번째 차
    for i in range(n):
        # i번째 차 m명 계산
        for j in range(m):
            if idx >= N:
                return min_to_time(bus)
            
            if new_time[idx] > bus:
                answer = bus
                break
            
            answer = new_time[idx]-1
            idx += 1
        # 다음 차 도착
        bus += t
    return min_to_time(answer)

def time_to_min(time):
    h, m = time.split(":")
    return int(h) * 60 + int(m)

def min_to_time(min):
    h = "00" + str(min // 60)
    m = "00" + str(min % 60)
    return f"{h[-2:]}:{m[-2:]}"