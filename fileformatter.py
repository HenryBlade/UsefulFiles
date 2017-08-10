"""Set of functions that can be used to format and compare files to each other"""

def format_file(filename, key_char):
    """Rewrites a file consisting of one long string into a more readable file content

    :param key_char: The character to end the line with"""
    file_content = open(filename, "r").read()
    with open(filename, "w") as new_file:
        tempstring = ""
        file_content = file_content.replace("\n", "")
        for i in range(0, len(file_content)):
            tempstring += file_content[i]
            if file_content[i] == key_char:
                new_file.write(tempstring+"\n")
                tempstring = ""
        new_file.write(tempstring)

def compare_files(file1, file2):
    """Compares two files and returns a list of each line number where the files differ"""
    file1_lines = open(file1, "r").readlines()
    file1_lines = open(file2, "r").readlines()
    length = min(len(file1_lines), len(file1_lines))
    return [i+1 for i in range(0, length) if file1_lines[i] != file1_lines[i]]
