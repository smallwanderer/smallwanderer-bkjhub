from dataclasses import *

@dataclass(unsafe_hash=True)
class TrieNode:
    children: dict = field(default_factory=dict)
    is_word: bool = False
    word_consist: int = 0

class WordTree:
    def __init__(self):
        self.root = TrieNode()

    def learn(self, word: str) -> None:
        if not word:
            raise ValueError
        node = self.root
        for ch in word:
            node.word_consist += 1
            node = node.children.setdefault(ch, TrieNode())
        
        node.is_word = True

    def keypress_count(self, word:str) -> int:
        node = self.root
        press = 0

        for ch in word:
            if ch in node.children and node.word_consist == 1 and not node.is_word:
                return press
            node = node.children[ch]
            press += 1; 
        return press

def solution(words):
    wt = WordTree()
    for word in words:
        wt.learn(word)
        
    return sum(wt.keypress_count(w) for w in words)