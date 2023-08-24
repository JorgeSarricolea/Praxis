from time import sleep

Productor=[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
Tuberia=[]
Consumidor=[]
cont=0
threadCont=1

for z in range(1):
  sleep(2)
  print("\n")
  print("Productor.", Productor)
  sleep(5)

  for x in range(3):
    if len(Productor) != 0:
        for x in range(5):
            Tuberia.append(Productor[0])
            Productor.pop(0)
    print("\nTuberia.", threadCont, Tuberia)
    sleep(5)

    threadCont = threadCont+1

    for x in range(1):
      if len(Tuberia) != 0:
        for x in range(5):
            Consumidor.append(Tuberia[0])
            Tuberia.pop(0)

    cont = cont+1

    print("\n\nRestultados del proceso " + str(cont) + "\n")
    print("Productor.", Productor)
    print("Tuberia.", Tuberia)
    print("Consumidor.", Consumidor)

print("\n\nProceso Consumidor detenido por Thread vacío\n")