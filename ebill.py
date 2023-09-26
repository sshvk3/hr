 
units = int(input(" Please enter Number of Units you Consumed : "))

if(units <= 100):
    amount = units * 2
elif(units <= 10000):
    amount = 200 + ((units - 100) * 3)
elif(units <= 1000000):
    amount = 200 + 3 * 9900 + ((units - 10000) * 5)
else:
    amount = 200 + 3 * 9900 + 5* 990000 + ((units - 1000000) * 7)

print("\nElectricity Bill = %.2f"  %amount)