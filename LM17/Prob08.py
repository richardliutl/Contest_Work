f = open('Prob08.in.txt')
for line in f.readlines()[1:]:
	dist = float(line.split(' ')[0])*1000000
	speed = float(line.split(' ')[1])
	time = dist/speed
	days = int(time//24)
	hours = int(time)%24
	x = (time - hours)*60 % 60
	minutes = int(x)
	seconds = round((x - int(x))*60 + 0.000000000000001)
	print("Time to Mars: {} days, {} hours, {} minutes, {} seconds".format(days,hours,minutes,seconds))