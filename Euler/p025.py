a = [1,1]
while(len(str(a[-1])) < 1000):
	a.append(a[-1]+a[-2])
print(str(len(a))+": "+str(a[-1]))