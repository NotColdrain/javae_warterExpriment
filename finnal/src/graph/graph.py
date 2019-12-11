import matplotlib.pyplot as plt
import numpy as np

filename = "data.txt"

def get_array(filename):
    with open(filename) as file:
        file_lines = file.readlines()
        num_of_lines = len(file_lines)
        class_array = np.zeros(num_of_lines,int)
        books_array = np.zeros(num_of_lines,int)
        index = 0
        for line in file_lines:
            line = line.strip()
            formline = line.split()
            class_array[index] = formline[0]
            books_array[index] = formline[1]
            index += 1
    return class_array, books_array

def main():
    class_array, books_array = get_array(filename)
    plt.xticks(class_array)
    plt.bar(class_array, books_array)
    plt.xlabel("class")
    plt.ylabel("books")
    plt.savefig("ceshi.jpg")

main()
