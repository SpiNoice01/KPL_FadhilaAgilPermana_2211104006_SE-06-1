from typing import TypeVar

T = TypeVar("T")

def maximum(a: T, b: T) -> T:
    return a if a > b else b

print(maximum(10, 20))
print(maximum(10.5, 20.5))
print(maximum("a", "b"))


def jumblahkan (data: list[T]) -> T:
    jumblahkan = 0


def kali_dua(data: list[int]) -> list[int]:
    return [x * 2 for x in data]

print(kali_dua([1, 2, 3]))
print(kali_dua(["a", "b", "c"]))
