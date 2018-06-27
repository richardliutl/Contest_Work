#! /usr/bin/python3

import sys
from math import log, ceil

n = 0
m = 0
d = {}
s = ""
c = 0
for a in sys.stdin:
  if c==0:
    arr = a.split(" ")
    n = int(arr[0])
    m = int(arr[1])
    c = 1
  elif c>n:
    s = a
    break
  else:
    arr = a.split(" -> ")
    d[arr[0].strip()] = arr[1].strip()
    c += 1
while m > 0:
  old_s = s
  s = ""
  for i in old_s:
    if i in d:
      s += d[i]
    else:
      s += i
  m -= 1
print(s)