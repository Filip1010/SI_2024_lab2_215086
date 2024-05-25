Filip Kuzmanoski 215086

2. https://prnt.sc/Yn6ipQ0pSjqv
3. Цикломатската комплексност на нацртаниот CFG е 6 . До резултатот стигнав со броење на региони на горе-наведениот CFG.
4. 
Test Case 1: allItems = null, payment = 100
Test Case 2: allItems = new Item("item1", "123456", 100, 0), payment = 100
Test Case 3: allItems = new Item(null, "123456", 100, 0), payment = 100
Test Case 4: allItems = new Item("", "123456", 100, 0), payment = 100
Test Case 5: allItems = new Item("item1", "123456", 100, 0), payment = 100
Test Case 6: allItems = new Item("item1", null, 100, 0), payment = 100
Test Case 7: allItems = new Item("item1", "123456", 100, 0), payment = 100
Test Case 8: allItems = new Item("item1", "12345a", 100, 0), payment = 100
Test Case 9: allItems = new Item("item1", "123456", 100, 0), payment = 100
Test Case 10: allItems= new Item("item1", "123456", 100, 0.1), payment = 100
Test Case 11: allItems = new Item("item1", "123456", 100, 0), payment = 100
Test Case 12: allItems = new Item("item1", "012345", 350, 0.1), payment = 100
Test Case 13: allItems = new Item("item1", "123456", 350, 0.1), payment = 100
Test Case 14: allItems = new Item("item1", "123456", 50, 0), payment = 100
Test Case 15: allItems = new Item("item1", "123456", 150, 0), payment = 100

   
   За (allItems==null)
   First Branch: (allItems==null)
     - Ако (allItems==null) тогаш сите items се null , па ке врати Exception
   Second Branch: (allItems != null)
     - Сите items не се нула , па кодот продолжува да ја иницијализира сумата на 0 и се повторува.

   За item.getName() == null || item.getName().length() == 0
    First branch: item.getName() == null
     - Името на item-от е нула, треба да се постави на „unknown“
    Second branch: item.getName().length() == 0
     - Името на item-от е празна низа, треба да се постави на „unknown“
    Third branch: item.getName() != null && item.getName().length() > 0
     - Името на item-от не е нула и не е празно, така што нема промена на името.
  
   За item.getBarcode() != null
    First branch: item.getBarcode() == null 
     - Баркодот на item-от е нула, што треба да фрли Exception
     Second branch: item.getBarcode() != null
     - Баркодот на item-от не е нул , продолжува со валидација
 
   За allowed.indexOf(c) == -1 (for each character in the barcode)
     First branch: allowed.indexOf(c) == -1   
      - Баркодот содржи неважечки знак „a“, кој треба да фрли Exception.
      Second branch: allowed.indexOf(c) != -1
       - Баркодот содржи само валидни знаци
  
   За item.getDiscount() > 0
     First branch: item.getDiscount() > 0
     - Item-от има попуст, па цената ќе се прилагоди соодветно.
     Second branch: item.getDiscount() <= 0
     - Item-от нема попуст, па на сумата се додава целосната цена.

    За item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'
    First branch: All conditions are true
    - Item цена е поголема од 300, има попуст, а баркодот започнува со „0“, така што 30 ќе се одземе од збирот.
    Second branch: One or more conditions are false
    - Item цената е поголема од 300 и има попуст, но баркодот не започнува со „0“, така што нема дополнително 
    одземање.

    За sum <= payment 
    First branch: sum <= payment
    - Вкупната сума е помала или еднаква на уплатата, па затоа треба да се врати точно.
    Second branch: sum > payment
    -  Вкупната сума е поголема од уплатата, затоа треба да се врати false .

Подредени се како примери за секој branch  така што 1,2 се First pa Second branch итн , за сите посебно.

5.    item.getPrice() > 300 is true, item.getDiscount() > 0 is true, item.getBarcode().charAt(0) == '0' is true
      Тест случај 1 - Сите услови се точни, затоа се применува специјалниот попуст.
      item.getPrice() > 300 is true, item.getDiscount() > 0 is true, item.getBarcode().charAt(0) == '0' is false
      Тест случај 2 - Баркодот не започнува со 0, така што специјалниот попуст не се применува.
      item.getPrice() > 300 is true, item.getDiscount() > 0 is false, item.getBarcode().charAt(0) == '0' is true
      Тест случај 3 - Попустот не е поголем од 0, затоа специјалниот попуст не се применува.
      item.getPrice() > 300 is true, item.getDiscount() > 0 is false, item.getBarcode().charAt(0) == '0'is false
      Тест случај 4 - И попустот не е поголем од 0 и баркодот не започнува со 0 така што специјалниот попуст 
      не се применува.
      item.getPrice() > 300 is false, item.getDiscount() > 0 is true, item.getBarcode().charAt(0) == '0' is true
      Тест случај 5 - Цената не е поголема од 300, затоа специјалниот попуст не се применува.
      item.getPrice() > 300 is false, item.getDiscount() > 0 is true, item.getBarcode().charAt(0) == '0'is false
      Тест случај 6 - Цената не е поголема од 300, а баркодот не започнува со 0, така што специјалниот попуст 
      не се применува.
      item.getPrice() > 300 is false, item.getDiscount() > 0 is false, item.getBarcode().charAt(0) == '0'is true
      Тест случај 7 - И цената не е поголема од 300 и попустот не е поголем од 0, така што специјалниот попуст 
      не се применува.
      item.getPrice() > 300 is false, item.getDiscount() > 0 is false, item.getBarcode().charAt(0) == '0' is 
      false
      Тест случај 8 - Сите услови се false , затоа специјалниот попуст не се применува.

      

