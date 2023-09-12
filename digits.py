def count_digits(n):
    """
    Count the number of digits in a given integer.

    Args:
        n (int): The integer to count digits in.

    Returns:
        int: The number of digits in the integer.
    """
    return len(str(n))

def smallest_i(x0):
    """
    Find the smallest positive 'i' such that xi = xi-1,
    where xi is the number of digits in the decimal representation of xi-1.

    Args:
        x0 (int): The initial integer value x0.

    Returns:
        int: The smallest positive 'i' that satisfies the condition.
    """
    seen = set()
    i = 0

    while x0 not in seen:
        seen.add(x0)
        i += 1
        x0 = count_digits(x0)

    return i

inputs = []

while True:
    x0 = input()
    if x0 == "END":
        break
    inputs.append(int(x0))

results = []

for x0 in inputs:
    result = smallest_i(x0)
    results.append(result)

for i, result in enumerate(results):
    print(result)
