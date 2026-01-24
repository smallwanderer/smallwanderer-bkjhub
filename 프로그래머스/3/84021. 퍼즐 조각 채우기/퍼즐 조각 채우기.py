"""
nxn 격자 위에 퍼즐 조각을 정규화하여 나타낼 수 있는 방법을 찾아야 함.
퍼즐 조각은 회전할 수 있음.

1. 퍼즐 ㅗ와 퍼즐 ㅓ가 같음을 나타낼 수 있는 방법
-> 한 시작 지점에서부터 다른 지점까지의 좌표를 묶은 list로 나타내기?
-> 시작 지점은 어떻게 정해야 하는가? 모든 좌표마다 한번씩 시작 지점으로 삼고 돌려봐야 됨?
"""

from collections import Counter
DIR4 = [(1,0), (-1,0), (0,1), (0,-1)]

def puzzle_detector(board, target):
    """board에서 값이 target인 연결 컴포넌트(좌표)를 반환"""
    H, W = len(board), len(board[0])
    visited = [[False]*W for _ in range(H)]
    comps = []

    for col in range(H):
        for row in range(W):
            if visited[col][row] or board[col][row] != target:
                continue

            stack = [(col, row)]
            visited[col][row] = True
            comp = []

            while stack:
                cy, cx = stack.pop()
                comp.append((cy, cx))

                for dy, dx in DIR4:
                    ny, nx = cy + dy, cx + dx
                    if 0 <= ny < H and 0 <= nx < W:
                        if not visited[ny][nx] and board[ny][nx] == target:
                            visited[ny][nx] = True
                            stack.append((ny, nx))
            
            comps.append(comp)

    return comps

# normalize 주의점: 도형의 한 위치가 아닌 도형을 담고있는 작은 평면을 기준으로
def puzzle_normalize(points):
    miny = min(y for y, x in points)
    minx = min(x for y, x in points)
    shifted = [(y-miny, x-minx) for y, x in points]
    return tuple(sorted(shifted))

def puzzle_canonicalize(puzzle: list) -> list:
    # 매 회전마다 좌표계가 바뀜 -> 따라서 회전하고 normalization을 수행해야 함.
    pts = puzzle[:]
    cands = []
    for _ in range(4):
        cands.append(puzzle_normalize(pts))
        pts = [(-x, y) for y, x in pts] # 매회 90도 회전 -> 좌표가 음수로 바뀜 (0, 0)으로 다시 맞춰야함.
    return min(cands)

def solution(game_board, table):
    # game_board = [[1, 0], [1, 1]]
    # table = [[0, 1], [1, 1]]
    holes = [puzzle_canonicalize(comp) for comp in puzzle_detector(game_board, 0)]
    blocks = [puzzle_canonicalize(comp) for comp in puzzle_detector(table, 1)]

    hole_cnt = Counter(holes)
    answer = 0

    for b in blocks:
        if hole_cnt[b] > 0:
            hole_cnt[b] -= 1
            answer += len(b)
    
    return answer