# Function to find the numerical value of a word
def onetwothree(word):
    # Define the correct words and their numerical values
    words = {
        "one": 1,
        "two": 2,
        "three": 3,
        "four": 4,
        "five": 5,
        "six": 6,
        "seven": 7,
        "eight": 8,
        "nine": 9,
        "zero": 0
    }

    # Check if the word is in the dictionary
    if word in words:
        return words[word]

    # If the word is not in the dictionary, find the correct word
    for correct_word in words.keys():
        if len(word) == len(correct_word):
            diff_count = sum(c1 != c2 for c1, c2 in zip(word, correct_word))
            if diff_count == 1:
                return words[correct_word]

# Read the number of words
n = int(input())

# Read and process each word
for _ in range(n):
    word = input()
    numerical_value = onetwothree(word)
    print(numerical_value)
