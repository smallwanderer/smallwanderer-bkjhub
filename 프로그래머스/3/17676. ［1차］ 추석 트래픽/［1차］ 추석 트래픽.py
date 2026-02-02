def solution(lines):
    if not lines:
        return 0

    logs = []
    for l in lines:
        _, end, sec = l.split(" ")
        end = time_to_sec(end)
        start = end - sec_to_ms(sec) + 1
        logs.append((start, end))

    points = []
    for s, e in logs:
        points.append(s)
        points.append(e)

    answer = 0
    for t in points:
        w_end = t + 999
        cnt = 0
        for s, e in logs:
            if s <= w_end and e >= t:
                cnt += 1
        answer = max(answer, cnt)

    return answer

def time_to_sec(time):
    hour, min, sec = time.split(":")
    sec, ms = sec.split(".")
    ms = (ms + "000")[:3]
    return (int(hour) * 3600 + int(min) * 60 + int(sec)) * 1000 + int(ms)

def sec_to_ms(sec):
    sec = sec[:-1]
    if "." in sec:
        sec, ms = sec.split(".")
        ms = (ms + "000")[:3]
        return int(sec) * 1000 + int(ms)
    return int(sec) * 1000