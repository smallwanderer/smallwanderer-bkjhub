import sys
input = sys.stdin.readline

def greedy_meeting_schedule(meetings):
    meetings.sort(key=lambda x: (x[1], x[0]))
    
    count = 0
    end_time = 0

    for start, end in meetings:
        if start >= end_time:
            count += 1
            end_time = end
    
    return count

n = int(input().strip())
meetings = [tuple(map(int, input().strip().split())) for _ in range(n)]

print(greedy_meeting_schedule(meetings))    