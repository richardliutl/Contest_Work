# Problem00

# open the file
with open('Prob00.in.txt') as inFile:
    # get the number of test cases
    for T in range(int(inFile.readline())):
        # get the number of lines in each test case
        for N in range(int(inFile.readline())):
            # read in and print out
            print(inFile.readline(), end='')
#done
