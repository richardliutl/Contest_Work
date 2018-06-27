#! /usr/bin/python3

import sys
from math import log, ceil

for a in sys.stdin:
  cank = False

  arr = a.split(" ")
  a = int(arr[0])
  b = int(arr[1])
  c = int(arr[2])
  i = int(arr[3])
  k = int(arr[4])
  
  if i == 0:
    cank = k == 1
  else:
    ii = ceil(i/c)
    while ii <= i:
      if k-1 >= a*ii and k-1 <= ii*(a + b - 1):
        cank = True
      ii += 1

  if cank:
    print("possible")
  else:
    print("impossible")