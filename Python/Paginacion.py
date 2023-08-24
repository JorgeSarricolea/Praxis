import time
from numpy import random
import numpy as np

paginas = [1,2,3,4,5,6,0,0,0,0]
marcos = []
pagMarc = [[0,0],[0, 0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0]]
num = 0


#Creamos una lista de marcos de forma random
marcos = np.random.permutation(11)
new_marcos = np.delete(marcos, np.where(marcos == 0))

#Imprimimos las páginas asignadas en la lista
print("Cargando páginas en memoria virtual\n")
for i in range(6):
  print("Página ", paginas[i])
  time.sleep(1)

print("\n--------------------------------------------")

#Imprimimos los marcos creados de forma random
print("\nCargando marcos\n")
for i in range(10):
  print("Marco ", new_marcos[i])
  time.sleep(1)

print("\n--------------------------------------------")

#Asignamos las páginas a los marcos correspondientes
print("\nAsignando páginas a cada marco existente\n")
for i in range(10):

  for j in range(10):
    if j == 0:
      pagMarc[i][j] = new_marcos[i]

  if paginas[i] != 0:
    print("\nPágina ", paginas[i], " asignada al marco ", new_marcos[i])
    time.sleep(1)


for i in range(10):
  for j in range(10):
    if j == 1:
      pagMarc[i][j] = paginas[i]

#Imprimimos la tabla de marcos asignados
print("\n--------------------------------------------")
print("\nCreando tabla de marcos con su página asignada\n")

print("Marco | Página\n")
for i in range(10):
  print("   ", pagMarc[i])
  time.sleep(1)

# Instituto Tecnológico de Mérida. Campus Poniente
# Ingeniería en Sistemas Computacionales
# Sistemas Operativos
# Realizado por:
# Gutiérrez Alonso, Alejandro
# Uicab Cetz, Luisa Alejandra
# Sarricolea Veyro, Jorge 
# Uicab Espinoza, Martin Antonio