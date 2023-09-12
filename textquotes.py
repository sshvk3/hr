import sys

inside_quote = False 

for char in sys.stdin.read():
    """
    Process input characters, replacing quotation marks.
    
    Args:
        char (str): The current character being processed.
        
    Returns:
        None
        
    Prints characters with quotation mark replacements based on the `inside_quote` flag.
    """
    if char == '"':
        print("''" if inside_quote else '``', end='')
        inside_quote = not inside_quote  
    else:
        print(char, end='')