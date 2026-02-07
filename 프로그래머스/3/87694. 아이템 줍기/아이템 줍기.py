from dataclasses import dataclass, field
from collections import deque
from typing import List, Tuple

Rect = Tuple[int, int, int, int]
Point = Tuple[int, int]

EMPTY, BORDER, INSIDE = 0, 1, 2

@dataclass
class GameBoard:
    max_x: int
    max_y: int
    grid: List[List[int]] = field(init=False)
    h: int = field(init=False)
    w: int = field(init=False)

    def __post_init__(self) -> None:
        self.w = (self.max_x + 2) * 2
        self.h = (self.max_y + 2) * 2
        self.grid = [[EMPTY] * self.w for _ in range(self.h)]

    
    def insert_rec(self, rec: Rect) -> None:
        sx, sy, ex, ey = [v * 2 for v in rec]

        for x in range(sx, ex + 1):
            if self.grid[sy][x] != INSIDE: self.grid[sy][x] = BORDER
            if self.grid[ey][x] != INSIDE: self.grid[ey][x] = BORDER
        for y in range(sy, ey + 1):
            if self.grid[y][sx] != INSIDE: self.grid[y][sx] = BORDER
            if self.grid[y][ex] != INSIDE: self.grid[y][ex] = BORDER

        for y in range(sy + 1, ey):
            for x in range(sx + 1, ex):
                self.grid[y][x] = INSIDE


    def bfs(self, start: Point, goal: Point) -> int:
        sx, sy = start[0]*2, start[1]*2
        gx, gy = goal[0]*2, goal[1]*2

        dist = [[-1] * self.w for _ in range(self.h)]
        q = deque([(sx, sy)])
        dist[sy][sx] = 0

        movement = ((1,0), (-1,0), (0,1), (0,-1))
        while q:
            currentX, currentY = q.popleft()
            if currentX == gx and currentY == gy:
                return dist[currentY][currentX] // 2

            for dx, dy in movement:
                x, y = currentX+dx, currentY+dy
                if (self._boundary(x, y) and 
                    self.grid[y][x] == BORDER and 
                    dist[y][x] == -1):
                    dist[y][x] = dist[currentY][currentX] + 1
                    q.append((x, y))
        
        return -1
            

    def _boundary(self, x: int, y: int) -> bool:
        return 0 <= x < self.w and 0 <= y < self.h
    

def solution(rectangle, characterX, characterY, itemX, itemY):
    maxX, maxY = max(r[2] for r in rectangle), max(r[3] for r in rectangle)
    print(maxX, maxY)
    gb = GameBoard(maxX, maxY)
    for rec in rectangle:
        gb.insert_rec(rec)
    
    return gb.bfs((characterX, characterY), (itemX, itemY))